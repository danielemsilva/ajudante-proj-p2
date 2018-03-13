package principal;

import easyaccept.EasyAccept;

/**
 * Classe sem logica de negocio, apenas atribui tarefas a this.qmaCtrl.
 */
public class Facade {

	private QuemMeAjudaController qmaCtrl = new QuemMeAjudaController();
	
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
	public void cadastrarAluno(String nome, String matricula, String codigoCurso, String telefone, String email) {
		this.qmaCtrl.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
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
		return this.qmaCtrl.recuperaAluno(matricula);
	}

	/**
	 * Lista todos os alunos cadastrados.
	 * 
	 * @return lista de alunos
	 */
	public String listarAlunos() {
		return this.qmaCtrl.listarAlunos();
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
		return this.qmaCtrl.getInfoAluno(matricula, atributo);
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
		this.qmaCtrl.tornarTutor(matricula, disciplina, proficiencia);
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
		return this.qmaCtrl.recuperaTutor(matricula);
	}

	/**
	 * Lista todos os alunos que sao tutores.
	 * 
	 * @return lista com os dados dos tutores
	 */
	public String listarTutores() {
		return this.qmaCtrl.listarTutores();
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
		this.qmaCtrl.cadastrarHorario(email, horario, dia);
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
		this.qmaCtrl.cadastrarLocalDeAtendimento(email, local);
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
		return this.qmaCtrl.consultaHorario(email, horario, dia);
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
		return this.qmaCtrl.consultaLocal(email, local);
	}

	/**
	 * Delega para ajudaController a responsabilidade de criar uma ajuda presencial.
	 * 
	 * @param matrAluno
	 *            matricula do aluno que pediu a ajuda
	 * @param disciplina
	 *            disciplina estudada
	 * @param horario
	 *            horario do atendimento
	 * @param dia
	 *            dia desejado para o atendimento
	 * @param localInteresse
	 *            local de interesse do aluno
	 * @return identificacao da ajuda
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		return this.qmaCtrl.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}

	/**
	 * Delega para ajudaController a responsabilidade de criar uma ajuda online.
	 * 
	 * @param matrAluno
	 *            matricula do aluno que pediu a ajuda
	 * @param disciplina
	 *            disciplina estudada
	 *
	 * @return identificacao da ajuda
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		return this.qmaCtrl.pedirAjudaOnline(matrAluno, disciplina);
	}

	/**
	 * Retorna os dados do tutor da referente ajuda.
	 * 
	 * @param idAjuda
	 *            identificacao de ajuda
	 * @return dados do tutor
	 */
	public String pegarTutor(int idAjuda) {
		return this.qmaCtrl.pegarTutor(idAjuda);
	}

	/**
	 * Retorna uma informacao especifica de ajuda.
	 * 
	 * @param idAjuda
	 *            identificacao de ajuda
	 * @param atributo
	 *            categoria da informacao desejada
	 * @return dado requerido
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.qmaCtrl.getInfoAjuda(idAjuda, atributo);
	}

	/**
	 * Atribiu uma pontuacao ao tutor de uma ajuda,
	 * 
	 * @param idAjuda
	 *            identificacao de ajuda
	 * @param nota
	 *            nota a ser atribuida ao tutor
	 */
	public void avaliarTutor(int idAjuda, int nota) {
		this.qmaCtrl.avaliarTutor(idAjuda, nota);
	}

	/**
	 * Retorna a pontuacao atribuida a um tutor
	 * 
	 * @param matricula
	 *            matricula do tutor
	 * @return nota do tutor
	 */
	public String pegarNota(String matricula) {
		return this.qmaCtrl.pegarNota(matricula);
	}

	/**
	 * Retorna o nivel de conhecimento do tutor de acordo com a pontuacao
	 * 
	 * @param matricula
	 *            matricula do tutor
	 * @return nivel
	 */
	public String pegarNivel(String matricula) {
		return this.qmaCtrl.pegarNivel(matricula);
	}
	
	/**
	 * Recebe um total de dinheiro, em centavos, destinado a algum tutor.
	 * 
	 * @param matriculaTutor 
	 *            matricula do tutor que recebera a doacao
	 * @param totalCentavos 
	 *            total de centavos da doacao
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		this.qmaCtrl.doarDinheiro(matriculaTutor, totalCentavos);
	}
	
	/**
	 * Retorna o dinheiro total ja doado ao tutor.
	 * 
	 * @param emailTutor
	 *            email do tutor
	 * @return dinheiro do tutor
	 */
	public int totalDinheiroTutor(String emailTutor) {
		return this.qmaCtrl.totalDinheiroTutor(emailTutor);
	}
	
	/**
	 * Retorna o dinheiro disponivel no caixa do sistema.
	 * 
	 * @return total do dinheiro do sistema, em centavos
	 */
	public int totalDinheiroSistema() {
		return this.qmaCtrl.totalDinheiroSistema();
	}
	
	/**
	 * Altera o tipo da ordenacao de alunos
	 * 
	 * @param ordem
	 *            descricao da ordenacao desejada
	 */
	public void configurarOrdem(String ordem) {
		this.qmaCtrl.configurarOrdem(ordem);
	}
	
	/**
	 * Realiza a gravacao dos dados
	 */
	public void gravarDados() {
		this.qmaCtrl.gravarDados();
	}
	
	/**
	 * Realiza a leitura dos dados
	 */
	public void lerDados() {
		this.qmaCtrl.lerDados();
	}
	
	/**
	 * Realiza a limpeza dos dados
	 */
	public void limparDados() {
		this.qmaCtrl.limparDados();
	}

	/**
	 * Executa chamada de testes de aceitacao
	 * 
	 * @param args
	 *            casos de testes do EasyAccept
	 */
	public static void main(String[] args) {
		args = new String[] { "principal.Facade", 
				"acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt", "acceptance_test/us4_test.txt", 
				"acceptance_test/us5_test.txt", "acceptance_test/us6_test.txt" };
		EasyAccept.main(args);
	}

}
