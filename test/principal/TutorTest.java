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
<<<<<<< HEAD
=======
	
	/**
	 * Verifica se um local de atendimento vazio pode ser adicionado a um tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaLocalVazio() {
		this.tutor.adicionaLocal("");
	}
	
	/**
	 * Verifica se um local de atendimento nulo pode ser adicionado a um tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaLocalNulo() {
		this.tutor.adicionaLocal(null);
	}
	
	/**
	 * Verifica se um local de atendimento nao cadastrado
	 * pode ser adicionado a um tutor.
	 */
	@Test
	public void testAdicionaLocalNaoCadastrado() {
		this.tutor.adicionaLocal("CAA");
	}
	
	/**
	 * Verifica se um local de atendimento ja cadastrado
	 * pode ser adicionado a um tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAdicionaLocalJaCadastrado() {
		this.tutor.adicionaLocal("CAA");
		this.tutor.adicionaLocal("CAA");
	}
	
	/**
	 * Verifica se um horario de atendimento nao cadastrado
	 * esta entre os horarios de atendimentos de um tutor.
	 */
	@Test
	public void testConsultaHorarioNaoCadastrado() {
		assertFalse(this.tutor.consultaHorario("seg", "13:00"));
	}
	
	/**
	 * Verifica se um horario de atendimento cadastrado
	 * esta entre os horarios de atendimentos de um tutor.
	 */
	@Test
	public void testConsultaHorarioCadastrado() {
		this.tutor.adicionaHorario("seg", "15:00");
		assert(this.tutor.consultaHorario("seg", "15:00"));
	}
	
	/**
	 * Verifica se um local de atendimento nao cadastrado
	 * esta entre os locais de atendimentos de um tutor.
	 */
	@Test
	public void testConsultaLocalNaoCadastrado() {
		assertFalse(this.tutor.consultaLocal("CAA"));
	}
	
	/**
	 * Verifica se um local de atendimento cadastrado
	 * esta entre os locais de atendimentos de um tutor.
	 */
	@Test
	public void testConsultaLocalCadastrado() {
		this.tutor.adicionaLocal("CAA");
		assert(this.tutor.consultaLocal("CAA"));
	}
>>>>>>> 4445a8281238c327b3c0baee4004e6eedacebda0

}
