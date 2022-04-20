package br.edu.femass.bibliotecafemass.dao;



import br.edu.femass.bibliotecafemass.model.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDao implements Dao<Livro>{
    private static List<Livro> livros= new ArrayList<Livro>();

    @Override
    public void Gravar(Livro objeto) throws Exception {
        livros.add(objeto);

    }

    @Override
    public List Listar() throws Exception {
        return livros;
    }

    @Override
    public void Excluir(Livro objeto) throws Exception {
        livros.remove(objeto);


    }
}
