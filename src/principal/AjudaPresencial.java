package principal;
/**
 * Classe que extende Ajuda, contem os atributos e metodos de Ajuda, contem local, dia e horario
 *
 */
public class AjudaPresencial extends Ajuda {
	private String local;
	private String dia;
	private String horario;
	
	/**
	 * Construtor da representacao de AjudaPresencial, utiliza o contrutor de Ajuda. 
	 * @param disciplina representacao de disciplina
	 * @param tutor representacao de Tutor
	 * @param id representacao de id
	 * @param local representacao de local
	 * @param dia representacao de dia
	 * @param horario representacao de horario
	 */
	public AjudaPresencial(String disciplina, String tutor, int id, String local, String dia, String horario) {
		super(disciplina, tutor, id);
		this.local = local;
		this.dia = dia;
		this.horario = horario;
	}
	/**
	 * Metodo que retorna uma informacao por base no atributo
	 * @param atributo representacao de atributo
	 * @return
	 */
	public String  getInfoAjuda(String atributo) {
		if(atributo.equals("dia")) {
			return this.dia;
		}else if(atributo.equals("local")) {
			return this.local;
		}else if(atributo.equals("horario")) {
			return this.horario;
		}else if(atributo.equals("disciplina")) {
			return this.disciplina;
		}
		return "atributo invalido";
	}
}
