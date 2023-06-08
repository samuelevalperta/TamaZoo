package it.unibs.ing.fp.lab.TamaZoo;

public class TamaGordo extends Tamagotchi{

    private final static double MOLTIPLICATORE_CAREZZE = 2;

    /**
     * Represents a TamaGordo tamagotchi, a specific type of Tamagotchi.
     *
     * @param _nome      the name of the TamaGordo
     * @param _sazieta   the initial fullness value of the TamaGordo
     * @throws IllegalArgumentException if the provided _sazieta value is invalid
     */
    public TamaGordo(String _nome, double _sazieta) throws IllegalArgumentException {
        super(_nome, MAX_AFFETTO, _sazieta);
        this.nomeTipo = "gordo";
    }
    
    /**
     * riceviCarezze accepts a number of carezze and adjusts the instance's sazieta level accordingly.
     *
     * @param carezze Number of carezze given to the TamaGordo; must be non-negative.
     * @throws IllegalArgumentException if carezze is negative.
     */
    @Override
    public void riceviCarezze(int carezze) throws IllegalArgumentException {

        if (carezze < 0) {
            throw new IllegalArgumentException("Non puoi inserire valori negativi!");
        }

        setSazieta(Math.max(MIN_SAZIETA, getSazieta() - (MOLTIPLICATORE_CAREZZE * carezze / FATTORE_CAREZZE)));
    }
    
    /**
     * riceviBiscotti accepts a number of biscotti and adjusts the instance's sazieta level accordingly.
     *
     * @param biscotti Number of biscotti given to the TamaGordo; must be non-negative.
     * @throws IllegalArgumentException if biscotti is negative.
     */
    @Override
    public void riceviBiscotti(int biscotti) throws IllegalArgumentException {

        if (biscotti < 0) {
            throw new IllegalArgumentException("Non puoi inserire valori negativi!");
        }

        for (int i = 0; i < biscotti; i++)
            setAffetto(Math.min(MAX_SAZIETA, getSazieta() + getSazieta() * FATTORE_BISCOTTI));
    }
    
    /**
     * Determines if the TamaGordo tamagotchi is dead. A tamagotchi is considered dead when its sazieta level
     * (fullness) reaches the minimum sazieta (MIN_SAZIETA) value.
     *
     * @return true if the TamaGordo tamagotchi's sazieta level is equal to MIN_SAZIETA, false otherwise
     */
    @Override
    public boolean sonoMorto() {
        return getSazieta() == MIN_SAZIETA;
    }
    /**
     * Checks if the TamaGordo is dead. The TamaGordo is considered dead if its sazieta (fullness) value is equal to the minimum sazieta value.
     *
     * @return true if the TamaGordo is dead, false otherwise
     */
    @Override
    public boolean sonoMorto() {
        return getSazieta() == MIN_SAZIETA;
    }

    /**
      * Determines if the TamaGordo tamagotchi is sad by checking its sazieta level.
      *
      * @return true if sazieta is lower than the happiness threshold (MIN_SAZIETA_FELICITA), false otherwise.
      */
    @Override
    public boolean sonoTriste() {
        return getSazieta() < MIN_SAZIETA_FELICITA;
    }
}
