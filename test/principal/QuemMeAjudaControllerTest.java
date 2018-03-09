package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe responsavel por testar as funcionalidades da classe 
 * QuemMeAjudaController.
 *
 */
public class QuemMeAjudaControllerTest {
	
	private QuemMeAjudaController quemMeAjudaController;
	
	/**
	 * Inicializa quemMeAjudaController.
	 */
	@Before
	public void iniciaAjudaController() {
		this.quemMeAjudaController = new QuemMeAjudaController();
	}

	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando a matricula do
	 * aluno e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatrAlunoVazia() {
		this.quemMeAjudaController.pedirAjudaPresencial("", "P2",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando a matricula do
	 * aluno e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatrAlunoEmBranco() {
		this.quemMeAjudaController.pedirAjudaPresencial("    ", "P2",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando a disciplina
	 * de interesse e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDisciplinaVazia() {
		this.quemMeAjudaController.pedirAjudaPresencial("11111111", "",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando a disciplina
	 * de interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDisciplinaEmBranco() {
		this.quemMeAjudaController.pedirAjudaPresencial("11111111", "  ",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o horario de
	 * interesse e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioVazio() {
		this.quemMeAjudaController.pedirAjudaPresencial("11111111", "P2",
				"", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o horario de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioEmBranco() {
		this.quemMeAjudaController.pedirAjudaPresencial("11111111", "P2",
				"   ", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o dia de
	 * interesse e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaVazio() {
		this.quemMeAjudaController.pedirAjudaPresencial("11111111", "P2",
				"13:00", "", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o dia de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaEmBranco() {
		this.quemMeAjudaController.pedirAjudaPresencial("11111111", "P2",
				"13:00", "   ", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o local de
	 * interesse e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalVazio() {
		this.quemMeAjudaController.pedirAjudaPresencial("11111111", "P2",
				"", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o local de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalEmBranco() {
		this.quemMeAjudaController.pedirAjudaPresencial("11111111", "P2",
				"   ", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial que nao possui monitor disponivel pode
	 * ser cadastrada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialSemMonitor() {
		this.quemMeAjudaController.pedirAjudaPresencial(
				"11111111", "P2", "13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se a primeira ajuda presencial cadastrada possui indice 1.
	 */
	@Test
	public void testPedirPrimeiraAjudaPresencialValida() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.cadastrarHorario("mario@ccc.edu.br",
				"13:00", "seg");
		this.quemMeAjudaController.cadastrarLocalDeAtendimento(
				"mario@ccc.edu.br", "LCC2");
		assertEquals(1, this.quemMeAjudaController.pedirAjudaPresencial(
				"11111111", "P2", "13:00", "seg", "LCC2"));
	}
	
	/**
	 * Verifica se a segunda ajuda presencial cadastrada possui indice 2.
	 */
	@Test
	public void testPedirSegundaAjudaPresencialValida() {
		this.quemMeAjudaController.cadastrarAluno("Mario", "22222", "CC", "",
				"mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.cadastrarHorario("mario@ccc.edu.br",
				"13:00", "seg");
		this.quemMeAjudaController.cadastrarHorario("mario@ccc.edu.br",
				"15:00", "sex");
		this.quemMeAjudaController.cadastrarLocalDeAtendimento(
				"mario@ccc.edu.br", "LCC2");
		this.quemMeAjudaController.pedirAjudaPresencial("11111111", "P2",
				"15:00", "sex", "LCC2");
		assertEquals(2, this.quemMeAjudaController.pedirAjudaPresencial(
				"11111111", "P2", "13:00", "seg", "LCC2"));
	}
	
	/**
	 * Verifica se uma ajuda online pode ser pedida quando a matricula do
	 * aluno e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatrAlunoVazia() {
		this.quemMeAjudaController.pedirAjudaOnline("", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser pedida quando a matricula do
	 * aluno e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatrAlunoEmBranco() {
		this.quemMeAjudaController.pedirAjudaOnline("    ", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser pedida quando a disciplina
	 * de interesse e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaVazia() {
		this.quemMeAjudaController.pedirAjudaOnline("11111111", "");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser pedida quando a disciplina
	 * de interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaEmBranco() {
		this.quemMeAjudaController.pedirAjudaOnline("11111111", "  ");
	}
	
	/**
	 * Verifica se uma ajuda online que nao possui monitor disponivel pode
	 * ser cadastrada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineSemMonitor() {
		this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2");
	}
	
	/**
	 * Verifica se a primeira ajuda online cadastrada possui indice 1.
	 */
	@Test
	public void testPedirPrimeiraAjudaOnlineValida() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		assertEquals(1, this.quemMeAjudaController.pedirAjudaOnline("11111111",
				"P2"));
	}
	
	/**
	 * Verifica se a segunda ajuda online cadastrada possui indice 2.
	 */
	@Test
	public void testPedirSegundaAjudaOnlineValida() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.pedirAjudaOnline("22222222", "P2");
		assertEquals(2, this.quemMeAjudaController.pedirAjudaOnline("11111111",
				"P2"));
	}
	
	/**
	 * Verifica se um tutor de uma ajuda de id negativo pode ser
	 * retornada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaIdNegativo() {
		this.quemMeAjudaController.pegarTutor(-1);
	}
	
	/**
	 * Verifica se um tutor de uma ajuda de id zero pode ser
	 * retornado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaIdZero() {
	    this.quemMeAjudaController.pegarTutor(0);
	}
	
	/**
	 * Verifica se um tutor de uma ajuda online de id positivo
	 * pode ser retornado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaOnlineIdPositivo() {
	    assertEquals("Tutor - 22222222, disciplina - P2", 
	    		this.quemMeAjudaController.pegarTutor(
	    				this.quemMeAjudaController.pedirAjudaOnline("11111111",
	    						"P2")));
	}
	
	/**
	 * Verifica se um tutor de uma ajuda presencial de id
	 * positivo pode ser retornado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaPresencialIdPositivo() {
	    assertEquals("Tutor - 22222222, horario - 13:00, dia - seg, "
	    		+ "local - LCC2, disciplina - P2",
	    		this.quemMeAjudaController.pegarTutor(
	    				this.quemMeAjudaController.pedirAjudaPresencial(
	    						"11111111", "P2", "LCC2", "seg", "13:00")));
	}
	
	/**
	 * Verifica se a doacao do dinheiro ao tutor eh realizada devidamente
	 */
	@Test
	public void testDoarDinheiroAoTutor() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.ufcg.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.doarDinheiro("22222", 100);
		assertEquals(80, this.quemMeAjudaController.totalDinheiroTutor("mario@ccc.ufcg.edu.br"));
	}
	
	/**
	 * Espera-se erro ao tentar recuperar o total de dinheiro de um tutor
	 * nao encontrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarDinheiroEmailInexistente() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.ufcg.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.doarDinheiro("22222", 100);
		assertEquals(80, this.quemMeAjudaController.totalDinheiroTutor("luzia@ccc.ufcg.edu.br"));
	}
	
	/**
	 * Espera-se erro ao tentar recuperar o total de dinheiro de um tutor
	 * informando um email vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarDinheiroEmailVazio() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.ufcg.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.doarDinheiro("22222", 100);
		assertEquals(80, this.quemMeAjudaController.totalDinheiroTutor("  "));
	}
	
	/**
	 * Espera-se erro ao tentar doar uma quantia negativa
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarDinheiroInvalido() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.ufcg.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.doarDinheiro("22222", -500);
	}
	
	/**
	 * Verifica se o dinheiro destinado ao sistema eh calculada devidamente
	 */
	@Test
	public void testTotalDinheiroSistema() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.ufcg.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.doarDinheiro("22222", 100);
		assertEquals(20, this.quemMeAjudaController.totalDinheiroSistema());
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id negativo pode ser
	 * feita.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorIdAjudaNegativo() {
		this.quemMeAjudaController.avaliarTutor(-1, 4);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id nao cadastrado 
	 * pode ser feita.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorIdAjudaNaoCadastrado() {
		this.quemMeAjudaController.avaliarTutor(1, 4);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id cadastrado pode 
	 * ser feita.
	 */
	@Test
	public void testAvaliarTutorIdAjudaCadastrado() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2"), 
				4);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id cadastrado pode 
	 * ser feita quando a nota e inferior a zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaNegativa() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2"), 
				-1);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id cadastrado pode 
	 * ser feita quando a nota e superior a cinco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaAcimaPermitido() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2"), 
				6);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id cadastrado pode 
	 * ser feita quando a nota e igual a zero.
	 */
	@Test
	public void testAvaliarTutorNotaMinima() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2"), 
				0);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id cadastrado pode 
	 * ser feita quando a nota e igual a cinco.
	 */
	@Test
	public void testAvaliarTutorNotaMaxima() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2"), 
				5);
	}
	
	/**
	 * Verifica se os alunos sao listados pela ordem configurada para nome
	 */
	@Test
	public void testListarAlunosPorNome() {
		this.quemMeAjudaController.cadastrarAluno(
				"Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
		this.quemMeAjudaController.cadastrarAluno(
				"Ana", "1232455", "DD34", "8495981012", "ana234@blizzard.com");
		this.quemMeAjudaController.cadastrarAluno(
				"Joao", "1232423", "DD34", "8467989023", "joaozinho@blizzard.com");
		this.quemMeAjudaController.configurarOrdem("NOME");
		String retornoEsperado = "1232455 - Ana - DD34 - 8495981012 - ana234@blizzard.com, "
				+ "1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com, "
				+ "1232428 - Lucas - EER4 - luquinhas@blizzard.com";
		assertEquals(this.quemMeAjudaController.listarAlunos(), retornoEsperado);
	}

	/**
	 * Verifica se os alunos sao listados pela ordem configurada para email
	 */
	@Test
	public void testListarAlunosPorEmail() {
		this.quemMeAjudaController.cadastrarAluno(
				"Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
		this.quemMeAjudaController.cadastrarAluno(
				"Ana", "1232455", "DD34", "8495981012", "ana234@blizzard.com");
		this.quemMeAjudaController.cadastrarAluno(
				"Joao", "1232423", "DD34", "8467989023", "joaozinho@blizzard.com");
		this.quemMeAjudaController.configurarOrdem("EMAIL");
		String retornoEsperado = "1232455 - Ana - DD34 - 8495981012 - ana234@blizzard.com, "
				+ "1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com, "
				+ "1232428 - Lucas - EER4 - luquinhas@blizzard.com";
		assertEquals(this.quemMeAjudaController.listarAlunos(), retornoEsperado);
	}
	
	/**
	 * Verifica se os alunos sao listados pela ordem configurada para matricula
	 */
	@Test
	public void testListarAlunosPorMatricula() {
		this.quemMeAjudaController.cadastrarAluno(
				"Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
		this.quemMeAjudaController.cadastrarAluno(
				"Ana", "1232455", "DD34", "8495981012", "ana234@blizzard.com");
		this.quemMeAjudaController.cadastrarAluno(
				"Joao", "1232423", "DD34", "8467989023", "joaozinho@blizzard.com");
		this.quemMeAjudaController.configurarOrdem("MATRICULA");
		String retornoEsperado = "1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com, "
				+ "1232428 - Lucas - EER4 - luquinhas@blizzard.com, "
				+ "1232455 - Ana - DD34 - 8495981012 - ana234@blizzard.com";
		assertEquals(this.quemMeAjudaController.listarAlunos(), retornoEsperado);
	}

}
