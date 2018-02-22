package base;

import java.util.Comparator;
import principal.Aluno;

/**
 * Implementacao do comparator para ordenar alfabeticamente os alunos
 * 
 */
public class AlunoComparator implements Comparator<Aluno> {

	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		return aluno1.getNome().compareTo(aluno2.getNome());
	}

}
