package it.unibs.ing.fp.lab.TamaZoo;

public class TamaGordo extends Tamagotchi{

    private final static double MOLTIPLICATORE_CAREZZE = 2;

    public TamaGordo(String _nome, double _sazieta) throws IllegalArgumentException {
        super(_nome, MAX_AFFETTO, _sazieta);
        this.nomeTipo = "gordo";
    }

    /**
     *
     * @param carezze numero di carezze da fare al tamagotchi
     * @throws IllegalArgumentException
     */
    @Override
    public void riceviCarezze(int carezze) throws IllegalArgumentException {

        if (carezze < 0) {
            throw new IllegalArgumentException("Non puoi inserire valori negativi!");
        }

        setSazieta(Math.max(MIN_SAZIETA, getSazieta() - (MOLTIPLICATORE_CAREZZE * carezze / FATTORE_CAREZZE)));
    }

    /**
     *
     * @param biscotti numero di biscotti da dare al tamagotchi
     * @throws IllegalArgumentException
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
     *
     * @return true se e' morto
     */
    @Override
    public boolean sonoMorto() {
        return getSazieta() == MIN_SAZIETA;
    }

    /**
     *
     * @return true se e' triste
     */
    @Override
    public boolean sonoTriste() {
        return getSazieta() < MIN_SAZIETA_FELICITA;
    }
}
