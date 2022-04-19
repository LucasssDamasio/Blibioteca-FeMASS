package br.edu.femass.bibliotecafemass.model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmprestimoTest {
    private LocalDate DataEmprestimo=LocalDate.now();
    private LocalDate DataDevolucao;
    private Copia copia;
    private Emprestimo emprestimo;

   @Test
    void EmprestimoAluno() {

        Usuario usuario = new Aluno("Joao", 123, 1234);
        Emprestimo emprestimo = new Emprestimo(usuario, copia);
        emprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusDays(5));
        assertEquals(emprestimo.getDataDevolucao().minusDays(5),emprestimo.getDataEmprestimo());

    }
    @Test
    void EmprestimoProfessor() {
        Usuario usuario = new Professor("Joao", 123, 1234);
        Emprestimo emprestimo= new Emprestimo(null,copia);
        emprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusDays(30));
        assertEquals(emprestimo.getDataDevolucao().minusDays(30),emprestimo.getDataEmprestimo());
    }

}
