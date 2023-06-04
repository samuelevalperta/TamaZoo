package it.unibs.ing.fp.lab.TamaZoo;

import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
import it.unibs.fp.mylib.NumeriCasuali;

public class GestoreTamaZoo {

    private static final String[] VOCI_MENU = {"Dai carezze", "Dai biscotti"};
    private static final String TITOLO = "Elenco Funzionalita'";
    private static final String ERRORE_FUNZIONE = "La funzione non rientra tra quelle disponibili!";
    private static final String BENVENUTO = "\nProgramma per la gestione dell'Archivio CD\n\n";
    private static final String MESS_FINALE = "Fine programma";
    public static final String MESS_NUMERO_TAMAGOTCHI = "Quanti tamagotchi vuoi creare? ";
    public static final int MIN_TAMAGOTCHI = 1;
    public static final int MAX_TAMAGOTCHI = 100;
    public static final int MAX_CAREZZE = 10;
    public static final int MIN_CAREZZE = 1;
    public static final int MAX_BISCOTTI = 10;
    public static final int MIN_BISCOTTI = 1;
    public static final String MESS_CAREZZE = "Verranno date %d carezze ad ogni tamagotchi.\n\n";
    public static final String MESS_BISCOTTI = "Verranno dati %d biscotti ad ogni tamagotchi.\n\n";
    public static final String MESS_MORTI = "Tutti i tamagotchi sono morto!";

    public static void main(String[] args) {

        MyMenu menu = new MyMenu(TITOLO, VOCI_MENU);
        TamaZoo zoo = new TamaZoo();
        boolean finito = false;

        System.out.println(BENVENUTO);

        int numeroTamagotchi = InputDati.leggiIntero(MESS_NUMERO_TAMAGOTCHI, MIN_TAMAGOTCHI, MAX_TAMAGOTCHI);

        for (int i = 0; i < numeroTamagotchi; i++) {
            zoo.aggiungi(IOUtil.creaTamagotchi(i));

        }

        do {
            int scelta = menu.scegli();

            switch (scelta) {
                case 1:
                    int numCarezze = NumeriCasuali.estraiIntero(MIN_CAREZZE, MAX_CAREZZE);
                    System.out.printf(MESS_CAREZZE, numCarezze);
                    zoo.daiCarezze(numCarezze);
                    break;
                case 2:
                    int numBiscotti = NumeriCasuali.estraiIntero(MIN_BISCOTTI, MAX_BISCOTTI);
                    System.out.printf(MESS_BISCOTTI, numBiscotti);
                    zoo.daiBiscotti(numBiscotti);
                    break;
                case 0:
                    finito = true;
                    break;
                default:
                    System.out.println(ERRORE_FUNZIONE);
                    break;
            }

            if (zoo.sonoTuttiMorti()) {
                System.out.println(MESS_MORTI);
                finito = true;
            }

        } while (!finito);

        System.out.println(MESS_FINALE);

    }
}