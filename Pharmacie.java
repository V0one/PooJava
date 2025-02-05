import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Pharmacie {

    ArrayList<Produit> produits = new ArrayList<>();

    public void afficherListeProduits(){
        produits.sort(Comparator.comparing(Produit::getNom));
        Iterator<Produit> iterator = produits.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    public void ajouterProduit(String nom, int quantite, float prix, Categorie categorie){
        if (quantite <= 0) {
            return;}
        if (prix <= 0) {
            return;
        }
        Produit produit = new Produit(nom, quantite, prix, categorie);
        produits.add(produit);
    }
}
