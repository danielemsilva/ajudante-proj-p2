package principal;

import easyaccept.EasyAccept;

public class Facade {
	
	private AlunoController alunoController = new AlunoController();
	
	public void cadastrarAluno(String nome, String matricula, String codigoCurso,
			String telefone, String email) {
		alunoController.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}
	
	public String recuperaAluno(String matricula) {
		return alunoController.recuperaAluno(matricula);
	}
	
	public String listarAlunos() {
		return alunoController.listarAlunos();
	}
	
	public String getInfoAluno(String matricula, String atributo) {
		return alunoController.getInfoAluno(matricula, atributo);
	}
	
	public static void main(String[] args) {
		args = new String[] {"principal.Facade",
				"acceptance_test/us1_test.txt"};
		EasyAccept.main(args);
	}
}
