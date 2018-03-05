package principal;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe responsavel por testar as funcionalidades da classe AjudaOnline.
 *
 */
public class AjudaOnlineTest {

	private AjudaOnline ajudaOnline;
	
	/**
	 * Verifica se uma ajuda online pode ser criada quando o id informado
	 * e negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineIdNegativo() {
		this.ajudaOnline = new AjudaOnline(-1, "22222222", "11111111", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser criada quando o id informado
	 * e zero.
	 */
	@Test
	public void testPedirAjudaOnlineIdZero() {
		this.ajudaOnline = new AjudaOnline(0, "22222222", "11111111", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser criada quando o id informado
	 * e positivo.
	 */
	@Test
	public void testPedirAjudaOnlineIdPositivo() {
		this.ajudaOnline = new AjudaOnline(1, "22222222", "11111111", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser criada quando a matricula do
	 * aluno e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatrAlunoVazia() {
		this.ajudaOnline = new AjudaOnline(1, "", "111111111", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser criada quando a matricula do
	 * aluno e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatrAlunoEmBranco() {
		this.ajudaOnline = new AjudaOnline(1, "    ", "111111111", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser criada quando a matricula do
	 * tutor e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatrTutorVazia() {
		this.ajudaOnline = new AjudaOnline(1, "111111111", "", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser criada quando a matricula do
	 * tutor e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatrTutorEmBranco() {
		this.ajudaOnline = new AjudaOnline(1, "111111111", "    ", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser criada quando a disciplina
	 * de interesse e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaVazia() {
		this.ajudaOnline = new AjudaOnline(1, "11111111", "22222222", "");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser criada quando a disciplina
	 * de interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaEmBranco() {
		this.ajudaOnline = new AjudaOnline(1, "11111111", "22222222", "  ");
	}
	
	/**
	 * Verifica se uma matricula de um tutor e retornada.
	 */
	@Test
	public void testGetMatriculaTutor() {
		this.ajudaOnline = new AjudaOnline(1, "22222222", "11111111", "P2");
		assertEquals("11111111", this.ajudaOnline.getMatriculaTutor());
	}
	
}
