package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {
	Aluno aluno;
	@Before
	public void iniciaAluno() {
		this.aluno = new Aluno("Joao","122312","cc9", "8390890923","joaozinho@blizzad.com");
	}
	@Test
	public void getInfoNomeTest() {
		assertEquals("Joao",this.aluno.getInfo("Nome"));
	}
	@Test
	public void getInfoMatriculaTest() {
		assertEquals("122312",this.aluno.getInfo("Matricula"));
	}
	@Test
	public void getInfocodigoCursoTest() {
		assertEquals("cc9",this.aluno.getInfo("CodigoCurso"));
	}
	@Test
	public void getInfotelefoneTest() {
		assertEquals("8390890923",this.aluno.getInfo("Telefone"));
	}
	@Test
	public void getInfoemailTest() {
		assertEquals("joaozinho@blizzad.com",this.aluno.getInfo("Email"));
	}
	@Test
	public void getMatricula() {
		assertEquals("122312",this.aluno.getMatricula());
	}
	@Test 
	public void getNomeTest() {
		assertEquals("Joao", this.aluno.getNome());
	}
	@Test
	public void getEmailTest() {
		assertEquals("joaozinho@blizzad.com", this.aluno.getEmail());
	}
}
