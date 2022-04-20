package br.edu.femass.bibliotecafemass.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LivroTest {
    String titulo;
    int edicao;
    int ano;
    Genero genero;
    Copia copia;



    @Test
    void ValidaDisponiveis() {

        Livro livro=  new Livro(titulo,edicao,ano,genero);
        livro.setCopia(copia = new Copia(true,livro));
        assertEquals(0,livro.getDisponiveis().size());


    }
}

