import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.HashMap;

public abstract class commande implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Map<Produit, Integer> produitsCommande = new HashMap<>() ;
    protected LocalDateTime dateCommande ;

    public commande() {
        this.dateCommande = LocalDateTime.now();
    }

    public void ajouterProduit(Produit produit, int quantite) {
        if (quantite <= 0) return;
        produitsCommande.put(produit, quantite);
    }

    public boolean validerCommande() {
        boolean stocksSuffisants = true;

        for (Map.Entry<Produit, Integer> entry : produitsCommande.entrySet()) {
            Produit produit = entry.getKey();
            int quantiteDemandee = entry.getValue();

            if (produit.getQuantite() < quantiteDemandee) {
                System.out.println("Stock insuffisant pour " + produit.getNom());
                stocksSuffisants = false;
            }
        }

        if (stocksSuffisants) {
            for (Map.Entry<Produit, Integer> entry : produitsCommande.entrySet()) {
                Produit produit = entry.getKey();
                int quantiteDemandee = entry.getValue();
                produit.setQuantite(produit.getQuantite() - quantiteDemandee);

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

    public void setDateCommande() {
        this.dateCommande = LocalDateTime.now();
    }

    public Map<Produit, Integer> getProduitsCommande() {
        return produitsCommande;
    }

    public void setProduitsCommande(Map<Produit, Integer> produitsCommande) {
        this.produitsCommande = produitsCommande;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }
}
