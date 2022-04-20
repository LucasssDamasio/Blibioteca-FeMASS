package br.edu.femass.bibliotecafemass.model;

import javafx.scene.control.CheckBox;

import java.time.LocalDate;

public class Emprestimo {

    private LocalDate DataEmprestimo=LocalDate.now();
    private LocalDate DataDevolucao;
    private Usuario usuario;
    private Copia copia;

    public  Emprestimo(Usuario usuario, Copia copia){
        this.usuario=usuario;
        this.copia=copia;
        usuario.setEmprestimo(this);
    }

    public LocalDate getDataEmprestimo() {
        return DataEmprestimo;
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        DataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return DataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        DataDevolucao = dataDevolucao;
    }

    @Override
    public String toString() {
        return usuario+","+ copia+"DataEmpr. "+ DataEmprestimo+"DataDev. "+DataDevolucao;

    }


}

