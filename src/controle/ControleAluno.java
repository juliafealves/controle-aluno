package controle;

import aluno.Aluno;
import grupo.Grupo;

import java.util.HashMap;
import java.util.NoSuchElementException;


public class ControleAluno {

    private HashMap<String, Aluno> alunos;
    private HashMap<String, Grupo> grupos;

    /**
     * Inicializa as coleções do ControleAluno.
     */
    public ControleAluno(){
        this.alunos = new HashMap<>();
        this.grupos = new HashMap<>();
    }

    /**
     * Cadastra um aluno no controle de alunos. A matrícula deve ser única.
     *
     * @param matricula Matrícula única do aluno.
     * @param nome Nome completo do aluno.
     * @param curso Curso do aluno.
     * @return boolean Caso tenha cadastrado o aluno com sucesso.
     */
    public boolean cadastraAluno(String matricula, String nome, String curso) {
        if(this.alunos.containsKey(matricula))
            throw new UnsupportedOperationException("Matrícula já cadastrada!");

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

    /**
     * Verfica se o nome do grupo de estudos é válido.
     *
     * @param nome Nome do grupo de estudos.
     * @return Retona true caso o nome seja válido.
     */
    private boolean validaNomeGrupo(String nome){
        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome do Grupo deve ser informada.");

        return true;
    }

    /**
     * Cadastra um grupo no controle de alunos. O nome deve ser único e não deve ser case sensitive.
     *
     * @param nome Nome do grupo único.
     * @return Retorna true caso o grupo foi cadastrado com sucesso.
     */
    public boolean cadastraGrupo(String nome) {
        if(this.grupos.containsKey(nome.toLowerCase()))
            throw new UnsupportedOperationException("Grupo já cadastrado!");

        this.grupos.put(nome.toLowerCase(), new Grupo(nome));

        return true;
    }

    /**
     * Aloca um aluno em um grupo de estudos.
     *
     * @param matricula Matrícula do aluno a ser alocado.
     * @param grupo Nome do grupo de estudos.
     * @return Retorna true caso o aluno tenha sido alocado com sucesso.
     */
    public boolean alocaAluno(String matricula, String grupo) {
        this.validaMatricula(matricula);
        this.validaNomeGrupo(grupo);

        if(!this.grupos.containsKey(grupo.toLowerCase()))
            throw new NoSuchElementException("Grupo não cadastrado.");

        if(!this.alunos.containsKey(matricula))
            throw new NoSuchElementException("Aluno não cadastrado.");

        this.grupos.get(grupo.toLowerCase()).adicionaAluno(this.alunos.get(matricula));

        return true;
    }
}
