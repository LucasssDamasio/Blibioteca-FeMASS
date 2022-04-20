package br.edu.femass.bibliotecafemass.GUI;

import br.edu.femass.bibliotecafemass.dao.EmprestimoDao;
import br.edu.femass.bibliotecafemass.dao.LivroDao;
import br.edu.femass.bibliotecafemass.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class BibliotecaController implements Initializable {
    private LivroDao livrodao= new LivroDao();
    private  EmprestimoDao emprestimoDao= new EmprestimoDao();
    @FXML
    private ComboBox<Genero> CboGenero;
    @FXML
    private ComboBox<Livro> CboLivro;
    @FXML
    private ListView<Livro> LstLivros;
    @FXML
    private ListView<Emprestimo> LstEmprestimo;
    @FXML
    private Button BtnCadastrar;
    @FXML
    private Button BtnEmprestar;
    @FXML
    private Button BtnAdicionar;
    @FXML
    private Button BtnExcluir;
    @FXML
    private Button BtnExcluir2;
    @FXML
    private Button BtnGravar;
    @FXML
    private Button BtnCancelar;
    @FXML
    private Button BtnCancelar2;

    private void HabilitarInterface(boolean Adicionar){
        TxtTitulo.setDisable(!Adicionar);
        TxtEdicao.setDisable(!Adicionar);
        TxtAno.setDisable(!Adicionar);
        TxtNome.setDisable(!Adicionar);
        TxtSobrenome.setDisable(!Adicionar);
        TxtQtd.setDisable(!Adicionar);
        CboLivro.setDisable(!Adicionar);
        BtnGravar.setDisable(!Adicionar);
        BtnAdicionar.setDisable(Adicionar);
        BtnExcluir.setDisable(Adicionar);
        BtnCancelar.setDisable(!Adicionar);
        LstLivros.setDisable(Adicionar);

    }

    private void HabilitarInterface2(boolean Adicionar){
        TxtCpf.setDisable(!Adicionar);
        TxtNome2.setDisable(!Adicionar);
        TxtMatricula.setDisable(!Adicionar);
        CboLivro.setDisable(!Adicionar);
        ChkProfessor.setDisable(!Adicionar);
        ChkAluno.setDisable(!Adicionar);
        BtnEmprestar.setDisable(!Adicionar);
        BtnCadastrar.setDisable(Adicionar);
        BtnExcluir2.setDisable(Adicionar);
        BtnCancelar2.setDisable(!Adicionar);
        LstEmprestimo.setDisable(Adicionar);

    }

    @FXML
    private void  BtnAdicionar_Action(ActionEvent evento){
        HabilitarInterface(true);
    }
    @FXML
    private void  BtnCadastrar_Action(ActionEvent evento) {
        HabilitarInterface2(true);
    }

    @FXML
    private void  BtnExcluir_Action(ActionEvent evento) throws Exception {
        livrodao.Excluir(LstLivros.getSelectionModel().getSelectedItem());
        AtualizarLista();



    }
    @FXML
    private void  BtnCancelar_Action(ActionEvent evento){
        HabilitarInterface( false);
    }
    @FXML
    private void  BtnExcluir2_Action(ActionEvent evento) throws Exception {
        emprestimoDao.Excluir(LstEmprestimo.getSelectionModel().getSelectedItem());
        AtualizarLista2();
    }
    @FXML
    private void  BtnCancelar2_Action(ActionEvent evento){
        HabilitarInterface2( false);
    }

    @FXML
    private void  BtnGravar_Action(ActionEvent evento)  throws Exception {


        String titulo= TxtTitulo.getText();
        int edicao= Integer.parseInt(TxtEdicao.getText());
        int ano=Integer.parseInt(TxtAno.getText());
        Genero genero=CboGenero.getValue();
        Livro livro=  new Livro(titulo,edicao,ano,genero);
        livro.setAutor(new Autor(TxtNome.getText(), TxtSobrenome.getText()));
        int qtd=Integer.parseInt(TxtQtd.getText());
        for(int i=0; i<  qtd;i++) {
            livro.setCopia(new Copia(i==0,livro));
        }
        try{
            livrodao.Gravar(livro);

        } catch (Exception e){
            e.printStackTrace();

        }
        AtualizarLista();

        HabilitarInterface(false);
    }
    @FXML
    private void  BtnEmprestar_Action(ActionEvent evento)  throws Exception {
        String nome2= TxtNome2.getText();
        int cpf= Integer.parseInt(TxtCpf.getText());
        int matricula= Integer.parseInt(TxtMatricula.getText());
        Usuario usuario = null;

        if(ChkAluno.isSelected()){
            usuario= new Aluno(nome2,cpf,matricula);

        }
        else if(ChkProfessor.isSelected()){
            usuario= new Professor(nome2,cpf,matricula);

        }
        else{
            return;
        }


        List<Copia> copias= CboLivro.getSelectionModel().getSelectedItem().getCopias();
        Copia copia=copias.get(new Random().nextInt(copias.size()));
        Emprestimo emprestimo= new Emprestimo(usuario,copia);
        try{
            emprestimoDao.Gravar(emprestimo);;

        } catch (Exception e){
            e.printStackTrace();

        }
        AtualizarLista2();
        HabilitarInterface2(false);

    }

    @FXML
    private void ChkAluno_Action(ActionEvent evento){
        if (ChkAluno.isSelected()){
            ChkProfessor.setSelected(false);
        }

    }

    @FXML
    private void ChkProfessor_Action(ActionEvent evento){
        if (ChkProfessor.isSelected()){
            ChkAluno.setSelected(false);
        }

    }


    @FXML
    private TextField TxtTitulo;

    @FXML
    private TextField TxtEdicao;

    @FXML
    private TextField TxtAno;

    @FXML
    private TextField TxtNome;
    @FXML
    private TextField TxtSobrenome;
    @FXML
    private TextField TxtQtd;

    @FXML
    private TextField TxtNome2;

    @FXML
    private TextField TxtCpf;

    @FXML
    private TextField TxtMatricula;

    @FXML
    private CheckBox ChkAluno;


    @FXML
    private CheckBox ChkProfessor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Genero> generos= FXCollections.observableArrayList(Genero.values());
        CboGenero.setItems(generos);
        AtualizarLista();

        ObservableList<Livro> livros=FXCollections.observableArrayList();
        CboLivro.setItems(livros);
        AtualizarLista2();

    }
    public void AtualizarLista(){
        List<Livro> livros= null;
        try{
            livros= livrodao.Listar();

        } catch (Exception e){
            livros= new ArrayList<Livro>();

        }
        ObservableList<Livro> livrosOB= FXCollections.observableArrayList(livros);
        LstLivros.setItems(livrosOB);
        List<Livro> Disponivel= new ArrayList<>();
        livros.forEach(i->{
            if(i.getDisponiveis().size()>0){
                Disponivel.add(i);
            }
        });
        ObservableList<Livro> livrosDIS= FXCollections.observableArrayList(Disponivel);
        CboLivro.setItems(livrosDIS);

    }
    public void  AtualizarLista2(){
        List<Emprestimo> emprestimos= null;
        try{
            emprestimos=emprestimoDao.Listar();

        } catch (Exception e){
            emprestimos= new ArrayList<Emprestimo>();

        }
        ObservableList<Emprestimo> emprestimosOB= FXCollections.observableArrayList(emprestimos);
        LstEmprestimo.setItems(emprestimosOB);

    }

}