package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe responsavel por testar as funcionalidades da classe AjudaPresencial.
 *
 */
public class AjudaPresencialTest {
	
	private AjudaPresencial ajudaPresencial;
	
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
				"P2", "", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o horario de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialHorarioEmBranco() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "   ", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o dia de
	 * interesse e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaVazio() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "13:00", "", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o dia de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialDiaEmBranco() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "13:00", "   ", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser criada quando o local de
	 * interesse e vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalVazio() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "", "seg", "LCC2");
	}
	
	/**
	 * Verifica se uma ajuda presencial pode ser pedida quando o local de
	 * interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialLocalEmBranco() {
		this.ajudaPresencial = new AjudaPresencial(1, "22222222", "11111111",
				"P2", "   ", "seg", "LCC2");
	}


}
