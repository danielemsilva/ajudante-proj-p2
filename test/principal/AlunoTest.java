package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe responsavel por testar as funcionalidades da classe Aluno.
 *
 */
public class AlunoTest {
	
	Aluno aluno;
	
	/**
	 * Cria uma instância de Aluno.
	 */
	@Before
	public void iniciaAluno() {
		this.aluno = new Aluno(
				"Joao", "122312", "cc9", "8390890923", "joaozinho@blizzad.com");
	}
	
	/**
	 * Verifica se um aluno com nome vazio pode ser criado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoNomeVazio() {
		Aluno a = new Aluno(
				"", "122312", "cc9", "8390890923", "joaozinho@blizzad.com");
	}
	
	/**
	 * Verifica se um aluno com nome nulo pode ser criado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoNomeNulo() {
		Aluno a = new Aluno(
				null, "122312", "cc9", "8390890923", "joaozinho@blizzad.com");
	}
	
	/**
	 * Verifica se um aluno com matricula vazia pode ser criado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoMatriculaVazia() {
		Aluno a = new Aluno(
				"Joao", "", "cc9", "8390890923", "joaozinho@blizzad.com");
	}
	
	/**
	 * Verifica se um aluno com matricula nula pode ser criado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoMatriculaNula() {
		Aluno a = new Aluno(
				"Joao", null, "cc9", "8390890923", "joaozinho@blizzad.com");
	}
	
	/**
	 * Verifica se um aluno com codigo do curso vazio pode ser criado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoCodigoCursoVazio() {
		Aluno a = new Aluno(
				"Joao", "111111", "", "8390890923", "joaozinho@blizzad.com");
	}
	
	/**
	 * Verifica se um aluno com codigo do curso nulo pode ser criado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoCodigoCursoNulo() {
		Aluno a = new Aluno(
				"Joao", "111111", null, "8390890923", "joaozinho@blizzad.com");
	}
	
	/**
	 * Verifica se um aluno com email vazio pode ser criado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoEmailVazio() {
		Aluno a = new Aluno(
				"Joao", "111111", "CC", "8390890923", "");
	}
	
	/**
	 * Verifica se um aluno com email nulo pode ser criado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoEmailNulo() {
		Aluno a = new Aluno(
				"Joao", "111111", "", "8390890923", null);
	}
	
	/**
	 * Verifica se um aluno com email sem '@' pode ser criado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoEmailInvalido1() {
		Aluno a = new Aluno(
				"Joao", "111111", "CC", "8390890923", "joaozinhoblizzad.com");
	}
	
	/**
	 * Verifica se um aluno com email sem conteudo antes do '@' pode ser criado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoEmailInvalido2() {
		Aluno a = new Aluno(
				"Joao", "111111", "CC", "8390890923", "@blizzad.com");
	}
	
	/**
	 * Verifica se um aluno com email sem conteudo depois do '@' pode ser criado.
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testCriaAlunoEmailInvalido3() {
		Aluno a = new Aluno(
				"Joao", "111111", "CC", "8390890923", "joaozinho@");
	}
	
	/**
	 * Verifica se um aluno com telefone vazio pode ser criado.
	 */
	@Test
	public void testCriaAlunoTelefoneVazio() {
		Aluno a = new Aluno(
				"Joao", "111111", "CC", "", "joaozinho@blizzad.com");
	}
	
	/**
	 * Verifica se a informacao 'Nome' é retornada como esperado. 
	 */
	@Test
	public void getInfoNomeTest() {
		assertEquals("Joao", this.aluno.getInfo("Nome"));
	}
	
	/**
	 * Verifica se a informacao 'Matricula' é retornada como esperado. 
	 */
	@Test
	public void getInfoMatriculaTest() {
		assertEquals("122312", this.aluno.getInfo("Matricula"));
	}
	
	/**
	 * Verifica se a informacao 'CodigoCurso' é retornada como esperado. 
	 */
	@Test
	public void getInfocodigoCursoTest() {
		assertEquals("cc9", this.aluno.getInfo("CodigoCurso"));
	}
	
	/**
	 * Verifica se a informacao 'Telefone' é retornada como esperado. 
	 */
	@Test
	public void getInfotelefoneTest() {
		assertEquals("8390890923", this.aluno.getInfo("Telefone"));
	}
	
	/**
	 * Verifica se a informacao 'Email' é retornada como esperado. 
	 */
	@Test
	public void getInfoemailTest() {
		assertEquals("joaozinho@blizzad.com", this.aluno.getInfo("Email"));
	}
	
	/**
	 * Verifica se a matricula é retornada como esperado. 
	 */
	@Test
	public void getMatricula() {
		assertEquals("122312", this.aluno.getMatricula());
	}
	
	/**
	 * Verifica se nome é retornado como esperado. 
	 */
	@Test 
	public void getNomeTest() {
		assertEquals("Joao", this.aluno.getNome());
	}
	
	/**
	 * Verifica se email é retornado como esperado. 
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
		Aluno novoAluno = new Aluno(
				"Lucas", "1233432","dss2", "","luquinhas@blizzad.com");
		assertEquals("1233432 - Lucas - dss2 - luquinhas@blizzad.com", 
				novoAluno.toString());
	}
	
	/**
	 * Verifica a representacao textual de um aluno com telefone.
	 */
	@Test
	public void testToStringComTelefone() {
		assertEquals(this.aluno.toString(), 
				"122312 - Joao - cc9 - 8390890923 - joaozinho@blizzad.com");
	}
	
	/**
	 * Verifica de dois alunos com matriculas iguais sao iguais.
	 */
	@Test
	public void testEqualsMatriculasIguais() {
		Aluno a = new Aluno(
				"Joao", "111111", "CC", "999999999", "joaozinho@blizzad.com");
		Aluno b = new Aluno(
				"Marcos", "111111", "CC", "888888888", "marquinhos@blizzad.com");
		assertEquals(a, b);
	}
	
	/**
	 * Verifica de dois alunos com matriculas diferentes sao iguais.
	 */
	@Test
	public void testEqualsMatriculasDiferentes() {
		Aluno a = new Aluno(
				"Joao", "111111", "CC", "999999999", "joaozinho@blizzad.com");
		Aluno b = new Aluno(
				"Marcos", "222222", "CC", "888888888", "marquinhos@blizzad.com");
		assertNotEquals(a, b);
	}
	
	/**
	 * Verifica se a instancia de tutor de um aluno que nao e tutor e nula.
	 */
	@Test
	public void testGetTutorNulo() {
		assertEquals(null, this.aluno.getTutor());
	}
	
	/**
	 * Verifica se um aluno que nao e tutor pode se tornar tutor.
	 */
	@Test
	public void testTornarTutor() {
		this.aluno.tornarTutor("programacao", 4);
	}
	
	/**
	 * Verifica se um aluno, que nao e tutor, e tutor.
	 */
	@Test
	public void testEhTutorFalse() {
		assertEquals(false, this.aluno.ehTutor());
	}
	
	/**
	 * Verifica se um aluno, que e tutor, e tutor.
	 */
	@Test
	public void testEhTutorTrue() {
		aluno.tornarTutor("Programcao", 4);
		assertEquals(true,this.aluno.ehTutor());
	}
		
}
