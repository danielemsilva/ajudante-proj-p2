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

	private int id;
	private int dinheiro;
	private double pontuacao;
	private String nivel;
	private List<String> locais;
	private Map<String, Integer> disciplinas;
	private Map<String, List<String>> horarios;

	/**
	 * Constroi um tutor, inicializando os mapas disciplinas e horarios e a lista
	 * locais.
	 * 
	 */
	public Tutor() {
		this.locais = new ArrayList<>();
		this.disciplinas = new HashMap<>();
		this.horarios = new HashMap<>();
		this.pontuacao = 4.0;
		this.setNivel();
	}

	/**
	 * Adiciona uma nova disciplina.
	 * 
	 * @param disciplina
	 *            nome da disciplina
	 * @param proficiencia
	 *            nivel de proficiencia nessa disciplina. Os valores possiveis
	 *            pertencem ao conjunto [1, 5]
	 */
	public void adicionaDisciplina(String disciplina, int proficiencia, int id) {
		this.validaDisciplinaProficiencia(disciplina, proficiencia);
		this.disciplinas.put(disciplina, proficiencia);
		this.id = id;
	}

	/**
	 * Adiciona um local de atendimento.
	 * 
	 * @param local
	 *            local de atendimento
	 */
	public void adicionaLocal(String local) {
		this.validaLocal(local);
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
	 * Verifica se um determinado local esta entre os locais onde o tutor atende.
	 * 
	 * @param local
	 *            local a ser pesquisado
	 * 
	 * @return true, se o local for um dos locais de atendimento do tutor, e false
	 *         caso contrario
	 */
	public boolean consultaLocal(String local) {
		return this.locais.contains(local);
	}

	/**
	 * Verifica se um determinado horario esta entre os horarios de atendimento do
	 * tutor.
	 * 
	 * @param dia
	 *            dia a ser pesquisado
	 * @param horario
	 *            horario a ser pesquisado
	 * 
	 * @return true, se o horario for um dos horarios de atendimento do tutor, e
	 *         false caso contrario
	 */
	public boolean consultaHorario(String dia, String horario) {
		if (!this.horarios.containsKey(dia)) {
			return false;
		}
		return this.horarios.get(dia).contains(horario);
	}

	/**
	 * Verifica se uma determinada disciplina esta entre as disciplinas da lista.
	 * 
	 * @param disciplina
	 *            nome da disciplina a ser consultado
	 * 
	 * @return true, se a disciplina for uma das que o tutor ensina, e false caso
	 *         contrario
	 */
	public boolean consultaDisciplina(String disciplina) {
		return this.disciplinas.containsKey(disciplina);
	}

	/**
	 * Verifica se uma determinada disciplina tem proficiencia alta (maior ou igual
	 * a 3)
	 * 
	 * @param disciplina
	 *            nome da disciplina a ser consultado
	 * 
	 * @return true, se a proficiencia for alta, e false caso contrario
	 */
	public boolean consultaProficiencia(String disciplina) {
		return this.disciplinas.get(disciplina) >= 3;
	}

	/**
	 * Atualiza a pontuacao do tutor.
	 * 
	 * @param nota
	 *            nota da avaliacao utilizada no calculo da pontuacao
	 */
	public void setPontuacao(double nota) {
		if (nota < 0) {
			throw new IllegalArgumentException(
					"Erro na avaliacao de tutor: nota nao pode ser menor que 0");
		}
		if (nota > 5) {
			throw new IllegalArgumentException(
					"Erro na avaliacao de tutor: nota nao pode ser maior que 5");
		}
		this.pontuacao = ((this.pontuacao * 5) + nota) / 6.0;
		this.setNivel();
	}

	/**
	 * Atualiza o nivel do tutor de acordo com a pontuacao
	 */
	private void setNivel() {
		if (this.pontuacao > 4.5) {
			this.nivel = "TOP";
		} else if (this.pontuacao > 3.0 || this.pontuacao <= 4.5) {
			this.nivel = "Tutor";
		} else if (this.pontuacao > 0 || this.pontuacao <= 3.0) {
			this.nivel = "Aprendiz";
		}
	}

	/**
	 * Atualiza a valor do dinheiro do Tutor
	 * 
	 * @param dinheiro
	 *            dinheiro dado ao tutor
	 */
	public void setDinheiro(int dinheiro) {
		if (dinheiro < 0) {
			throw new IllegalArgumentException(
					"Erro na doacao para tutor: totalCentavos nao pode ser menor que zero");
		}
		this.dinheiro += dinheiro;
	}

	/**
	 * Retorna a pontuacao do tutor.
	 * 
	 * @return pontuacao
	 */
	public double getPontuacao() {
		return this.pontuacao;
	}

	/**
	 * Retorna o nivel do tutor.
	 * 
	 * @return nivel do tutor de acordo com a sua pontuacao.
	 */
	public String getNivel() {
		return this.nivel;
	}

	/**
	 * Retorna o dinheiro ja dado ao tutor.
	 * 
	 * @return dinheiro total do tutor
	 */
	public int getDinheiro() {
		return this.dinheiro;
	}

	/**
	 * Retorna o id de cadastro do tutor.
	 * 
	 * @return identificacao de cadastro
	 */
	public int getId() {
		return this.id;
	}
	
	/**
	 * Valida disciplina e proficiencia.
	 * 
	 * @param disciplina
	 *            disciplina da tutoria
	 * @param proficiencia
	 *            nivel de proficiencia para a disciplina
	 */
	private void validaDisciplinaProficiencia(String disciplina, int proficiencia) {
		if (disciplina == null || disciplina.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro na definicao de papel: Disciplina nao pode ser nula ou vazia");
		}
		if (this.disciplinas.containsKey(disciplina)) {
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

	/**
	 * Valida local de atendimento.
	 * 
	 * @param local
	 *            local do atendimento.
	 */
	private void validaLocal(String local) {
		if (local == null || local.trim().equals("")) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: local nao pode ser vazio ou em branco");
		}
		if (this.locais.contains(local)) {
			throw new IllegalArgumentException(
					"Erro no cadastrar local de atendimento: Local ja cadastrado");
		}
	}

	/**
	 * Implementacao do hashcode de identificacao de tutor, baseado em disciplinas,
	 * horarios e locais de atendimento.
	 * 
	 * @return hashcode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.disciplinas == null) ? 0 : this.disciplinas.hashCode());
		result = prime * result + ((this.horarios == null) ? 0 : this.horarios.hashCode());
		result = prime * result + ((this.locais == null) ? 0 : this.locais.hashCode());
		return result;
	}

	/**
	 * Compara dois objetos do tipo Tutor, caracterizados pelas disciplinas que
	 * ensinam, horarios e locais de atendimento.
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
		Tutor outroTutor = (Tutor) obj;
		if (this.disciplinas == null && outroTutor.disciplinas != null) {
			return false;
		} else if (!this.disciplinas.equals(outroTutor.disciplinas)) {
			return false;
		}
		if (this.horarios == null && outroTutor.horarios != null) {
			return false;
		} else if (!this.horarios.equals(outroTutor.horarios)) {
			return false;
		}
		if (this.locais == null && outroTutor.locais != null) {
			return false;
		} else if (!this.locais.equals(outroTutor.locais)) {
			return false;
		}
		return true;
	}
}
