import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Pharmacie {

    ArrayList<Produit> produits = new ArrayList<>();

    public void afficherListeProduits(){
        Array.sort(pieces);
        Iterator<Produit> iterator = produits.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }
}
