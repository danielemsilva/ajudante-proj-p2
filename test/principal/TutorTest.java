package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe responsavel por testar as funcionalidades da classe Tutor.
 *
 */
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
	
	/**
	 * Verifica se uma pontuacao de um tutor pode ser mudada para um valor 
	 * negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetPontuacaoNegativa() {
		this.tutor.setPontuacao(-1);
	}
	
	/**
	 * Verifica se uma pontuacao de um tutor pode ser mudada para um valor 
	 * maior que cinco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetPontuacaoMaiorPermitido() {
		this.tutor.setPontuacao(6);
	}
	
	/**
	 * Verifica se uma pontuacao de um tutor pode ser mudada para zero. 
	 */
	@Test
	public void testSetPontuacaoMinima() {
		this.tutor.setPontuacao(0);
	}
	
	/**
	 * Verifica se uma pontuacao de um tutor pode ser mudada para cinco. 
	 */
	@Test
	public void testSetPontuacaoMaxima() {
		this.tutor.setPontuacao(5);
	}
	
	/**
	 * Verifica se a pontuacao de um tutor nao avaliado eh quatro.
	 */
	@Test
	public void testGetPontuacaoTutorNaoAvaliado() {
		assertEquals(4, this.tutor.getPontuacao(), 0);
	}
	
	/**
	 * Verifica se a pontuacao de um tutor avaliado eh retornada como esperado.
	 */
	@Test
	public void testGetPontuacaoTutorAvaliado() {
		this.tutor.setPontuacao(5);
		assertEquals(4.16, this.tutor.getPontuacao(), 0.01);
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando o tutor nao foi 
	 * avaliado.
	 */
	@Test
	public void testGetNivelTutorNaoAvaliado() {
		assertEquals("Tutor", this.tutor.getNivel());
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando o tutor foi bem
	 * avaliado.
	 */
	@Test
	public void testGetNivelTutorBemAvaliado() {
		this.tutor.setPontuacao(5);
		this.tutor.setPontuacao(5);
		this.tutor.setPontuacao(5);
		this.tutor.setPontuacao(5);
		assertEquals("TOP", this.tutor.getNivel());
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando o tutor foi 
	 * medianamente avaliado.
	 */
	@Test
	public void testGetNivelTutorAvaliadoMedianamente() {
		this.tutor.setPontuacao(4);
		assertEquals("Tutor", this.tutor.getNivel());
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando o tutor foi 
	 * medianamente avaliado.
	 */
	@Test
	public void testGetNivelTutorMauAvaliado() {
		this.tutor.setPontuacao(1);
		this.tutor.setPontuacao(1);
		this.tutor.setPontuacao(1);
		assertEquals("Aprendiz", this.tutor.getNivel());
	}
	
	/**
	 * Verifica se o dinheiro de um tutor eh mudado quando o valor informado eh
	 * negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testSetDinheiroNegativo() {
		this.tutor.setDinheiro(-1);
	}
	
	/**
	 * Verifica se o dinheiro de um tutor eh mudado quando o valor informado eh
	 * zero.
	 */
	@Test
	public void testSetDinheiroZero() {
		this.tutor.setDinheiro(0);
	}
	

}
