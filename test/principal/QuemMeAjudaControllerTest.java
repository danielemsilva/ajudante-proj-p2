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
	 * Verifica se uma ajuda presencial que nao possui monitor disponivel pode
	 * ser cadastrada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaPresencialSemMonitor() {
		this.quemMeAjudaController.pedirAjudaPresencial(
				"11111111", "P2", "13:00", "seg", "LCC2");
	}
	
	/**
	 * Verifica se a primeira ajuda presencial cadastrada possui indice 1.
	 */
	@Test
	public void testPedirPrimeiraAjudaPresencialValida() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.cadastrarHorario("mario@ccc.edu.br",
				"13:00", "seg");
		this.quemMeAjudaController.cadastrarLocalDeAtendimento(
				"mario@ccc.edu.br", "LCC2");
		assertEquals(1, this.quemMeAjudaController.pedirAjudaPresencial(
				"11111111", "P2", "13:00", "seg", "LCC2"));
	}
	
	/**
	 * Verifica se a segunda ajuda presencial cadastrada possui indice 2.
	 */
	@Test
	public void testPedirSegundaAjudaPresencialValida() {
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
	
	/**
	 * Verifica se uma ajuda online pode ser pedida quando a matricula do
	 * aluno e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatrAlunoVazia() {
		this.quemMeAjudaController.pedirAjudaOnline("", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser pedida quando a matricula do
	 * aluno e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineMatrAlunoEmBranco() {
		this.quemMeAjudaController.pedirAjudaOnline("    ", "P2");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser pedida quando a disciplina
	 * de interesse e vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaVazia() {
		this.quemMeAjudaController.pedirAjudaOnline("11111111", "");
	}
	
	/**
	 * Verifica se uma ajuda online pode ser pedida quando a disciplina
	 * de interesse e em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineDisciplinaEmBranco() {
		this.quemMeAjudaController.pedirAjudaOnline("11111111", "  ");
	}
	
	/**
	 * Verifica se uma ajuda online que nao possui monitor disponivel pode
	 * ser cadastrada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPedirAjudaOnlineSemMonitor() {
		this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2");
	}
	
	/**
	 * Verifica se a primeira ajuda online cadastrada possui indice 1.
	 */
	@Test
	public void testPedirPrimeiraAjudaOnlineValida() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		assertEquals(1, this.quemMeAjudaController.pedirAjudaOnline("11111111",
				"P2"));
	}
	
	/**
	 * Verifica se a segunda ajuda online cadastrada possui indice 2.
	 */
	@Test
	public void testPedirSegundaAjudaOnlineValida() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.pedirAjudaOnline("22222222", "P2");
		assertEquals(2, this.quemMeAjudaController.pedirAjudaOnline("11111111",
				"P2"));
	}
	
	/**
	 * Verifica se um tutor de uma ajuda de id negativo pode ser
	 * retornada.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaIdNegativo() {
		this.quemMeAjudaController.pegarTutor(-1);
	}
	
	/**
	 * Verifica se um tutor de uma ajuda de id zero pode ser
	 * retornado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaIdZero() {
	    this.quemMeAjudaController.pegarTutor(0);
	}
	
	/**
	 * Verifica se um tutor de uma ajuda online de id positivo
	 * pode ser retornado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaOnlineIdPositivo() {
	    assertEquals("Tutor - 22222222, disciplina - P2", 
	    		this.quemMeAjudaController.pegarTutor(
	    				this.quemMeAjudaController.pedirAjudaOnline("11111111",
	    						"P2")));
	}
	
	/**
	 * Verifica se um tutor de uma ajuda presencial de id
	 * positivo pode ser retornado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorAjudaPresencialIdPositivo() {
	    assertEquals("Tutor - 22222222, horario - 13:00, dia - seg, "
	    		+ "local - LCC2, disciplina - P2",
	    		this.quemMeAjudaController.pegarTutor(
	    				this.quemMeAjudaController.pedirAjudaPresencial(
	    						"11111111", "P2", "LCC2", "seg", "13:00")));
	}
	
	/**
	 * Verifica se a doacao do dinheiro ao tutor eh realizada devidamente
	 */
	@Test
	public void testDoarDinheiroAoTutor() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.ufcg.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.doarDinheiro("22222", 100);
		assertEquals(80, this.quemMeAjudaController.totalDinheiroTutor(
				"mario@ccc.ufcg.edu.br"));
	}
	
	/**
	 * Espera-se erro ao tentar recuperar o total de dinheiro de um tutor
	 * nao encontrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarDinheiroEmailInexistente() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.ufcg.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.doarDinheiro("22222", 100);
		assertEquals(80, this.quemMeAjudaController.totalDinheiroTutor("luzia@ccc.ufcg.edu.br"));
	}
	
	/**
	 * Espera-se erro ao tentar recuperar o total de dinheiro de um tutor
	 * informando um email vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarDinheiroEmailVazio() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.ufcg.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.doarDinheiro("22222", 100);
		assertEquals(80, this.quemMeAjudaController.totalDinheiroTutor("  "));
	}
	
	/**
	 * Espera-se erro ao tentar doar uma quantia negativa
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarDinheiroInvalido() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.ufcg.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.doarDinheiro("22222", -500);
	}
	
	/**
	 * Verifica se o dinheiro destinado ao sistema eh calculada devidamente
	 */
	@Test
	public void testTotalDinheiroSistema() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.ufcg.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.doarDinheiro("22222", 100);
		assertEquals(20, this.quemMeAjudaController.totalDinheiroSistema());
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id negativo pode ser
	 * feita.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorIdAjudaNegativo() {
		this.quemMeAjudaController.avaliarTutor(-1, 4);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id nao cadastrado 
	 * pode ser feita.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorIdAjudaNaoCadastrado() {
		this.quemMeAjudaController.avaliarTutor(1, 4);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id cadastrado pode 
	 * ser feita.
	 */
	@Test
	public void testAvaliarTutorIdAjudaCadastrado() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2"), 
				4);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id cadastrado pode 
	 * ser feita quando a nota e inferior a zero.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaNegativa() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2"), 
				-1);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda de id cadastrado pode 
	 * ser feita quando a nota e superior a cinco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorNotaAcimaPermitido() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2"), 
				6);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda online cadastrada pode 
	 * ser feita quando a nota e igual a zero.
	 */
	@Test
	public void testAvaliarTutorNotaMinimaAjudaOnline() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2"), 
				0);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda online cadastrada pode 
	 * ser feita quando a nota e igual a cinco.
	 */
	@Test
	public void testAvaliarTutorNotaMaximaAjudaOnline() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2"), 
				5);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda online cadastrada pode 
	 * ser feita mais de uma vez.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorDuasVezesAjudaOnline() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		int id = this.quemMeAjudaController.pedirAjudaOnline("11111111", "P2");
		this.quemMeAjudaController.avaliarTutor(id, 5);
		this.quemMeAjudaController.avaliarTutor(id, 5);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda presencial cadastrada 
	 * pode ser feita quando a nota e igual a zero.
	 */
	@Test
	public void testAvaliarTutorNotaMinimaAjudaPresencial() {
		this.quemMeAjudaController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.quemMeAjudaController.tornarTutor("3333", "TG", 5);
		this.quemMeAjudaController.cadastrarLocalDeAtendimento("bia@ccc.com",
				"LCC3");
		this.quemMeAjudaController.cadastrarHorario("bia@ccc.com", "13:00", 
				"seg");
		int id = this.quemMeAjudaController.pedirAjudaPresencial("22222", "TG",
				"13:00", "seg", "LCC3");
		this.quemMeAjudaController.avaliarTutor(id, 0);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda presencial cadastrada 
	 * pode ser feita quando a nota e igual a cinco.
	 */
	@Test
	public void testAvaliarTutorNotaMaximaAjudaPresencial() {
		this.quemMeAjudaController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.quemMeAjudaController.tornarTutor("3333", "TG", 5);
		this.quemMeAjudaController.cadastrarLocalDeAtendimento("bia@ccc.com",
				"LCC3");
		this.quemMeAjudaController.cadastrarHorario("bia@ccc.com", "13:00", 
				"seg");
		int id = this.quemMeAjudaController.pedirAjudaPresencial("22222", "TG",
				"13:00", "seg", "LCC3");
		this.quemMeAjudaController.avaliarTutor(id, 5);
	}
	
	/**
	 * Verifica se a avalicao de um tutor de uma ajuda presencial cadastrada 
	 * pode ser feita mais de uma vez.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliarTutorDuasVezesAjudaPresencial() {
		this.quemMeAjudaController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.quemMeAjudaController.tornarTutor("3333", "TG", 5);
		this.quemMeAjudaController.cadastrarLocalDeAtendimento("bia@ccc.com",
				"LCC3");
		this.quemMeAjudaController.cadastrarHorario("bia@ccc.com", "13:00", 
				"seg");
		int id = this.quemMeAjudaController.pedirAjudaPresencial("22222", "TG",
				"13:00", "seg", "LCC3");
		this.quemMeAjudaController.avaliarTutor(id, 5);
		this.quemMeAjudaController.avaliarTutor(id, 5);
	}
	
	/**
	 * Verifica se a nota de um tutor eh retornada quando a matricula informada
	 * e nula.*/
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNotaMatriculaNula() {
		this.quemMeAjudaController.pegarNota(null);
	}
	
	/**
	 * Verifica se a nota de um tutor eh retornada quando a matricula informada
	 * e vazia.*/
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNotaMatriculaVazia() {
		this.quemMeAjudaController.pegarNota("");
	}
	
	/**
	 * Verifica se a nota de um tutor eh retornada quando a matricula informada
	 * nao foi registrada no sistema.
	 * */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNotaMatriculaInexistente() {
		this.quemMeAjudaController.pegarNota("111111111");
	}
	
	/**
	 * Verifica se a nota de um tutor eh retornada quando a matricula informada
	 * eh de um aluno que nao eh tutor.
	 * */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNotaMatriculaNaoTutor() {
		this.quemMeAjudaController.pegarNota("111111111");
	}
	
	/**
	 * Verifica se a nota de um tutor eh retornada quando a matricula informada
	 * eh de um aluno que eh tutor que nao foi avaliado.
	 * */
	@Test
	public void testPegarNotaMatriculaTutorNaoAvaliado() {
		this.quemMeAjudaController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.quemMeAjudaController.tornarTutor("111111", "P2", 5);
		this.quemMeAjudaController.pegarNota("111111");
	}
	
	/**
	 * Verifica se a nota de um tutor eh retornada quando a matricula informada
	 * eh de um aluno que eh tutor que foi avaliado.
	 * */
	@Test
	public void testPegarNotaMatriculaTutorAvaliado() {
		this.quemMeAjudaController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.quemMeAjudaController.tornarTutor("111111", "P2", 5);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("222222", "P2"),
				5);
		this.quemMeAjudaController.pegarNota("111111");
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula informada
	 * e nula.*/
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNivelMatriculaNula() {
		this.quemMeAjudaController.pegarNivel(null);
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula informada
	 * e vazia.*/
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNivelMatriculaVazia() {
		this.quemMeAjudaController.pegarNivel("");
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula informada
	 * nao foi registrada no sistema.
	 * */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNivelMatriculaInexistente() {
		this.quemMeAjudaController.pegarNivel("111111111");
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula informada
	 * eh de um aluno que nao eh tutor.
	 * */
	@Test(expected = IllegalArgumentException.class)
	public void testPegarNivelMatriculaNaoTutor() {
		this.quemMeAjudaController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.quemMeAjudaController.pegarNivel("111111");
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula informada
	 * eh de um aluno que eh tutor que nao foi avaliado.
	 */
	@Test
	public void testPegarNivelMatriculaTutorNaoAvaliado() {
		this.quemMeAjudaController.cadastrarAluno(
				"Beatriz", "111111", "CC", "99999999", "bia@ccc.com");
		this.quemMeAjudaController.tornarTutor("111111", "P2", 5);
		assertEquals("Tutor", this.quemMeAjudaController.pegarNivel("111111"));
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula 
	 * informada eh de um aluno que eh tutor de uma ajuda presencial.
	 */
	@Test
	public void testPegarNivelMatriculaTutorAvaliadoAjudaPresencial() {
		this.quemMeAjudaController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.quemMeAjudaController.tornarTutor("3333", "TG", 5);
		this.quemMeAjudaController.cadastrarLocalDeAtendimento("bia@ccc.com",
				"LCC3");
		this.quemMeAjudaController.cadastrarHorario("bia@ccc.com", "13:00", 
				"seg");
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaPresencial("22222", "TG",
						"13:00", "seg", "LCC3"), 5);
		assertEquals("Tutor", this.quemMeAjudaController.pegarNivel("3333"));
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula 
	 * informada eh de um aluno que eh tutor de uma ajuda online.
	 */
	@Test
	public void testPegarNivelMatriculaTutorAvaliadoAjudaOnline() {
		this.quemMeAjudaController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.quemMeAjudaController.tornarTutor("3333", "TG", 5);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("22222", "TG"), 5);
		assertEquals("Tutor", this.quemMeAjudaController.pegarNivel("3333"));
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula 
	 * informada eh de um aluno que eh tutor que foi avaliado com boas notas.
	 */
	@Test
	public void testPegarNivelMatriculaTutorAvaliadoBoasNotas() {
		this.quemMeAjudaController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.quemMeAjudaController.tornarTutor("3333", "TG", 5);
		this.quemMeAjudaController.cadastrarLocalDeAtendimento("bia@ccc.com",
				"LCC3");
		this.quemMeAjudaController.cadastrarHorario("bia@ccc.com", "13:00", 
				"seg");
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaPresencial("22222", "TG",
				"13:00", "seg", "LCC3"), 5);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("22222", "TG"), 5);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("55555", "TG"), 5);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("88888", "TG"), 5);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("44444", "TG"), 5);
		assertEquals("TOP", this.quemMeAjudaController.pegarNivel("3333"));
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula 
	 * informada eh de um aluno que eh tutor que foi avaliado com notas medias.
	 */
	@Test
	public void testPegarNivelMatriculaTutorAvaliadoNotasMedias() {
		this.quemMeAjudaController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.quemMeAjudaController.tornarTutor("3333", "TG", 5);
		this.quemMeAjudaController.cadastrarLocalDeAtendimento("bia@ccc.com",
				"LCC3");
		this.quemMeAjudaController.cadastrarHorario("bia@ccc.com", "13:00", 
				"seg");
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaPresencial("22222", "TG",
				"13:00", "seg", "LCC3"), 4);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("22222", "TG"), 4);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("55555", "TG"), 4);
		assertEquals("Tutor", this.quemMeAjudaController.pegarNivel("3333"));
	}
	
	/**
	 * Verifica se o nivel de um tutor eh retornado quando a matricula 
	 * informada eh de um aluno que eh tutor que foi avaliado com notas baixas.
	 */
	@Test
	public void testPegarNivelMatriculaTutorAvaliadoNotasBaixas() {
		this.quemMeAjudaController.cadastrarAluno(
				"Beatriz", "3333", "CC", "99999999", "bia@ccc.com");
		this.quemMeAjudaController.tornarTutor("3333", "TG", 5);
		this.quemMeAjudaController.cadastrarLocalDeAtendimento("bia@ccc.com",
				"LCC3");
		this.quemMeAjudaController.cadastrarHorario("bia@ccc.com", "13:00", 
				"seg");
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaPresencial("22222", "TG",
				"13:00", "seg", "LCC3"), 1);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("22222", "TG"), 2);
		this.quemMeAjudaController.avaliarTutor(
				this.quemMeAjudaController.pedirAjudaOnline("55555", "TG"), 3);
		assertEquals("Tutor", this.quemMeAjudaController.pegarNivel("3333"));
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula do tutor eh 
	 * vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaVazia() {
		this.quemMeAjudaController.doarDinheiro("", 100);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula do tutor eh 
	 * em branco.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaEmBranco() {
		this.quemMeAjudaController.doarDinheiro("   ", 100);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula do tutor eh 
	 * nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaNula() {
		this.quemMeAjudaController.doarDinheiro(null, 100);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula do tutor nao 
	 * foi registrada no sistema.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaInvalida() {
		this.quemMeAjudaController.doarDinheiro("10101010", 100);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula informada eh 
	 * de um aluno que nao eh tutor.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarMatriculaNaoTutor() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.doarDinheiro("22222", 100);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula informada eh 
	 * de um aluno que eh tutor.
	 */
	@Test
	public void testDoarMatriculaTutor() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 5);
		this.quemMeAjudaController.doarDinheiro("22222", 100);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando o valor doado eh negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDoarValorNegativo() {
		this.quemMeAjudaController.doarDinheiro("22222", -1);
	}
	
	/**
	 * Verifica se uma doacao pode ser feita quando a matricula informada eh 
	 * de um aluno que eh tutor e o valor informado eh zero.
	 */
	@Test
	public void testDoarMatriculaTutorZero() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 5);
		this.quemMeAjudaController.doarDinheiro("22222", 0);
	}
	
	/**
	 * Verifica se os alunos sao listados pela ordem configurada para nome
	 */
	@Test
	public void testListarAlunosPorNome() {
		this.quemMeAjudaController.cadastrarAluno(
				"Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
		this.quemMeAjudaController.cadastrarAluno(
				"Ana", "1232455", "DD34", "8495981012", "ana234@blizzard.com");
		this.quemMeAjudaController.cadastrarAluno(
				"Joao", "1232423", "DD34", "8467989023", "joaozinho@blizzard.com");
		this.quemMeAjudaController.configurarOrdem("NOME");
		String retornoEsperado = "1232455 - Ana - DD34 - 8495981012 - ana234@blizzard.com, "
				+ "1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com, "
				+ "1232428 - Lucas - EER4 - luquinhas@blizzard.com";
		assertEquals(this.quemMeAjudaController.listarAlunos(), retornoEsperado);
	}

	/**
	 * Verifica se os alunos sao listados pela ordem configurada para email
	 */
	@Test
	public void testListarAlunosPorEmail() {
		this.quemMeAjudaController.cadastrarAluno(
				"Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
		this.quemMeAjudaController.cadastrarAluno(
				"Ana", "1232455", "DD34", "8495981012", "ana234@blizzard.com");
		this.quemMeAjudaController.cadastrarAluno(
				"Joao", "1232423", "DD34", "8467989023", "joaozinho@blizzard.com");
		this.quemMeAjudaController.configurarOrdem("EMAIL");
		String retornoEsperado = "1232455 - Ana - DD34 - 8495981012 - ana234@blizzard.com, "
				+ "1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com, "
				+ "1232428 - Lucas - EER4 - luquinhas@blizzard.com";
		assertEquals(this.quemMeAjudaController.listarAlunos(), retornoEsperado);
	}
	
	/**
	 * Verifica se os alunos sao listados pela ordem configurada para matricula
	 */
	@Test
	public void testListarAlunosPorMatricula() {
		this.quemMeAjudaController.cadastrarAluno(
				"Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
		this.quemMeAjudaController.cadastrarAluno(
				"Ana", "1232455", "DD34", "8495981012", "ana234@blizzard.com");
		this.quemMeAjudaController.cadastrarAluno(
				"Joao", "1232423", "DD34", "8467989023", "joaozinho@blizzard.com");
		this.quemMeAjudaController.configurarOrdem("MATRICULA");
		String retornoEsperado = "1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com, "
				+ "1232428 - Lucas - EER4 - luquinhas@blizzard.com, "
				+ "1232455 - Ana - DD34 - 8495981012 - ana234@blizzard.com";
		assertEquals(this.quemMeAjudaController.listarAlunos(), retornoEsperado);
	}
	
	/**
	 * Verifica se os dados cadastrados sao gravados em arquivo
	 */
	@Test
	public void testGravarDados() {
		this.quemMeAjudaController.cadastrarAluno(
				"Mario", "22222", "CC", "", "mario@ccc.edu.br");
		this.quemMeAjudaController.tornarTutor("22222", "P2", 4);
		this.quemMeAjudaController.cadastrarHorario("mario@ccc.edu.br", "13:00", "seg");
		this.quemMeAjudaController.cadastrarLocalDeAtendimento("mario@ccc.edu.br", "LCC2");
		this.quemMeAjudaController.pedirAjudaPresencial(
				"11111111", "P2", "13:00", "seg", "LCC2");
		assert(this.quemMeAjudaController.gravarDados());
	}
	
	/**
	 * Verifica se a leitura de alunos foi realizada com sucesso
	 */
	@Test
	public void testLerAlunos() {
		this.quemMeAjudaController.lerDados();
		assertEquals(this.quemMeAjudaController.listarAlunos(), "22222 - Mario - CC - mario@ccc.edu.br");
	}
	
	/**
	 * Verifica se a leitura de ajudas foi realizada com sucesso
	 */
	@Test
	public void testLerAjudas() {
		this.quemMeAjudaController.lerDados();
		assertEquals("Tutor - 22222, horario - 13:00, dia - seg, local - LCC2, disciplina - P2", 
				this.quemMeAjudaController.pegarTutor(1));
	}

}
