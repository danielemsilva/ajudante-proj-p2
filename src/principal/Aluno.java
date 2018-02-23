package principal;

/**
 * Esta classe representa um aluno, que possui nome, matricula (identificador),
 * codigo do curso, email e telefone (opcional).
 */
public class Aluno {

	private String nome;
	private String matricula;
	private String codigoCurso;
	private String telefone;
	private String email;
	private Tutor tutor;

	/**
	 * Cria um aluno, com nome, matricula, codigo do curso, telefone e email,
	 * verificando se os argumentos informados sao validos.
	 * 
	 * @param nome
	 *            String que representa o nome do aluno.
	 * @param matricula
	 *            String que representa a matrícula do aluno.
	 * @param codigoCurso
	 *            int que representa o codigo do curso do aluno.
	 * @param telefone
	 *            String que representa o telefone do aluno.
	 * @param email
	 *            String que representa o email do aluno.
	 */
	public Aluno(String nome, String matricula, String codigoCurso, String telefone, String email) {
		validaDados(nome, matricula, codigoCurso, email);
		validaEmail(email);

		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.email = email;
		this.telefone = telefone;
		this.tutor = null;
	}

	/**
	 * Retorna algum dado de um aluno requisitado por parametro. Os dados possiveis
	 * sao: nome, matricula, codigoCurso, telefone, email.
	 * 
	 * @param atributo
	 *            categoria do dado requerido
	 * 
	 * @return dado requerido
	 */
	public String getInfo(String atributo) {
		if (atributo.equals("Nome")) {
			return this.nome;
		} else if (atributo.equals("Matricula")) {
			return this.matricula;
		} else if (atributo.equals("CodigoCurso")) {
			return this.codigoCurso;
		} else if (atributo.equals("Telefone")) {
			return this.telefone;
		} else if (atributo.equals("Email")) {
			return this.email;
		} else {
			// lança erro de atributo invalido
		}
		return "";
	}

	/**
	 * Retorna a matricula do aluno
	 * 
	 * @return matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * Retorna o nome do aluno
	 * 
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna o email do aluno
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Cria uma nova instancia para tutor, se este for nulo, e adiciona a nova
	 * disciplina disponibilizada e sua proficiencia
	 * 
	 * @param disciplina
	 *            disciplina a ser acrescentada
	 * @param proficiencia
	 *            proficiencia em relacao a nova disciplina
	 */
	public void tornarTutor(String disciplina, int proficiencia) {
		if (tutor == null) {
			this.tutor = new Tutor();
		}
		tutor.adicionaDisciplina(disciplina, proficiencia);
	}
	/**
	 * Adciona local de tutoria
	 * @param local representacao do local de tutoria
	 */
	public void adicionaLocal(String local) {
		this.tutor.adicionaLocal(local);
	}

	/**
	 * Retorna se o aluno eh tutor de alguma disciplina
	 * 
	 * @return true se houver instancia para tutor
	 */
	public boolean ehTutor() {
		return tutor != null;
	}

	/**
	 * Retorna a representacao textual do aluno, com matricula, nome, codigo do
	 * curso, telefone (se houver) e email separados por hifens.
	 * 
	 * @return String com os dados do aluno
	 */
	@Override
	public String toString() {
		String dados = this.matricula + " - " + this.nome + " - " + this.codigoCurso;
		if (!telefone.equals("")) {
			dados += " - " + this.telefone;
		}
		dados += " - " + this.email;
		return dados;
	}

	/**
	 * Implementacao do hashcode com matricula como identificador.
	 * 
	 * @return hashcode
	 */
	@Override
	public int hashCode() {
		return this.matricula.hashCode();
	}

	/**
	 * Compara dois objetos do tipo Aluno, identificados pela matricula.
	 * 
	 * @param obj
	 *            objeto a ser comparado
	 * 
	 * @return true, se os objetos forem iguais, e false caso contrario
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Aluno outroAluno = (Aluno) obj;
		if (this.matricula == null && outroAluno.matricula != null) {
			return false;
		} else if (!matricula.equals(outroAluno.matricula)) {
			return false;
		}
		return true;
	}

	/**
	 * Valida os dados matricula, nome, codigo e email e gera excecao se algum deles
	 * for nulo ou vazio.
	 * 
	 * @param matricula
	 *            matricula a ser validada
	 * @param nome
	 *            nome a ser validado
	 * @param codigo
	 *            codigo do curso a ser validado
	 * @param email
	 *            email a ser validado
	 */
	private void validaDados(String nome, String matricula, String codigo, String email) {
		if (nome == null || nome.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Nome nao pode ser vazio ou nulo");
		}
		if (matricula == null || matricula.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Matricula nao pode ser vazia ou nula");
		}
		if (codigo == null || codigo.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Codigo do curso nao pode ser vazio ou nulo");
		}
		if (email == null || email.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email nao pode ser vazio ou nulo");
		}
	}

	/**
	 * Valida um email para que este tenha obrigatoriamente um '@' com texto antes e
	 * depois dele.
	 * 
	 * @param email
	 *            String que representa um email.
	 */
	private void validaEmail(String email) {
		if (!email.contains("@") || email.indexOf("@") == 0 || email.indexOf("@") == email.length() - 1) {
			throw new IllegalArgumentException("Erro no cadastro de aluno: Email invalido");
		}
	}

}
