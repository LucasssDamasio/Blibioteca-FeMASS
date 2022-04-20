package br.edu.femass.bibliotecafemass.model;

public abstract class Usuario {
    private String Nome;
    private int CPF;
    private int Matricula;
    private Emprestimo emprestimo;
    private int PrazoDevolução;


    public Usuario(String nome, int CPF, int Matricula, int PrazoDevolução) {
        this.Nome = nome;
        this.CPF = CPF;
        this.Matricula = Matricula;
        this.PrazoDevolução = PrazoDevolução;


    }

    public Emprestimo getEmprestimo() {
        return emprestimo;
    }

    public void setEmprestimo(Emprestimo emprestimo) {
        this.emprestimo = emprestimo;
        emprestimo.setDataDevolucao(emprestimo.getDataEmprestimo().plusDays(PrazoDevolução));

    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    public int getMatricula() {
        return Matricula;
    }

    public void setMatricula(int matricula) {
        Matricula = matricula;
    }


    @Override
    public String toString() {
        return Nome+"Matr."+Matricula;


    }
}
