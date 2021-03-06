package grupo;

import aluno.Aluno;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Responsável por realizar testes unitários da classe Grupo.
 *
 * @author Júlia Fernandes Alves (julia.alves@ccc.ufcg.edu.br)
 */
public class GrupoTest {
    private Grupo grupo;

    /**
     * Cria um objeto Grupo para ser utilizado nos testes unitários abaixo.
     */
    @Before
    public void criaGrupo(){
        this.grupo = new Grupo("Molejão");
    }

    /**
     * Teste para criação de grupo.
     */
    @Test
    public void testGrupo(){
        new Grupo("Raça Negra");
    }

    /**
     * Verifica se ocorre exceção ao criar um grupo com nome vazio.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGrupoComNomeVazio(){
        new Grupo("");
    }

    /**
     * Verifica se ocorre exceção ao criar um grupo com nome nulo.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGrupoComNomeNulo(){
        new Grupo(null);
    }

    /**
     * Verifica se dois objetos grupos são iguais. Eles serão ditos como iguais caso os nomes sejam os mesmos.
     */
    @Test
    public void testGruposIguais(){
        Assert.assertTrue(this.grupo.equals(new Grupo("Molejão")));
    }

    /**
     * Verifica se dois objetos grupos são iguais mesmo com nomes com cases diferentes.
     */
    @Test
    public void testGruposIguaisCaseDiferente(){
        Assert.assertTrue(this.grupo.equals(new Grupo("mOLEJÃO")));
    }

    /**
     * Verifica se dois objetos grupos são diferentes.
     */
    @Test
    public void testGruposDiferentes(){
        Assert.assertFalse(this.grupo.equals(new Grupo("Raça Negra")));
    }

    /**
     * Verifica se dois objetos grupos iguais possuem o mesmo hashCode.
     */
    @Test
    public void testGruposIguaisHashCodeIguais(){
        Assert.assertEquals(this.grupo.hashCode(), new Grupo("Molejão").hashCode());
    }

    /**
     * Verifica se dois objetos grupos diferentes possuem hashCode diferentes.
     */
    @Test
    public void testGruposDiferentesHashCodeDiferentes(){
        Assert.assertNotEquals(this.grupo.hashCode(), new Grupo("Raça Negra").hashCode());
    }

    /**
     * Verifica se dois objetos grupos diferentes possuem hashCode diferentes.
     * Indiretamente, verifica se o toString está funcionando corretamente.
     */
    @Test
    public void testAdicionaAluno(){
        Aluno aluno = new Aluno("123", "Alan Turing", "Matemática");
        this.grupo.adicionaAluno(aluno);
        String toString = "Alunos do grupo Molejão:" + System.lineSeparator() + "* " + aluno.toString() + System.lineSeparator();
        Assert.assertEquals(toString, this.grupo.toString());
    }

    /**
     * Verifica se o toString do objeto grupo está formato corretamente.
     */
    @Test
    public void testToString(){
        String toString = "Alunos do grupo Molejão:" + System.lineSeparator() + "** Nenhum aluno adicionado. **";
        Assert.assertEquals(toString, this.grupo.toString());
    }
}
