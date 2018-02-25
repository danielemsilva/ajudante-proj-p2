package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {
	Aluno aluno;
	//instancia Aluno
	@Before
	public void iniciaAluno() {
		this.aluno = new Aluno("Joao","122312","cc9", "8390890923","joaozinho@blizzad.com");
	}
	//espera-se que retorne o Nome do aluno
	@Test
	public void getInfoNomeTest() {
		assertEquals("Joao",this.aluno.getInfo("Nome"));
	}
	//espera-se que retorne a matricula do aluno
	@Test
	public void getInfoMatriculaTest() {
		assertEquals("122312",this.aluno.getInfo("Matricula"));
	}
	//espera-se que retorne o Codigo do Curso do aluno
	@Test
	public void getInfocodigoCursoTest() {
		assertEquals("cc9",this.aluno.getInfo("CodigoCurso"));
	}
	//espera-se que retorne o Telefone do aluno
	@Test
	public void getInfotelefoneTest() {
		assertEquals("8390890923",this.aluno.getInfo("Telefone"));
	}
	//espera-se que retorne o Email do aluno
	@Test
	public void getInfoemailTest() {
		assertEquals("joaozinho@blizzad.com",this.aluno.getInfo("Email"));
	}
	//espera-se que retorne a Matricula do aluno
	@Test
	public void getMatricula() {
		assertEquals("122312",this.aluno.getMatricula());
	}
	//espera-se que retorne o Nome do aluno
	@Test 
	public void getNomeTest() {
		assertEquals("Joao", this.aluno.getNome());
	}
	//espera-se que retorne o Email do aluno
	@Test
	public void getEmailTest() {
		assertEquals("joaozinho@blizzad.com", this.aluno.getEmail());
	}
	//espera-se que retorne Tutor vazio
	@Test
	public void getTutorVazio() {
		assertEquals(null,this.aluno.getTutor());
	}
	//espera-se que cadastre Tutor e nao retorne nada
	@Test
	public void tornarTutorTest() {
		this.aluno.tornarTutor("programacao", 4);
	}
	//espera-se que retorne o Tutor cadastrado
	@Test
	public void getTutorCadastradoTest() {
		Tutor tutor = new Tutor();
		tutor.adicionaDisciplina("Programcao", 4);
		aluno.tornarTutor("Programcao", 4);
		assertEquals(tutor,this.aluno.getTutor());
	}
	//espera-se que retorne false, por nao ter Tutor cadastrado
	@Test
	public void ehTutorFalseTest() {
		assertEquals(false,this.aluno.ehTutor());
	}
	//espera-se que retorne true, por ter Tutor cadastrado
	@Test
	public void ehTutorTrueTest() {
		aluno.tornarTutor("Programcao", 4);
		assertEquals(true,this.aluno.ehTutor());
	}
	//espera-se que retorne a descricao de Aluno com telefone
	@Test
	public void toStringTest() {
		assertEquals("122312 - Joao - cc9 - 8390890923 - joaozinho@blizzad.com", this.aluno.toString());
	}
	//espera-se que retorne a descricao de Aluno com telefone
	@Test
	public void toStringAlunoSemTelefoneTest() {
		Aluno novoAluno = new Aluno("Lucas", "1233432","dss2", "","luquinhas@blizzad.com");
		assertEquals("1233432 - Lucas - dss2 - luquinhas@blizzad.com", novoAluno.toString());
	}
}
