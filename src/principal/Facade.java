package principal;

import easyaccept.EasyAccept;

public class Facade {

	private AlunoController alunoController = new AlunoController();

	public void cadastrarAluno(String nome, String matricula, String codigoCurso, String telefone, String email) {
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

	public void tornarTutor(String matricula, String disciplina, int proficiencia) {

	}

	public String recuperaTutor(String matricula) {
		return "";
	}

	public String listarTutores() {
		return "";
	}

	public void cadastrarHorario(String email, String horario, String dia) {

	}

	public void cadastrarLocalDeAtendimento(String email, String local) {

	}

	public boolean consultaHorario(String email, String horario, String dia) {
		return true;
	}

	public boolean consultaLocal(String email, String local) {
		return true;
	}

	public static void main(String[] args) {
		args = new String[] { "principal.Facade", "acceptance_test/us1_test.txt" };
		EasyAccept.main(args);
	}
}
