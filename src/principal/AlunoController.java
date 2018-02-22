package principal;

import java.util.HashMap;
import java.util.Map;

public class AlunoController {

	private Map<String, Aluno> alunos;
	
	public AlunoController() {
		alunos = new HashMap<>();
	}
	
	public void cadastrarAluno(String nome, String matricula, String codigoCurso,
			String telefone, String email) {
		if (!alunoExiste(matricula)) {
			Aluno novoAluno = new Aluno(nome, matricula, codigoCurso, telefone, email);
			alunos.put(matricula, novoAluno);
		} else {
			// erro se existir um aluno com essa matricula
		}
	}
	
	public String recuperaAluno(String matricula) {
		if(alunoExiste(matricula)) {
			return alunos.get(matricula).toString();
		} else {
			// erro se não existir um aluno com essa matricula
		}
		return "";
	}
	
	public String listarAlunos() {
		String lista = "";
		for (String matricula : alunos.keySet()) {
			lista += alunos.get(matricula);
		}
		return lista;
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		return alunos.get(matricula).getInfo(atributo);
	}
	
	private boolean alunoExiste(String matricula) {
		return alunos.containsKey(matricula);
	}
}
