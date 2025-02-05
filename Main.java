public class Main {
    public static void main(String[] args) {

        Categorie medicament = new Categorie("Médicament");

        Pharmacie pharmacie = new Pharmacie();
        pharmacie.ajouterProduit("Doliprane", 10, 2.5f, medicament);
        pharmacie.ajouterProduit("Efferalgan", 4, 3.0f, medicament);

        // Récupérer les produits directement de la pharmacie
        Produit doliprane = pharmacie.trouverProduit("Doliprane");
        Produit efferalgan = pharmacie.trouverProduit("Efferalgan");

        CommandeStandard commandeStandard = new CommandeStandard();
        commandeStandard.ajouterProduit(doliprane, 8);
        commandeStandard.ajouterProduit(efferalgan, 1);

        pharmacie.enregistrerCommande(commandeStandard);

        CommandeUrgence commandeUrgence = new CommandeUrgence();
        commandeUrgence.ajouterProduit(doliprane, 1);
        commandeUrgence.ajouterProduit(efferalgan, 1);

        pharmacie.enregistrerCommande(commandeUrgence);

        pharmacie.afficherStocks();
    }
}
