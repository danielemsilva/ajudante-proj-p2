package principal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Map;

public class ManipulaDados {
	
	public boolean gravarAlunos(List<Aluno> alunos) {
		boolean sucesso = false;
		try {
			FileOutputStream arquivo = new FileOutputStream("dados/alunos.dat");
			ObjectOutputStream objGravar = new ObjectOutputStream(arquivo);
			objGravar.writeObject(alunos);
			objGravar.flush();
			objGravar.close();
			arquivo.flush();
			arquivo.close();
			sucesso = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucesso;
	}
	
	public List<Aluno> lerAlunos() {
		try {
			FileInputStream arquivoLeitura = new FileInputStream("dados/alunos.dat");
			ObjectInputStream objLeitura =
					new ObjectInputStream(arquivoLeitura);
			List<Aluno> alunosLidos = (List<Aluno>) objLeitura.readObject();
			objLeitura.close();
			arquivoLeitura.close();
			return alunosLidos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean gravarAjudas(Map<Integer, Ajuda> ajudas) {
		boolean sucesso = false;
		try {
			FileOutputStream arquivo = new FileOutputStream("dados/ajudas.dat");
			ObjectOutputStream objGravar = new ObjectOutputStream(arquivo);
			objGravar.writeObject(ajudas);
			objGravar.flush();
			objGravar.close();
			arquivo.flush();
			arquivo.close();
			sucesso = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sucesso;
	}
	
	public Map<Integer, Ajuda> lerAjudas() {
		try {
			FileInputStream arquivoLeitura = new FileInputStream("dados/ajudas.dat");
			ObjectInputStream objLeitura =
					new ObjectInputStream(arquivoLeitura);
			Map<Integer, Ajuda> ajudasLidas = (Map<Integer, Ajuda>) objLeitura.readObject();
			objLeitura.close();
			arquivoLeitura.close();
			return ajudasLidas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
