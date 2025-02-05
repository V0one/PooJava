import java.util.Map;

public class CommandeUrgence extends commande {

    @Override
    public boolean validerCommande() {
        for (Map.Entry<Produit, Integer> entry : produitsCommande.entrySet()) {
            Produit produit = entry.getKey();
            int quantiteDemandee = entry.getValue();
            if (produit.getQuantite() < quantiteDemandee) {
                System.out.println("Stock insuffisant pour " + produit.getNom() + ", mais la commande est urgente.");
            }
        }
        System.out.println("Commande urgente validée.");
        return true;
    }
}