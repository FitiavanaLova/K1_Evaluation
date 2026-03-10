public class Mecanicien {
    private int id;
    private String nom;
    private MarqueEnum marque;

    public Mecanicien(int id, String nom, MarqueEnum marque){
        this.id = id;
        this.nom = nom;
        this.marque = marque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public MarqueEnum getMarque() {
        return marque;
    }

    public void setMarque(MarqueEnum marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Mecanicien [id=" + id + ", nom=" + nom + ", marque=" + marque + "]";
    }
}