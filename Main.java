public class Main {
    public static void main(String[] args) {

        Categorie medicament = new Categorie("Médicament");
        Produit doliprane = new Produit("Doliprane", 10, 2.5f, medicament);
        Produit efferalgan = new Produit("Efferalgan", 5, 3.0f, medicament);

        Pharmacie pharmacie = new Pharmacie();
        pharmacie.ajouterProduit("Doliprane", 10, 2.5f, medicament);
        pharmacie.ajouterProduit("Efferalgan", 5, 3.0f, medicament);

        CommandeStandard commandeStandard = new CommandeStandard();
        commandeStandard.ajouterProduit(doliprane, 8);
        commandeStandard.ajouterProduit(efferalgan, 6);

        pharmacie.enregistrerCommande(commandeStandard);

        CommandeUrgence commandeUrgence = new CommandeUrgence();
        commandeUrgence.ajouterProduit(doliprane, 8);
        commandeUrgence.ajouterProduit(efferalgan, 6);

        pharmacie.enregistrerCommande(commandeUrgence);
    }
}
