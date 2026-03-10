import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {
    //QUESTION A: Le nombre de réparation effectuée par marque et modèle de voiture

    public List<ReparationStat> countNombreReparation() {
        DBConnection dbConnection = new DBConnection();
        List<ReparationStat> nombre_reparation = new ArrayList<>();

        String sql = """
            SELECT mv.marque, mv.modele, COUNT(r.id) AS nombre_reparation
            FROM reparation r
            JOIN modele_voiture mv ON r.id_modele_voiture = mv.id
            GROUP BY mv.marque, mv.modele
        """;

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                MarqueEnum marque = MarqueEnum.valueOf(resultSet.getString("marque"));
                ModeleEnum modele = ModeleEnum.valueOf(resultSet.getString("modele"));
                int nombre = resultSet.getInt("nombre_reparation");

                nombre_reparation.add(new ReparationStat(marque, modele, nombre));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du nombre de reparation", e);
        }
        return nombre_reparation;
    }

    //QUESTION B :  Le pourcentage de réparation par modèle dont le résultat doit
    //être retourné en une seule ligne

    public PourcentageReparation countPourcentageReparation() {
        DBConnection dbConnection = new DBConnection();
        String sql = """
        SELECT
            ROUND(SUM(CASE WHEN mv.modele='RANGER' THEN 1 ELSE 0 END) * 100.0 /
                  (SELECT COUNT(*) FROM Reparation), 2) AS nbre_reparation_ranger,
            ROUND(SUM(CASE WHEN mv.modele='EVEREST' THEN 1 ELSE 0 END) * 100.0 /
                  (SELECT COUNT(*) FROM Reparation), 2) AS nbre_reparation_everest,
            ROUND(SUM(CASE WHEN mv.modele='YUKON' THEN 1 ELSE 0 END) * 100.0 /
                  (SELECT COUNT(*) FROM Reparation), 2) AS nbre_reparation_yukon,
            ROUND(SUM(CASE WHEN mv.modele='RAM' THEN 1 ELSE 0 END) * 100.0 /
                  (SELECT COUNT(*) FROM Reparation), 2) AS nbre_reparation_ram
        FROM reparation r
        JOIN modele_voiture mv ON r.id_modele_voiture = mv.id;
    """;

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                double ranger = rs.getDouble("nbre_reparation_ranger");
                double everest = rs.getDouble("nbre_reparation_everest");
                double yukon = rs.getDouble("nbre_reparation_yukon");
                double ram = rs.getDouble("nbre_reparation_ram");

                return new PourcentageReparation(ranger, everest, yukon, ram);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du pourcentage de reparation", e);
        }

        return new PourcentageReparation(0, 0, 0, 0);
    }

    //QUESTION C : Le cout par réparation
    public List<CoutReparation> findCoutReparation() {
        DBConnection dbConnection = new DBConnection();
        List<CoutReparation> cout_reparation = new ArrayList<>();

        String sql = """
            SELECT mv.marque, m.nom ,
                    SUM(r.cout) AS cout_reparation    
                    FROM reparation r
                    JOIN mecanicien m ON r.id_mecanicien = m.id
                    JOIN modele_voiture mv ON r.id_modele_voiture = mv.id
                    GROUP BY mv.marque,m.nom;
        """;

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement preparedStatement = conn.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                MarqueEnum marque = MarqueEnum.valueOf(resultSet.getString("marque"));
                String nomMecanicien = resultSet.getString("nom");
                double cout = resultSet.getDouble("cout_reparation");

                cout_reparation.add(new CoutReparation(marque, nomMecanicien, cout));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du nombre de reparation", e);
        }
        return cout_reparation;
    }

    //QUESTION D: Le nom du mécanicien qui a le moins rapporté de l’argent au garage

    public MecanicienMin findMecanicienMin() {
        DBConnection dbConnection = new DBConnection();
        String sql = """
               SELECT m.nom AS nom_mecanicien,
                                  SUM(r.cout) AS cout_total
                           FROM reparation r
                           JOIN mecanicien m ON r.id_mecanicien = m.id
                           GROUP BY m.nom
                           ORDER BY SUM(r.cout) ASC
                           LIMIT 1;
    """;

        try (Connection conn = dbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) {
                String nom = rs.getString("nom_mecanicien");
                double coutTotal = rs.getDouble("cout_total");
                return new MecanicienMin(nom, coutTotal);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors du calcul du mecanicien qui a le moins rapporte", e);
        }

        return null;
    }
}
