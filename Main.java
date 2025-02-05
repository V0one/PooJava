public class Main {
    public static void main(String[] args) {
        Pharmacie p = new Pharmacie();
        p.ajouterProduit("doliprane",4,10,"Anti_douleur");
//        p.afficherListeProduits();
//        p.supprimerProduit("doliprane");
        p.ajouterProduit("abou",1,10000,"Antibiotique");
//        p.afficherListeProduits();

        p.afficherQuantiteMoins5();
    }
}
