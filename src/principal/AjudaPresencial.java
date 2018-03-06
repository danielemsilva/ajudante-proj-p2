package principal;

/**
 * Classe que extende Ajuda e contem matriculas do aluno e de tutor, 
 * disciplina, local, dia e horario.
 */
public class AjudaPresencial extends Ajuda {

	private String local;
	private String dia;
	private String horario;

	/**
	 * Construtor da representacao de AjudaPresencial, utiliza o contrutor de Ajuda.
	 * 
	 * @param id
	 *            representacao de ajuda
	 * @param matrAluno
	 *            matricula do aluno que pediu a ajuda
	 * @param matrTutor
	 *            matricula do tutor que ensinou nessa ajuda
	 * @param disciplina
	 *            disciplina estudada
	 * @param local
	 *            local do ocorrido
	 * @param dia
	 *            dia em que ocorreu a ajuda
	 * @param horario
	 *            horario da ajuda
	 */
	public AjudaPresencial(int id, String matrAluno, String matrTutor, 
			String disciplina, String local, String dia, String horario) {
		super(id);
		this.validarDados(matrAluno, matrTutor, disciplina, horario, dia, local);
		this.matrAluno = matrAluno;
		this.matrTutor = matrTutor;
		this.disciplina = disciplina;
		this.local = local;
		this.dia = dia;
		this.horario = horario;
	}

	/**
	 * Retorna uma informacao com base no atributo
	 * 
	 * @param atributo
	 *            categoria do dado desejado
	 * @return informacado requerida
	 */
	public String getInfoAjuda(String atributo) {
		if (atributo.equals("dia")) {
			return this.dia;
		} else if (atributo.equals("localInteresse")) {
			return this.local;
		} else if (atributo.equals("horario")) {
			return this.horario;
		} else if (atributo.equals("disciplina")) {
			return this.disciplina;
		}
		return "atributo invalido";
	}	

	/**
	 * Representacao textual de uma ajuda presencial.
	 * 
	 * @return String com a matricula do tutor, horario, dia, local e disciplina da
	 *         ajuda.
	 */
	@Override
	public String toString() {
		return "Tutor - " + this.matrTutor + ", horario - " + this.horario + ", dia - " +  
				this.dia + ", local - " + this.local + ", disciplina - " + this.disciplina;
	}
	
	/**
	 * Valida os dados passados no construtor.
	 * 
	 * @param matrAluno
	 *            a matricula do aluno que solicita a ajuda
	 * @param matrTutor
	 *            a matricula do tutor que vai ajudar
	 * @param disciplina
	 *            a disciplina que o aluno necessita de ajuda
	 * @param horario
	 *            o horario em que ajuda vai acontecer
	 * @param dia
	 *            o dia em que a ajuda vai acontecer
	 * @param local
	 *            o local onde a ajuda vai acontecer
	 */
	private void validarDados(String matrAluno, String matrTutor,
			String disciplina, String horario, String dia, String local) {
		if (matrAluno == null || matrAluno.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
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
		if (local == null || local.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: local de interesse nao pode ser vazio ou em branco");
		}
		if (matrTutor == null || matrTutor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial:"
					+ " matricula de tutor nao pode ser vazio ou em branco");
		}
	}
	
}
