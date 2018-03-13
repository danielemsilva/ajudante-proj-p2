package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Classe responsavel por gravar e ler estruturas de dados correspondentes ao tipo
 * desejado.
 *
 */
public class ManipulaDados {
	
	private String pathAlunos = "dados/alunos.dat";
	private String pathAjudas = "dados/ajudas.dat";
	
	/**
	 * Grava uma lista de alunos em um arquivo 'alunos.dat'
	 * @param alunos lista de alunos serializaveis para gravacao
	 * @return estado da gravacao. True se foi realizado com sucesso,
	 * false se ocorreu algum erro durante o processo.
	 */
	public boolean gravarAlunos(List<Aluno> alunos) {
		boolean sucesso = false;
		try {
			File arquivo = new File(this.pathAlunos);
			FileOutputStream arquivoGravar = new FileOutputStream(arquivo);
			ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGravar);
			objGravar.writeObject(alunos);
			objGravar.flush();
			objGravar.close();
			arquivoGravar.flush();
			arquivoGravar.close();
			sucesso = true;
		} catch (Exception e) {
			sucesso = false;
		}
		return sucesso;
	}
	
	/**
	 * Realiza a leitura do arquivo 'alunos.dat' armazenando em uma lista
	 * os alunos lidos e as informacoes de tutores.
	 * @return lista de alunos
	 */
	public List<Aluno> lerAlunos() {
		try {
			File arquivo = new File(this.pathAlunos);
			FileInputStream arquivoLeitura = new FileInputStream(arquivo);
			ObjectInputStream objLeitura =
					new ObjectInputStream(arquivoLeitura);
			List<Aluno> alunosLidos = (List<Aluno>) objLeitura.readObject();
			objLeitura.close();
			arquivoLeitura.close();
			return alunosLidos;
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * Deleta os alunos armazenados no arquivo 'alunos.dat'.
	 * 
	 * @return estado de remocao: true se os alunos foram removidos com sucesso
	 *     e false caso contrario.
	 */
	public boolean deletarAlunos() {
		boolean sucesso = false;
		try {
			File arquivo = new File(this.pathAlunos);
			PrintWriter writer = new PrintWriter(arquivo);
			writer.print("");
			writer.close();
		} catch (Exception e) {
			
		}
		return sucesso;
	}
	
	/**
	 * Grava uma mapa de ajudas em um arquivo 'ajudas.dat'
	 * @param ajudas mapa de ajudas serializaveis para gravacao
	 * @return estado da gravacao. True se foi realizado com sucesso,
	 * false se ocorreu algum erro durante o processo.
	 */
	public boolean gravarAjudas(Map<Integer, Ajuda> ajudas) {
		boolean sucesso = false;
		try {
			File arquivo = new File(this.pathAjudas);
			FileOutputStream arquivoGravar = new FileOutputStream(arquivo);
			ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGravar);
			objGravar.writeObject(ajudas);
			objGravar.flush();
			objGravar.close();
			arquivoGravar.flush();
			arquivoGravar.close();
			sucesso = true;
		} catch (Exception e) {
			sucesso = false;
		}
		return sucesso;
	}
	
	/**
	 * Realiza a leitura do arquivo 'ajudas.dat' armazenando em um mapa
	 * as ajudas lidas.
	 * @return mapa de ajudas
	 */
	public Map<Integer, Ajuda> lerAjudas() {
		try {
			File arquivo = new File(this.pathAjudas);
			FileInputStream arquivoLeitura = new FileInputStream(arquivo);
			ObjectInputStream objLeitura =
					new ObjectInputStream(arquivoLeitura);
			Map<Integer, Ajuda> ajudasLidas = (Map<Integer, Ajuda>) objLeitura.readObject();
			objLeitura.close();
			arquivoLeitura.close();
			return ajudasLidas;
		} catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * Deleta as ajudas armazenadas no arquivo 'ajudas.dat'.
	 * 
	 * @return estado de remocao: true se as ajudas foram removidas com sucesso
	 *     e false caso contrario.
	 */
	public boolean deletarAjudas() {
		boolean sucesso = false;
		try {
			File arquivo = new File(this.pathAjudas);
			PrintWriter writer = new PrintWriter(arquivo);
			writer.print("");
			writer.close();
		} catch (Exception e) {
			
		}
		return sucesso;
	}
}
