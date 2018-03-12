package principal;

import static org.junit.Assert.*;

import org.junit.Test;

public class AjudaTest {
	private Ajuda ajuda;
	/**
	 * Testa instanciar uma Ajuda sendo AjudaOnline
	 */
	@Test
	public void instanciaAjudaOnline() {
		this.ajuda = new AjudaOnline(1, "123345", "234565", "Programacao");
	}
	/**
	 * Testa instanciar uma Ajuda sendo AjudaPrecencial
	 */
	@Test
	public void instanciaAjudaPrecencial() {
		this.ajuda = new AjudaPresencial(1, "123345", "234565", "Programacao", "16","12/03" , "UFCG");
	}
	/**
	 *Espera-se que lance uma excecao, pois o ID e invalido 
	 */
	@Test(expected = IllegalArgumentException.class)
	public void intanciaAjudaComIDInvalidoTest() {
		this.ajuda = new AjudaPresencial(-1, "123345", "234565", "Programacao", "16","12/03" , "UFCG");
	}
	/**
	 * Verifica se uma ajuda avaliada retorna true
	 */
	@Test
	public void avaliarTest() {
		this.ajuda = new AjudaOnline(1, "123345", "234565", "Programacao");
		this.ajuda.avaliar();
		assertEquals(true,this.ajuda.foiAvaliada());
	}
	/**
	 * Verifica se uma ajuda nao avaliada retorna false
	 */
	@Test
	public void AjudaNaoAvaliadaTest() {
		this.ajuda = new AjudaOnline(1, "123345", "234565", "Programacao");
		assertEquals(false,this.ajuda.foiAvaliada());
	}
	/**
	 * Espera-se que retorna uma string da matricula de Tutor
	 */
	@Test
	public void getMatriculaTutorTest() {
		this.ajuda = new AjudaOnline(1, "123345", "234565", "Programacao");
		assertEquals("234565",this.ajuda.getMatriculaTutor());
	}
	/**
	 * Espera-se que retorna uma string da matricula de Aluno
	 */
	@Test
	public void getMatriculaAlunoTest() {
		this.ajuda = new AjudaOnline(1, "123345", "234565", "Programacao");
		assertEquals("123345",this.ajuda.getMatriculaAluno());
	}
	/**
	 * Espera-se que retorne o valor do ID da Ajuda
	 */
	@Test
	public void getId() {
		this.ajuda = new AjudaOnline(1, "123345", "234565", "Programacao");
		assertEquals(1,this.ajuda.getId());
	}
	
}
