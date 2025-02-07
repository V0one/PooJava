import java.util.*;
import java.io.*;

public class ChargementDonne {

    public static Object charger (String fichier) {
        try(FileInputStream fis = new FileInputStream(fichier);
        ObjectInputStream ois = new ObjectInputStream(fis)) {
            return ois.readObject();
        }

        catch(IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }


    }
    public static ArrayList<Produit> chargerProduits(String fichier) {
        return (ArrayList<Produit>) charger(fichier);
    }

    public static ArrayList<Utilisateur> chargerUtilisateurs(String fichier) {
        return (ArrayList<Utilisateur>) charger(fichier);
    }

    public static Map<Produit, Integer> chargerProduitsCommande(String fichier) {
        return (Map<Produit, Integer>) charger(fichier);
    }
}
