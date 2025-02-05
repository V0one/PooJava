import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Pharmacie {

    ArrayList<Produit> produits ;


    public Pharmacie() {
        this.produits = new ArrayList();
    }

    public void afficherListeProduits(){
        produits.sort(Comparator.comparing(Produit::getNom));
        Iterator<Produit> iterator = produits.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
    }

    public int afficherProduit (String nom) {
        nom = nom.toUpperCase();
        char premierChar = nom.charAt(0);
        int debut  = 0;
        int fin  = produits.size() - 1;
        
        while (debut < fin) {
            int millieu = produits.size() / 2;

            if (premierChar == produits.get(millieu).getNom().toUpperCase().charAt(0)) {
                return produits.get(millieu).getQuantite();
            }
            else if (premierChar < produits.get(millieu).getNom().toUpperCase().charAt(0)) {
                fin = millieu - 1;
            }
            else {
                debut = millieu + 1;
            }
        }
        System.out.println("Erreur de la produit, il n'existe pas");
        return -1;



    }

}
