package principal;

/**
 * Esta classe eh responsavel por manipular os controllers de Ajuda e Aluno e
 * intermediar informacoes entre eles.
 *
 */
public class QuemMeAjudaController {

	private AlunoController alunoCtrl;
	private AjudaController ajudaCtrl;
	private int dinheiroSistema;

	/**
	 * Constroi um novo controller do sistema, inicializando tambem os 
	 * controllers de ajuda e aluno.
	 */
	public QuemMeAjudaController() {
		this.alunoCtrl = new AlunoController();
		this.ajudaCtrl = new AjudaController();
		this.dinheiroSistema = 0;
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
		this.alunoCtrl.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
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
		return this.alunoCtrl.recuperaAluno(matricula);
	}

	/**
	 * Lista os alunos ordenados alfabeticamente.
	 * 
	 * @return lista de alunos
	 */
	public String listarAlunos() {
		return this.alunoCtrl.listarAlunos();
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
		return this.alunoCtrl.getInfoAluno(matricula, atributo);
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
		this.alunoCtrl.tornarTutor(matricula, disciplina, proficiencia);
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
		return this.alunoCtrl.recuperaTutor(matricula);
	}

	/**
	 * Lista todos os alunos que sao tutores.
	 * 
	 * @return lista com os dados dos tutores
	 */
	public String listarTutores() {
		return this.alunoCtrl.listarTutores();
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
		this.alunoCtrl.cadastrarHorario(email, horario, dia);
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
		this.alunoCtrl.cadastrarLocalDeAtendimento(email, local);
	}

	/**
	 * Verifica se um determinado horario esta entre os horarios de atendimento
	 * de um tutor.
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
		return this.alunoCtrl.consultaHorario(email, horario, dia);
	}

	/**
	 * Verifica se um determinado local esta entre os locais de atendimento de 
	 * um tutor.
	 * 
	 * @param email
	 *            email do tutor
	 * @param local
	 *            local a ser pesquisado
	 * 
	 * @return true, se o local for um dos locais de atendimento do tutor, e 
	 *         false caso contrario
	 */
	public boolean consultaLocal(String email, String local) {
		return this.alunoCtrl.consultaLocal(email, local);
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
	 * 
	 * @return id da ajuda cadastrada.
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, 
			String dia, String localInteresse) {
		this.validarDadosAjudaPresencial(matrAluno, disciplina, horario, dia, 
				localInteresse);
		String matrTutor = this.alunoCtrl.buscarTutor(disciplina, horario, dia, localInteresse);
		return this.ajudaCtrl.pedirAjudaPresencial(matrAluno, matrTutor, disciplina, 
				horario, dia, localInteresse);
	}

