package it.unibs.ing.fp.lab.TamaZoo;

import java.util.Vector;

public class TamaZoo {

    private Vector<Tamagotchi> vettoreTamagotchi;

    /**
     * TamaZoo is a class that represents a collection of Tamagotchis. It has a primary constructor that initializes an empty Vector
     * to store Tamagotchi objects. It also contains methods to add Tamagotchis to the collection, provide biscuits and cuddles, and
     * check if all Tamagotchis in the TamaZoo are dead.
     */
    public TamaZoo() {
        this.vettoreTamagotchi = new Vector<Tamagotchi>();
    }

    
    /**
     * Adds a Tamagotchi instance (daInserire) into the TamaZoo's vettoreTamagotchi Vector.
     *
     * @param daInserire the Tamagotchi instance to be added to the TamaZoo.
     */
    public void aggiungi(Tamagotchi daInserire) {
        vettoreTamagotchi.add(daInserire);
    }
    
    /**
     * The daiBiscotti method provides a specified number of biscuits (numeroBiscotti) to all Tamagotchis in the TamaZoo.
     * It iterates through the vettoreTamagotchi Vector, checks if the Tamagotchi is still alive, and provides the biscuits.
     * If the Tamagotchi remains alive after receiving biscuits, the method prints its current state.
     *
     * @param numeroBiscotti the number of biscuits to be given to each Tamagotchi in the TamaZoo.
     */
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

    /**
     * The daiCarezze method provides a specified number of cuddles (numeroCarezze) to all Tamagotchis in the TamaZoo.
     * It iterates through the vettoreTamagotchi Vector, checks if the Tamagotchi is still alive, and provides the cuddles.
     * If the Tamagotchi remains alive after receiving cuddles, the method prints its current state.
     *
     * @param numeroCarezze the number of cuddles to be given to each Tamagotchi in the TamaZoo.
     */
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
    
    /**
     * Checks if all Tamagotchis in the TamaZoo are dead. Iterates through the vettoreTamagotchi Vector and returns false
     * if at least one Tamagotchi is alive, otherwise returns true when all Tamagotchis are found to be dead.
     *
     * @return a boolean value - true if all Tamagotchis are dead, false if at least one Tamagotchi is alive.
     */
    public boolean sonoTuttiMorti() {
        for (Tamagotchi tama: vettoreTamagotchi){
            if (!tama.sonoMorto())
                return false;
        }
        return true;
    }

}
