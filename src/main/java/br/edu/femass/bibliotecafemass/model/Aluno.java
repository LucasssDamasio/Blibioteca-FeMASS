package br.edu.femass.bibliotecafemass.model;

import java.time.LocalDate;

public class Aluno extends Usuario{
    public Aluno(String nome, int CPF, int Matricula) {

        super(nome, CPF, Matricula,5);


    }
}
