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
public class Tutor {

	private Map<String, Integer> disciplinas;
	private Map<String, List<String>> horarios;
	private List<String> locais;

	/**
	 * Constroi uma nova tutoria, inicializando os mapas de disciplinas com suas
	 * proficiencias, e horarios e a lista de locais.
	 * 
	 */
	public Tutor() {
		this.disciplinas = new HashMap<>();
		this.locais = new ArrayList<>();
		this.horarios = new HashMap<>();
	}

	/**
	 * Adiciona uma nova disciplina de ensino e proficiencia em relacao a essa
	 * disciplina.
	 * 
	 * @param disciplina
	 *            nova disciplina disponibilizada
	 * @param proficiencia
	 *            nivel de proficiencia nessa disciplina
	 */
	public void adicionaTutoria(String disciplina, int proficiencia) {
		validaDados(disciplina, proficiencia);
		this.disciplinas.put(disciplina, proficiencia);
	}

	/**
	 * Adiciona um novo local de atendimento
	 * 
	 * @param local
	 *            local de atendimento a ser adicionado
	 */
	public void adicionaLocal(String local) {
		if (local == null || local.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		if (locais.contains(local)) {
			throw new IllegalArgumentException("Erro no cadastrar local de atendimento: Local ja cadastrado");
		}
		this.locais.add(local);
	}

	/**
	 * Adiciona um novo horario para atendimento
	 * 
	 * @param dia
	 *            dia disponivel
	 * @param horario
	 *            horario no referente dia a ser adicionado
	 */
	public void adicionaHorario(String dia, String horario) {
		validaDiaHorario(dia, horario);

		if (!horarios.containsKey(dia)) {
			horarios.put(dia, new ArrayList<String>());
		}
		horarios.get(dia).add(horario);
	}

	/**
	 * Retorna se o local procurado existe na lista
	 * 
	 * @param local
	 *            local a ser pesquisado
	 * @return true se existir aquele local na lista
	 */
	public boolean consultaLocal(String local) {
		return locais.contains(local);
	}

	/**
	 * Retorna se o horario procurado existe no registro
	 * 
	 * @param dia
	 *            dia a ser pesquisado
	 * @param horario
	 *            horario a ser pesquisado
	 * @return true se o horario existir referente aquele dia
	 */
	public boolean consultaHorario(String dia, String horario) {
		if (!horarios.containsKey(dia)) {
			return false;
		}
		return horarios.get(dia).contains(horario);
	}

	/**
	 * Valida a disciplina e proficiencia.
	 * 
	 * @param disciplina
	 *            disciplina da tutoria
	 * @param proficiencia
	 *            nivel de proficiencia para a disciplina
	 */
	private void validaDados(String disciplina, int proficiencia) {
		if (disciplina == null || disciplina.trim().equals("")) {
			throw new IllegalArgumentException("Erro na definicao de papel: Disciplina nao pode ser nula ou vazia");
		}
		if (disciplinas.containsKey(disciplina)) {
			throw new IllegalArgumentException("Erro na definicao de papel: Ja eh tutor dessa disciplina");
		}
		if (proficiencia <= 0) {
			throw new IllegalArgumentException("Erro na definicao de papel: Proficiencia invalida");
		}
	}

	/**
	 * Valida o dia e horario de atendimento
	 * 
	 * @param dia
	 *            dia disponivel
	 * @param horario
	 *            horario referente ao dia
	 */
	private void validaDiaHorario(String dia, String horario) {
		if (dia == null || dia.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
		if (horario == null || horario.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
	}
}
