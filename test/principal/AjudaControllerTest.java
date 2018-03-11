package principal;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Classe responsavel por testar as funcionalidades da classe AjudaController.
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
				"13:00", "seg", "");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o local de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalEmBranco() {
		this.ajudaController.pedirAjudaPresencial("22222222", "11111111", "P2",
				"13:00", "seg", "  ");
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
				"13:00", "seg", "LCC2");
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
	
	/**
	 * Verifica se um tutor de uma ajuda de id negativo pode ser
	 * retornada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaOnlineIdNegativo() {
	    this.ajudaController.pegarTutor(-1);
	}
	
	/**
	 * Verifica se um tutor de uma ajuda de id zero pode ser
	 * retornada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaOnlineIdZero() {
	    this.ajudaController.pegarTutor(0);
	}
	
	/**
	 * Verifica se o tutor de uma ajuda online de id positivo pode ser 
	 * retornado.
	 */
	@Test
	public void testPegarTutorAjudaOnlineIdPositivo() {
		this.ajudaController.pedirAjudaOnline("11111111", "22222222", "P2");
	    assertEquals("Tutor - 22222222, disciplina - P2", 
	    		this.ajudaController.pegarTutor(1));
	}
	
	/**
	 * Verifica se o tutor de uma ajuda presencial de id positivo pode ser 
	 * retornado.
	 */
	@Test
	public void testPegarTutorAjudaPresencialIdPositivo() {
	    assertEquals("Tutor - 22222222, horario - 13:00, dia - seg, "
	    		+ "local - LCC2, disciplina - P2", this.ajudaController.pegarTutor(
	    				this.ajudaController.pedirAjudaPresencial("11111111",
	    						"22222222", "P2", "13:00", "seg", "LCC2")));
	}
	
	/**
	 * Verifica se a disciplina de uma ajuda de id negativo pode ser retornada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoDisciplinaAjudaIdNegativo() {
		this.ajudaController.getInfoAjuda(-1, "disciplina");
	}
	
	/**
	 * Verifica se a disciplina de uma ajuda de id nao cadastrado pode ser 
	 * retornada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoDisciplinaAjudaIdNaoCadastrado() {
		this.ajudaController.getInfoAjuda(10, "disciplina");
	}
	
	/**
	 * Verifica se alguma informacao pode ser obtida de uma ajuda presencial
	 * cadastrada quando o atributo informado e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoVazio() {
		assertEquals("P2", this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaPresencial("11111111",
						"22222222", "P2", "13:00", "seg", "LCC2"),
				""));
	}
	
	/**
	 * Verifica se alguma informacao pode ser obtida de uma ajuda presencial
	 * cadastrada quando o atributo informado e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaPresencialAtributoEmBranco() {
		assertEquals("P2", this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaPresencial("11111111",
						"22222222", "P2", "13:00", "seg", "LCC2"),
				"    "));
	}
	
	/**
	 * Verifica se alguma informacao pode ser obtida de uma ajuda online
	 * cadastrada quando o atributo informado e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineAtributoVazio() {
		assertEquals("P2", this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaOnline("11111111",
						"22222222", "P2"),
				""));
	}
	
	/**
	 * Verifica se alguma informacao pode ser obtida de uma ajuda online
	 * cadastrada quando o atributo informado e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaOnlineAtributoEmBranco() {
		assertEquals("P2", this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaOnline("11111111",
						"22222222", "P2"),
				"    "));
	}
	
	/**
	 * Verifica se a disciplina de uma ajuda presencial cadastrada pode ser
	 * retornada.
	 */
	@Test
	public void testGetInfoDisciplinaAjudaPresencial() {
		assertEquals("P2", this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaPresencial("11111111",
						"22222222", "P2", "13:00", "seg", "LCC2"),
				"disciplina"));
	}
	
	/**
	 * Verifica se o dia de uma ajuda presencial cadastrada pode ser retornado.
	 */
	@Test
	public void testGetInfoDiaAjudaPresencial() {
		assertEquals("seg", this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaPresencial("11111111",
						"22222222", "P2", "13:00", "seg", "LCC2"),
				"dia"));
	}
	
	/**
	 * Verifica se o local de uma ajuda presencial cadastrada pode ser 
	 * retornado.
	 */
	@Test
	public void testGetInfoLocalAjudaPresencial() {
		assertEquals("LCC2", this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaPresencial("11111111",
						"22222222", "P2", "13:00", "seg", "LCC2"),
				"localInteresse"));
	}
	
	/**
	 * Verifica se o horario de uma ajuda presencial cadastrada pode ser 
	 * retornado.
	 */
	@Test
	public void testGetInfoHorarioAjudaPresencial() {
		assertEquals("13:00", this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaPresencial("11111111",
						"22222222", "P2", "13:00", "seg", "LCC2"),
				"horario"));
	}
	
	/**
	 * Verifica se um atributo que nao pertence a uma ajuda presencial 
	 * cadastrada pode ser retornado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAtributoInvalidoAjudaPresencial() {
		assertEquals("13:00", this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaPresencial("11111111",
						"22222222", "P2", "13:00", "seg", "LCC2"),
				"minuto"));
	}
	
	/**
	 * Verifica se a disciplina de uma ajuda online cadastrada pode ser 
	 * retornada.
	 */
	@Test
	public void testGetInfoDisciplinaAjudaOnline() {
		assertEquals("P2", this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaOnline("11111111", "22222222",
						"P2"),
			    "disciplina"));
	}
	
	/**
	 * Verifica se o dia de uma ajuda online cadastrada pode ser retornado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoDiaAjudaOnline() {
		this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaOnline("11111111", "22222222",
						"P2"),
				"dia");
	}
	
	/**
	 * Verifica se o local de uma ajuda online cadastrada pode ser retornado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoLocalAjudaOnline() {
		this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaOnline("11111111", "22222222",
						"P2"),
				"localInteresse");
	}
	
	/**
	 * Verifica se o horario de uma ajuda online cadastrada pode ser retornado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoHorarioAjudaOnline() {
		this.ajudaController.getInfoAjuda(
				this.ajudaController.pedirAjudaOnline("11111111", "22222222",
						"P2"),
				"horario");
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id negativo pode ser
	 * feita.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorIdAjudaNegativo() {
		this.ajudaController.avaliar(-1);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id nao cadastrado 
	 * pode ser feita.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorIdAjudaNaoCadastrado() {
		this.ajudaController.avaliar(1);
	}
	
	/**
	 * Verifica se a avaliacao de um tutor de uma ajuda online cadastrada que 
	 * nao foi avaliada pode ser feita.
	 */
	@Test
	public void testAvaliarTutorAjudaOnlineNaoAvaliada() {
		this.ajudaController.avaliar(
				this.ajudaController.pedirAjudaOnline("11111111", "22222222",
						"P2"));
	}
	
	/**
	 * Verifica se a avaliacao de um tutor de uma ajuda online cadastrada que 
	 * foi avaliada pode ser feita.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorAjudaOnlineAvaliada() {
		int id = this.ajudaController.pedirAjudaOnline("11111111", "22222222",
				"P2");
		this.ajudaController.avaliar(id);
		this.ajudaController.avaliar(id);
	}
	
	/**
	 * Verifica se a avaliacao de um tutor de uma ajuda presencial cadastrada 
	 * que nao foi avaliada pode ser feita.
	 */
	@Test
	public void testAvaliarTutorAjudaPresencialNaoAvaliada() {
		this.ajudaController.avaliar(this.ajudaController.pedirAjudaPresencial(
				"11111111", "22222222", "P2", "13:00", "seg", "LCC2"));
	}
	
	/**
	 * Verifica se a avaliacao de um tutor de uma ajuda presencial cadastrada 
	 * que foi avaliada pode ser feita.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorAjudaPresencialAvaliada() {
		int id = this.ajudaController.pedirAjudaPresencial(
				"11111111", "22222222", "P2", "13:00", "seg", "LCC2");
		this.ajudaController.avaliar(id);
		this.ajudaController.avaliar(id);
	}
		
}
	
	