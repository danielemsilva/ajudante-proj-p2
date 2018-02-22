package principal;

public class Aluno {
	
	private String nome;
	private String matricula;
	private String codigoCurso;
	private String telefone;
	private String email;
	
	/**
	 * Cria um aluno, cujo telefone não foi informado,
	 * caso os argumentos informados sejam válidos.
	 * 
	 * @param nome
	 *     String que representa o nome do aluno.
	 * @param matricula
	 *     String que representa a matrícula do aluno.
	 * @param codigoCurso
	 *     int que representa o codigo do curso do aluno.
	 * @param email
	 *     String que representa o email do aluno.
	 */
	public Aluno(String nome, String matricula, String codigoCurso, String email) {
		if (nome.trim().equals("") || nome.equals(null)) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aluno: nome não pode ser nulo ou vazio.");
		}
		if (matricula.trim().equals("") || matricula.equals(null)) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aluno: matricula não pode ser nula ou vazia.");
		}
		if (email.trim().equals("") || email.equals(null)) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aluno: email não pode ser nulo ou vazio.");
		}
		this.validaEmail(email);
		
		this.nome = nome;
		this.matricula = matricula;
		this.codigoCurso = codigoCurso;
		this.email = email;
		
	}
	
	/**
	 * Cria um aluno, cujo telefone foi informado,
	 * caso os argumentos informados sejam válidos.
	 * 
	 * @param nome
	 *     String que representa o nome do aluno.
	 * @param matricula
	 *     String que representa a matrícula do aluno.
	 * @param codigoCurso
	 *     int que representa o codigo do curso do aluno.
	 * @param telefone
	 *     String que representa o telefone do aluno.
	 * @param email
	 *     String que representa o email do aluno.
	 */
	public Aluno(String nome, String matricula, String codigoCurso, String telefone, String email) {
		this(nome, matricula, codigoCurso, email);
		if (telefone.trim().equals("") || telefone.equals(null)) {
			throw new IllegalArgumentException(
					"Erro no cadastro de aluno: email não pode ser nulo ou vazio.");
		}
		this.telefone = telefone;
	}
	
	/**
	 * Valida um email para que este tenha obrigatoriamente um '@'
	 * e algo antes e depois desta.
	 * 
	 * @param email
	 *     String que representa um email.
	 */
	public void validaEmail(String email) {
		if (email.contains("@")) {
			if (email.indexOf("@") == 0 && email.indexOf("@") == email.length() - 1) {
				throw new IllegalArgumentException(
						"Erro no cadastro de aluno: email invalido.");
			}
		}
	}
	
	public String getInfo(String atributo) {
		if (atributo.equals("nome")) {
			return this.getNome();
		} else if (atributo.equals("matricula")) {
			return this.getMatricula();
		} else if (atributo.equals("codigoCurso")) {
			return this.getCodigoCurso();
		} else if (atributo.equals("telefone")) {
			return this.getTelefone();
		} else if (atributo.equals("email")) {
			return this.getEmail();
		}
		return "";
	}
	
	public String getNome() {
		return nome;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getCodigoCurso() {
		return codigoCurso;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	@Override
	public int hashCode() {
		return this.matricula.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	

}
