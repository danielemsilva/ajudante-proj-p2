package principal;

import easyaccept.EasyAccept;
/**
 * Classe sem logica de negocio, apenas atribui tarefas a AlunoController.
 * 
 *
 */
public class Facade {

	private AlunoController alunoController = new AlunoController();

	/**
	 * Cadastro de um aluno
	 * 
	 * @param nome
	 *            nome do aluno
	 * @param matricula
	 *            matricula de identificacao
	 * @param codigoCurso
	 *            codigo do curso que ele pertence
	 * @param telefone
	 *            telefone do aluno
	 * @param email
	 *            email
	 */
	public void cadastrarAluno(String nome, String matricula, String codigoCurso, 
			String telefone, String email) {
		alunoController.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	/**
	 * Recupera os dados de um aluno atraves de sua matricula.
	 * 
	 * @param matricula
	 *            matricula do aluno requisitado
	 * 
	 * @return informacoes do aluno
	 */
	public String recuperaAluno(String matricula) {
		return alunoController.recuperaAluno(matricula);
	}

	/**
	 * Lista todos os alunos cadastrados.
	 * 
	 * @return lista de alunos
	 */
	public String listarAlunos() {
		return alunoController.listarAlunos();
	}

	/**
	 * Retorna uma informacao especifica de um aluno cadastrado.
	 * 
	 * @param matricula
	 *            matricula do aluno
	 * @param atributo
	 *            categoria do informacao desejada
	 * 
	 * @return dado especifico do aluno
	 */
	public String getInfoAluno(String matricula, String atributo) {
		return alunoController.getInfoAluno(matricula, atributo);
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
		alunoController.tornarTutor(matricula, disciplina, proficiencia);
	}

	/**
	 * Recupera as informacoes de um aluno tutor.
	 * 
	 * @param matricula
	 *            matricula do aluno
	 * 
	 * @return dados do tutor
	 */
	public String recuperaTutor(String matricula) {
		return alunoController.recuperaTutor(matricula);
	}

	/**
	 * Lista todos os alunos que sao tutores.
	 * 
	 * @return lista com os dados dos tutores
	 */
	public String listarTutores() {
		return alunoController.listarTutores();
	}

	/**
	 * Cadastra um horario de atendimento de um tutor.
	 * 
	 * @param email
	 *            email do tutor
	 * @param horario
	 *            horario no referente dia a ser adicionado
	 * @param dia
	 *            dia disponivel
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		alunoController.cadastrarHorario(email, horario, dia);
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
		alunoController.cadastrarLocalDeAtendimento(email, local);
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
		return alunoController.consultaHorario(email, horario, dia);
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
		return alunoController.consultaLocal(email, local);
	}

	/**
	 * Executa chamada de testes de aceitacao
	 * @param args
	 *            casos de testes do EasyAccept
	 */
	public static void main(String[] args) {
		args = new String[] { "principal.Facade", "acceptance_test/us1_test.txt", 
				"acceptance_test/us2_test.txt", "acceptance_test/us3_test.txt" };
		EasyAccept.main(args);
	}
}
