package br.edu.femass.bibliotecafemass.model;

import java.util.Objects;

public class Copia {
    private  boolean fixo;
    private int codigo;
    private Livro livro;
    private static int lastcod=1;

    public Copia (boolean fixo,Livro livro ) {

        this.fixo = fixo;
        this.codigo =lastcod;
        lastcod++;
        this.livro=livro;


    }

    public boolean isFixo() {
        return fixo;
    }

    public void setFixo(boolean fixo) {
        this.fixo = fixo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "cod:"+ lastcod +livro;

    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}


