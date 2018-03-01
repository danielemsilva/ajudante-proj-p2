package principal;
/**
 * Clase representa uma ajuda, contendo id, tutor, disciplina e estado da avaliacao.
 *
 */
public class Ajuda {
	private int id;
	private String tutor;
	protected String disciplina;
	private boolean avaliada = false;
	/**
	 * Construtor da representacao de Ajuda
	 * @param disciplina representacao de disciplina
	 * @param tutor representacao de tutor
	 * @param id representacao do id
	 */
	public Ajuda(String disciplina, String tutor, int id ) {
		this.disciplina = disciplina;
		this.tutor = tutor;
		this.id = id;
	}
	/**
	 * retorna a matricula do tutor
	 * @return
	 */
	public String pegarTutor() {
		return this.tutor;
	}
	/**
	 * retorna o nome da disciplina
	 * @return 
	 */
	public String getInfoAjuda(String atributo) {
		if (atributo.equals("disciplina")) {
			return this.disciplina;
		}
		return "atributo invalido";
	}
	/**
	 * Altera o estado de avaliada de false para true
	 */
	public void avaliar() {
		this.avaliada = true;
	}
	/**
	 * retorna o estado de avaliada
	 * @return true se avaliada ou false se nao avaliada
	 */
	public boolean foiAvaliada() {
		return this.avaliada;
	}
}
