package principal;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Classe responsavel por testar as funcionalidades da classe AjudaPresencial.
 *
 */
public class AjudaPresencialTest {
	
	private AjudaPresencial ajudaPresencial;
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o id informado
	 * e negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialIdNegativo() {
		this.ajudaPresencial = new AjudaPresencial(-1, "22222222", "11111111",
				"P2", "13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o id informado
	 * e zero.
	 */
	@Test
	public void testPedirAjudaPresencialIdZero() {
		this.ajudaPresencial = new AjudaPresencial(0, "22222222", "11111111",
				"P2", "13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o id informado
	 * e positivo.
	 */
	@Test
	public void testPedirAjudaPresencialIdPositivo() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando a matricula do
	 * aluno e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatrAlunoVazia() {
		this.ajudaPresencial = new AjudaPresencial(1, "", "11111111", "P2",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando a matricula do
	 * aluno e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatrAlunoEmBranco() {
		this.ajudaPresencial = new AjudaPresencial(1, "    ", "11111111", "P2",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando a matricula do
	 * tutor e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatrTutorVazia() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "", "P2",
				"13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando a matricula do
	 * tutor e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialMatrTutorEmBranco() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "    ",
				"P2", "13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando a disciplina
	 * de interesse e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDisciplinaVazia() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"", "13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando a disciplina
	 * de interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDisciplinaEmBranco() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"  ", "13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o horario de
	 * interesse e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioVazio() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "LCC2", "seg", "");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o horario de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioEmBranco() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "LCC2", "seg", "   ");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o dia de
	 * interesse e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaVazio() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "LCC2", "", "13:00");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o dia de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaEmBranco() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "LCC2", "   ", "13:00");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o local de
	 * interesse e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalVazio() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "", "seg", "13:00");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o local de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalEmBranco() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "    ", "seg", "13:00");
	}
	
	/**
	 * Verifica se uma matricula de um tutor e retornada.
	 */
	@Test
	public void testGetMatriculaTutor() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "13:00", "seg", "LCC2");
		assertEquals("11111111", this.ajudaPresencial.getMatriculaTutor());
	}
	
	/**
	 * Verifica se a disciplina de uma ajuda presencial e retornada.
	 */
	@Test
	public void testGetInfoAjudaDisciplina() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111", "P2",
				"13:00", "seg", "LCC2");
		assertEquals("P2", this.ajudaPresencial.getInfoAjuda("disciplina"));
	}
	
	/**
	 * Verifica se o dia de uma ajuda presencial e retornado.
	 */
	@Test
	public void testGetInfoAjudaDia() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111", "P2",
				"13:00", "seg", "LCC2");
		assertEquals("seg", this.ajudaPresencial.getInfoAjuda("dia"));
	}
	
	/**
	 * Verifica se o local de uma ajuda presencial e retornado.
	 */
	@Test
	public void testGetInfoAjudaLocalInteresse() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111", "P2",
				"13:00", "seg", "LCC2");
		assertEquals("LCC2", this.ajudaPresencial.getInfoAjuda("localInteresse"));
	}
	
	/**
	 * Verifica se o horario de uma ajuda presencial e retornado.
	 */
	@Test
	public void testGetInfoAjudaHorario() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111", "P2",
				"13:00", "seg", "LCC2");
		assertEquals("13:00", this.ajudaPresencial.getInfoAjuda("horario"));
	}
	
	/**
	 * Verifica se um atributo qualquer que nao pertence a uma ajuda presencial e retornado.
	 */
	@Test
	public void testGetInfoAjudaAtributoInvalido() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111", "P2",
				"13:00", "seg", "LCC2");
		assertEquals("atributo invalido", this.ajudaPresencial.getInfoAjuda("minuto"));
	}

}
