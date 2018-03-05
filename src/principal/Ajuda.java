package principal;

/**
 * Essa classe representa uma ajuda, contendo id e estado de avaliacao.
 */
public abstract class Ajuda {

	private int id;
	private boolean avaliada;
	protected String matrAluno;
	protected String matrTutor;
	protected String disciplina;

	/**
	 * Constroi uma nova ajuda
	 * 
	 * @param id
	 *            identificacao da ajuda
	 */
	public Ajuda(int id) {
		this.validarId(id);
		this.id = id;
		this.avaliada = false;
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
	 * Metodo abstrato para o retorno de informacoes de ajuda.
	 * 
	 * @param atributo categoria do dado desejado
	 * @return dado especificado.
	 */
	public abstract String getInfoAjuda(String atributo);
	
	/**
	 * Metodo abstrato para o retorno da matricula do tutor que ensina
	 * na ajuda.
	 * 
	 * @return matricula do tutor
	 */
	public abstract String getMatriculaTutor();
	
	/**
	 * Retorna a identificacao da ajuda.
	 * 
	 * @return id
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Valida a identificacao passada ao construtor.
	 * 
	 * @param id
	 *     a identificacao da ajuda
	 */
	private void validarId(int id) {
		if (id < 0) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda: id nao pode ser menor que zero.");
		}
	}
		
}
