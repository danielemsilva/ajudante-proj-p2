package principal;

import java.util.HashMap;
import java.util.Map;

public class AjudaController {
	
	private Map<Integer, Ajuda> ajudas;
	
	public AjudaController() {
		ajudas = new HashMap<Integer, Ajuda>();
	}

	public int pedirAjudaPrecencial(String matrAluno, String matrTutor, String disciplina, 
			String horario, String dia, String localInteresse) {
		Ajuda ajuda = new AjudaPresencial(this.ajudas.size() + 1, matrAluno, matrTutor, 
				disciplina, localInteresse, dia, horario);
		this.ajudas.put(ajudas.size(), ajuda);
		return this.ajudas.size();
	}

	public int pedirAjudaOnline(String matrAluno, String matrTutor, String disciplina) {
		Ajuda ajuda = new Ajuda(this.ajudas.size() + 1, matrAluno, matrTutor, disciplina);
		this.ajudas.put(this.ajudas.size() + 1, ajuda);
		return this.ajudas.size() - 1;
	}

	public String pegarTutor(int idAjuda) {
		return this.ajudas.get(idAjuda).pegarTutor();
	}

	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.ajudas.get(idAjuda).getInfoAjuda(atributo);
	}

	public void avaliar(int idAjuda) {
		if (!(this.ajudas.get(idAjuda).foiAvaliada())) {
			this.ajudas.get(idAjuda).avaliar();
		}
	}
}
