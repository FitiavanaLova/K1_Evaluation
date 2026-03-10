public class CoutReparation {
    private MarqueEnum marque;
    private String nomMecanicien;
    private double cout;

    public CoutReparation(MarqueEnum marque, String nomMecanicien, double cout) {
        this.marque = marque;
        this.nomMecanicien = nomMecanicien;
        this.cout = cout;
    }

    public MarqueEnum getMarque() { return marque; }
    public String getNomMecanicien() { return nomMecanicien; }
    public double getCout() { return cout; }

    @Override
    public String toString() {
        return marque + " | " + nomMecanicien + " | " + cout;
    }
}