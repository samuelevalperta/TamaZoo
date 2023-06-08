/**
 * @author Samuele
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
	
	/** The name of the Tamagotchi instance. */
	private String nome;
	/** The sazieta variable represents the satiety level of the Tamagotchi. */
	private double sazieta;
	/** The affection level of the Tamagotchi instance, ranging from 0 (none) to 100 (max). */
	private double affetto;
	/** The type of the Tamagotchi instance. */
	protected String nomeTipo;

	public Tamagotchi() {
	}

	/**
	 * Constructs a new Tamagotchi instance with the given name, affection and satiety levels.
	 *
	 * @param _nome     The name of the Tamagotchi instance.
	 * @param _affetto  The initial affection level of the Tamagotchi, ranging from 0 (none) to 100 (max).
	 * @param _sazieta  The initial satiety level of the Tamagotchi, ranging from 0 (none) to 100 (max).
	 * @throws IllegalArgumentException If any of the levels (_affetto, _sazieta) passed are negative.
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
		 * Adjusts the Tamagotchi instance's level of affection and satiety based on the received number of caresses (carezze).
		 * If the input value is negative, an IllegalArgumentException is thrown. The affection level increases by the number of
		 * caresses, while the satiety level decreases by the amount of caresses divided by the predefined affection factor.
		 * The affection level is capped at the maximum affection value, and the satiety level does not go below the minimum
		 * satiety value.
		 *
		 * @param carezze integer representing the number of caresses given to the Tamagotchi instance.
		 * @throws IllegalArgumentException if the input value is negative.
		 */
	public void riceviCarezze(int carezze) throws IllegalArgumentException {
		
		if (carezze < 0) {
			throw new IllegalArgumentException("Non puoi inserire valori negativi!");
		}
		
		affetto = Math.min(MAX_AFFETTO, affetto + carezze);
		sazieta = Math.max(MIN_SAZIETA, sazieta - carezze / FATTORE_CAREZZE);
	}

	/**
		 * This method allows receiving a number of biscuits for Tamagotchi to increase its satiety level as well
		 * as decrease its affection level. The method throws an IllegalArgumentException if the input value is negative.
		 * The satiety level, sazieta, increases by a factor of FATTORE_BISCOTTI with every biscuit
		 * received, up to the maximum value, MAX_SAZIETA.
		 * The affection level, affetto, decreases based on the number of biscuits received and the
		 * FATTORE_BISCOTTI_AFFETTO, but doesn't go below the minimum value, MIN_AFFETTO.
		 *
		 * @param biscotti The number of biscuits received; a positive integer.
		 * @throws IllegalArgumentException If the number of biscuits received is negative.
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
	 	* Determines if the Tamagotchi instance is dead based on its affection and satiety levels.
	 	* A Tamagotchi is considered dead if its affection reaches the minimum value, MIN_AFFETTO, or
	 	* if its satiety reaches either the minimum value, MIN_SAZIETA, or the maximum value, MAX_SAZIETA.
	 	*
	 	* @return true if the Tamagotchi is dead; false otherwise.
	 	*/
	public boolean sonoMorto() {
		return affetto == MIN_AFFETTO || sazieta == MIN_SAZIETA || sazieta == MAX_SAZIETA;
	}
	
	/**
		 * Checks if the Tamagotchi instance is sad.
		 *
		 * SonoTriste method determines whether the Tamagotchi instance is sad by comparing the values of affection and satiety
		 * with the predefined constants for happiness. The method returns true if any of the conditions are met:
		 * 1. Affection level is less than the minimum affection level for happiness (MIN_AFFETTO_FELICITA).
		 * 2. Satiety level is greater than the maximum satiety level for happiness (MAX_SAZIETA_FELICITA).
		 * 3. Satiety level is less than the minimum satiety level for happiness (MIN_SAZIETA_FELICITA).
		 *
		 * @return true if the Tamagotchi instance is sad, false otherwise.
		 */
	public boolean sonoTriste() {
		return affetto < MIN_AFFETTO_FELICITA ||
				sazieta > MAX_SAZIETA_FELICITA ||
				sazieta < MIN_SAZIETA_FELICITA;
	}
	
	public double getSazieta() {
		return sazieta;
	}

	public void setSazieta(double sazieta) {
		this.sazieta = sazieta;
	}

	public double getAffetto() {
		return affetto;
	}

	public void setAffetto(double affetto) {
		this.affetto = affetto;
	}

	public String getNomeTipo() {
		return nomeTipo;
	}

	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}

	/**
	 * Returns a formatted string representation of the Tamagotchi object, which includes its name, type, affection and satiety levels.
	 *
	 * @return A string representation of the Tamagotchi object, with the format "Nome: {name}\nTipo: {type}\nAffetto: {affection}\nSazieta: {satiety}".
	 */
	public String toString() {
		return String.format(FORMAT_TOSTRING, nome, nomeTipo, affetto, sazieta);
	}
	
	/**
	 * The saluta method is used to display a greeting ("Ciao!") to the user.
	 * If the Tamagotchi instance has a non-empty name, it also displays a message containing the name of the Tamagotchi.
	 */
	public void saluta() {
		System.out.println("Ciao!");
		if(nome != null && !nome.trim().isEmpty()) {
			System.out.println("Mi chiamo " + nome);
		}
	}

}
