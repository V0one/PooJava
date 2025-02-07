import java.util.*;
import java.io.*;

public class SauvegardeDonnee {

    public static void sauvergarderDonne (Object data, String fichier ) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichier))) {
            oos.writeObject(data);
            System.out.println("Données sauvegardées dans " + fichier);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sauvergarderUtilisateurs (ArrayList<Utilisateur> utilisateurs, String fichier) {
        sauvergarderDonne(utilisateurs, fichier);
    }

    public static void sauvegarderCommande (HashMap<Produit, Integer> produitsCommande, String fichier) {
        sauvergarderDonne(produitsCommande, fichier);
    }

    public static void sauvegarderProduits (ArrayList<Produit> produits, String fichier) {
        sauvergarderDonne(produits, fichier);
    }


}
