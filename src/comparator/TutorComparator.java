package comparator;

import java.util.Comparator;
import principal.Aluno;

/**
 * Implementacao do comparator para ordenar tutores pelo cadastro
 * 
 */
public class TutorComparator implements Comparator<Aluno> {

	/**
	 * Compara os ids dos dois alunos tutores e retorna a diferenca entre eles
	 * @param aluno1 um objeto Aluno
	 * @param aluno2 outro objeto Aluno
	 * @return inteiro com a diferenca dos ids 
	 */
	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		int diferenca = aluno1.getTutor().getId() - aluno2.getTutor().getId();
		if(diferenca == 0) {
			diferenca = aluno1.getTutor().getPontuacao() - aluno2.getTutor().getPontuacao();
		}
		return diferenca;
	}

}
