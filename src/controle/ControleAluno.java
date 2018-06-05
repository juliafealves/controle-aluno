package controle;

import aluno.Aluno;

import java.util.HashMap;

public class ControleAluno {

    private HashMap<String, Aluno> alunos;

    /**
     * Inicializa as coleções do ControleAluno.
     */
    public ControleAluno(){
        this.alunos = new HashMap<>();
    }

    /**
     * Cadastra uma aluno no controle de alunos. A matrícula deve ser única.
     *
     * @param matricula Matrícula única do aluno.
     * @param nome Nome completo do aluno.
     * @param curso Curso do aluno.
     * @return boolean Caso tenha cadastrado o aluno com sucesso.
     */
    public boolean cadastraAluno(String matricula, String nome, String curso) {
        if(this.alunos.containsKey(matricula))
            throw new IllegalArgumentException("Matrícula já cadastrada!");

        this.alunos.put(matricula, new Aluno(matricula, nome, curso));

        return true;
    }
}
