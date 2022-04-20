package br.edu.femass.bibliotecafemass.model;


import java.util.ArrayList;
import java.util.List;

public class Livro {

   private String titulo;
    private  int edicao;
    private int ano;
    private Autor autor;
    private Genero genero;
    private List<Copia> copias=new ArrayList<>();

    public Livro(String titulo,int edicao, int ano, Genero genero) {
        this.titulo = titulo;
        this.edicao = edicao;
        this.ano = ano;
        this.genero = genero;




    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }


    public Genero getGenero() {
        return genero;
    }


    public List<Copia> getCopias() {
        return copias;
    }

    public void setCopia(Copia copia) {
        this.copias.add(copia);
    }

    public  List<Copia> getDisponiveis(){
        List<Copia> Disponiveis= new ArrayList<>();
        this.copias.forEach(i->{
            if(!i.isFixo()){
                Disponiveis.add(i);

            }

        });
        return Disponiveis;
    }

    @Override
    public String toString() {

        return titulo+"," + autor;


    }
}


