import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataRetriever dataRetriever = new DataRetriever();

        // QUESTION A : Nombre de réparations par marque et modèle
             System.out.println("\n=== QUESTION A: Nombre de réparations par marque et modèle ===");
             List<ReparationStat> stats = dataRetriever.countNombreReparation();

            System.out.println("Nombre de réparations par marque et modèle :");
            for (ReparationStat stat : stats) {
                System.out.println(stat.getMarque() + " | " + stat.getModele() + " | " + stat.getNombre());

        //QUESTION B :  Le pourcentage de réparation par modèle
            System.out.println("\n=== QUESTION B:  Le pourcentage de réparation par modèle  ===");
            PourcentageReparation pourcentages = dataRetriever.countPourcentageReparation();

            System.out.println("nbre_reparation_ranger | nbre_reparation_everest | nbre_reparation_yukon | nbre_reparation_ram");
            System.out.println(pourcentages);

        //QUESTION C:  Le cout de réparation de modèle de voiture par marque et par mécanicien
            System.out.println("\n=== QUESTION B:  Le cout de réparation  ===");
            List<CoutReparation> couts = dataRetriever.findCoutReparation();

            for (CoutReparation cout : couts) {
                System.out.println(cout.getMarque() + " | " + cout.getNomMecanicien() + " | " + cout.getCout());

        //QUESTION D:  Le nom du mécanicien qui a le moins rapporté de l’argent au garage
           System.out.println("\n=== QUESTION D:  Mécanicien qui a le moins rapporté d'argent  ===");
           MecanicienMin mecaniciens = dataRetriever.findMecanicienMin();
           System.out.println("mecanicien | cout_reparation_rapporte");
           System.out.println(mecaniciens);

            }
        }
    }
}