	/**
	 * Encontra o tutor mais apto a ajudar da disciplina informada e realiza o
	 * pedido de ajuda online.
	 * 
	 * @param matrAluno
	 *            matricula do aluno que pediu a ajuda
	 * @param disciplina
	 *            disciplina da ajuda
	 * 
	 * @return id da ajuda cadastrada
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		this.validarDadosAjudaOnline(matrAluno, disciplina);
		String matrTutor = this.alunoCtrl.buscarTutor(disciplina);
		return this.ajudaCtrl.pedirAjudaOnline(matrAluno, matrTutor, disciplina);
	}

	/**
	 * Retorna os dados do tutor de uma determinada ajuda.
	 * 
	 * @param idAjuda
	 *            identificacao da ajuda
	 * @return dados do tutor que deu a ajuda
	 */
	public String pegarTutor(int idAjuda) {
		if (idAjuda <= 0) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		}
		return this.ajudaCtrl.pegarTutor(idAjuda);
	}

	/**
	 * Retorna alguma informacao especifica da ajuda.
	 * 
	 * @param idAjuda
	 *            identificacao da ajuda
	 * @param atributo
	 *            categoria do dado requisitado
	 * @return dado requisitado
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		this.validarDadosGetInfoAjuda(idAjuda, atributo);
		return this.ajudaCtrl.getInfoAjuda(idAjuda, atributo);
	}

	/**
	 * Avalia com uma pontuacao o tutor que deu uma determinada ajuda.
	 * 
	 * @param idAjuda
	 *            identificacao da ajuda
	 * @param nota
	 *            nota a ser atribuida ao tutor
	 */
	public void avaliarTutor(int idAjuda, int nota) {
		this.validarDadosAvaliar(idAjuda, nota);
		String matricula = this.ajudaCtrl.avaliar(idAjuda);
		this.alunoCtrl.avaliarTutor(matricula, nota);
	}

	/**
	 * Retorna a pontuacao do tutor.
	 * 
	 * @param matricula
	 *            matricula do aluno
	 * @return nota do tutor no formato "#,##"
	 */
	public String pegarNota(String matricula) {
		if(matricula == null || matricula.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na consulta da nota: matricula nao pode ser nula ou vazia");
		}
		return String.format("%.2f", this.alunoCtrl.getNota(matricula)).replace('.', ',');
	}
	
	/**
	 * Retorna o nivel do tutor de acordo com a sua pontuacao.
	 * 
	 * @param matricula
	 *            matricula do aluno
	 * @return nivel do tutor
	 */
	public String pegarNivel(String matricula) {
		if(matricula == null || matricula.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na consulta do nivel: matricula nao pode ser nula ou vazia");
		}
		return this.alunoCtrl.getNivel(matricula);
	}
	
	/**
	 * Distribui o dinheiro de uma doacao entre o tutor e o sistema atraves de
	 * uma taxa baseada na pontuacao e nivel do tutor.
	 * 
	 * @param matricula 
	 *            matricula do tutor
	 * @param doacao 
	 *            dinheiro a ser doado
	 */
	public void doarDinheiro(String matricula, int doacao) {
		this.validarDadosDoar(matricula, doacao);
		double taxaTutor = this.alunoCtrl.calcularTaxaTutor(matricula);
		int totalSistema = (int) Math.round(((1 - taxaTutor) * doacao));
		int totalTutor = doacao - totalSistema;
		this.dinheiroSistema += totalSistema;
		this.alunoCtrl.doarDinheiro(matricula, totalTutor);
	}
	
	/**
	 * Retorna o dinheiro total ja doado ao tutor.
	 * 
	 * @param email 
	 *            email do tutor
	 * @return dinheiro do tutor
	 */
	public int totalDinheiroTutor(String email) {
		if(email == null || email.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na consulta de total de dinheiro do tutor: "
					+ "emailTutor nao pode ser vazio ou nulo");
		}
		return this.alunoCtrl.totalDinheiroTutor(email);
	}
	
	/**
	 * Retorna o dinheiro disponivel no caixa do sistema.
	 * 
	 * @return total do dinheiro do sistema, em centavos
	 */
	public int totalDinheiroSistema() {
		return this.dinheiroSistema;
	}
	
	/**
	 * Altera o tipo da ordenacao de alunos.
	 * 
	 * @param ordem
	 *            descricao da ordenacao desejada
	 */
	public void configurarOrdem(String ordem) {
		if (ordem == null || ordem.trim().equals("")){
			throw new IllegalArgumentException("Erro na configuracao da "
				+ "ordenacao: ordem nao pode ser vazia ou em branco");
		}
		this.alunoCtrl.configurarOrdem(ordem);
	}
	
	/**
	 * Realiza as chamadas para gravacao dos dados.
	 * 
	 * @return true se todos os dados foram salvos com sucesso,
	 * false se ocorreu algum erro durante as gravacoes.
	 */
	public boolean gravarDados() {
		return this.alunoCtrl.gravarAlunos() && this.ajudaCtrl.gravarAjudas() && this.gravarCaixa();
	}
	
	/**
	 * Realiza as chamadas para leitura dos dados.
	 * 
	 * @return true se as listas de alunos e ajudas foram preenchidas,
	 * 		false se alguma esta nula.
	 */
	public boolean lerDados() {
		this.lerCaixa();
		return this.alunoCtrl.lerAlunos() && this.ajudaCtrl.lerAjudas();
	}
	
	/**
	 * Realiza as chamadas para limpeza de dados.
	 */
	public void limparDados() {
		this.alunoCtrl.deletarAlunos();
		this.ajudaCtrl.deletarAjudas();
		this.deletarCaixa();
	}
	
	/**
	 * Valida os dados passados ao metodo pedirAjudaOnline.
	 * 
	 * @param matrAluno
	 *            a matricula do aluno que solicita a ajuda
	 * @param disciplina
	 *            a disciplina que o aluno necessita de ajuda
	 */
	private void validarDadosAjudaOnline(String matrAluno, String disciplina) {
		if (matrAluno == null || matrAluno.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda online:" 
							+ " matricula de aluno nao pode ser vazio ou em branco");
		}
		if (disciplina == null || disciplina.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda online:" 
							+ " disciplina nao pode ser vazio ou em branco");
		}
	}

	/**
	 * Valida os dados passados ao metodo pedirAjudaPresencial exceto a
	 * matricula do tutor.
	 * 
	 * @param matrAluno
	 *            a matricula do aluno que solicita a ajuda
	 * @param disciplina
	 *            a disciplina que o aluno necessita de ajuda
	 * @param horario
	 *            o horario em que ajuda vai acontecer
	 * @param dia
	 *            o dia em que a ajuda vai acontecer
	 * @param localInteresse
	 *            o local onde a ajuda vai acontecer
	 */
	private void validarDadosAjudaPresencial(String matrAluno, String disciplina,
			String horario, String dia, String localInteresse) {
		if (matrAluno == null || matrAluno.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial:" 
							+ " matricula de aluno nao pode ser vazio ou em branco");
		}
		if (disciplina == null || disciplina.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial:" 
							+ " disciplina nao pode ser vazio ou em branco");
		}
		if (horario == null || horario.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial:"
							+ " horario nao pode ser vazio ou em branco");
		}
		if (dia == null || dia.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial:"
							+ " dia nao pode ser vazio ou em branco");
		}
		if (localInteresse == null || localInteresse.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial:" 
							+ " local de interesse nao pode ser vazio ou em branco");
		}
	}

	/**
	 * Valida os dados passados ao metodo getInfoAjuda.
	 * 
	 * @param idAjuda
	 *            o identificador da ajuda
	 * @param atributo
	 *            um dos atributos de uma ajuda
	 */
	private void validarDadosGetInfoAjuda(int idAjuda, String atributo) {
		if (idAjuda < 0) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar info da ajuda : id nao pode menor"
					+ " que zero ");
		}
		if (atributo == null || atributo.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar info da ajuda : atributo nao pode"
					+ " ser vazio ou em branco");
		}
	}

	/**
	 * Valida os dados passados no metodo avaliar.
	 * 
	 * @param id
	 *            o identificador da ajuda
	 * @param nota
	 *            nota a ser atribuida ao tutor
	 */
	private void validarDadosAvaliar(int id, int nota) {
		if (nota < 0) {
			throw new IllegalArgumentException(
					"Erro na avaliacao de tutor: nota nao pode ser menor que 0");
		}
		if (nota > 5) {
			throw new IllegalArgumentException(
					"Erro na avaliacao de tutor: nota nao pode ser maior que 5");
		}
		if (id < 0) {
			throw new IllegalArgumentException(
					"Erro na avaliacao de tutor: id nao encontrado ");
		}
	}
	
	/**
	 * Valida os dados passados ao metodo doarDinheiro.
	 * 
	 * @param matricula
	 *            o identificador de aluno
	 * @param doacao
	 *            doacao para o tutor
	 */
	private void validarDadosDoar(String matricula, int doacao) {
		if (doacao < 0) {
			throw new IllegalArgumentException("Erro na doacao para tutor: "
					+ "totalCentavos nao pode ser menor que zero");
		}
		if (matricula == null || matricula.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na doacao para tutor: matricula nao pode ser vazia ou"
					+ " nula");
		}
	}

	/**
	 * Realiza a chamada para gravar o dinheiro do sistema.
	 * 
	 * @return true se gravou em arquivo, false se ocorreu algum erro.
	 */
	private boolean gravarCaixa() {
		ManipulaDados manipula = new ManipulaDados();
		return manipula.gravarCaixa(this.dinheiroSistema);
	}
	
	/**
	 * Realiza a chamada para leitura do dinheiro do sistema.
	 */
	private void lerCaixa() {
		ManipulaDados manipula = new ManipulaDados();
		this.dinheiroSistema = manipula.lerCaixa();
	}
	
	/**
	 * Realiza a chamada para limpar o dinheiro do sistema no arquivo.
	 */
	private void deletarCaixa() {
		ManipulaDados manipula = new ManipulaDados();
		manipula.deletarCaixa();
	}
}
