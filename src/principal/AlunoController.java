package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import base.AlunoComparator;

/**
 * Esta classe eh responsavel pelo gerenciamento dos alunos.
 *
 */
public class AlunoController {

	private List<Aluno> alunos;
	private Comparator<Aluno> comparator;

	/**
	 * Constroi um novo controlar,
	 * inicializando a lista de alunos e o comparator.
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
	public void cadastrarAluno(String nome, String matricula,
			String codigoCurso, String telefone, String email) {
		Aluno novoAluno = new Aluno(
				nome, matricula, codigoCurso, telefone, email);
		if (procuraAluno(matricula) != null) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		alunos.add(novoAluno);
	}

	/**
	 * Retorna os dados de um aluno.
	 * 
	 * @param matricula
	 *            matricula do aluno requisitado
	 *            
	 * @return informacoes do aluno
	 */
	public String recuperaAluno(String matricula) {
		Aluno aluno = procuraAluno(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException(
					"Erro na busca por aluno: Aluno nao encontrado");
		}
		return aluno.toString();
	}

	/**
	 * Lista os alunos ordenados alfabeticamente.
	 * 
	 * @return lista de alunos
	 */
	public String listarAlunos() {
		Collections.sort(alunos, comparator);
		String lista = "";
		for (Aluno aluno : alunos) {
			if (!lista.equals("")) {
				lista += ", ";
			}
			lista += aluno.toString();
		}
		return lista;
	}

	/**
	 * Retorna uma informacao especifica do aluno.
	 * 
	 * @param matricula
	 *            matricula do aluno
	 * @param atributo
	 *            categoria do dado
	 *            
	 * @return um dado do aluno
	 */
	public String getInfoAluno(String matricula, String atributo) {
		Aluno aluno = procuraAluno(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException(
					"Erro na obtencao de informacao de aluno: Aluno nao encontrado");
		}
		return aluno.getInfo(atributo);
	}

	/**
	 * Transforma um aluno em tutor da disciplina informada.
	 * 
	 * @param matricula
	 *            matricula do aluno
	 * @param disciplina
	 *            disciplina a ser ensinada
	 * @param proficiencia
	 *            nivel de proficiencia para essa disciplina
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {
		Aluno aluno = procuraAluno(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException(
					"Erro na definicao de papel: Tutor nao encontrado");
		}
		aluno.tornarTutor(disciplina, proficiencia);
	}

	/**
	 * Retorna as informacoes de um aluno tutor.
	 * 
	 * @param matricula
	 *            matricula do aluno
	 *            
	 * @return dados do tutor
	 */
	public String recuperaTutor(String matricula) {
		Aluno aluno = procuraAluno(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException(
					"Erro na busca por tutor: Tutor nao encontrado");
		}
		return aluno.toString();
	}
	
	/**
	 * Lista todos os alunos que sao tutores.
	 * 
	 * @return lista com os dados dos tutores
	 */
	public String listarTutores() {
		String lista = "";
		for (Aluno aluno : alunos) {
			if (aluno.ehTutor()) {
				if (!lista.equals("")) {
					lista += ", ";
				}
				lista += aluno.toString();
			}
		}

		return lista;
	}
	
	public void cadastrarHorario(String email, String horario, String dia) {

	}
	
	/**
	 * Cadastra um local de atendimento de um tutor.
	 * 
	 * @param email
	 *     email do tutor
	 * @param local
	 *     local da tutoria
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		for(Aluno aluno: this.alunos) {
			if(aluno.getEmail().equals(email)) {
				aluno.adicionaLocal(local);
			}
		}
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
