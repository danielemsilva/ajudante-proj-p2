package comparator;

import java.util.Comparator;

import principal.Aluno;

/**
 * Implementacao do comparator para ordenar os alunos pelo email
 * 
 */
public class Email implements Comparator<Aluno> {

	/**
	 * Compara os emails de dois alunos e retorna a diferença entre eles
	 * @param aluno1 um objeto Aluno
	 * @param aluno2 outro objeto Aluno
	 * @return inteiro com a diferenca das strings de email 
	 */
	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		return aluno1.getEmail().compareTo(aluno2.getEmail());
	}
}
