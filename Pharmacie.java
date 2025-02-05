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
}
