import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Pharmacie p = new Pharmacie();
        ArrayList<Produit> produit = ChargementDonne.chargerProduits("produit.ser");
        p.setProduits(produit);
        p.afficherListeProduits();
    }
}
