package principal;

/**
 * Classe que extende Ajuda, contem os atributos e metodos de Ajuda, contem
 * local, dia e horario
 *
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
		super(id, matrAluno, matrTutor, disciplina);
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
		} else if (atributo.equals("local")) {
			return this.local;
		} else if (atributo.equals("horario")) {
			return this.horario;
		} else if (atributo.equals("disciplina")) {
			return this.disciplina;
		}
		return "atributo invalido";
	}
}
