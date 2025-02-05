import java.util.Map;

public class CommandeStandard extends commande{
    @Override
    public boolean validerCommande() {
        for (Map.Entry<Produit, Integer> entry : produitsCommande.entrySet()) {
            Produit produit = entry.getKey();
            int quantiteDemandee = entry.getValue();
            if (produit.getQuantite() < quantiteDemandee) {
                System.out.println("Stock insuffisant pour " + produit.getNom());
                return false;
            }
        }
        System.out.println("Commande standard validée.");
        return true;
    }
}
