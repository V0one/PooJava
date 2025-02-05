import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;

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


    public void supprimerProduit() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Voulez-vous rechercher le produit par : 1) Nom 2) Identifiant ? (Entrez 1 ou 2)");
        int choix = scanner.nextInt();
        scanner.nextLine();

        Optional<Produit> produitTrouve = Optional.empty();

        if (choix == 1) {
            System.out.print("Entrez le nom du produit : ");
            String nom = scanner.nextLine();
            produitTrouve = produits.stream()
                    .filter(produit -> produit.getNom().equalsIgnoreCase(nom))
                    .findFirst();
        } else if (choix == 2) {
            System.out.print("Entrez l'identifiant du produit : ");
            int id = scanner.nextInt();
            produitTrouve = produits.stream()
                    .filter(produit -> produit.getId() == id)
                    .findFirst();
        }

        if (produitTrouve.isPresent()) {
            Produit produit = produitTrouve.get();
            System.out.println("Produit trouvé : " + produit);
            System.out.print("Êtes-vous sûr de vouloir supprimer ce produit ? (oui/non) : ");
            String confirmation = scanner.next();

            if (confirmation.equalsIgnoreCase("oui")) {
                produits.remove(produit);
                System.out.println("Produit supprimé avec succès !");
            } else {
                System.out.println("Suppression annulée.");
            }
        } else {
            System.out.println("Produit non trouvé.");
        }
    }
}
