package principal;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

/**
 * Classe responsavel por testar as funcionalidades da classe Aluno.
 *
 */
public class AlunoTest {

	private Aluno aluno;

	/**
	 * Cria uma instancia de Aluno.
	 */
	@Before
	public void iniciaAluno() {
		this.aluno = new Aluno("Joao", "122312", "cc9", "8390890923",
				"joaozinho@blizzad.com");
	}

	/**
	 * Verifica se um aluno com nome vazio pode ser criado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaAlunoNomeVazio() {
		new Aluno("", "122312", "cc9", "8390890923", "joaozinho@blizzad.com");
	}

	/**
	 * Verifica se um aluno com nome nulo pode ser criado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaAlunoNomeNulo() {
		new Aluno(null, "122312", "cc9", "8390890923", "joaozinho@blizzad.com");
	}

	/**
	 * Verifica se um aluno com matricula vazia pode ser criado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaAlunoMatriculaVazia() {
		new Aluno("Joao", "", "cc9", "8390890923", "joaozinho@blizzad.com");
	}

	/**
	 * Verifica se um aluno com matricula nula pode ser criado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaAlunoMatriculaNula() {
		new Aluno("Joao", null, "cc9", "8390890923", "joaozinho@blizzad.com");
	}

	/**
	 * Verifica se um aluno com codigo do curso vazio pode ser criado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaAlunoCodigoCursoVazio() {
		new Aluno("Joao", "111111", "", "8390890923", "joaozinho@blizzad.com");
	}

	/**
	 * Verifica se um aluno com codigo do curso nulo pode ser criado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaAlunoCodigoCursoNulo() {
		new Aluno("Joao", "111111", null, "8390890923",
				"joaozinho@blizzad.com");
	}

	/**
	 * Verifica se um aluno com email vazio pode ser criado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaAlunoEmailVazio() {
		new Aluno("Joao", "111111", "CC", "8390890923", "");
	}

	/**
	 * Verifica se um aluno com email nulo pode ser criado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaAlunoEmailNulo() {
		new Aluno("Joao", "111111", "", "8390890923", null);
	}

	/**
	 * Verifica se um aluno com email sem '@' pode ser criado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaAlunoEmailInvalido1() {
		new Aluno("Joao", "111111", "CC", "8390890923",
				"joaozinhoblizzad.com");
	}

	/**
	 * Verifica se um aluno com email sem conteudo antes do '@' pode ser
	 * criado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaAlunoEmailInvalido2() {
		new Aluno("Joao", "111111", "CC", "8390890923", "@blizzad.com");
	}

	/**
	 * Verifica se um aluno com email sem conteudo depois do '@' pode ser
	 * criado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCriaAlunoEmailInvalido3() {
		new Aluno("Joao", "111111", "CC", "8390890923", "joaozinho@");
	}

	/**
	 * Verifica se um aluno com telefone vazio pode ser criado.
	 */
	@Test
	public void testCriaAlunoTelefoneVazio() {
		new Aluno("Joao", "111111", "CC", "", "joaozinho@blizzad.com");
	}

	/**
	 * Verifica se a informacao 'Nome' eh retornada como esperado.
	 */
	@Test
	public void getInfoNomeTest() {
		assertEquals("Joao", this.aluno.getInfo("Nome"));
	}

	/**
	 * Verifica se a informacao 'Matricula' eh retornada como esperado.
	 */
	@Test
	public void getInfoMatriculaTest() {
		assertEquals("122312", this.aluno.getInfo("Matricula"));
	}

	/**
	 * Verifica se a informacao 'CodigoCurso' eh retornada como esperado.
	 */
	@Test
	public void getInfoCodigoCursoTest() {
		assertEquals("cc9", this.aluno.getInfo("CodigoCurso"));
	}

	/**
	 * Verifica se a informacao 'Telefone' eh retornada como esperado.
	 */
	@Test
	public void getInfoTelefoneTest() {
		assertEquals("8390890923", this.aluno.getInfo("Telefone"));
	}

	/**
	 * Verifica se a informacao 'Email' eh retornada como esperado.
	 */
	@Test
	public void getInfoEmailTest() {
		assertEquals("joaozinho@blizzad.com", this.aluno.getInfo("Email"));
	}

	/**
	 * Verifica se a matricula eh retornada como esperado.
	 */
	@Test
	public void getMatricula() {
		assertEquals("122312", this.aluno.getMatricula());
	}

	/**
	 * Verifica se nome eh retornado como esperado.
	 */
	@Test
	public void getNomeTest() {
		assertEquals("Joao", this.aluno.getNome());
	}

	/**
	 * Verifica se email eh retornado como esperado.
	 */
	@Test
	public void getEmailTest() {
		assertEquals("joaozinho@blizzad.com", this.aluno.getEmail());
	}

	/**
	 * Verifica a representacao textual de um aluno sem telefone.
	 */
	@Test
	public void testToStringSemTelefone() {
		Aluno novoAluno = new Aluno("Lucas", "1233432", "dss2", "",
				"luquinhas@blizzad.com");
		assertEquals("1233432 - Lucas - dss2 - luquinhas@blizzad.com",
				novoAluno.toString());
	}

	/**
	 * Verifica a representacao textual de um aluno com telefone.
	 */
	@Test
	public void testToStringComTelefone() {
		assertEquals(this.aluno.toString(), "122312 - Joao - cc9 - 8390890923"
				+ " - joaozinho@blizzad.com");
	}

