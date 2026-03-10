public class Reparation {
    private int id;
    private Mecanicien mecanicien;
    private ModeleVoiture modeleVoiture;
    private double cout;


    public Reparation(int id, Mecanicien mecanicien, ModeleVoiture modeleVoiture, double cout) {
        this.id = id;
        this.mecanicien = mecanicien;
        this.modeleVoiture = modeleVoiture;
        this.cout = cout;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Mecanicien getMecanicien() {
        return mecanicien;
    }

    public void setMecanicien(Mecanicien mecanicien) {
        this.mecanicien = mecanicien;
    }

    public ModeleVoiture getModeleVoiture() {
        return modeleVoiture;
    }

    public void setModeleVoiture(ModeleVoiture modeleVoiture) {
        this.modeleVoiture = modeleVoiture;
    }

    public double getCout() {
        return cout;
    }

    public void setCout(double cout) {
        this.cout = cout;
    }


    @Override
    public String toString() {
        return "Reparation [id=" + id + ", mecanicien=" + mecanicien.getNom()
                + ", modeleVoiture=" + modeleVoiture.getModele()
                + ", cout=" + cout + "]";
    }
}