package principal;

/**
 * Essa classe representa uma ajuda, contendo id, tutor, disciplina e estado da
 * avaliacao.
 *
 */
public class Ajuda {

	private int id;
	private String matrAluno;
	protected String matrTutor;
	protected String disciplina;
	private boolean avaliada;

	/**
	 * Constroi uma nova ajuda
	 * 
	 * @param id
	 *            identificacao da ajuda
	 * @param matrAluno
	 *            matricula do aluno que pede ajuda
	 * @param matrTutor
	 *            matricula do aluno que ensina nessa ajuda
	 * @param disciplina
	 *            disciplina debatida
	
	 */
	public Ajuda(int id, String matrAluno, String matrTutor, String disciplina) {
		this.id = id;
		this.disciplina = disciplina;
		this.matrAluno = matrAluno;
		this.matrTutor = matrTutor;
		this.avaliada = false;
	}

	/**
	 * Retorna o dado desejado na descricao
	 * 
	 * @return atributo requerido
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
	 * Retorna o estado de avaliacao da ajuda
	 * 
	 * @return true se a ajuda ja foi avaliada ou false se nao foi avaliada
	 */
	public boolean foiAvaliada() {
		return this.avaliada;
	}
	
	/**
	 * Retorna a matricula do tutor que deu a ajuda
	 * 
	 * @return matricula do tutor
	 */
	public String getMatriculaTutor() {
		return this.matrTutor;
	}

	/**
	 * Representacao textual da ajuda.
	 * 
	 * @return String com a matricula do tutor e a disciplina
	 */
	@Override
	public String toString() {
		return "Tutor - " + this.matrTutor + ", disciplina -" + this.disciplina;
	}
	
}