	/**
	 * Verifica se dois alunos com matriculas iguais sao iguais.
	 */
	@Test
	public void testEqualsMatriculasIguais() {
		Aluno aluno1 = new Aluno("Joao", "111111", "CC", "999999999",
				"joaozinho@blizzad.com");
		Aluno aluno2 = new Aluno("Marcos", "111111", "CC", "888888888",
				"marquinhos@blizzad.com");
		assertEquals(aluno1, aluno2);
	}

	/**
	 * Verifica se dois alunos com matriculas diferentes sao iguais.
	 */
	@Test
	public void testEqualsMatriculasDiferentes() {
		Aluno aluno1 = new Aluno("Joao", "111111", "CC", "999999999",
				"joaozinho@blizzad.com");
		Aluno aluno2 = new Aluno("Marcos", "222222", "CC", "888888888",
				"marquinhos@blizzad.com");
		assertNotEquals(aluno1, aluno2);
	}

	/**
	 * Verifica a instancia de tutor de um aluno que nao eh tutor.
	 */
	@Test
	public void testGetTutorNulo() {
		assertEquals(null, this.aluno.getTutor());
	}

	/**
	 * Verifica se um aluno que nao eh tutor pode se tornar tutor.
	 */
	@Test
	public void testTornarTutor() {
		this.aluno.tornarTutor("Programacao", 4, 1);
	}

	/**
	 * Verifica se um aluno, que nao eh tutor, nao eh informado como tutor.
	 */
	@Test
	public void testEhTutorFalse() {
		assertFalse(this.aluno.ehTutor());
	}

	/**
	 * Verifica se um aluno, que eh tutor, eh informado como tutor.
	 */
	@Test
	public void testEhTutorTrue() {
		aluno.tornarTutor("Programacao", 4, 1);
		assert(this.aluno.ehTutor());
	}
	
	/**
	 * Verifica se a consulta de tutoria pode ser realizada com a disciplina vazia.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testTutoriaDisciplinaVazia() {
		aluno.tornarTutor("Programacao", 4, 1);
		aluno.tutoriaDisponivel("  ", "14:00", "qua", "LCC2");
	}
	
	/**
	 * Verifica se a consulta de tutoria pode ser realizada com o horario vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testTutoriaHorarioVazio() {
		aluno.tornarTutor("Programacao", 4, 1);
		aluno.tutoriaDisponivel("Programacao", "   ", "qua", "LCC2");
	}
	
	/**
	 * Verifica se a consulta de tutoria pode ser realizada com o dia vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testTutoriaDiaVazio() {
		aluno.tornarTutor("Programacao", 4, 1);
		aluno.tutoriaDisponivel("Programacao", "14:00", "  ", "LCC2");
	}
	
	/**
	 * Verifica se a consulta de tutoria pode ser realizada com o local vazio.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testTutoriaLocalVazio() {
		aluno.tornarTutor("Programacao", 4, 1);
		aluno.tutoriaDisponivel("Programacao", "14:00", "qua", "   ");
	}
	
	/**
	 * Verifica se a consulta de tutoria pode ser realizada passando dados validos.
	 */
	@Test
	public void testTutoria() {
		aluno.tornarTutor("Programacao", 4, 1);
		aluno.getTutor().adicionaHorario("qua", "14:00");
		aluno.getTutor().adicionaLocal("LCC2");
		assert(this.aluno.tutoriaDisponivel("Programacao", "14:00", "qua", "LCC2"));
	}
	
	/**
	 * Verifica se a consulta de tutoria pode ser realizada com uma disciplina
	 * incorreta.
	 */
	@Test
	public void testTutoriaDisciplinaFalsa() {
		aluno.tornarTutor("Programacao", 4, 1);
		aluno.getTutor().adicionaHorario("qua", "14:00");
		aluno.getTutor().adicionaLocal("LCC2");
		assertFalse(this.aluno.tutoriaDisponivel("Algoritmos Avancados", "14:00", "qua", "LCC2"));
	}
	
	/**
	 * Verifica se a consulta de tutoria pode ser realizada com o horario
	 * de atendimento incorreto.
	 */
	@Test
	public void testTutoriaHorarioFalso() {
		aluno.tornarTutor("Programacao", 4, 1);
		aluno.getTutor().adicionaHorario("qua", "14:00");
		aluno.getTutor().adicionaLocal("LCC2");
		assertFalse(this.aluno.tutoriaDisponivel("Programacao", "10:00", "qua", "LCC2"));
	}
	
	/**
	 * Verifica se a consulta de tutoria pode ser realizada com o dia
	 * incorreto.
	 */
	@Test
	public void testTutoriaDiaFalso() {
		aluno.tornarTutor("Programacao", 4, 1);
		aluno.getTutor().adicionaHorario("qua", "14:00");
		aluno.getTutor().adicionaLocal("LCC2");
		assertFalse(this.aluno.tutoriaDisponivel("Programacao", "14:00", "seg", "LCC2"));
	}
	
	/**
	 * Verifica se a consulta de tutoria pode ser realizada com o local
	 * de atendimento incorreto.
	 */
	@Test
	public void testTutoriaLocalFalso() {
		aluno.tornarTutor("Programacao", 4, 1);
		aluno.getTutor().adicionaHorario("qua", "14:00");
		aluno.getTutor().adicionaLocal("LCC2");
		assertFalse(this.aluno.tutoriaDisponivel("Programacao", "14:00", "qua", "CAA404"));
	}
	/**
	 * Espera-se que retorne toString de Aluno
	 */
	@Test
	public void testToString() {
		assertEquals("122312 - Joao - cc9 - 8390890923 - joaozinho@blizzad.com",this.aluno.toString());
	}

}
