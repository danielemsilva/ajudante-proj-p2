package principal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Essa classe representa um aluno tutor, que possui, alem de suas informacoes como aluno, 
 * a disciplina que ele ensina, a proficiencia em relacao a essa disciplina, uma lista de 
 * locais que atende e a lista de dias e horarios disponiveis.
 *
 */
public class Tutoria {

	private String disciplina;
	private int proficiencia, avaliacao;
	private List<String> locais;
	private Map<String, List<String>> horarios;
	
	public Tutoria(String disciplina, int proficiencia) {
		validar(disciplina, proficiencia);
		
		this.disciplina = disciplina;
		this.proficiencia = proficiencia;
		this.locais = new ArrayList<>();
		this.horarios = new HashMap<>();
	}
	
	public String getDisciplina() {
		return disciplina;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	public int getAvaliacao() {
		return avaliacao;
	}

	private void validar(String disciplina, int proficiencia) {
		
	}
}
