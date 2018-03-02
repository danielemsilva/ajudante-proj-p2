package comparator;

import java.util.Comparator;
import principal.Aluno;

/**
 * Implementacao do comparator para ordenar tutores pela pontuacao
 * 
 */
public class TutorComparator implements Comparator<Aluno> {

	/**
	 * Compara as pontuacoes dos dois alunos tutores e retorna a diferenca entre eles.
	 * Se os alunos tivem a mesma pontuacao, retorna o que foi cadastrado primeiro
	 * (pela ordem do id).
	 * @param aluno1 um objeto Aluno
	 * @param aluno2 outro objeto Aluno
	 * @return inteiro com a diferenca das pontuacoes.
	 */
	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		int diferenca = aluno1.getTutor().getPontuacao() - aluno2.getTutor().getPontuacao();
		if(diferenca == 0) {
			diferenca = aluno1.getTutor().getId() - aluno2.getTutor().getId();
		}
		return diferenca;
	}

}
