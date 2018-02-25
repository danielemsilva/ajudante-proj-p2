package principal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoControllerTest {
	AlunoController alunoController;
	
	//inicializa alunoController
	@Before
	public void iniciaAlunoController() {
		alunoController = new AlunoController();
	}
	//cadastra aluno em alunoController
	@Before
	public void CadastraAlunoTest() {
		this.alunoController.cadastrarAluno("Joao", "1232423", "DD34", "8467989023", "joaozinho@blizzard.com");
	}
	//cadastra Aluno sem telefone em alunoCOntroller
	@Test 
	public void cadastraAlunoSemTelefoneTest() {
		this.alunoController.cadastrarAluno("Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
	}
	//espera-se que lance uma excecao, pois ja existe aluno com esta matricula
	@Test (expected = IllegalArgumentException.class)
	public void cadastraAlunoMatriculaJaExistenteTest() {
		this.alunoController.cadastrarAluno("Lucas", "1232423", "EER4", "832334521", "luquinhas@blizzard.com");
	}
	//espera-se que procure e retorne aluno cadastrado
	@Test
	public void procuraAluno() {
		assertEquals("1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com", this.alunoController.recuperaAluno("1232423"));
	}
	//espera-se que lance uma excecao, pois o aluno nao esta cadastrado
	@Test (expected = IllegalArgumentException.class)
	public void recuperarAlunoNaoCadastrado() {
		this.alunoController.recuperaAluno("1347895");
	}
	//espera-se que liste todos os alunos cadastrados em alunoController
	@Test
	public void listarAlunos() {
		this.alunoController.cadastrarAluno("Lucas", "1232428", "EER4", "", "luquinhas@blizzard.com");
		assertEquals("1232423 - Joao - DD34 - 8467989023 - joaozinho@blizzard.com, 1232428 - Lucas - EER4 - luquinhas@blizzard.com", this.alunoController.listarAlunos());
	}
	//espera-se que procure na matricula passada a matricula passado e retorne a matricula do aluno
	@Test
	public void getInfoMatriculaTest() {
		assertEquals("1232423",this.alunoController.getInfoAluno("1232423", "Matricula"));
	}
	//espera-se que procure na matricula passada o Nome passado e retorne o Nome do aluno
	@Test
	public void getInfoNomeTest() {
		assertEquals("Joao",this.alunoController.getInfoAluno("1232423", "Nome"));
	}
	//espera-se que procure na matricula passada o CodigoCurso passado e retorne o CodigoCurso do aluno
	@Test
	public void getInfoCodigoCursoTest() {
		assertEquals("DD34",this.alunoController.getInfoAluno("1232423", "CodigoCurso"));
	}
	//espera-se que procure na matricula passada o Telefone passado e retorne o Telefone do aluno
	@Test
	public void getInfoTelefoneTest() {
		assertEquals("8467989023",this.alunoController.getInfoAluno("1232423", "Telefone"));
	}
	//espera-se que procure na matricula passada o Email passado e retorne o Email do aluno
	@Test
	public void getInfoEmailTest() {
		assertEquals("joaozinho@blizzard.com",this.alunoController.getInfoAluno("1232423", "Email"));
	}
	//espera-se que lance uma excecao pois o aluno nao esta cadastrado
	@Test (expected = IllegalArgumentException.class)
	public void getInfoAlunoNaoCadastradoTest() {
		this.alunoController.getInfoAluno("234523", "Nome");
	}
}
