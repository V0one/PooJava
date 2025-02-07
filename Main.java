import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Pharmacie pharmacie = new Pharmacie();
        Scanner scanner = new Scanner(System.in);
        ListeUtilisateur listeUtilisateur = new ListeUtilisateur();
        Admin admin = new Admin("Admin","123");
        admin.ajouterUtilisateur(admin,listeUtilisateur.getUtilisateurs());
        boolean connecter = false;
        Utilisateur personne = null;

        //Map<Produit, Integer> commandeProduit = ChargementDonne.chargerProduitsCommande("produitCommande.ser");
        ArrayList<commande> commandeProduit = ChargementDonne.chargerProduitsCommande("produitCommande.ser");
        pharmacie.setCommandes(commandeProduit);


        ArrayList<Utilisateur> utilisateurs = ChargementDonne.chargerUtilisateurs("utilisateurs.ser");
        listeUtilisateur.setUtilisateurs(utilisateurs);

        ArrayList<Produit> produits = ChargementDonne.chargerProduits("produit.ser");
        pharmacie.setProduits(produits);

        for (Utilisateur utilisateur : utilisateurs) {
            System.out.println(utilisateur.getEmail() + " " + utilisateur.getClass());
        }

        while (!connecter) {
            System.out.print("Veuillez rentrez votre email : ");
            String email = scanner.nextLine();
            System.out.print("Veuillez entrer votre mdp : ");
            String mdp = scanner.nextLine();
            personne = listeUtilisateur.seConnecter(email,mdp);
            if(personne != null) {
                connecter = true;
            }
        }

        int choix = 0;
        if (personne.getClass() == Admin.class) {
            while (choix != 3) {

                System.out.println("\n === Gestion des utilisateurs ===");
                System.out.println("1. Créer un compte");
                System.out.println("2. Supprimer un compte ");
                System.out.println("3. Quitter");
                System.out.print("Choisissez une option : ");


                choix = Integer.parseInt(scanner.nextLine());

                switch (choix) {
                    case 1:
                        System.out.print("Veuillez entrer l'email de l'utilisateur : ");
                        String email = scanner.nextLine();
                        System.out.print("Veuillez entrer l'mdp : ");
                        String mdp = scanner.nextLine();
                        System.out.print("Quelle type d'utilisateur Employe / Client ");
                        String type = scanner.nextLine();
                        if (type.equalsIgnoreCase("client")) {
                            Client client = new Client(email,mdp);
                            admin.ajouterUtilisateur(client,listeUtilisateur.getUtilisateurs());
                        }
                        else {
                        Employe employe = new Employe(email, mdp);
                        admin.ajouterUtilisateur(employe, listeUtilisateur.getUtilisateurs());
                        }
                        SauvegardeDonnee.sauvergarderUtilisateurs(listeUtilisateur.getUtilisateurs(),"utilisateurs.ser");
                        break;
                    case 2:
                        System.out.print("Veuillez entrer l'email de l'utilisateur : ");
                        String email2 = scanner.nextLine();
                        admin.supprimerUtilisateur(email2, listeUtilisateur.getUtilisateurs());
                        SauvegardeDonnee.sauvergarderUtilisateurs(listeUtilisateur.getUtilisateurs(),"utilisateurs.ser");
                        break;
                    case 3:
                        System.out.println("Au revoir !");
                        break;

                    default:
                        System.out.println("❌ Option invalide. Veuillez réessayer.");
                }


            }
        }


        int choixPharmacie = 0;
        if (personne.getClass() == Employe.class) {
            while (choixPharmacie != 8) {
                System.out.println("\n=== Gestion de la Pharmacie ===");
                System.out.println("1. Afficher la liste des produits");
                System.out.println("2. Ajouter un produit");
                System.out.println("3. Supprimer un produit");
                System.out.println("4. Enregistrer une commande");
                System.out.println("5. Afficher les stocks critiques (<5)");
                System.out.println("6. Afficher l'historique des commandes");
                System.out.println("7. Exporter les statistiques");
                System.out.println("8. Quitter");
                System.out.print("Choisissez une option : ");

                choixPharmacie = Integer.parseInt(scanner.nextLine());

                switch (choixPharmacie) {
                    case 1:
                        pharmacie.afficherListeProduits();
                        break;

                    case 2:
                        System.out.print("Nom du produit : ");
                        String nom = scanner.nextLine();
                        System.out.print("Quantité : ");
                        int quantite = Integer.parseInt(scanner.nextLine());
                        System.out.print("Prix : ");
                        float prix = Float.parseFloat(scanner.nextLine());
                        System.out.print("Catégorie : ");
                        String categorie = scanner.nextLine();

                        pharmacie.ajouterProduit(nom, quantite, prix, categorie);
                        System.out.println("✅ Produit ajouté avec succès.");
                        SauvegardeDonnee.sauvegarderProduits(pharmacie.getProduits(),"produit.ser");
                        break;

                    case 3:
                        System.out.print("Nom du produit à supprimer : ");
                        String produitASupprimer = scanner.nextLine();
                        pharmacie.supprimerProduit(produitASupprimer);
                        SauvegardeDonnee.sauvegarderProduits(pharmacie.getProduits(),"produit.ser");
                        break;

                    case 4:
                        System.out.println("=== Enregistrement d'une commande ===");
                        System.out.print("Type de commande (1 = Standard, 2 = Urgente) : ");
                        int typeCommande = Integer.parseInt(scanner.nextLine());

                        commande commande;
                        if (typeCommande == 1) {
                            commande = new CommandeStandard();
                        } else if (typeCommande == 2) {
                            commande = new CommandeUrgence();
                        } else {
                            System.out.println("❌ Type de commande invalide.");
                            break;
                        }

                        while (true) {
                            System.out.print("Nom du produit (ou 'fin' pour terminer) : ");
                            String nomProduitCommande = scanner.nextLine();

                            if (nomProduitCommande.equalsIgnoreCase("fin")) {
                                break;
                            }

                            Produit produitCommande = pharmacie.trouverProduit(nomProduitCommande);
                            if (produitCommande != null) {
                                System.out.print("Quantité : ");
                                int quantiteCommande = Integer.parseInt(scanner.nextLine());
                                commande.ajouterProduit(produitCommande, quantiteCommande);
                                SauvegardeDonnee.sauvegarderProduits(pharmacie.getProduits(),"produit.ser");
                                SauvegardeDonnee.sauvegarderCommande( "produitCommande.ser",pharmacie.getCommandes());

                            } else {
                                System.out.println("❌ Produit non trouvé.");
                            }
                        }

                        pharmacie.enregistrerCommande(commande);
                        break;

                    case 5:
                        pharmacie.afficherQuantiteMoins5();
                        break;

                    case 6:
                        pharmacie.afficherHistoriqueCommandes();
                        break;
                    case  7 :
                        pharmacie.exporterStatistiquesVentes("Statistiques.csv");

                    case 8:
                        System.out.println("Au revoir !");
                        break;

                    default:
                        System.out.println("❌ Option invalide. Veuillez réessayer.");
                }
            }
        } else if (personne.getClass() == Client.class) {
            //System.out.println("4. Rechercher un produit");
            //case 4:
            //System.out.print("Nom du produit à rechercher : ");
            //String produitRecherche = scanner.nextLine();
            //pharmacie.afficherProduit(produitRecherche);
            //break;
            choix = 0;
            while (choix != 2 ) {
                System.out.println("\n=== Recherche de produit ===");
                System.out.println("1. Rechercher un produit");
                System.out.println("2. Quittez");
                System.out.print("Choisissez une option : ");
                choix = Integer.parseInt(scanner.nextLine());


                switch (choix) {
                    case 1:
                        System.out.print("Nom du produit : ");
                        String nom = scanner.nextLine();
                        pharmacie.afficherProduit(nom);
                        break;
                    case 2:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("La saisie est inpossible");
                }
            }
        }

        scanner.close();
    }
}
