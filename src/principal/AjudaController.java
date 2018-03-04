package principal;

import java.util.HashMap;
import java.util.Map;

/**
 * Esta classe e responsavel pelo gerenciamento das ajudas.
 *
 */
public class AjudaController {

	private Map<Integer, Ajuda> ajudas;

	/**
	 * Constroi o controlador, inicializando o mapa de ajudas.
	 */
	public AjudaController() {
		ajudas = new HashMap<Integer, Ajuda>();
	}

	/**
	 * Realiza um pedido de ajuda presencial.
	 * 
	 * @param matrAluno
	 *            a matricula do aluno que solicita a ajuda
	 * @param matrTutor
	 *            a matricula do tutor que ajudara
	 * @param disciplina
	 *            a disciplina que o aluno necessita de ajuda
	 * @param horario
	 *            o horario em que ajuda vai acontecer
	 * @param dia
	 *            o dia em que a ajuda vai acontecer
	 * @param localInteresse
	 *            o local onde a ajuda vai acontecer
	 * 
	 * @return o inteiro que identifica a ajuda
	 */
	public int pedirAjudaPresencial(String matrAluno, String matrTutor, String disciplina, 
			String horario, String dia, String localInteresse) {
<<<<<<< HEAD
		this.validarDadosAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
		Ajuda ajuda = new AjudaPresencial(this.ajudas.keySet().size() + 1, matrAluno, matrTutor, 
				disciplina, localInteresse, dia, horario);
=======
		this.validarDadosAjudaPresencial(matrAluno, matrTutor, disciplina, horario, dia,
				localInteresse);
		Ajuda ajuda = new AjudaPresencial(this.ajudas.keySet().size() + 1, matrAluno,
				matrTutor, disciplina, localInteresse, dia, horario);
>>>>>>> 8dfcaf92708afd342a9f08dd2a08ac88927ae5ef
		this.ajudas.put(this.ajudas.keySet().size() + 1, ajuda);
		return this.ajudas.keySet().size();
	}

	/**
	 * Realiza um pedido de ajuda online.
	 * 
	 * @param matrAluno
	 *            a matricula do aluno que solicita a ajuda
	 * @param matrTutor
	 *            a matricula do tutor que ajudara
	 * @param disciplina
	 *            a disciplina que o aluno necessita de ajuda
	 * 
	 * @return o inteiro que identifica a ajuda
	 */
	public int pedirAjudaOnline(String matrAluno, String matrTutor, String disciplina) {
		this.validarDadosAjudaOnline(matrAluno, disciplina);
		Ajuda ajuda = new Ajuda(this.ajudas.size() + 1, matrAluno, matrTutor, disciplina);
		this.ajudas.put(this.ajudas.size() + 1, ajuda);
		return this.ajudas.keySet().size();
	}

	/**
	 * Retorna a matricula do tutor de uma ajuda.
	 * 
	 * @param idAjuda
	 *            a identificacao da ajuda
	 * 
	 * @return a matricula do tutor
	 */
	public String pegarTutor(int idAjuda) {
		this.validarDadosPegarTutor(idAjuda);
		return this.ajudas.get(idAjuda).toString();
	}

	/**
	 * Retorna a informacao de um atributo de uma ajuda.
	 * 
	 * @param idAjuda
	 *            a identificacao da ajuda.
	 * @param atributo
	 *            um dos atributos de uma ajuda
	 * 
	 * @return a informacao do atributo
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		this.validarDadosGetInfoAjuda(idAjuda, atributo);
		return this.ajudas.get(idAjuda).getInfoAjuda(atributo);

	}

	/**
	 * Verifica se a ajuda ja foi avaliada. Se nao, altera o estado para
	 * avalida e retorna a matricula do tutor da ajuda.
	 * 
	 * @param idAjuda
	 */
	public String avaliar(int idAjuda) {
		this.validarDadosAvaliar(idAjuda);
		this.ajudas.get(idAjuda).avaliar();
		return this.ajudas.get(idAjuda).getMatriculaTutor();
	}

	/**
	 * Valida os dados passados ao metodo pegarTutor.
	 * 
	 * @param idAjuda
	 *            o identificador da ajuda
	 */
	private void validarDadosPegarTutor(int idAjuda) {
		if (idAjuda <= 0) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar tutor : id nao pode menor que zero ");
		}
		if (idAjuda > this.ajudas.keySet().size()) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar tutor : id nao encontrado ");
		}
	}

	/**
	 * Valida os dados passados ao metodo pedirAjudaOnline.
	 * 
	 * @param matrAluno
	 *            a matricula do aluno que solicita a ajuda
	 * @param disciplina
	 *            a disciplina que o aluno necessita de ajuda
	 */
	public void validarDadosAjudaOnline(String matrAluno, String disciplina) {
		if (matrAluno == null || matrAluno.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda online: matricula de aluno nao pode ser vazio ou em branco");
		}
		if (disciplina == null || disciplina.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda online: disciplina nao pode ser vazio ou em branco");
		}
	}

	/**
	 * Valida os dados passados ao metodo pedirAjudaPresencial.
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
<<<<<<< HEAD
	public void validarDadosAjudaPresencial(String matrAluno, String disciplina, 
			String horario, String dia, String localInteresse) {
=======
	public void validarDadosAjudaPresencial(String matrAluno, String matrTutor,
			String disciplina, String horario, String dia, String localInteresse) {
>>>>>>> 8dfcaf92708afd342a9f08dd2a08ac88927ae5ef
		if (matrAluno == null || matrAluno.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		}
		if (matrTutor == null || matrTutor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial:"
					+ " matricula de tutor nao pode ser vazio ou em branco");
		}
		if (disciplina == null || disciplina.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		}
		if (horario == null || horario.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: horario nao pode ser vazio ou em branco");
		}
		if (dia == null || dia.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: dia nao pode ser vazio ou em branco");
		}
		if (localInteresse == null || localInteresse.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
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
					"Erro ao tentar recuperar info da ajuda : id nao pode menor que zero ");
		}
		if (!this.ajudas.containsKey(idAjuda)) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar info da ajuda : id nao encontrado ");
		}
		if (atributo == null || atributo.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar info da ajuda : atributo nao pode ser vazio ou em branco");
		}
		if (this.ajudas.get(idAjuda).getInfoAjuda(atributo).equals("atributo invalido")) {
			throw new IllegalArgumentException(
					"Erro ao tentar recuperar info da ajuda : atributo nao encontrado");
		}
	}

	/**
	 * Valida o dado passado ao metodo avaliar.
	 * 
	 * @param id
	 *            o identificador da ajuda
	 */
	private void validarDadosAvaliar(int id) {
		if (id < 0 || !this.ajudas.containsKey(id)) {
			throw new IllegalArgumentException(
					"Erro na avaliacao de tutor: id nao encontrado");
		}
		if(this.ajudas.get(id).foiAvaliada()){
			throw new IllegalArgumentException(
					"Erro na avaliacao de tutor: Ajuda ja avaliada" );
		}
	}
}
