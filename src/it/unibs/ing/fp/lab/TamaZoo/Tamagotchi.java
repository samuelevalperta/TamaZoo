/**
 * @author Samuele Valperta
 */

package it.unibs.ing.fp.lab.TamaZoo;

public class Tamagotchi {

	protected static final int MIN_AFFETTO = 0;
	protected static final int MIN_SAZIETA = 0;
	private static final int FATTORE_BISCOTTI_AFFETTO = 4;
	protected static final double FATTORE_BISCOTTI = 0.1;
	protected static final int FATTORE_CAREZZE = 2;
	protected static final int MAX_SAZIETA = 100;
	protected static final int MAX_AFFETTO = 100;
	private static final int MIN_AFFETTO_FELICITA = 30;
	protected static final int MIN_SAZIETA_FELICITA = 30;
	protected static final int MAX_SAZIETA_FELICITA = 90;
	public static final String FORMAT_TOSTRING = "Nome: %s\nTipo: %s\nAffetto: %.2f\nSazieta: %.2f";

	/**
	 * Rappresenta il nome del Tamagotchi
	 */
	private String nome;
	/**
	 * Rappresenta la sazieta' del Tamagotchi
	 */
	private double sazieta;
	/**
	 * Rappresenta lo stato affettivo del Tamagotchi
	 */
	private double affetto;

	/**
	 * Rappresenta la tipologia del Tamagotchi
	 */
	protected String nomeTipo;

	public Tamagotchi() {
	}

	/**
	 * Costruttore che permette l'inizializzazione degli attributi del Tamagotchi a discapito del nomeTipo
	 * @param _nome Nome del Tamagotchi, può essere nullo
	 * @param _affetto Valore iniziale dell'affetto, non può essere negativo
	 * @param _sazieta Valore iniziale di sazieta', non può essere negativo
	 * @throws IllegalArgumentException Se vengono passati dei valori negativi
	 */
	public Tamagotchi(String _nome, double _affetto, double _sazieta) throws IllegalArgumentException {
		
		if (_affetto < 0 || _sazieta < 0) {
			throw new IllegalArgumentException("Non puoi inserire valori negativi!");
		}
		
		this.nome = _nome;
		this.sazieta = _sazieta;
		this.affetto = _affetto;
		this.nomeTipo = "normale";
	}
	
	/**
	 * Metodo per accarezzare, questo comporta l'aumento della quantita' di affetto e la diminuzione di sazieta'.
	 * I nuovi valori vengono impostati rispettando i limiti massimi consentiti
	 * @param carezze numero di carezze da fare al tamagotchi
	 * @throws IllegalArgumentException Se la quantita' di carezze date e' negativa
	 */
	public void riceviCarezze(int carezze) throws IllegalArgumentException {
		
		if (carezze < 0) {
			throw new IllegalArgumentException("Non puoi inserire valori negativi!");
		}
		
		affetto = Math.min(MAX_AFFETTO, affetto + carezze);
		sazieta = Math.max(MIN_SAZIETA, sazieta - carezze / FATTORE_CAREZZE);
	}

	/**
	 * Metodo per sfamare, questo comporta l'aumento di sazieta' e la diminuizione di affetto.
	 * I nuovi valori vengono impostati rispettando i limiti massimi consentiti.
	 * @param biscotti numero di biscotti da dare al tamagotchi
	 * @throws IllegalArgumentException Se la quantita' di biscotti dati e' negativa
	 */
	public void riceviBiscotti(int biscotti) throws IllegalArgumentException {
		
		if (biscotti < 0) {
			throw new IllegalArgumentException("Non puoi inserire valori negativi!");
		}
		
		for (int i = 0; i < biscotti; i++) {
			sazieta = Math.min(MAX_SAZIETA, sazieta + sazieta * FATTORE_BISCOTTI);
		}
		affetto = Math.max(MIN_AFFETTO, affetto - biscotti / FATTORE_BISCOTTI_AFFETTO);
	}
	
	/**
	 * Definisce se il tamagotchi e' morto in base ai valori di sazieta' e affetto, accordando con limiti prestabiliti
	 * @return Ritorna true se il tamgotchi e' morto
	 */
	public boolean sonoMorto() {
		return affetto == MIN_AFFETTO || sazieta == MIN_SAZIETA || sazieta == MAX_SAZIETA;
	}

	/**
	 * Definisce se il tamagotchi e' triste in base ai valori di sazieta' e affetto, accordando con limiti prestabiliti
	 * @return Ritorna true se il tamgotchi e' triste
	 */
	public boolean sonoTriste() {
		return affetto < MIN_AFFETTO_FELICITA ||
				sazieta > MAX_SAZIETA_FELICITA ||
				sazieta < MIN_SAZIETA_FELICITA;
	}

	/**
	 * 
	 * @return Ritorna il valore di sazieta'
	 */
	public double getSazieta() {
		return sazieta;
	}

	/**
	 * 
	 * @param sazieta Riceve il valore di sazieta' e lo imposta
	 */
	public void setSazieta(double sazieta) {
		this.sazieta = sazieta;
	}

	/**
	 * 
	 * @return Ritorna il valore di affetto
	 */
	public double getAffetto() {
		return affetto;
	}

	/**
	 * 
	 * @param affetto Riceve il valore di affetto e lo imposta
	 */
	public void setAffetto(double affetto) {
		this.affetto = affetto;
	}

	/**
	 *
	 * @return Ritorna il tipo di tamagotchi
	 */
	public String getNomeTipo() {
		return nomeTipo;
	}

	/**
	 *
	 * @param nomeTipo Riceve il tipo di tamagotchi e lo imposta
	 */
	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	/**
	 * 
	 * @return Una stringa formattata contente i valori di nome, tipo, affetto e sazieta'
	 */
	public String toString() {
		return String.format(FORMAT_TOSTRING, nome, nomeTipo, affetto, sazieta);
	}
	
	/**
	 * 
	 * Il tamagotchi saluta, se e' battezzato si presenta anche.
	 */
	public void saluta() {
		System.out.println("Ciao!");
		if(nome != null && !nome.trim().isEmpty()) {
			System.out.println("Mi chiamo " + nome);
		}
	}
	

}
