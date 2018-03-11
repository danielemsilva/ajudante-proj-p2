package principal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import comparator.PontuacaoTutorComparator;
import comparator.EmailAlunoComparator;
import comparator.MatriculaAlunoComparator;
import comparator.NomeAlunoComparator;

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
		this.comparator = new NomeAlunoComparator();
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
		Collections.sort(this.alunos, this.comparator);
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
			throw new IllegalArgumentException(
					"Erro na definicao de papel: Tutor nao encontrado");
		}
		aluno.tornarTutor(disciplina, proficiencia, this.id);
		this.id++;
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
			throw new IllegalArgumentException(
					"Erro na busca por tutor: Tutor nao encontrado");
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
		Collections.sort(this.alunos, this.comparator);
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
			throw new IllegalArgumentException(
					"Erro no cadastrar horario: tutor nao cadastrado");
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
	 * Encontra o tutor da disciplina informada, que antende nos horario, dia e
	 * local informados, e possui maior pontuacao na disciplina. Caso dois tutores
	 * se encontrem nesta situacao, o tutor que foi cadastrado primeiro e retornado.
	 * 
	 * @param disciplina
	 *            a disciplina que sera debatida
	 * @param horario
	 *            o horario da ajuda
	 * @param dia
	 *            o dia da ajuda
	 * @param local
	 *            o local da ajuda
	 * 
	 * @return o tutor mais apto a ajudar.
	 */
	public String buscarTutor(String disciplina, String horario, String dia, 
			String local) {
		List<Aluno> tutoresCandidatos = this.buscarTutoresCandidatos(disciplina, 
				horario, dia, local);
		Comparator<Aluno> comparator = new PontuacaoTutorComparator();
		Collections.sort(tutoresCandidatos, comparator);
		if (!tutoresCandidatos.isEmpty()) {
			return tutoresCandidatos.get(0).getMatricula();
		}
		return "";
	}

	/**
	 * Encontra o tutor da disciplina informada que possui maior pontucao nesta.
	 * Caso dois tutores se encontrem nesta situacao, o tutor que foi cadastrado
	 * primeiro e retornado.
	 * 
	 * @param disciplina
	 *            a disciplina que sera debatida
	 * 
	 * @return o tutor mais apto a ajudar
	 */
	public String buscarTutor(String disciplina) {
		List<Aluno> tutoresCandidatos = this.buscarTutoresDisciplina(disciplina);
		Comparator<Aluno> comparator = new PontuacaoTutorComparator();
		Collections.sort(tutoresCandidatos, comparator);
		if (!tutoresCandidatos.isEmpty()) {
			return tutoresCandidatos.get(0).getMatricula();
		}
		return "";
	}

	/**
	 * Recupera o aluno por meio de sua matricula e chama o metodo que altera a
	 * pontuacao.
	 * 
	 * @param matricula
	 *            matricula do aluno
	 * @param nota
	 *            nota a ser atribuida
	 */
	public void avaliarTutor(String matricula, int nota) {
		Aluno aluno = this.procuraAlunoMatricula(matricula);
		this.validarDadosAvaliarTutor(aluno, nota);
		aluno.getTutor().setPontuacao(nota);
	}
	
	/**
	 * Valida os dados passados ao metodo avaliarTutor.
	 * 
	 * @param aluno
	 *     o aluno que se pretende avaliar
	 * @param nota
	 *     a nota que sera atribuida ao aluno
	 */
	private void validarDadosAvaliarTutor(Aluno aluno, int nota) {
		if (aluno == null) {
			throw new IllegalArgumentException(
					"Erro ao avaliar tutor: tutor nao cadastrado");
		}
		if (aluno.getTutor() == null) {
			throw new IllegalArgumentException(
					"Erro ao avaliar tutor: o aluno informado nao eh tutor");
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
	 * Retorna a pontuacao do tutor.
	 * 
	 * @param matricula
	 *            matricula do aluno
	 * @return nota
	 */
	public double getNota(String matricula) {
		Aluno aluno = this.procuraAlunoMatricula(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException(
					"Erro na consulta da nota: tutor nao cadastrado");
		}
		if (aluno.getTutor() == null) {
			throw new IllegalArgumentException(
					"Erro ao pegar nota: o aluno informado nao eh tutor");
		}
		return aluno.getTutor().getPontuacao();
	}

	/**
	 * Retorna o nivel do tutor de acordo com a sua pontuacao.
	 * 
	 * @param matricula
	 *            matricula do aluno
	 * @return nivel do tutor
	 */
	public String getNivel(String matricula) {
		Aluno aluno = this.procuraAlunoMatricula(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException(
					"Erro na consulta do nivel: tutor nao cadastrado");
		}
		return aluno.getTutor().getNivel();
	}
	
	/**
	 * Calcula uma taxa de dinheiro destinado ao tutor de acordo com
	 * seu nivel e pontuacao.
	 * 
	 * @param matricula
	 *            matricula do tutor
	 * @return taxa calculada de acordo com o nivel e pontuacao
	 */
	public double calcularTaxaTutor(String matricula) {
		Aluno aluno = this.procuraAlunoMatricula(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException(
					"Erro na doacao para tutor: Tutor nao encontrado");
		}
		double taxaTutor = 80;
		if (this.getNivel(matricula).equals("TOP")) {
			double nota = Math.floor(this.getNota(matricula) * 10) / 10.0;
			double diferenca = (nota - 4.5) * 10;
			taxaTutor = 90 + 1 * diferenca;
		}
		else if (this.getNivel(matricula).equals("Aprendiz")) {
			double nota = Math.floor(this.getNota(matricula) * 10) / 10.0;
			double diferenca = (3.0 - nota) * 10;
			taxaTutor = 40 - 1 * diferenca;
		}
		return taxaTutor / 100;
	}
	
	/**
	 * Adiciona um total de dinheiro ao tutor
	 * 
	 * @param matricula 
	 *            matricula do tutor
	 * @param doacao 
	 *            dinheiro a ser doado
	 */
	public void doarDinheiro(String matricula, int doacao) {
		Aluno aluno = this.procuraAlunoMatricula(matricula);
		if (aluno == null) {
			throw new IllegalArgumentException(
					"Erro na doacao para tutor: Tutor nao encontrado");
		}
		aluno.getTutor().setDinheiro(doacao);
	}
	
	/**
	 * Retorna o dinheiro total ja doado ao tutor
	 * 
	 * @param email 
	 *            email do tutor
	 * @return dinheiro do tutor
	 */
	public int totalDinheiroTutor(String email) {
		Aluno aluno = this.procuraAlunoEmail(email);
		if (aluno == null) {
			throw new IllegalArgumentException(
					"Erro na consulta de total de dinheiro do tutor: Tutor nao encontrado");
		}
		return aluno.getTutor().getDinheiro();
	}
	
	/**
	 * Altera o comparator que ordena a lista de alunos
	 * 
	 * @param ordem tipo da ordenacao
	 */
	public void configurarOrdem(String ordem) {
		if (ordem.equals("NOME")) {
			this.comparator = new NomeAlunoComparator();
		}
		else if (ordem.equals("MATRICULA")) {
			this.comparator = new MatriculaAlunoComparator();
		}
		else if (ordem.equals("EMAIL")) {
			this.comparator = new EmailAlunoComparator();
		}
	}
	
	/**
	 * Cria uma nova instancia para gravar a lista de alunos
	 * 
	 * @return true se gravou no arquivo, false se deu algum erro
	 */
	public boolean gravarAlunos() {
		ManipulaDados manipula = new ManipulaDados();
		return manipula.gravaAlunos(this.alunos);
	}
	
	/**
	 * Realiza a leitura dos alunos e armazena na lista de alunos
	 */
	public void lerAlunos() {
		ManipulaDados manipula = new ManipulaDados();
		this.alunos = manipula.lerAlunos();
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

	/**
	 * Busca os tutores disponiveis para as especificacoes informadas.
	 * 
	 * @param disciplina
	 *            a disciplina que sera debatida
	 * @param horario
	 *            o horario da ajuda
	 * @param dia
	 *            o dia da ajuda
	 * @param local
	 *            o local da ajuda
	 * 
	 * @return uma lista de tutores que satisfazem as especificacoes
	 */
	private List<Aluno> buscarTutoresCandidatos(String disciplina, String horario, 
			String dia, String local) {
		List<Aluno> tutoresCandidatos = new ArrayList<>();
		for (Aluno aluno : alunos) {
			if (aluno.ehTutor() && aluno.tutoriaDisponivel(disciplina, horario, 
					dia, local)) {
				tutoresCandidatos.add(aluno);
			}
		}
		return tutoresCandidatos;
	}

	/**
	 * Busca os tutores disponiveis para a disciplina informada.
	 * 
	 * @param disciplina
	 *            a disciplina que sera debatida
	 * 
	 * @return uma lista de tutores que satisfazem a especificacao
	 */
	private List<Aluno> buscarTutoresDisciplina(String disciplina) {
		List<Aluno> tutoresDisciplina = new ArrayList<>();
		for (Aluno aluno : alunos) {
			if (aluno.ehTutor() && aluno.getTutor().consultaDisciplina(disciplina)) {
				tutoresDisciplina.add(aluno);
			}
		}
		return tutoresDisciplina;
	}
}
