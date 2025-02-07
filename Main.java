import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
//        Pharmacie p = new Pharmacie();
//        p.ajouterProduit("doliprane",1,10,"Anti_douleur");
////        p.afficherListeProduits();
////        p.supprimerProduit("doliprane");
//        p.ajouterProduit("abou",4,10000,"Antibiotique");
////        p.afficherListeProduits();
//
//        p.afficherQuantiteMoins5();
//        Categorie medicament = new Categorie("Médicament");
//
//        Pharmacie pharmacie = new Pharmacie();
//        pharmacie.ajouterProduit("Doliprane", 10, 2.5f, "medicament");
//        pharmacie.ajouterProduit("Efferalgan", 4, 3.0f, "medicament");
//        pharmacie.ajouterProduit("Spasfon", 5, 3.5f, "medicament");
//
//        Produit doliprane = pharmacie.trouverProduit("Doliprane");
//        Produit efferalgan = pharmacie.trouverProduit("Efferalgan");
//        Produit spasfon = pharmacie.trouverProduit("Spasfon");
//
//        CommandeStandard commandeStandard = new CommandeStandard();
//        commandeStandard.ajouterProduit(doliprane, 8);
//        commandeStandard.ajouterProduit(efferalgan, 1);
//
//        pharmacie.enregistrerCommande(commandeStandard);
//
//        CommandeUrgence commandeUrgence = new CommandeUrgence();
//        commandeUrgence.ajouterProduit(doliprane, 1);
//        commandeUrgence.ajouterProduit(spasfon, 2);
//
//        pharmacie.enregistrerCommande(commandeUrgence);
//
//        pharmacie.afficherStocks();
//
//        pharmacie.afficherHistoriqueCommandes();
//        p.afficherProduit("dolipRanE");
        Pharmacie pharmacie = new Pharmacie();

        // Ajouter des produits
        pharmacie.ajouterProduit("Paracétamol", 100, 5.0f, "Médicament");
        pharmacie.ajouterProduit("Vitamine C", 50, 10.0f, "Complément alimentaire");

        // Enregistrer des commandes
        Produit paracetamol = pharmacie.trouverProduit("Paracétamol");
        Produit vitamineC = pharmacie.trouverProduit("Vitamine C");

        commande commande1 = new commande() {};
        commande1.ajouterProduit(paracetamol, 10);
        commande1.ajouterProduit(vitamineC, 40);
        pharmacie.enregistrerCommande(commande1);

        commande commande2 = new commande() {};
        commande2.ajouterProduit(paracetamol, 25);
        pharmacie.enregistrerCommande(commande2);

        // Exporter les statistiques de ventes
        pharmacie.exporterStatistiquesVentes("statistiques_ventes.csv");
        Pharmacie p = new Pharmacie();
        ArrayList<Produit> produit = ChargementDonne.chargerProduits("produit.ser");
        p.setProduits(produit);
        p.afficherListeProduits();
    }
}
