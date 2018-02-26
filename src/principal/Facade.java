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
		alunoController.tornarTutor(matricula, disciplina, proficiencia);
	}

	public String recuperaTutor(String matricula) {
		return alunoController.recuperaTutor(matricula);
	}

	public String listarTutores() {
		return alunoController.listarTutores();
	}

	public void cadastrarHorario(String email, String horario, String dia) {
		alunoController.cadastrarHorario(email, horario, dia);
	}

	public void cadastrarLocalDeAtendimento(String email, String local) {
		alunoController.cadastrarLocalDeAtendimento(email, local);
	}

	public boolean consultaHorario(String email, String horario, String dia) {
		return alunoController.consultaHorario(email, horario, dia);
	}

	public boolean consultaLocal(String email, String local) {
		return alunoController.consultaLocal(email, local);
	}

	public static void main(String[] args) {
		args = new String[] { "principal.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt" };
		EasyAccept.main(args);
	}
}
