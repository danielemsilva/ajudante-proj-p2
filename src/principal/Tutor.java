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
	 * Constroi uma tutoria, inicializando os mapas disciplinas e horarios
	 * e a lista locais.
	 * 
	 */
	public Tutor() {
		this.disciplinas = new HashMap<>();
		this.locais = new ArrayList<>();
		this.horarios = new HashMap<>();
	}

	/**
	 * Adiciona uma nova disciplina.
	 * 
	 * @param disciplina
	 *            nome da disciplina
	 * @param proficiencia
	 *            nivel de proficiencia nessa disciplina.
	 *            Os valores possíveis pertencem ao conjunto [1, 5]
	 */
	public void adicionaDisciplina(String disciplina, int proficiencia) {
		this.validaDados(disciplina, proficiencia);
		this.disciplinas.put(disciplina, proficiencia);
	}

	/**
	 * Adiciona um local de atendimento.
	 * 
	 * @param local
	 *            local de atendimento
	 */
	public void adicionaLocal(String local) {
		if (local == null || local.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		if (locais.contains(local)) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: Local ja cadastrado");
		}
		this.locais.add(local);
	}

	/**
	 * Adiciona um horario de atendimento.
	 * 
	 * @param dia
	 *            dia disponivel
	 * @param horario
	 *            horario no referente dia a ser adicionado
	 */
	public void adicionaHorario(String dia, String horario) {
		this.validaDiaHorario(dia, horario);

		if (!this.horarios.containsKey(dia)) {
			this.horarios.put(dia, new ArrayList<String>());
		}
		this.horarios.get(dia).add(horario);
	}

	/**
	 * Verifica se um determinado local esta entre
	 * os locais onde o tutor atende.
	 * 
	 * @param local
	 *            local a ser pesquisado
	 *            
	 * @return true, se o local for um dos locais de atendimento do tutor,
	 *     e false caso contrario
	 */
	public boolean consultaLocal(String local) {
		return this.locais.contains(local);
	}

	/**
	 * Verifica se um determinado horario esta
	 * entre os horarios de atendimento do tutor.
	 * 
	 * @param dia
	 *            dia a ser pesquisado
	 * @param horario
	 *            horario a ser pesquisado
	 *            
	 * @return true, se o horario for um dos horarios de atendimento do tutor,
	 *     e false caso contrario
	 */
	public boolean consultaHorario(String dia, String horario) {
		if (!this.horarios.containsKey(dia)) {
			return false;
		}
		return this.horarios.get(dia).contains(horario);
	}

	/**
	 * Valida disciplina e proficiencia.
	 * 
	 * @param disciplina
	 *            disciplina da tutoria
	 * @param proficiencia
	 *            nivel de proficiencia para a disciplina
	 */
	private void validaDados(String disciplina, int proficiencia) {
		if (disciplina == null || disciplina.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na definicao de papel: Disciplina nao pode ser nula ou vazia");
		}
		if (disciplinas.containsKey(disciplina)) {
			throw new IllegalArgumentException(
					"Erro na definicao de papel: Ja eh tutor dessa disciplina");
		}
		if (proficiencia <= 0) {
			throw new IllegalArgumentException(
					"Erro na definicao de papel: Proficiencia invalida");
		}
	}

	/**
	 * Valida dia e horario de atendimento.
	 * 
	 * @param dia
	 *            dia disponivel
	 * @param horario
	 *            horario referente ao dia
	 */
	private void validaDiaHorario(String dia, String horario) {
		if (dia == null || dia.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastrar horario: dia nao pode ser vazio ou em branco");
		}
		if (horario == null || horario.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
		result = prime * result + ((horarios == null) ? 0 : horarios.hashCode());
		result = prime * result + ((locais == null) ? 0 : locais.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutor other = (Tutor) obj;
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		if (horarios == null) {
			if (other.horarios != null)
				return false;
		} else if (!horarios.equals(other.horarios))
			return false;
		if (locais == null) {
			if (other.locais != null)
				return false;
		} else if (!locais.equals(other.locais))
			return false;
		return true;
	}
}
