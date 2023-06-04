/**
 * @author Samuele Valperta
 */

package it.unibs.ing.fp.lab.TamaZoo;
import it.unibs.fp.mylib.EstrazioniCasuali;
import it.unibs.fp.mylib.InputDati;

import java.util.Random;

public class IOUtil {
	private static final String RICHIESTA_NOME = "Dai un nome al %d^ tamagotchi: ";
	public static final int NUMERO_TIPI = 3;
	public static final int TAMABASE = 1;
	public static final int TAMATRISTE = 2;
	public static final int TAMAGORDO = 3;

	/**
	 * Wrapper del metodo costruttore della classe Tamagotchi randomizzando il tipo.
	 * @return un nuovo oggetto della classe Tamagotchi, puo essere anche TamaTriste o TamaGordo
	 */
	public static Tamagotchi creaTamagotchi(int i) {

		String nome = InputDati.leggiStringa(String.format(RICHIESTA_NOME, i + 1));

		int tipoEstratto = EstrazioniCasuali.estraiIntero(1, NUMERO_TIPI);

		int affetto;
		int sazieta;

		switch(tipoEstratto) {
			case TAMABASE:
				affetto = EstrazioniCasuali.estraiIntero(0, Tamagotchi.MAX_AFFETTO);
				sazieta = EstrazioniCasuali.estraiIntero(0, Tamagotchi.MAX_SAZIETA);
				return new Tamagotchi(nome, affetto, sazieta);
			case TAMATRISTE:
				sazieta = EstrazioniCasuali.estraiIntero(0, Tamagotchi.MAX_SAZIETA);
				return new TamaTriste(nome, sazieta);
			case TAMAGORDO:
				sazieta = EstrazioniCasuali.estraiIntero(0, Tamagotchi.MAX_SAZIETA);
				return new TamaGordo(nome, sazieta);
			default:
				return new Tamagotchi();
		}

	}
	
}

