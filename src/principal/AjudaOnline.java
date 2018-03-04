package principal;

/**
 * Essa classe representa uma ajuda online, contendo matriculas de
 * tutor e aluno e disciplina.
 */
public class AjudaOnline extends Ajuda {
	
	public AjudaOnline(int id, String matrAluno, String matrTutor,
			String disciplina) {
		super(id);
		this.validarDados(matrAluno, matrTutor, disciplina);
		this.matrAluno = matrAluno;
		this.matrTutor = matrTutor;
		this.disciplina = disciplina;
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
	 * Retorna a matricula do aluno que pediu a ajuda.
	 * 
	 * @return matricula do aluno
	 */
	public String getMatriculaAluno() {
		return this.matrAluno;
	}
	
	/**
	 * Retorna a matricula do tutor.
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
		return "Tutor - " + this.matrTutor + ", disciplina- " + this.disciplina;
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
	 */
	private void validarDados(String matrAluno, String matrTutor, String disciplina) {
		if (matrAluno == null || matrAluno.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: matricula de aluno nao pode ser vazio ou em branco");
		}
		if (disciplina == null || disciplina.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no pedido de ajuda presencial: disciplina nao pode ser vazio ou em branco");
		}
		if (matrTutor == null || matrTutor.trim().equals("")) {
			throw new IllegalArgumentException("Erro no pedido de ajuda presencial:"
					+ " matricula de tutor nao pode ser vazio ou em branco");
		}
	}

}
