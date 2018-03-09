package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * Classe responsavel por testar as funcionalidades da classe AlunoController.
 *
 */
public class AlunoControllerTest {

	private AlunoController alunoController;

	/**
	 * Inicializa alunoController.
	 */
	@Before
	public void iniciaAlunoController() {
		alunoController = new AlunoController();
	}

	/**
	 * Cadastra um aluno com telefone.
	 */
	@Before
	public void cadastraAluno() {
		this.alunoController.cadastrarAluno(
				"Joao", "1232423", "DD34", "8467989023", "joaozinho@blizzard.com");
	}

	/**
	 * Verifica se o cadastro de um aluno sem telefone pode ser realizado.
	 */
	@Test
	public void testCadastraAlunoSemTelefone() {
		this.alunoController.cadastrarAluno(
				"Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
	}

	/**
	 * Espera-se uma excecao ao cadastrar um aluno com matricula ja cadastrada
	 * anteriormente.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraAlunoMatriculaJaExistente() {
		this.alunoController.cadastrarAluno(
				"Lucas", "1232423", "EER4", "832334521", "luquinhas@blizzard.com");
	}

	/**
	 * Verifica os dados retornados por recupera aluno
	 */
	@Test
	public void testRecuperaAluno() {
		assertEquals(this.alunoController.recuperaAluno("1232423"),
				"1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com");
	}

	/**
	 * Espera-se uma excecao ao tentar recuperar um aluno com matricula nao
	 * existente.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testRecuperarAlunoNaoCadastrado() {
		this.alunoController.recuperaAluno("1347895");
	}
	
	/**
	 * Verifica a listagem dos alunos quando um aluno foi cadastrado.
	 */
	@Test
	public void testListarAlunosUmCadastrado() {
		assertEquals("1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com",
				this.alunoController.listarAlunos());
	}

	/**
	 * Verifica a listagem dos alunos quando dois alunos foram cadastrados.
	 */
	@Test
	public void testListarAlunosDoisCadastrados() {
		this.alunoController.cadastrarAluno(
				"Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
		assertEquals("1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com,"
				+ " 1232428 - Lucas - EER4 - luquinhas@blizzard.com",
				this.alunoController.listarAlunos());
	}

	/**
	 * Verifica se os alunos sao listados pela ordem configurada para nome
	 */
	@Test
	public void testListarAlunosPorNome() {
		this.alunoController.cadastrarAluno(
				"Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
		this.alunoController.cadastrarAluno(
				"Ana", "1232455", "DD34", "8495981012", "ana234@blizzard.com");
		this.alunoController.configurarOrdem("NOME");
		String retornoEsperado = "1232455 - Ana - DD34 - 8495981012 - ana234@blizzard.com, "
				+ "1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com, "
				+ "1232428 - Lucas - EER4 - luquinhas@blizzard.com";
		assertEquals(this.alunoController.listarAlunos(), retornoEsperado);
	}

	/**
	 * Verifica se os alunos sao listados pela ordem configurada para email
	 */
	@Test
	public void testListarAlunosPorEmail() {
		this.alunoController.cadastrarAluno(
				"Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
		this.alunoController.cadastrarAluno(
				"Ana", "1232455", "DD34", "8495981012", "ana234@blizzard.com");
		this.alunoController.configurarOrdem("EMAIL");
		String retornoEsperado = "1232455 - Ana - DD34 - 8495981012 - ana234@blizzard.com, "
				+ "1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com, "
				+ "1232428 - Lucas - EER4 - luquinhas@blizzard.com";
		assertEquals(this.alunoController.listarAlunos(), retornoEsperado);
	}
	
	/**
	 * Verifica se os alunos sao listados pela ordem configurada para matricula
	 */
	@Test
	public void testListarAlunosPorMatricula() {
		this.alunoController.cadastrarAluno(
				"Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
		this.alunoController.cadastrarAluno(
				"Ana", "1232455", "DD34", "8495981012", "ana234@blizzard.com");
		this.alunoController.configurarOrdem("MATRICULA");
		String retornoEsperado = "1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com, "
				+ "1232428 - Lucas - EER4 - luquinhas@blizzard.com, "
				+ "1232455 - Ana - DD34 - 8495981012 - ana234@blizzard.com";
		assertEquals(this.alunoController.listarAlunos(), retornoEsperado);
	}
	
	/**
	 * Verifica o retorno de getInfoAluno para o dado 'Matricula'
	 */
	@Test
	public void testGetInfoMatricula() {
		assertEquals("1232423", 
				this.alunoController.getInfoAluno("1232423", "Matricula"));
	}

	/**
	 * Verifica o retorno de getInfoAluno para o dado 'Nome'
	 */
	@Test
	public void testGetInfoNome() {
		assertEquals("Joao", 
				this.alunoController.getInfoAluno("1232423", "Nome"));
	}

	/**
	 * Verifica o retorno de getInfoAluno para o dado 'CodigoCurso'
	 */
	@Test
	public void testGetInfoCodigoCurso() {
		assertEquals("DD34", 
				this.alunoController.getInfoAluno("1232423", "CodigoCurso"));
	}

	/**
	 * Verifica o retorno de getInfoAluno para o dado 'Telefone'
	 */
	@Test
	public void testGetInfoTelefone() {
		assertEquals("8467989023", 
				this.alunoController.getInfoAluno("1232423", "Telefone"));
	}

	/**
	 * Verifica o retorno de getInfoAluno para o dado 'Email'
	 */
	@Test
	public void getInfoEmailTest() {
		assertEquals("joaozinho@blizzard.com", 
				this.alunoController.getInfoAluno("1232423", "Email"));
	}

	/**
	 * Verifica se uma informacao pode ser obtida de um aluno nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void getInfoAlunoNaoCadastradoTest() {
		this.alunoController.getInfoAluno("234523", "Nome");
	}
	
	/**
	 * Verifica se um aluno cadastrado pode se tornar tutor de uma disciplina.
	 */
	@Test
	public void tornarTutorTest() {
		this.alunoController.tornarTutor("1232423", "Programacao", 4);
	}
	
	/**
	 * Verifica se um aluno nao cadastrado pode se tornar tutor de uma 
	 * disciplina.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void tornarTutorAlunoNaoCadastradoTest() {
		this.alunoController.tornarTutor("237890", "Calculo I", 3);
	}
	
	/**
	 * Verifica se um tutor cadastrado pode ser recuperado.
	 */
	@Test
	public void recuperaTutorTest() {
		Aluno novoAluno = new Aluno("Joao", "1232423", "DD34", "8467989023",
				"joaozinho@blizzard.com");
		this.alunoController.tornarTutor("1232423", "Programacao", 4);
		assertEquals(novoAluno.toString(), this.alunoController.recuperaTutor(
				"1232423"));
	}
	
	/**
	 * Verifica se um tutor nao cadastrado pode ser recuperado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void recuperarTutorAlunoNaoCadastradoTest() {
		this.alunoController.recuperaAluno("232342");
	}
	
	/**
	 * Verifica se um horario de atendimento pode ser cadastrado
	 * para um email valido de tutor.
	 */
	@Test
	public void cadastrarHorarioTest() {
		this.alunoController.tornarTutor("1232423", "Programacao", 4);
		this.alunoController.cadastrarHorario("joaozinho@blizzard.com",
				"17:30", "21/03");
	}
	
	/**
	 * Verifica se um horario de atendimento pode ser cadastrado
	 * para um email nulo de tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarHorarioEmailNuloTest() {
		this.alunoController.cadastrarHorario(null, "17:30", "21/03");
	}
	
	/**
	 * Verifica se um horario de atendimento pode ser cadastrado
	 * para um email vazio de tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarHorarioEmailVazioTest() {
		this.alunoController.cadastrarHorario("", "17:30", "21/03");
	}
	
	/**
	 * Verifica se um horario de atendimento pode ser cadastrado
	 * para um email de tutor nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarHorarioTutorNCadastradoTest() {
		this.alunoController.cadastrarHorario("elizinha@blizzard.com", "14:30",
				"23/03");
	}
	
	/**
	 * Verifica se um local de atendimento pode ser cadastrado
	 * para um email valido de tutor.
	 */
	@Test
	public void cadastrarLocalDeAtendimentoTest() {
		this.alunoController.tornarTutor("1232423", "Programacao", 4);
		this.alunoController.cadastrarLocalDeAtendimento(
				"joaozinho@blizzard.com", "LCC3");
	}
	
	/**
	 * Verifica se um local de atendimento pode ser cadastrado
	 * para um email nulo de tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarLocalDeAtendimentoEmailNuloTest() {
		this.alunoController.cadastrarLocalDeAtendimento(null, "LCC3");
	}
	
	/**
	 * Verifica se um local de atendimento pode ser cadastrado
	 * para um email vazio de tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarLocalDeAtendimentoEmailVazioTest() {
		this.alunoController.cadastrarLocalDeAtendimento("", "LCC3");
	}
	
	/**
	 * Verifica se um local de atendimento pode ser cadastrado
	 * para um email de tutor nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void cadastrarLocalDeAtendimentoTutorNCadastradoTest() {
		this.alunoController.cadastrarLocalDeAtendimento(
				"elizinha@blizzard.com", "LCC3");
	}
	
	/**
	 * Verifica se um horario de atendimento cadastrado de um tutor
	 * esta entre seus horarios de atendimento.
	 */
	@Test
	public void consultaHorarioTest() {
		this.alunoController.tornarTutor("1232423", "Programacao", 4);
		this.alunoController.cadastrarHorario("joaozinho@blizzard.com",
				"17:30", "21/03");
		assertEquals(true,this.alunoController.consultaHorario(
				"joaozinho@blizzard.com", "17:30", "21/03"));
	}
	
	/**
	 * Verifica se um horario de atendimento nao cadastrado de um tutor
	 * esta entre seus horarios de atendimento.
	 */
	@Test
	public void consultaHorarioNaoCadastradoTest() {
		this.alunoController.tornarTutor("1232423", "Programacao", 4);
		this.alunoController.cadastrarHorario("joaozinho@blizzard.com",
				"14:30", "21/03");
		assertEquals(false, this.alunoController.consultaHorario(
				"joaozinho@blizzard.com", "17:30", "21/03"));
	}
	
	/**
	 * Verifica se um horario de atendimento de um tutor nao cadastrado
	 * esta entre seus horarios de atendimento.
	 */
	@Test
	public void consultaHorarioTutorNaoCadastradoTest() {
		assertEquals(false, this.alunoController.consultaHorario(
				"elizinha@blizzard.com", "17:30", "21/03"));
	}
	
	/**
	 * Verifica se um local de atendimento cadastrado de um tutor
	 * esta entre seus locais de atendimento.
	 */
	@Test
	public void consultaLocalDeAtendimentoTest() {
		this.alunoController.tornarTutor("1232423", "Programacao", 4);
		this.alunoController.cadastrarLocalDeAtendimento("joaozinho@blizzard.com", "UFCG");
		assertEquals(true,this.alunoController.consultaLocal("joaozinho@blizzard.com", "UFCG"));
	}
	
	/**
	 * Testa a listagem dos tutores quando nenhum tutor foi cadastrado.
	 */
	@Test
	public void listarTutoresSemTutores() {
		assertEquals(this.alunoController.listarTutores(), "");
	}
	
	/**
	 * Testa a listagem dos tutores quando um tutor foi cadastrado.
	 */
	@Test
	public void listarTutoresComUmTutor() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("111111", "TG", 4);
		assertEquals(this.alunoController.listarTutores(),
				"111111 - Beatriz - CC - 99999999 - bia@ccc.com");
	}

}

