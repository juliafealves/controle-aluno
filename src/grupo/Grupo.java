package grupo;

import aluno.Aluno;

import java.util.HashSet;
import java.util.Objects;

/**
 * Representa um Grupo e seus atributos.
 *
 * @author Júlia Fernandes Alves (julia.alves@ccc.ufcg.edu.br)
 */
public class Grupo {
    private String nome;
    private HashSet<Aluno> alunos;

    /**
     * Cria um objeto do tipo Grupo.
     *
     * @param nome Nome do Grupo. É obrigatório o preenchimento.
     */
    public Grupo(String nome) {
        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome deve ser informado.");

        this.nome = nome;
        this.alunos = new HashSet<>();
    }

    /**
     * Adiciona um aluno no grupo.
     * @param aluno
     */
    public void adicionaAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    /**
     * Lista todos os alunos que participam do grupo.
     *
     * @return
     */
    @Override
    public String toString(){
        String grupo = "Alunos do grupo " + this.nome + ":" + System.lineSeparator();

        if(!this.alunos.isEmpty()) {
            for (Aluno aluno : this.alunos)
                grupo += "* " + aluno.toString() + System.lineSeparator();
        }else{
            grupo += "** Nenhum aluno adicionado. **";
        }

        return grupo;
    }

    /**
     * Verifica se dois objetos são iguais. Só serão iguais se tiverem o mesmo nome, não é case sensitive.
     * @param objeto
     * @return
     */
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        Grupo grupo = (Grupo) objeto;

        return Objects.equals(this.nome.toLowerCase(), grupo.nome.toLowerCase());
    }

    /**
     * Geração de hashCode baseado no nome do grupo.
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.nome.toLowerCase());
    }
}
