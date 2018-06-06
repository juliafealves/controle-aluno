package controle;

import aluno.Aluno;

import java.util.HashMap;
import java.util.NoSuchElementException;

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

    /**
     * Consulta um aluno cadastrado no controle de alunos.
     * Caso o aluno não esteja cadastro será lançada uma exceção.
     *
     * @param matricula Matrícula única do aluno.
     * @return String formata com as informações do aluno.
     */
    public String consultaAluno(String matricula) {
        this.validaMatricula(matricula);

        if(!this.alunos.containsKey(matricula))
            throw new NoSuchElementException("Aluno não cadastrado.");

        return "Aluno: " + this.alunos.get(matricula).toString();
    }

    /**
     * Valida uma matrícula.
     *
     * @param matricula Matrícula deve ser preenchida e possuir um valor númerico positivo.
     * @return Retona true caso a matrícula seja válida.
     */
    private boolean validaMatricula(String matricula){
        if(matricula == null || matricula.isEmpty())
            throw new IllegalArgumentException("Matrícula deve ser informada.");

        if(!matricula.matches("[0-9]+"))
            throw new IllegalArgumentException("Matrícula inválida.");

        return true;
    }
}
