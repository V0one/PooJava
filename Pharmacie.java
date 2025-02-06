import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Scanner;

public class Pharmacie {

    ArrayList<Produit> produits ;


    public Pharmacie() {
        this.produits = new ArrayList();
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

    public Produit trouverProduit(String nom) {
        for (Produit produit : produits) {
            if (produit.getNom().equalsIgnoreCase(nom)) {
                return produit;
            }
        }
        System.out.println("Produit non trouvé : " + nom);
        return null;
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


    public int afficherProduit (String nom) {
        nom = nom.toUpperCase();
        char premierChar = nom.charAt(0);
        int debut  = 0;
        int fin  = produits.size() - 1;

        while (debut < fin) {
            int millieu = produits.size() / 2;

            if (premierChar == produits.get(millieu).getNom().toUpperCase().charAt(0)) {
                return produits.get(millieu).getQuantite();
            }
            else if (premierChar < produits.get(millieu).getNom().toUpperCase().charAt(0)) {
                fin = millieu - 1;
            }
            else {
                debut = millieu + 1;
            }
        }
        System.out.println("Erreur de la produit, il n'existe pas");
        return -1;



    }

        public void triPrix(){
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
        triPrix();
        for (Produit p : produits) {
            if (p.getQuantite() < 5) {
                System.out.println(p);
            }
        }

    }

}
