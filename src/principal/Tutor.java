package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Essa classe representa um aluno tutor, que possui, alem de suas informacoes
 * como aluno, a disciplina que ele ensina, a proficiencia em relacao a essa
 * disciplina, uma lista de locais que atende e a lista de dias e horarios
 * disponiveis.
 *
 */
public class Tutor {

	private Set<String> disciplinas;
	private List<Integer> proficiencias;
	private List<String> locais;
	private Map<String, List<String>> horarios;

	/**
	 * Constroi uma nova tutoria, inicializando as listas para disciplina,
	 * proficiencia, local e horario.
	 * 
	 */
	public Tutor() {
		this.disciplinas = new HashSet<>();
		this.proficiencias = new ArrayList<>();
		this.locais = new ArrayList<>();
		this.horarios = new HashMap<>();
	}

	public void adicionaTutoria(String disciplina, int proficiencia) {
		validar(disciplina, proficiencia);
		this.disciplinas.add(disciplina);
		this.proficiencias.add(proficiencia);
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
		if (disciplinas.contains(disciplina)) {
			throw new IllegalArgumentException("Erro na definicao de papel: Ja eh tutor dessa disciplina");
		}
		if (proficiencia <= 0) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}
	}
}
