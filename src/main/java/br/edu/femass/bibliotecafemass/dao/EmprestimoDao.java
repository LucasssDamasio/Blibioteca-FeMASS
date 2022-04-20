package br.edu.femass.bibliotecafemass.dao;

import br.edu.femass.bibliotecafemass.model.Emprestimo;

import java.util.ArrayList;
import java.util.List;

public class EmprestimoDao implements Dao<Emprestimo> {
    private static List<Emprestimo> emprestimos= new ArrayList<Emprestimo>();
    @Override
    public void Gravar(Emprestimo objeto) throws Exception {
        emprestimos.add(objeto);

    }

    @Override
    public  List Listar() throws Exception {
        return emprestimos;
    }

    @Override
    public void Excluir(Emprestimo objeto) throws Exception {
        emprestimos.remove(objeto);

    }
}
