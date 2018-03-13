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
	public void testCadastraAluno() {
		this.alunoController.cadastrarAluno(
				"Joao", "1232423", "DD34", "8467989023", 
				"joaozinho@blizzard.com");
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
				"Lucas", "1232423", "EER4", "832334521", 
				"luquinhas@blizzard.com");
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
	public void testGetInfoEmailTest() {
		assertEquals("joaozinho@blizzard.com", 
				this.alunoController.getInfoAluno("1232423", "Email"));
	}

	/**
	 * Verifica se uma informacao pode ser obtida de um aluno nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAlunoNaoCadastradoTest() {
		this.alunoController.getInfoAluno("234523", "Nome");
	}
	
	/**
	 * Verifica se um aluno cadastrado pode se tornar tutor de uma disciplina.
	 */
	@Test
	public void testTornarTutorTest() {
		this.alunoController.tornarTutor("1232423", "Programacao", 4);
	}
	
	/**
	 * Verifica se um aluno nao cadastrado pode se tornar tutor de uma 
	 * disciplina.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testTornarTutorAlunoNaoCadastradoTest() {
		this.alunoController.tornarTutor("237890", "Calculo I", 3);
	}
	
	/**
	 * Verifica se um tutor cadastrado pode ser recuperado.
	 */
	@Test
	public void testRecuperaTutorTest() {
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
	public void testRecuperarTutorAlunoNaoCadastradoTest() {
		this.alunoController.recuperaAluno("232342");
	}
	
	/**
	 * Verifica se um horario de atendimento pode ser cadastrado
	 * para um email valido de tutor.
	 */
	@Test
	public void testCadastrarHorarioTest() {
		this.alunoController.tornarTutor("1232423", "Programacao", 4);
		this.alunoController.cadastrarHorario("joaozinho@blizzard.com",
				"17:30", "21/03");
	}
	
	/**
	 * Verifica se um horario de atendimento pode ser cadastrado
	 * para um email nulo de tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioEmailNuloTest() {
		this.alunoController.cadastrarHorario(null, "17:30", "21/03");
	}
	
	/**
	 * Verifica se um horario de atendimento pode ser cadastrado
	 * para um email vazio de tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioEmailVazioTest() {
		this.alunoController.cadastrarHorario("", "17:30", "21/03");
	}
	
	/**
	 * Verifica se um horario de atendimento pode ser cadastrado
	 * para um email de tutor nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioTutorNCadastradoTest() {
		this.alunoController.cadastrarHorario("elizinha@blizzard.com", "14:30",
				"23/03");
	}
	
	/**
	 * Verifica se um local de atendimento pode ser cadastrado
	 * para um email valido de tutor.
	 */
	@Test
	public void testCadastrarLocalDeAtendimentoTest() {
		this.alunoController.tornarTutor("1232423", "Programacao", 4);
		this.alunoController.cadastrarLocalDeAtendimento(
				"joaozinho@blizzard.com", "LCC3");
	}
	
	/**
	 * Verifica se um local de atendimento pode ser cadastrado
	 * para um email nulo de tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalDeAtendimentoEmailNuloTest() {
		this.alunoController.cadastrarLocalDeAtendimento(null, "LCC3");
	}
	
	/**
	 * Verifica se um local de atendimento pode ser cadastrado
	 * para um email vazio de tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalDeAtendimentoEmailVazioTest() {
		this.alunoController.cadastrarLocalDeAtendimento("", "LCC3");
	}
	
	/**
	 * Verifica se um local de atendimento pode ser cadastrado
	 * para um email de tutor nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalDeAtendimentoTutorNCadastradoTest() {
		this.alunoController.cadastrarLocalDeAtendimento(
				"elizinha@blizzard.com", "LCC3");
	}
	
	/**
	 * Verifica se um horario de atendimento cadastrado de um tutor
	 * esta entre seus horarios de atendimento.
	 */
	@Test
	public void testConsultaHorarioTest() {
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
	public void testConsultaHorarioNaoCadastradoTest() {
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
	public void testConsultaHorarioTutorNaoCadastradoTest() {
		assertEquals(false, this.alunoController.consultaHorario(
				"elizinha@blizzard.com", "17:30", "21/03"));
	}
	
	/**
	 * Verifica se um local de atendimento cadastrado de um tutor
	 * esta entre seus locais de atendimento.
	 */
	@Test
	public void testConsultaLocalDeAtendimentoTest() {
		this.alunoController.tornarTutor("1232423", "Programacao", 4);
		this.alunoController.cadastrarLocalDeAtendimento(
				"joaozinho@blizzard.com", "UFCG");
		assertEquals(true,this.alunoController.consultaLocal(
				"joaozinho@blizzard.com", "UFCG"));
	}
	
	/**
	 * Testa a listagem dos tutores quando nenhum tutor foi cadastrado.
	 */
	@Test
	public void testListarTutoresSemTutores() {
		assertEquals(this.alunoController.listarTutores(), "");
	}
	
	/**
	 * Testa a listagem dos tutores quando um tutor foi cadastrado.
	 */
	@Test
	public void testListarTutoresComUmTutor() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("111111", "TG", 4);
		assertEquals(this.alunoController.listarTutores(),
				"111111 - Beatriz - CC - 99999999 - bia@ccc.com");
	}
	
	/**
	 * Verifica se uma avaliacao pode ser feita para um aluno nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorAlunoNaoCadastrado() {
		this.alunoController.avaliarTutor("1111111", 3);
	}
	
	/**
	 * Verifica se uma avaliacao pode ser feita para um aluno cadastrado que
	 * nao eh tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorAlunoCadastradoNaoTutor() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.alunoController.avaliarTutor("1111111", 3);
	}
	
	/**
	 * Verifica se uma avaliacao pode ser feita para um aluno cadastrado que
	 * eh tutor.
	 */
	@Test
	public void testAvaliarTutorAlunoCadastradoTutor() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("111111", "P2", 5);
		this.alunoController.avaliarTutor("111111", 5);
	}
	
	/**
	 * Verifica se uma avaliacao pode ser feita para um aluno cadastrado, que
	 * eh tutor, quando a nota eh zero.
	 */
	@Test
	public void testAvaliarTutorNotaMinima() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("111111", "P2", 5);
		this.alunoController.avaliarTutor("111111", 0);
	}
	
	/**
	 * Verifica se uma avaliacao pode ser feita para um aluno cadastrado, que
	 * eh tutor, quando a nota eh zero.
	 */
	@Test
	public void testAvaliarTutorNotaMaxima() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("111111", "P2", 5);
		this.alunoController.avaliarTutor("111111", 5);
	}
	
	/**
	 * Verifica se a nota de um tutor eh retornada quando a matricula informada
	 * e nula.*/
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNotaMatriculaNula() {
		this.alunoController.getNota(null);
	}
	
	/**
	 * Verifica se a nota de um tutor eh retornada quando a matricula informada
	 * e vazia.*/
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNotaMatriculaVazia() {
		this.alunoController.getNota("");
	}
	
	/**
	 * Verifica se a nota de um tutor eh retornada quando a matricula informada
	 * nao foi registrada no sistema.
	 * */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNotaMatriculaInexistente() {
		this.alunoController.getNota("111111111");
	}
	
	/**
	 * Verifica se a nota de um tutor eh retornada quando a matricula informada
	 * eh de um aluno que nao eh tutor.
	 * */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNotaMatriculaNaoTutor() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.alunoController.getNota("111111");
	}
	
	/**
	 * Verifica se a nota de um tutor eh retornada quando a matricula informada
	 * eh de um aluno que eh tutor que nao foi avaliado.
	 * */
	@Test
	public void testPegarNotaMatriculaTutorNaoAvaliado() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("111111", "P2", 5);
		assertEquals(4, this.alunoController.getNota("111111"), 0);
	}
	
	/**
	 * Verifica se a nota de um tutor eh retornada quando a matricula informada
	 * eh de um aluno que eh tutor que foi avaliado.
	 * */
	@Test
	public void testPegarNotaMatriculaTutorAvaliado() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("111111", "P2", 5);
		this.alunoController.avaliarTutor("111111", 5);
		assertEquals(4.16, this.alunoController.getNota("111111"), 0.01);
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula informada
	 * e nula.*/
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNivelMatriculaNula() {
		this.alunoController.getNivel(null);
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula informada
	 * e vazia.*/
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNivelMatriculaVazia() {
		this.alunoController.getNivel("");
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula informada
	 * nao foi registrada no sistema.
	 * */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNivelMatriculaInexistente() {
		this.alunoController.getNivel("111111111");
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula informada
	 * eh de um aluno que nao eh tutor.
	 * */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNivelMatriculaNaoTutor() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.alunoController.getNivel("111111");
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula informada
	 * eh de um aluno que eh tutor que nao foi avaliado.
	 */
	@Test
	public void testPegarNivelMatriculaTutorNaoAvaliado() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("111111", "P2", 5);
		assertEquals("Tutor", this.alunoController.getNivel("111111"));
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula 
	 * informada eh de um aluno que eh tutor de uma ajuda presencial.
	 */
	@Test
	public void testPegarNivelMatriculaTutorAvaliadoAjudaPresencial() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("3333", "TG", 5);
		this.alunoController.cadastrarLocalDeAtendimento("bia@ccc.com",
				"LCC3");
		this.alunoController.cadastrarHorario("bia@ccc.com", "13:00", 
				"seg");
		this.alunoController.avaliarTutor("3333", 5);
		assertEquals("Tutor", this.alunoController.getNivel("3333"));
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula 
	 * informada eh de um aluno que eh tutor de uma ajuda online.
	 */
	@Test
	public void testPegarNivelMatriculaTutorAvaliadoAjudaOnline() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("3333", "TG", 5);
		this.alunoController.avaliarTutor("3333", 5);
		assertEquals("Tutor", this.alunoController.getNivel("3333"));
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula 
	 * informada eh de um aluno que eh tutor que foi avaliado com boas notas.
	 */
	@Test
	public void testPegarNivelMatriculaTutorAvaliadoBoasNotas() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("3333", "TG", 5);
		this.alunoController.cadastrarLocalDeAtendimento("bia@ccc.com",
				"LCC3");
		this.alunoController.cadastrarHorario("bia@ccc.com", "13:00", 
				"seg");
		this.alunoController.avaliarTutor("3333", 5);
		this.alunoController.avaliarTutor("3333", 5);
		this.alunoController.avaliarTutor("3333", 5);
		this.alunoController.avaliarTutor("3333", 5);
		this.alunoController.avaliarTutor("3333", 5);
		assertEquals("TOP", this.alunoController.getNivel("3333"));
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula 
	 * informada eh de um aluno que eh tutor que foi avaliado com notas medias.
	 */
	@Test
	public void testPegarNivelMatriculaTutorAvaliadoNotasMedias() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("3333", "TG", 5);
		this.alunoController.cadastrarLocalDeAtendimento("bia@ccc.com",
				"LCC3");
		this.alunoController.cadastrarHorario("bia@ccc.com", "13:00", 
				"seg");
		this.alunoController.avaliarTutor("3333", 4);
		this.alunoController.avaliarTutor("3333", 4);
		this.alunoController.avaliarTutor("3333", 4);
		assertEquals("Tutor", this.alunoController.getNivel("3333"));
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula 
	 * informada eh de um aluno que eh tutor que foi avaliado com notas baixas.
	 */
	@Test
	public void testPegarNivelMatriculaTutorAvaliadoNotasBaixas() {
		this.alunoController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.alunoController.tornarTutor("3333", "TG", 5);
		this.alunoController.cadastrarLocalDeAtendimento("bia@ccc.com",
				"LCC3");
		this.alunoController.cadastrarHorario("bia@ccc.com", "13:00", 
				"seg");
		this.alunoController.avaliarTutor("3333", 1);
		this.alunoController.avaliarTutor("3333", 1);
		this.alunoController.avaliarTutor("3333", 1);
		assertEquals("Aprendiz", this.alunoController.getNivel("3333"));
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula do tutor eh 
	 * vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaVazia() {
		this.alunoController.doarDinheiro("", 100);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula do tutor eh 
	 * em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaEmBranco() {
		this.alunoController.doarDinheiro("   ", 100);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula do tutor eh 
	 * nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaNula() {
		this.alunoController.doarDinheiro(null, 100);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula do tutor nao 
	 * foi registrada no sistema.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaInvalida() {
		this.alunoController.doarDinheiro("10101010", 100);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula informada eh 
	 * de um aluno que nao eh tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaNaoTutor() {
		this.alunoController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.alunoController.doarDinheiro("22222", 100);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula informada eh 
	 * de um aluno que eh tutor.
	 */
	@Test
	public void testDoarMatriculaTutor() {
		this.alunoController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.alunoController.tornarTutor("22222", "P2", 5);
		this.alunoController.doarDinheiro("22222", 100);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula informada eh 
	 * de um aluno que eh tutor e o valor informado eh zero.
	 */
	@Test
	public void testDoarMatriculaTutorZero() {
		this.alunoController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.alunoController.tornarTutor("22222", "P2", 5);
		this.alunoController.doarDinheiro("22222", 0);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando o valor doado eh negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarValorNegativo() {
		this.alunoController.doarDinheiro("22222", -1);
	}
	
	/**
	 * Verifica se a configuracao de ordenacao pode ser feita quando o tipo de
	 * ordenacao informado eh nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConfigurarOrdemArgumentoNulo() {
		this.alunoController.configurarOrdem(null);
	}
	
	/**
	 * Verifica se a configuracao de ordenacao pode ser feita quando o tipo de
	 * ordenacao informado eh vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConfigurarOrdemArgumentoVazio() {
		this.alunoController.configurarOrdem("");
	}
	
	/**
	 * Verifica se a configuracao de ordenacao pode ser feita quando o tipo de
	 * ordenacao informado eh em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConfigurarOrdemArgumentoEmBranco() {
		this.alunoController.configurarOrdem("   ");
	}
	
	/**
	 * Verifica se a configuracao de ordenacao pode ser feita quando o tipo de
	 * ordenacao informado eh invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConfigurarOrdemArgumentoInvalido() {
		this.alunoController.configurarOrdem("blabla");
	}
	
	/**
	 * Verifica se a configuracao de ordenacao pode ser feita quando o tipo de
	 * ordenacao informado eh NOME.
	 */
	@Test
	public void testConfigurarOrdemArgumentoNome() {
		this.alunoController.configurarOrdem("NOME");
	}
	
	/**
	 * Verifica se a configuracao de ordenacao pode ser feita quando o tipo de
	 * ordenacao informado eh MATRICULA.
	 */
	@Test
	public void testConfigurarOrdemArgumentoMatricula() {
		this.alunoController.configurarOrdem("MATRICULA");
	}
	
	/**
	 * Verifica se a configuracao de ordenacao pode ser feita quando o tipo de
	 * ordenacao informado eh EMAIL.
	 */
	@Test
	public void testConfigurarOrdemArgumentoEmail() {
		this.alunoController.configurarOrdem("EMAIL");
	}
	
	/**
	 * Verifica se os dados de alunos sao gravados em arquivo
	 */
	@Test
	public void testGravarAlunos() {
		this.alunoController.cadastrarAluno(
				"Ana", "1232455", "DD34", "8495981012", "ana234@blizzard.com");
		assert(this.alunoController.gravarAlunos());
	}
	
	/**
	 * Verifica se os dados de alunos que sao tutores sao gravados
	 */
	@Test
	public void testGravarAlunosTutores() {
		this.alunoController.cadastrarAluno(
				"Ana", "1232455", "DD34", "8495981012", "ana234@blizzard.com");
		this.alunoController.tornarTutor("1232455", "P2", 5);
		this.alunoController.cadastrarLocalDeAtendimento("ana234@blizzard.com", "LCC2");
		this.alunoController.cadastrarHorario("ana234@blizzard.com", "13:00", "qua");
		assert(this.alunoController.gravarAlunos());
	}
	
	/**
	 * Verifica se a leitura dos dados de alunos foi realizada corretamente,
	 * listando os alunos alfabeticamente
	 */
	@Test
	public void testLerAlunos() {
		this.alunoController.lerAlunos();
		String retornoEsperado = "1232455 - Ana - DD34 - 8495981012 - ana234@blizzard.com, "
				+ "1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com";
		assertEquals(this.alunoController.listarAlunos(), retornoEsperado);
	}
	
	/**
	 * Verifica se a leitura dos dados de alunos que sao tutores foi realizada 
	 * corretamente, listando os alunos alfabeticamente
	 */
	@Test
	public void testLerAlunosTutores() {
		this.alunoController.lerAlunos();
		String retornoEsperado = "1232455 - Ana - DD34 - 8495981012 - ana234@blizzard.com";
		assertEquals(this.alunoController.listarTutores(), retornoEsperado);
	}
	
	/**
	 * Verifica se a limpeza dos dados de alunos eh realizada.
	 */
	@Test
	public void testDeletarAlunos() {
		this.alunoController.deletarAlunos();
	}
	

	
}