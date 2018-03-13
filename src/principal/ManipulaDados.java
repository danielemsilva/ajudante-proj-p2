package principal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

public class ManipulaDados {
	
	private String pathAlunos = "dados/alunos.dat";
	private String pathAjudas = "dados/ajudas.dat";
	
	public boolean gravarAlunos(List<Aluno> alunos) {
		boolean sucesso = false;
		try {
			File arquivo = new File(this.pathAlunos);
			if(arquivo.exists()) {
				arquivo.delete();
			}
			arquivo.createNewFile();
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
	
	
	public boolean gravarAjudas(Map<Integer, Ajuda> ajudas) {
		boolean sucesso = false;
		try {
			File arquivo = new File(this.pathAlunos);
			if(arquivo.exists()) {
				arquivo.delete();
			}
			arquivo.createNewFile();
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
}
