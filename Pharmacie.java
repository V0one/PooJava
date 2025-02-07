import java.io.Serializable;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;

public class Pharmacie implements Serializable {

    private static final long serialVersionUID = 1L;
    ArrayList<Produit> produits;
    ArrayList<commande> commandes;

    public Pharmacie() {
        this.produits = new ArrayList<>();
        this.commandes = new ArrayList<>();
    }

    public ArrayList<Produit> getProduits() {
        return produits;
    }

    public ArrayList<commande> getCommandes() {
        return commandes;
    }

    public void setCommandes(ArrayList<commande> commandes) {
        this.commandes = commandes;
    }

    public void setProduits(ArrayList<Produit> produits) {
        this.produits = produits;
    }

    public void afficherListeProduits() {
        produits.sort(Comparator.comparing(Produit::getNom));
        Iterator<Produit> iterator = produits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void ajouterProduit(String nom, int quantite, float prix, String categorie) {
        if (quantite <= 0 || prix <= 0) {
            return;
        }
        Categorie categorie1 = new Categorie(categorie);
        Produit produit = new Produit(nom, quantite, prix, categorie1);
        produits.add(produit);
    }

    public void supprimerProduit(String nomProduit) {
        Produit produitASupprimer = trouverProduit(nomProduit);

        if (produitASupprimer == null) {
            System.out.println("❌ Produit introuvable : " + nomProduit);
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Voulez-vous vraiment supprimer le produit '" + nomProduit + "' ? (oui/non) : ");
        String reponse = scanner.nextLine().trim().toLowerCase();

        if (reponse.equals("oui")) {
            produits.remove(produitASupprimer);
            System.out.println("✅ Produit supprimé : " + nomProduit);
        } else {
            System.out.println("❎ Suppression annulée.");
        }
    }


    public void afficherProduit (String nom) {
        nom = nom.toUpperCase();
        char premierChar = nom.charAt(0);
        int debut  = 0;
        int fin  = produits.size() ;

        while (debut < fin) {
            int millieu = (debut + fin) / 2;

            if (nom.equals(produits.get(millieu).getNom().toUpperCase())) {
                System.out.println("Le produit " + nom + " est disponible ! Et il en reste encore " + produits.get(millieu).getQuantite() + " exemplaire.");
                return;
            }
            else if (premierChar < produits.get(millieu).getNom().toUpperCase().charAt(0)) {
                fin = millieu - 1;
            }
            else {
                debut = millieu + 1;
            }
        }
        System.out.println("Erreur de la produit, il n'existe pas");
    }

    public void enregistrerCommande(commande commande) {
        if (commande.validerCommande()) {
            commandes.add(commande);

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

        public void triQuantite(){
            for (int i = 0 ; i < produits.size(); i++) {
                int indice = i;
                float min = produits.get(i).getQuantite();
                for (int j = i; j < produits.size(); j++) {
                    if (produits.get(j).getQuantite() < min) {
                        min = produits.get(j).getQuantite();
                        indice = j;
                    }

                }
                Produit temp = produits.get(i);
                produits.set(i,produits.get(indice));
                produits.set(indice,temp);

            }
        }

    public void afficherQuantiteMoins5 () {
//        int debut = 0;
//        int fin  = produits.size() - 1;
//        while (debut < fin) {
//            int millieu = produits.size() / 2;
//            if (produits.get(millieu).getQuantite() < 5) {
//                System.out.println(produits.get(millieu));
//            }
//            else if (produits.get(millieu).getQuantite() >= 5) {
//                fin = millieu - 1;
//            }
        triQuantite();
        for (Produit p : produits) {
            if (p.getQuantite() < 5) {
                System.out.println(p);
            }
        }
    // Je re trie le tableau afin que ça n'impacte pas les autres fonction qui eux travail sur un tableau trié de manière alphabetique
    produits.sort(Comparator.comparing(Produit::getNom));
    }

    public void afficherHistoriqueCommandes() {
        commandes.sort(Comparator.comparing(commande::getDateCommande).reversed());
        System.out.println("=== Historique des Commandes ===");
        for (commande commande : commandes) {
            commande.afficherCommande();
            System.out.println("--------------------------------");
        }
    }

    public void exporterStatistiquesVentes(String nomFichier) {
        // Map pour stocker les quantités vendues par produit
        Map<Produit, Integer> quantitesVenduesParProduit = new HashMap<>();

        // Variables pour le produit le plus vendu et le chiffre d'affaires total
        Produit produitLePlusVendu = null;
        int quantiteMaxVendue = 0;
        float chiffreAffairesTotal = 0;

        // Parcourir toutes les commandes pour calculer les statistiques
        for (commande commande : commandes) {
            for (Map.Entry<Produit, Integer> entry : commande.produitsCommande.entrySet()) {
                Produit produit = entry.getKey();
                int quantiteVendue = entry.getValue();

                // Mettre à jour les quantités vendues par produit
                quantitesVenduesParProduit.put(produit, quantitesVenduesParProduit.getOrDefault(produit, 0) + quantiteVendue);

                // Mettre à jour le produit le plus vendu
                if (quantitesVenduesParProduit.get(produit) > quantiteMaxVendue) {
                    produitLePlusVendu = produit;
                    quantiteMaxVendue = quantitesVenduesParProduit.get(produit);
                }

                // Mettre à jour le chiffre d'affaires total
                chiffreAffairesTotal += produit.getPrix() * quantiteVendue;
            }
        }

        // Trier les produits par quantité vendue (ordre décroissant)
        List<Map.Entry<Produit, Integer>> listeProduitsVendus = new ArrayList<>(quantitesVenduesParProduit.entrySet());
        listeProduitsVendus.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Générer le fichier CSV
        try (FileWriter writer = new FileWriter(nomFichier)) {
            // Écrire l'en-tête du fichier CSV
            writer.write("Produit,Quantité Vendue,Prix Unitaire,Total\n");

            // Écrire les données pour chaque produit
            for (Map.Entry<Produit, Integer> entry : listeProduitsVendus) {
                Produit produit = entry.getKey();
                int quantiteVendue = entry.getValue();
                float total = produit.getPrix() * quantiteVendue;
                writer.write(produit.getNom() + "," + quantiteVendue + "," + produit.getPrix() + "," + total + "\n");
            }

            // Écrire le produit le plus vendu
            writer.write("\nProduit le plus vendu: " + produitLePlusVendu.getNom() + " (" + quantiteMaxVendue + " unités)\n");

            // Écrire le chiffre d'affaires total
            writer.write("Chiffre d'affaires total: " + chiffreAffairesTotal + "\n");

            System.out.println("✅ Statistiques de ventes exportées dans le fichier : " + nomFichier);
        } catch (IOException e) {
            System.err.println("❌ Erreur lors de l'exportation des statistiques : " + e.getMessage());
        }
    }
}
