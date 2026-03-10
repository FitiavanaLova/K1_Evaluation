public class MecanicienMin {
    private String nom;
    private double coutTotal;

    public MecanicienMin(String nom, double coutTotal) {
        this.nom = nom;
        this.coutTotal = coutTotal;
    }

    public String getNom() { return nom; }
    public double getCoutTotal() { return coutTotal; }

    @Override
    public String toString() {
        return nom + " | " + coutTotal;
    }
}