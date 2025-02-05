import java.util.Map;
import java.util.HashMap;

public abstract class commande {
    protected Map<Produit, Integer> produitsCommande = new HashMap<>();

    public void ajouterProduit(Produit produit, int quantite) {
        if (quantite <= 0) return;
        produitsCommande.put(produit, quantite);
    }

    public boolean validerCommande() {
        boolean stocksSuffisants = true;

        // Vérification des stocks
        for (Map.Entry<Produit, Integer> entry : produitsCommande.entrySet()) {
            Produit produit = entry.getKey();
            int quantiteDemandee = entry.getValue();

            if (produit.getQuantite() < quantiteDemandee) {
                System.out.println("Stock insuffisant pour " + produit.getNom());
                stocksSuffisants = false;
            }
        }

        if (stocksSuffisants) {
            // Mise à jour des stocks
            for (Map.Entry<Produit, Integer> entry : produitsCommande.entrySet()) {
                Produit produit = entry.getKey();
                int quantiteDemandee = entry.getValue();
                produit.setQuantite(produit.getQuantite() - quantiteDemandee);

                // Alerte si la quantité devient critique
                if (produit.getQuantite() < 5) {
                    System.out.println("⚠️ Attention : Stock critique pour " + produit.getNom() + " (" + produit.getQuantite() + " restant)");
                }
            }
            return true;
        }
        return false;
    }

    public void afficherCommande() {
        for (Map.Entry<Produit, Integer> entry : produitsCommande.entrySet()) {
            Produit produit = entry.getKey();
            Integer quantite = entry.getValue();
            System.out.println(produit.getNom() + " - Quantité: " + quantite);
        }
    }
}
