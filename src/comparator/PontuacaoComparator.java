package comparator;

import java.util.Comparator;
import principal.Aluno;

/**
 * Implementacao do comparator para ordenar tutores pelas pontuacoes
 * 
 */
public class PontuacaoComparator implements Comparator<Aluno> {

	/**
	 * Compara as pontuacoes de dois tutores e retorna a diferenca entre eles
	 * @param aluno1 um objeto Aluno
	 * @param aluno2 outro objeto Aluno
	 * @return inteiro com a diferenca das pontuacoes 
	 */
	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		return aluno1.getTutor().getPontuacao() - aluno2.getTutor().getPontuacao();
	}

}
