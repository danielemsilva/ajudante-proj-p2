package principal;

public class QuemMeAjudaController {

	private AlunoController alunoCtrl;
	private AjudaController ajudaCtrl;

	public QuemMeAjudaController() {
		alunoCtrl = new AlunoController();
		ajudaCtrl = new AjudaController();
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
		alunoCtrl.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
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
		return alunoCtrl.recuperaAluno(matricula);
	}

	/**
	 * Lista os alunos ordenados alfabeticamente.
	 * 
	 * @return lista de alunos
	 */
	public String listarAlunos() {
		return alunoCtrl.listarAlunos();
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
		return alunoCtrl.getInfoAluno(matricula, atributo);
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
		alunoCtrl.tornarTutor(matricula, disciplina, proficiencia);
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
		return alunoCtrl.recuperaTutor(matricula);
	}

	/**
	 * Lista todos os alunos que sao tutores.
	 * 
	 * @return lista com os dados dos tutores
	 */
	public String listarTutores() {
		return alunoCtrl.listarTutores();
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
		alunoCtrl.cadastrarHorario(email, horario, dia);
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
		alunoCtrl.cadastrarLocalDeAtendimento(email, local);
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
		return alunoCtrl.consultaHorario(email, horario, dia);
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
		return alunoCtrl.consultaLocal(email, local);
	}

	/**
	 * Pesquisa a matricula do tutor que ensina essa disciplina, atende no horario e
	 * dia informados e no local de interesse, e entrega para AjudaController as
	 * informacoes necessarias para criar uma nova instancia de ajuda presencial.
	 * 
	 * @param matrAluno
	 *            matricula do aluno que pediu a ajuda
	 * @param disciplina
	 *            disciplina da ajuda
	 * @param horario
	 *            horario requisitado
	 * @param dia
	 *            dia desejado para o atendimento
	 * @param localInteresse
	 *            local de interesse para o atendimento
	 * @return id da ajuda cadastrada.
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		ajudaCtrl.validarDadosAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
		String matrTutor = alunoCtrl.buscarTutor(disciplina, horario, dia, localInteresse);
		return ajudaCtrl.pedirAjudaPresencial(matrAluno, matrTutor, disciplina, 
				horario, dia, localInteresse);
	}
	
	/**
	 * Encontra o tutor mais apto a ajudar da disciplina informada e realiza
	 * o pedido de ajuda online.
	 * 
	 * @param matrAluno
	 *            matricula do aluno que pediu a ajuda
	 * @param disciplina
	 *            disciplina da ajuda
	 *            
	 * @return id da ajuda cadastrada
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		ajudaCtrl.validarDadosAjudaOnline(matrAluno, disciplina);
		String matrTutor = alunoCtrl.buscarTutor(disciplina);
		return ajudaCtrl.pedirAjudaOnline(matrAluno, matrTutor, disciplina);
	}
	
	public String pegarTutor(int idAjuda) {
		return ajudaCtrl.pegarTutor(idAjuda);
	}
	
	public String getInfoAjuda(int idAjuda, String atributo) {
		return ajudaCtrl.getInfoAjuda(idAjuda, atributo);
	}
	
	public void avaliarTutor(int idAjuda, int nota) {
		String matricula = ajudaCtrl.avaliar(idAjuda);
		alunoCtrl.avaliarTutor(matricula, nota);
	}

}
