public class Main {
    public static void main(String[] args) {
        Pharmacie p = new Pharmacie();
        p.ajouterProduit("doliprane",1,10,"Anti_douleur");
//        p.afficherListeProduits();
//        p.supprimerProduit("doliprane");
        p.ajouterProduit("abou",4,10000,"Antibiotique");
//        p.afficherListeProduits();

        p.afficherQuantiteMoins5();
        p.afficherProduit("dolipRanE");
    }
}
