import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;

public class Pharmacie {

    ArrayList<Produit> produits = new ArrayList<>();

    public void afficherListeProduits() {
        produits.sort(Comparator.comparing(Produit::getNom));
        Iterator<Produit> iterator = produits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void ajouterProduit(String nom, int quantite, float prix, Categorie categorie) {
        if (quantite <= 0 || prix <= 0) {
            return;
        }
        Produit produit = new Produit(nom, quantite, prix, categorie);
        produits.add(produit);
    }

    public void supprimerProduit(String nom) {
        Optional<Produit> produitTrouve = produits.stream()
                .filter(produit -> produit.getNom().equalsIgnoreCase(nom))
                .findFirst();

        if (produitTrouve.isPresent()) {
            produits.remove(produitTrouve.get());
            System.out.println("Produit supprimé avec succès !");
        } else {
            System.out.println("Produit non trouvé.");
        }
    }
}
