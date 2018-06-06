package grupo;

import java.util.Objects;

public class Grupo {
    private String nome;

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
