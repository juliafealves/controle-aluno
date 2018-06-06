package grupo;

import java.util.Objects;

/**
 * Representa um Grupo e seus atributos.
 *
 * @author Júlia Fernandes Alves (julia.alves@ccc.ufcg.edu.br)
 */
public class Grupo {
    private String nome;

    /**
     * Cria um objeto do tipo Grupo.
     *
     * @param nome Nome do Grupo. É obrigatório o preenchimento.
     */
    public Grupo(String nome) {
        if(nome == null || nome.isEmpty())
            throw new IllegalArgumentException("Nome deve ser informado.");

        this.nome = nome;
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
