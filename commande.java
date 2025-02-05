import java.util.HashMap;
import java.util.Map;

public abstract class commande {
    protected Map<Produit, Integer> produitsCommande = new HashMap<>();

    public void ajouterProduit(Produit produit, int quantite) {
        if (quantite <= 0) return;
        produitsCommande.put(produit, quantite);
    }

    public abstract boolean validerCommande();

    public void afficherCommande() {
        for (Map.Entry<Produit, Integer> entry : produitsCommande.entrySet()) {
            Produit produit = entry.getKey();
            Integer quantite = entry.getValue();
            System.out.println(produit.getNom() + " - Quantité: " + quantite);
        }
    }
}
