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
	 * Verifica se a primeira ajuda cadastrada possui indice 1.
	 */
	@Test
	public void testPedirPrimeiraAjudaValida() {
		this.quemMeAjudaController.cadastrarAluno("Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.cadastrarHorario("mario@ccc.edu.br", "13:00", "seg");
		this.quemMeAjudaController.cadastrarLocalDeAtendimento("mario@ccc.edu.br", "LCC2");
		assertEquals(1, this.quemMeAjudaController.pedirAjudaPresencial(
				"11111111", "P2", "13:00", "seg", "LCC2"));
	}
	
	/**
	 * Verifica se a segunda ajuda cadastrada possui indice 2.
	 */
	@Test
	public void testPedirSegundaAjudaValida() {
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
	

}
