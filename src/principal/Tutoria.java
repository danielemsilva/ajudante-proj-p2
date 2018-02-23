package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Essa classe representa um aluno tutor, que possui, alem de suas informacoes
 * como aluno, a disciplina que ele ensina, a proficiencia em relacao a essa
 * disciplina, uma lista de locais que atende e a lista de dias e horarios
 * disponiveis.
 *
 */
public class Tutoria {

	private String disciplina;
	private int proficiencia;
	private int avaliacao;
	private List<String> locais;
	private Map<String, List<String>> horarios;

	/**
	 * Constroi uma nova tutoria com disciplina e proficiencia
	 * 
	 * @param disciplina
	 *            disciplina da tutoria
	 * @param proficiencia
	 *            proficiencia da disciplina
	 */
	public Tutoria(String disciplina, int proficiencia) {
		validar(disciplina, proficiencia);

		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
		this.locais = new ArrayList<>();
		this.horarios = new HashMap<>();
	}

	/**
	 * Retorna a disciplina da tutoria
	 * 
	 * @return disciplina
	 */
	public String getDisciplina() {
		return disciplina;
	}

	/**
	 * Retorna o nivel de proficiencia para a disciplina
	 * 
	 * @return proficiencia
	 */
	public int getProficiencia() {
		return proficiencia;
	}

	/**
	 * Retorna a numeracao da avaliacao sobre o tutor
	 * 
	 * @return avaliacao
	 */
	public int getAvaliacao() {
		return avaliacao;
	}

	/**
	 * Valida os argumentos 'disciplina' e 'proficiencia'
	 * 
	 * @param disciplina
	 *            disciplina da tutoria
	 * @param proficiencia
	 *            nivel de proficiencia para a disciplina
	 */
	private void validar(String disciplina, int proficiencia) {
		if (disciplina == null || disciplina.trim().equals("")) {
			throw new IllegalArgumentException("Erro na definicao de papel: Disciplina nao pode ser nula ou vazia");
		}
		if (proficiencia <= 0) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}
	}
}
