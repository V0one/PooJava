import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Map;

public class Pharmacie {

    ArrayList<Produit> produits;
    ArrayList<commande> commandes;

    public Pharmacie() {
        this.produits = new ArrayList<>();
        this.commandes = new ArrayList<>();
    }

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

    public int afficherProduit(String nom) {
        nom = nom.toUpperCase();
        char premierChar = nom.charAt(0);
        int debut = 0;
        int fin = produits.size() - 1;

        while (debut <= fin) {
            int millieu = (debut + fin) / 2;

            if (premierChar == produits.get(millieu).getNom().toUpperCase().charAt(0)) {
                return produits.get(millieu).getQuantite();
            } else if (premierChar < produits.get(millieu).getNom().toUpperCase().charAt(0)) {
                fin = millieu - 1;
            } else {
                debut = millieu + 1;
            }
        }
        System.out.println("Erreur de la produit, il n'existe pas");
        return -1;
    }

    public void enregistrerCommande(commande commande) {
        if (commande.validerCommande()) {
            commandes.add(commande);

            // Décrémentation des stocks après validation de la commande
            for (Map.Entry<Produit, Integer> entry : commande.produitsCommande.entrySet()) {
                Produit produit = entry.getKey();
                int quantiteCommandee = entry.getValue();

                produit.setQuantite(produit.getQuantite() - quantiteCommandee);

                if (produit.getQuantite() < 5) {
                    System.out.println("⚠️ Attention : Stock critique pour " + produit.getNom() + " (" + produit.getQuantite() + " restant)");
                }
            }
            System.out.println("Commande enregistrée avec succès.");
        } else {
            System.out.println("Commande échouée en raison de stocks insuffisants.");
        }
    }

    public void afficherStocks() {
        System.out.println("=== Stocks Actuels ===");
        for (Produit produit : produits) {
            System.out.println(produit.getNom() + ": " + produit.getQuantite() + " unités");
        }
    }

    public Produit trouverProduit(String nom) {
        for (Produit produit : produits) {
            if (produit.getNom().equalsIgnoreCase(nom)) {
                return produit;
            }
        }
        System.out.println("Produit non trouvé : " + nom);
        return null;
    }
}
