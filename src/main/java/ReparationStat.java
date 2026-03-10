public class ReparationStat {
    private MarqueEnum marque;
    private ModeleEnum modele;
    private int nombre;

    public ReparationStat(MarqueEnum marque, ModeleEnum modele, int nombre) {
        this.marque = marque;
        this.modele = modele;
        this.nombre = nombre;
    }


    public MarqueEnum getMarque() { return marque; }
    public ModeleEnum getModele() { return modele; }
    public int getNombre() { return nombre; }

    @Override
    public String toString() {
        return "ReparationStat [marque=" + marque + ", modele=" + modele + ", nombre=" + nombre + "]";
    }
}