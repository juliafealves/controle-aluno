package aluno;

import java.util.Objects;

/**
 * Representa um Aluno e seus atributos.
 *
 * @author Júlia Fernandes Alves (julia.alves@ccc.ufcg.edu.br)
 */
public class Aluno {

    private String matricula;
    private String nome;
    private String curso;

    /**
     * Cria um objeto do tipo Aluno.
     *
     * @param matricula Matrícula do aluno
     * @param nome Nome completo do aluno
     * @param curso Curso do aluno
     */
    public Aluno(String matricula, String nome, String curso) {
        if(matricula == null || matricula.isEmpty())
            throw new IllegalArgumentException("Matrícula deve ser informada.");

        if(!matricula.matches("[0-9]+"))
            throw new IllegalArgumentException("Matrícula inválida.");

        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome deve ser informado.");

        if(curso == null || curso.isEmpty())
            throw new IllegalArgumentException("Curso deve ser informado.");

        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    /**
     * Formata os dados básicos do aluno.
     * Ex.: 250 - Gabriel Reyes - Computação
     *
     * @return Dados do aluno formatado
     */
    @Override
    public String toString(){
        return this.matricula + " - " + this.nome + " - " + this.curso;
    }

    /**
     * Verifica se dois objetos são iguais. Só serão iguais se tiverem a mesma matrícula.
     *
     * @param objeto Objeto a ser comparado com objeto Aluno.
     * @return Retorna true caso os objetos possuam a mesma matrícula.
     */
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Aluno aluno = (Aluno) objeto;

        return Objects.equals(matricula, aluno.matricula);
    }

    /**
     * Geração de hashCode baseado na matrícula do aluno.
     *
     * @return Retorna o hashCode da matrícula.
     */
    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}
