package innerClasses;

public class Auto {

    private String autoFarbe;
    private int anzahlTueren;
    private int geschwindigkeit;
    private int kilometerstand;

    public Auto(String autoFarbe, int anzahlTueren, int geschwindigkeit, int kilometerstand) {
        this.autoFarbe = autoFarbe;
        this.anzahlTueren = anzahlTueren;
        this.geschwindigkeit = geschwindigkeit;
        this.kilometerstand = kilometerstand;
    }

    public void setAutoFarbe(String autoFarbe) {
        this.autoFarbe = autoFarbe;
    }

    public void setAnzahlTueren(int anzahlTueren) {
        this.anzahlTueren = anzahlTueren;
    }

    public void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    public void setKilometerstand(int kilometerstand) {
        this.kilometerstand = kilometerstand;
    }

    public String getAutoFarbe() {
        return autoFarbe;
    }

    public int getAnzahlTueren() {
        return anzahlTueren;
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public int getKilometerstand() {
        return kilometerstand;
    }

    void fahren(int strecke){
        kilometerstand = kilometerstand + strecke;
    }

    public static class Reifen {

        private int anzahl;
        private String typ;
        private String reifenFarbe;

    }


}
