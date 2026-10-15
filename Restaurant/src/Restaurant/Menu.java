package Restaurant;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Menu {

    public boolean ajouterPlat(String nomPlat, float prix, String type) {
        boolean ajoutReussi = false;

        Connection conn = Connecter.getConnection();

        if (conn != null) {
            // Requête SQL corrigée
            String sql = "INSERT INTO plat (nomPlat, prixPlat, typePlat) VALUES (?, ?, ?)";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, nomPlat); // Nom du plat
                stmt.setFloat(2, prix);    // Prix du plat
                stmt.setString(3, type);   // Type du plat

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    ajoutReussi = true;
                }

                stmt.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de l'ajout du plat : " + e.getMessage());
            } finally {
                Connecter.closeConnection(conn);
            }
        }

        return ajoutReussi;
    }

    public boolean retirerPlat(int idPlat) {
        boolean suppressionReussie = false;

        Connection conn = Connecter.getConnection();

        if (conn != null) {
            String sql = "DELETE FROM plat WHERE idPlat = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, idPlat); // ID du plat à supprimer

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    suppressionReussie = true;
                }

                stmt.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la suppression du plat : " + e.getMessage());
            } finally {
                Connecter.closeConnection(conn);
            }
        }

        return suppressionReussie;
    }

    public boolean modifierPlat(int idPlat, String nouveauNom, float nouveauPrix, String nouveauType) {
        boolean modificationReussie = false;

        Connection conn = Connecter.getConnection();

        if (conn != null) {
            // Vérifiez que les colonnes et les types de données correspondent
            String sql = "UPDATE plat SET nomPlat = ?, prixPlat = ?, typePlat = ? WHERE idPlat = ?";
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);

                // Assurez-vous que les valeurs correspondent aux attentes de la base
                stmt.setString(1, nouveauNom.trim()); // Évitez les espaces inutiles
                stmt.setFloat(2, nouveauPrix);
                stmt.setString(3, nouveauType.toLowerCase()); // Convertir en minuscules pour respecter un format ENUM
                stmt.setInt(4, idPlat);

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    modificationReussie = true;
                }

                stmt.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la modification du plat : " + e.getMessage());
            } finally {
                Connecter.closeConnection(conn);
            }
        }

        return modificationReussie;
    }
}
