package controle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ControleAlunoTest {
    private ControleAluno controleAluno;

    /**
     * Cria um ControleAluno para os testes unitários.
     */
    @Before
    public void criaControleAluno(){
        this.controleAluno = new ControleAluno();
    }

    /**
     * Verifica se um aluno é cadastrado com sucesso ao ControleAluno.
     */
    @Test
    public void testCadastraAluno(){
        Assert.assertTrue(this.controleAluno.cadastraAluno("123", "Isaac Newton", "Física"));
    }

    /**
     * Verifica se é lançada uma exceção caso cadastre outro aluno com a mesma matrícula.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testCadastraAlunoMatriculaExistente(){
        this.controleAluno.cadastraAluno("123", "Isaac Newton", "Física");
        this.controleAluno.cadastraAluno("123", "Sigmund Freud", "Medicina");
    }
}
