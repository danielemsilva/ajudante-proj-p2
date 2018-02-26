package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TutorTest {

	private Tutor tutor;

	/**
	 * Cria uma instancia de Tutor.
	 */
	@Before
	public void iniciaTutor() {
		this.tutor = new Tutor();
	}
	
	/**
	 * Verifica se um horario com dia vazio pode ser adicionado a um tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaHorarioDiaVazio() {
		this.tutor.adicionaHorario("", "15:00");
	}
	
	/**
	 * Verifica se um horario com dia nulo pode ser adicionado a um tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaHorarioDiaNulo() {
		this.tutor.adicionaHorario(null, "15:00");
	}
	
	/**
	 * Verifica se um horario com hora vazia pode ser adicionado a um tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaHorarioHoraVazia() {
		this.tutor.adicionaHorario("seg", "");
	}
	
	/**
	 * Verifica se um horario com hora nula pode ser adicionado a um tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaHorarioHoraNula() {
		this.tutor.adicionaHorario("seg", null);
	}
	
	/**
	 * Verifica se um horario valido pode ser adicionado a um tutor.
	 */
	@Test
	public void testAdicionaHorarioValido() {
		this.tutor.adicionaHorario("seg", "15:00");
	}

}
