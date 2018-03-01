package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import base.AlunoComparator;

/**
 * Esta classe e responsavel pelo gerenciamento dos alunos.
 *
 */
public class AlunoController {

	private List<Aluno> alunos;
	private Comparator<Aluno> comparator;
	private int id;

	/**
	 * Constroi um novo controlar, inicializando a lista de alunos e o comparator.
	 */
	public AlunoController() {
		this.alunos = new ArrayList<>();
		this.comparator = new AlunoComparator();
	}

	/**
	 * Cadastra um novo aluno
	 * 
	 * @param nome
	 *            nome do aluno
	 * @param matricula
	 *            matricula do aluno
	 * @param codigoCurso
	 *            codigo do curso que ele pertence
	 * @param telefone
	 *            telefone do aluno
	 * @param email
	 *            email
	 */
	public void cadastrarAluno(String nome, String matricula, String codigoCurso, 
			String telefone, String email) {
		Aluno novoAluno = new Aluno(nome, matricula, codigoCurso, telefone, email);
		if (this.procuraAlunoMatricula(matricula) != null) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aluno: Aluno de mesma matricula ja cadastrado");
		}
		this.alunos.add(novoAluno);
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
		Aluno aluno = this.procuraAlunoMatricula(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException("Erro na busca por aluno: Aluno nao encontrado");
		}
		return aluno.toString();
	}

	/**
	 * Lista os alunos ordenados alfabeticamente.
	 * 
	 * @return lista de alunos
	 */
	public String listarAlunos() {
		Collections.sort(this.alunos, comparator);
		String lista = "";
		for (Aluno aluno : this.alunos) {
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
	 *            categoria da informacao desejada
	 * 
	 * @return dado especifico do aluno
	 */
	public String getInfoAluno(String matricula, String atributo) {
		Aluno aluno = this.procuraAlunoMatricula(matricula);
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
		Aluno aluno = this.procuraAlunoMatricula(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException("Erro na definicao de papel: Tutor nao encontrado");
		}
		aluno.tornarTutor(disciplina, proficiencia, id);
		id++;
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
		Aluno aluno = this.procuraAlunoMatricula(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException("Erro na busca por tutor: Tutor nao encontrado");
		}
		return aluno.toString();
	}
	/**
	 * Retorna o objeto tutor do aluno
	 * 
	 * @return tutor
	 */
	public Tutor getTutor(String matricula) {
		Aluno aluno = this.procuraAlunoMatricula(matricula);
		return aluno.getTutor();
	}
	/**
	 * Lista todos os alunos que sao tutores.
	 * 
	 * @return lista com os dados dos tutores
	 */
	public String listarTutores() {
		String lista = "";
		for (Aluno aluno : this.alunos) {
			if (aluno.ehTutor()) {
				if (!lista.equals("")) {
					lista += ", ";
				}
				lista += aluno.toString();
			}
		}

		return lista;
	}

	/**
	 * Cadastra um horario de atendimento de um tutor.
	 * 
	 * @param email
	 *            o email do tutor
	 * @param horario
	 *            horario no referente dia a ser adicionado
	 * @param dia
	 *            dia disponivel
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		if (email == null || email.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastrar horario: email nao pode ser vazio ou em branco");
		}
		Aluno aluno = this.procuraAlunoEmail(email);
		if (aluno == null || !aluno.ehTutor()) {
			throw new IllegalArgumentException("Erro no cadastrar horario: tutor nao cadastrado");
		}
		aluno.getTutor().adicionaHorario(dia, horario);

	}

	/**
	 * Cadastra um local de atendimento de um tutor.
	 * 
	 * @param email
	 *            email do tutor
	 * @param local
	 *            local da tutoria
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		if (email == null || email.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: email nao pode ser vazio ou em branco");
		}
		Aluno aluno = this.procuraAlunoEmail(email);
		if (aluno == null || !aluno.ehTutor()) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: tutor nao cadastrado");
		}
		aluno.getTutor().adicionaLocal(local);
	}

	/**
	 * Verifica se um determinado horario esta entre os horarios de atendimento de
	 * um tutor.
	 * 
	 * @param email
	 *            email do tutor
	 * @param horario
	 *            horario a ser pesquisado
	 * @param dia
	 *            dia a ser pesquisado
	 * 
	 * @return true, se o horario for um dos horarios de atendimento do tutor, e
	 *         false caso contrario
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		Aluno aluno = this.procuraAlunoEmail(email);
		if (aluno == null || !aluno.ehTutor()) {
			return false;
		}
		return aluno.getTutor().consultaHorario(dia, horario);
	}

	/**
	 * Verifica se um determinado local esta entre os locais de atendimento de um
	 * tutor.
	 * 
	 * @param email
	 *            email do tutor
	 * @param local
	 *            local a ser pesquisado
	 * 
	 * @return true, se o local for um dos locais de atendimento do tutor, e false
	 *         caso contrario
	 */
	public boolean consultaLocal(String email, String local) {
		Aluno aluno = this.procuraAlunoEmail(email);
		if (aluno == null || !aluno.ehTutor()) {
			return false;
		}
		return aluno.getTutor().consultaLocal(local);
	}

	/**
	 * Verifica se um aluno esta cadastrado no sistema, dada sua matricula.
	 * 
	 * @param matricula
	 *            a matricula do aluno
	 * 
	 * @return o Aluno caso este esteja cadastrado e null caso contrario
	 */
	private Aluno procuraAlunoMatricula(String matricula) {
		for (Aluno aluno : this.alunos) {
			if (aluno.getMatricula().equals(matricula)) {
				return aluno;
			}
		}
		return null;
	}

	/**
	 * Verifica se um aluno esta cadastrado no sistema, dado seu email.
	 * 
	 * @param email
	 *            o email do aluno
	 * 
	 * @return o Aluno caso este esteja cadastrado e null caso contrario
	 */
	private Aluno procuraAlunoEmail(String email) {
		for (Aluno aluno : this.alunos) {
			if (aluno.getEmail().equals(email)) {
				return aluno;
			}
		}
		return null;
	}
}
