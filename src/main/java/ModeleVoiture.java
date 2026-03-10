public class ModeleVoiture {
    private int id;
    private MarqueEnum marque;
    private ModeleEnum modele;

    public ModeleVoiture(int id, MarqueEnum marque, ModeleEnum modele){
        this.id = id;
        this.marque = marque;
        this.modele = modele;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MarqueEnum getMarque() {
        return marque;
    }

    public void setMarque(MarqueEnum marque) {
        this.marque = marque;
    }

    public ModeleEnum getModele() {
        return modele;
    }

    public void setModele(ModeleEnum modele) {
        this.modele = modele;
    }

    @Override
    public String toString() {
        return "ModeleVoiture [id=" + id + ", marque=" + marque + ", modele=" + modele + "]";
    }
}