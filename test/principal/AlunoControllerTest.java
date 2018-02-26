package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoControllerTest {

	private AlunoController alunoController;

	/**
	 * Cria uma instancia de alunoController.
	 */
	@Before
	public void iniciaAlunoController() {
		alunoController = new AlunoController();
	}

	/**
	 * Cadastra um aluno com telefone.
	 */
	@Before
	public void CadastraAlunoTest() {
		this.alunoController.cadastrarAluno("Joao", "1232423", "DD34", "8467989023", "joaozinho@blizzard.com");
	}

	/**
	 * Verifica se o cadastro de um aluno sem telefone funciona como esperado.
	 */
	@Test
	public void cadastraAlunoSemTelefoneTest() {
		this.alunoController.cadastrarAluno("Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
	}

	/**
	 * Espera-se uma excecao ao cadastrar um aluno com matricula ja cadastrada
	 * anteriormente.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void cadastraAlunoMatriculaJaExistenteTest() {
		this.alunoController.cadastrarAluno("Lucas", "1232423", "EER4", "832334521", "luquinhas@blizzard.com");
	}

	/**
	 * Verifica os dados retornados por recupera aluno
	 */
	@Test
	public void recuperaAlunoTest() {
		assertEquals(this.alunoController.recuperaAluno("1232423"),
				"1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com");
	}

	/**
	 * Espera-se uma excecao ao tentar recuperar um aluno com matricula nao
	 * existente.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void recuperarAlunoNaoCadastrado() {
		this.alunoController.recuperaAluno("1347895");
	}

	/**
	 * Verifica a lista retornada de todos os alunos cadastrados
	 */
	@Test
	public void listarAlunos() {
		this.alunoController.cadastrarAluno("Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
		assertEquals(
				"1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com, 1232428 - Lucas - EER4 - luquinhas@blizzard.com",
				this.alunoController.listarAlunos());
	}

	/**
	 * Verifica o retorno de getInfoAluno para o dado 'Matricula'
	 */
	@Test
	public void getInfoMatriculaTest() {
		assertEquals("1232423", this.alunoController.getInfoAluno("1232423", "Matricula"));
	}

	/**
	 * Verifica o retorno de getInfoAluno para o dado 'Nome'
	 */
	@Test
	public void getInfoNomeTest() {
		assertEquals("Joao", this.alunoController.getInfoAluno("1232423", "Nome"));
	}

	/**
	 * Verifica o retorno de getInfoAluno para o dado 'CodigoCurso'
	 */
	@Test
	public void getInfoCodigoCursoTest() {
		assertEquals("DD34", this.alunoController.getInfoAluno("1232423", "CodigoCurso"));
	}

	/**
	 * Verifica o retorno de getInfoAluno para o dado 'Telefone'
	 */
	@Test
	public void getInfoTelefoneTest() {
		assertEquals("8467989023", this.alunoController.getInfoAluno("1232423", "Telefone"));
	}

	/**
	 * Verifica o retorno de getInfoAluno para o dado 'Email'
	 */
	@Test
	public void getInfoEmailTest() {
		assertEquals("joaozinho@blizzard.com", this.alunoController.getInfoAluno("1232423", "Email"));
	}

	/**
	 * Espera-se excecao ao tentar consultar informacao de um aluno com matricula
	 * nao cadastrada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoNaoCadastradoTest() {
		this.alunoController.getInfoAluno("234523", "Nome");
	}
}
