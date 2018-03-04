package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe responsável por testar as funcionalidades da classe AjudaController.
 *
 */
public class AjudaControllerTest {
	
	private AjudaController ajudaController;

	/**
	 * Inicializa ajudaController.
	 */
	@Before
	public void iniciaAjudaController() {
		ajudaController = new AjudaController();
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando a matricula do
	 * aluno e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatrAlunoVazia() {
		this.ajudaController.pedirAjudaPresencial("", "11111111", "P2",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando a matricula do
	 * aluno e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatrAlunoEmBranco() {
		this.ajudaController.pedirAjudaPresencial("    ", "11111111", "P2",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando a matricula do
	 * tutor e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatrTutorVazia() {
		this.ajudaController.pedirAjudaPresencial("22222222", "", "P2",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando a matricula do
	 * tutor e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatrTutorEmBranco() {
		this.ajudaController.pedirAjudaPresencial("22222222", "    ", "P2",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando a disciplina
	 * de interesse e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDisciplinaVazia() {
		this.ajudaController.pedirAjudaPresencial("22222222", "11111111", "",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando a disciplina
	 * de interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDisciplinaEmBranco() {
		this.ajudaController.pedirAjudaPresencial("22222222", "11111111", "  ",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o horario de
	 * interesse e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioVazio() {
		this.ajudaController.pedirAjudaPresencial("22222222", "11111111", "P2",
				"", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o horario de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioEmBranco() {
		this.ajudaController.pedirAjudaPresencial("22222222", "11111111", "P2",
				"   ", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o dia de
	 * interesse e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaVazio() {
		this.ajudaController.pedirAjudaPresencial("22222222", "11111111", "P2",
				"13:00", "", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o dia de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaEmBranco() {
		this.ajudaController.pedirAjudaPresencial("22222222", "11111111", "P2",
				"13:00", "   ", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o local de
	 * interesse e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalVazio() {
		this.ajudaController.pedirAjudaPresencial("22222222", "11111111", "P2",
				"", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o local de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalEmBranco() {
		this.ajudaController.pedirAjudaPresencial("22222222", "11111111", "P2",
				"   ", "seg", "LCC2");
	}
	
	/**
	 * Verifica se a primeira ajuda presencial cadastrada possui indice 1.
	 */
	@Test
	public void testPedirPrimeiraAjudaPresencialValida() {
		assertEquals(1, this.ajudaController.pedirAjudaPresencial("22222222",
				"11111111", "P2", "13:00", "seg", "LCC2"));
	}
	
	/**
	 * Verifica se a segunda ajuda presencial cadastrada possui indice 2.
	 */
	@Test
	public void testPedirSegundaAjudaPresencialValida() {
		this.ajudaController.pedirAjudaPresencial("22222222", "11111111", "P2",
				"15:00", "sex", "LCC2");
		assertEquals(2, this.ajudaController.pedirAjudaPresencial("22222222",
				"11111111", "P2", "13:00", "seg", "LCC2"));
	}
	
	/**
	 * Verifica se uma ajuda online pode ser pedida quando a matricula do
	 * aluno e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatrAlunoVazia() {
		this.ajudaController.pedirAjudaOnline("", "111111111", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser pedida quando a matricula do
	 * aluno e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatrAlunoEmBranco() {
		this.ajudaController.pedirAjudaOnline("    ", "111111111", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser pedida quando a disciplina
	 * de interesse e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaVazia() {
		this.ajudaController.pedirAjudaOnline("11111111", "22222222", "");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser pedida quando a disciplina
	 * de interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaEmBranco() {
		this.ajudaController.pedirAjudaOnline("11111111", "22222222", "  ");
	}
	
	/**
	 * Verifica se a primeira ajuda online cadastrada possui indice 1.
	 */
	@Test
	public void testPedirPrimeiraAjudaOnlineValida() {
		assertEquals(1, this.ajudaController.pedirAjudaOnline("22222222",
				"11111111", "P2"));
	}
	
	/**
	 * Verifica se a segunda ajuda online cadastrada possui indice 2.
	 */
	@Test
	public void testPedirSegundaAjudaOnlineValida() {
		this.ajudaController.pedirAjudaOnline("11111111", "22222222", "P2");
		assertEquals(2, this.ajudaController.pedirAjudaOnline("22222222",
				"11111111", "P2"));
	}

}
