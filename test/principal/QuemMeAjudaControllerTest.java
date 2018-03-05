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
	 * Verifica se a matricula de um tutor de uma ajuda de id negativo pode ser
	 * retornada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaIdNegativo() {
		this.quemMeAjudaController.pegarTutor(-1);
	}
	
	/**
	 * Verifica se a matricula de um tutor de uma ajuda de id zero pode ser
	 * retornada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaIdZero() {
	    this.quemMeAjudaController.pegarTutor(0);
	}
	
	/**
	 * Verifica se a matricula de um tutor de uma ajuda online de id positivo
	 * pode ser retornada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaOnlineIdPositivo() {
		this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2");
	    this.quemMeAjudaController.pegarTutor(1);
	}
	
	/**
	 * Verifica se a matricula de um tutor de uma ajuda presencial de id
	 * positivo pode ser retornada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaPresencialIdPositivo() {
		this.quemMeAjudaController.pedirAjudaPresencial("11111111", "P2",
				"15:00", "sex", "LCC2");
	    this.quemMeAjudaController.pegarTutor(1);
	}

}
