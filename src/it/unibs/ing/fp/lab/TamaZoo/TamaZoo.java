package it.unibs.ing.fp.lab.TamaZoo;

import java.util.Vector;

public class TamaZoo {

    private Vector<Tamagotchi> vettoreTamagotchi;

    public TamaZoo() {
        this.vettoreTamagotchi = new Vector<Tamagotchi>();
    }

    public void aggiungi(Tamagotchi daInserire) {
        vettoreTamagotchi.add(daInserire);
    }

    public void daiBiscotti(int numeroBiscotti) {
        for (Tamagotchi tama: vettoreTamagotchi){
            if (!tama.sonoMorto()) {
                tama.riceviBiscotti(numeroBiscotti);
                if (!tama.sonoMorto()) {
                    //stampo i dati solo se non e' morto dopo aver mangiato
                    System.out.println(tama.toString());
                    System.out.println();
                }
            }

        }
    }

    public void daiCarezze(int numeroCarezze) {
        for (Tamagotchi tama: vettoreTamagotchi){
            if (!tama.sonoMorto()) {
                tama.riceviCarezze(numeroCarezze);
                if (!tama.sonoMorto()) {
                    //stampo i dati solo se non e' morto dopo aver mangiato
                    System.out.println(tama.toString());
                    System.out.println();
                }
            }

        }
    }
    public boolean sonoTuttiMorti() {
        for (Tamagotchi tama: vettoreTamagotchi){
            if (!tama.sonoMorto())
                return false;
        }
        return true;
    }

}
