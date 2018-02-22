package base;

import java.util.Comparator;
import principal.Aluno;

/**
 * Implementacao do comparator para ordenar alfabeticamente os alunos
 * 
 */
public class AlunoComparator implements Comparator<Aluno> {

	/**
	 * Compara os nomes de dois alunos e retorna a diferença entre eles
	 * @param aluno1 um objeto Aluno
	 * @param aluno2 outro objeto Aluno
	 * @return inteiro com a diferença das strings de nome 
	 */
	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		return aluno1.getNome().compareTo(aluno2.getNome());
	}

}
