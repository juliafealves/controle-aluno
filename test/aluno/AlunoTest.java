package aluno;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Responsável por realizar testes unitários da classe Aluno.
 *
 * @author Júlia Fernandes Alves (julia.alves@ccc.ufcg.edu.br)
 */
public class AlunoTest {
    private Aluno aluno;

    /**
     * Cria um objeto Aluno para ser utilizado nos testes unitários abaixo.
     */
    @Before
    public void criaAluno(){
        this.aluno = new Aluno("789", "Alan Turing", "Matemática");
    }

    /**
     * Teste para criação de aluno.
     */
    @Test
    public void testAluno(){
        new Aluno("123", "Albert Einstein", "Física");
    }

    /**
     * Verifica se ocorre exceção ao criar um aluno com matrícula vazia.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAlunoComMatriculaVazia(){
        new Aluno("", "Isaac Newton", "Física");
    }

    /**
     * Verifica se ocorre exceção ao criar um aluno com matrícula nula.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAlunoComMatriculaNula(){
        new Aluno(null, "Isaac Newton", "Física");
    }

    /**
     * Verifica se ocorre exceção ao criar um aluno com matrícula nula.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAlunoComMatriculaInvalida(){
        new Aluno("invalida", "Isaac Newton", "Física");
    }

    /**
     * Verifica se ocorre exceção ao criar um aluno com nome vazio.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAlunoComNomeVazio(){
        new Aluno("123", "", "Física");
    }

    /**
     * Verifica se ocorre exceção ao criar um aluno com nome nulo.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAlunoComNomeNulo(){
        new Aluno("123", null, "Física");
    }

    /**
     * Verifica se ocorre exceção ao criar um aluno com curso vazio.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAlunoComCursoVazio(){
        new Aluno("123", "Isaac Newton", "");
    }

    /**
     * Verifica se ocorre exceção ao criar um aluno com curso nulo.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAlunoComCursoNulo(){
        new Aluno("123", "Isaac Newton", null);
    }

    /**
     * Verifica se dois objetos alunos são iguais. Eles serão ditos como iguais caso as matrículas sejam as mesmas.
     */
    @Test
    public void testAlunosIguais(){
        Assert.assertTrue(this.aluno.equals(new Aluno("789", "Sigmund Freud", "Medicina")));
    }

    /**
     * Verifica se dois objetos alunos são diferentes.
     */
    @Test
    public void testAlunosDiferentes(){
        Assert.assertFalse(this.aluno.equals(new Aluno("123", "Sigmund Freud", "Medicina")));
    }

    /**
     * Verifica se dois objetos alunos iguais possuem o mesmo hashCode.
     */
    @Test
    public void testAlunoHashCodeIguais(){
        Assert.assertEquals(this.aluno.hashCode(), new Aluno("789", "Sigmund Freud", "Medicina").hashCode());
    }

    /**
     * Verifica se dois objetos alunos diferentes possuem hashCode diferentes.
     */
    @Test
    public void testAlunoMesmoHashCodeDiferente(){
        Assert.assertNotEquals(this.aluno.hashCode(), new Aluno("123", "Sigmund Freud", "Medicina").hashCode());
    }

    /**
     * Verifica se o toString do objeto aluno está formato corretamente.
     */
    @Test
    public void testToString(){
        Assert.assertEquals("789 - Alan Turing - Matemática", this.aluno.toString());
    }
}
