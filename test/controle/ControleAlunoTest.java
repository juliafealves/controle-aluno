package controle;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

/**
 * Responsável por realizar testes unitários da classe ControleAluno.
 *
 * @author Júlia Fernandes Alves (julia.alves@ccc.ufcg.edu.br)
 */
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
    @Test (expected = UnsupportedOperationException.class)
    public void testCadastraAlunoMatriculaExistente(){
        this.controleAluno.cadastraAluno("123", "Isaac Newton", "Física");
        this.controleAluno.cadastraAluno("123", "Sigmund Freud", "Medicina");
    }

    /**
     * Verifica se é possível consultar as informações de um aluno previamente cadastrado.
     */
    @Test
    public void testConsultaAluno(){
        this.controleAluno.cadastraAluno("123", "Isaac Newton", "Física");
        Assert.assertEquals("Aluno: 123 - Isaac Newton - Física", this.controleAluno.consultaAluno("123"));
    }

    /**
     *  Verifica se é lançada uma exceção caso consulte um aluno que ainda não foi cadastrado.
     */
    @Test (expected = NoSuchElementException.class)
    public void testConsultaAlunoInexistente(){
        this.controleAluno.cadastraAluno("234", "Isaac Newton", "Física");
        this.controleAluno.consultaAluno("123");
    }

    /**
     *  Verifica se é lançada uma exceção caso consulte um aluno em uma coleção de alunos vazia.
     */
    @Test (expected = NoSuchElementException.class)
    public void testConsultaAlunoControleAlunoVazio(){
        this.controleAluno.consultaAluno("123");
    }

    /**
     *  Verifica se é lançada uma exceção caso consulte um aluno com matrícula vazia.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConsultaAlunoMatriculaVazia(){
        this.controleAluno.consultaAluno("");
    }

    /**
     *  Verifica se é lançada uma exceção caso consulte um aluno com matrícula nula.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConsultaAlunoMatriculaNula(){
        this.controleAluno.consultaAluno(null);
    }

    /**
     *  Verifica se é lançada uma exceção caso consulte um aluno com matrícula inválida.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConsultaAlunoMatriculaInvalida(){
        this.controleAluno.consultaAluno("invalida");
    }

    /**
     * Verifica se um grupo é cadastrado com sucesso ao ControleAluno.
     */
    @Test
    public void testCadastraGrupo(){
        Assert.assertTrue(this.controleAluno.cadastraGrupo("Molejão"));
    }

    /**
     * Verifica se é lançada uma exceção caso cadastre outro grupo com o mesmo nome.
     */
    @Test (expected = UnsupportedOperationException.class)
    public void testCadastraGrupoNomeExistente(){
        this.controleAluno.cadastraGrupo("Raça Negra");
        this.controleAluno.cadastraGrupo("Raça Negra");
    }

    /**
     * Verifica se um aluno é alocado em um grupo com sucesso ao ControleAluno.
     */
    @Test
    public void testAlocaAluno(){
        this.controleAluno.cadastraGrupo("Molejão");
        this.controleAluno.cadastraAluno("123", "Isaac Newton", "Física");
        Assert.assertTrue(this.controleAluno.alocaAluno("123", "Molejão"));
    }

    /**
     * Verifica se é lançada uma exceção caso tente alocar um aluno existente em um grupo não cadastrado.
     */
    @Test (expected = NoSuchElementException.class)
    public void testAlocaAlunoGrupoNaoExistente(){
        this.controleAluno.cadastraAluno("123", "Isaac Newton", "Física");
        this.controleAluno.alocaAluno("123", "Molejão");
    }

    /**
     * Verifica se é lançada uma exceção caso tente alocar um aluno não cadastrado.
     */
    @Test (expected = NoSuchElementException.class)
    public void testAlocaAlunoNaoExistente(){
        this.controleAluno.cadastraGrupo("Molejão");
        this.controleAluno.alocaAluno("123", "Molejão");
    }

    /**
     *  Verifica se é lançada uma exceção caso tente alocar um aluno com matrícula vazia.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAlocaAlunoMatriculaVazia(){
        this.controleAluno.alocaAluno("", "Molejão");
    }

    /**
     *  Verifica se é lançada uma exceção caso tente alocar um aluno com matrícula nula.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAlocaAlunoMatriculaNula(){
        this.controleAluno.alocaAluno(null, "Molejão");
    }

    /**
     *  Verifica se é lançada uma exceção caso tente alocar um aluno com matrícula inválida.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAlocaAlunoMatriculaInvalida(){
        this.controleAluno.alocaAluno("invalida", "Molejão");
    }

    /**
     *  Verifica se é lançada uma exceção caso tente alocar um aluno com nome do grupo vazio.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAlocaAlunoNomeGrupoVazio(){
        this.controleAluno.alocaAluno("123", "");
    }

    /**
     *  Verifica se é lançada uma exceção caso tente alocar um aluno com nome do grupo nulo.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAlocaAlunoNomeGrupoNulo(){
        this.controleAluno.alocaAluno(null, "");
    }

    /**
     * Verifica a listagem de todos os alunos cadastrados em um grupo.
     */
    @Test
    public void testListaAlunosAlocados(){
        this.controleAluno.cadastraAluno("123", "Alan Turing", "Matemática");
        this.controleAluno.cadastraGrupo("Molejão");
        this.controleAluno.alocaAluno("123", "Molejão");

        String toString = "Alunos do grupo Molejão:" + System.lineSeparator() + "* 123 - Alan Turing - Matemática" + System.lineSeparator();
        Assert.assertEquals(toString, this.controleAluno.listaAlunosAlocados("MOLEJÃO"));
    }

    /**
     *  Verifica se é lançada uma exceção caso tente listar os alunos de um grupo que ainda não foi cadastrado.
     */
    @Test (expected = NoSuchElementException.class)
    public void testListaAlunosAlocadosGrupoNaoExistente(){
        this.controleAluno.listaAlunosAlocados("MOLEJÃO");
    }

    /**
     *  Verifica se é lançada uma exceção caso tente listar os alunos de um grupo com nome vazio.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testListaAlunosAlocadosGrupoNomeVazio(){
        this.controleAluno.listaAlunosAlocados("");
    }

    /**
     *  Verifica se é lançada uma exceção caso tente listar os alunos de um grupo com nome nulo.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testListaAlunosAlocadosGrupoNomeNulo(){
        this.controleAluno.listaAlunosAlocados(null);
    }

    /**
     * Verifica se é possível consultar as informações de um aluno previamente cadastrado.
     */
    @Test
    public void testRegistraParticipacaoAluno(){
        this.controleAluno.cadastraAluno("123", "Isaac Newton", "Física");
        Assert.assertTrue(this.controleAluno.registraParticipacaoAluno("123"));
    }

    /**
     *  Verifica se é lançada uma exceção caso tente registra a participação de um aluno que ainda não foi cadastrado.
     */
    @Test (expected = NoSuchElementException.class)
    public void testRegistraParticipacaoAlunoInexistente(){
        this.controleAluno.registraParticipacaoAluno("123");
    }

    /**
     *  Verifica se é lançada uma exceção caso tente registra a participação de um aluno com matrícula vazia.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testRegistraParticipacaoAlunoMatriculaVazia(){
        this.controleAluno.registraParticipacaoAluno("");
    }

    /**
     *  Verifica se é lançada uma exceção caso tente registra a participação de um aluno com matrícula nula.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testRegistraParticipacaoAlunoMatriculaNula(){
        this.controleAluno.registraParticipacaoAluno(null);
    }

    /**
     *  Verifica se é lançada uma exceção caso tente registra a participação de um aluno com matrícula inválida.
     */
    @Test (expected = IllegalArgumentException.class)
    public void testRegistraParticipacaoAlunoMatriculaInvalida(){
        this.controleAluno.registraParticipacaoAluno("invalida");
    }

    /**
     * Verifica se é possível consultar as informações de um aluno previamente cadastrado.
     */
    @Test
    public void testListarAlunosParticipantes(){
        this.controleAluno.cadastraAluno("123", "Alan Turing", "Matemática");
        this.controleAluno.registraParticipacaoAluno("123");
        String toString = "Alunos:" + System.lineSeparator() + "1. 123 - Alan Turing - Matemática";
        Assert.assertEquals(toString, this.controleAluno.listaAlunosParticipantes());
    }

}
