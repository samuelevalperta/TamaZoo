package it.unibs.ing.fp.lab.TamaZoo;

public class TamaTriste extends Tamagotchi{

    /**
     *
     * @param _nome
     * @param _sazieta
     * @throws IllegalArgumentException
     */
    public TamaTriste(String _nome, double _sazieta) throws IllegalArgumentException {
        super(_nome, 0, _sazieta);
        this.nomeTipo = "triste";
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

        setSazieta(Math.max(MIN_SAZIETA, getSazieta() - carezze / FATTORE_CAREZZE));
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
            setSazieta(Math.min(Tamagotchi.MAX_SAZIETA, getSazieta() + getSazieta() * FATTORE_BISCOTTI));

    }

    /**
     *
     * @return true se e' morto
     */
    @Override
    public boolean sonoMorto() {
        return getSazieta() == 0 || getSazieta() == MAX_SAZIETA;
    }

    /**
     *
     * @return true se e' triste, cioe sempre
     */
    @Override
    public boolean sonoTriste() {
        return true;
    }
}
