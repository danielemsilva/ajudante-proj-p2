package comparator;

import java.util.Comparator;

import principal.Aluno;

/**
 * Implementacao do comparator para ordenar os alunos pela matricula
 * 
 */
public class MatriculaAlunoComparator implements Comparator<Aluno> {

	/**
	 * Compara as matriculas de dois alunos e retorna a diferença entre eles
	 * @param aluno1 um objeto Aluno
	 * @param aluno2 outro objeto Aluno
	 * @return inteiro com a diferenca das strings matriculas 
	 */
	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		return aluno1.getMatricula().compareTo(aluno2.getMatricula());
	}
}
