package br.edu.femass.bibliotecafemass.dao;

import java.util.List;

public interface Dao<T> {
    public void Gravar(T objeto) throws Exception;
    public List Listar() throws Exception;
    public void Excluir(T objeto) throws Exception;
}
