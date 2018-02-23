package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import base.AlunoComparator;

/**
 * Esta classe eh responsavel pelo gerenciamento dos alunos
 *
 */
public class AlunoController {

	private List<Aluno> alunos;
	private Comparator<Aluno> comparator;

	/**
	 * Constroi um novo controlar, inicializando a lista de alunos e definindo o
	 * comparator
	 */
	public AlunoController() {
		alunos = new ArrayList<>();
		comparator = new AlunoComparator();
	}

	/**
	 * Cadastra um novo aluno
	 * 
	 * @param nome
	 *            nome do aluno
	 * @param matricula
	 *            matricula
	 * @param codigoCurso
	 *            codigo do curso que ele pertence
	 * @param telefone
	 *            telefone do aluno
	 * @param email
	 *            email
	 */
	public void cadastrarAluno(String nome, String matricula, String codigoCurso, String telefone, String email) {
		Aluno novoAluno = new Aluno(nome, matricula, codigoCurso, telefone, email);
		if (procuraAluno(matricula) != null) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		alunos.add(novoAluno);
	}

	/**
	 * Retorna os dados de um aluno consultado pela matricula
	 * 
	 * @param matricula
	 *            matricula do aluno requisitado
	 * @return informacoes do aluno
	 */
	public String recuperaAluno(String matricula) {
		Aluno aluno = procuraAluno(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException("Erro na busca por aluno: Aluno nao encontrado");
		}
		return aluno.toString();
	}

	/**
	 * Lista os alunos, ordenados alfabeticamente
	 * 
	 * @return lista de alunos
	 */
	public String listarAlunos() {
		Collections.sort(alunos, comparator);
		String lista = "";
		for (int i = 0; i < alunos.size(); i++) {
			lista += alunos.get(i).toString();
			if (i != alunos.size() - 1) {
				lista += ", ";
			}
		}
		return lista;
	}

	public String getInfoAluno(String matricula, String atributo) {
		Aluno aluno = procuraAluno(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException("Erro na obtencao de informacao de aluno: Aluno nao encontrado");
		}
		return aluno.getInfo(atributo);
	}

	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		Aluno aluno = procuraAluno(matricula);
		aluno.tornarTutor(disciplina, proficiencia);
	}

	public String recuperaTutor(String matricula) {
		return "";
	}

	public String listarTutores() {
		return "";
	}

	public void cadastrarHorario(String email, String horario, String dia) {

	}

	public void cadastrarLocalDeAtendimento(String email, String local) {

	}

	public boolean consultaHorario(String email, String horario, String dia) {
		return true;
	}

	public boolean consultaLocal(String email, String local) {
		return true;
	}

	private Aluno procuraAluno(String matricula) {
		for (Aluno aluno : alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				return aluno;
			}
		}
		return null;
	}
}
