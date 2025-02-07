import java.util.ArrayList;
import java.util.Iterator;

public class ListeUtilisateur {

    ArrayList<Utilisateur> utilisateurs = new ArrayList<>();

    public ListeUtilisateur() {
    }

    public Utilisateur seConnecter(String email, String mdp) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getEmail().equalsIgnoreCase(email) && utilisateur.getMdp().equals(mdp)) {
                System.out.println("vous etes connecté");
                return utilisateur;
            }
            else if (utilisateur.getEmail().equalsIgnoreCase(email) && !utilisateur.getMdp().equals(mdp)) {
                System.out.println("Le mot de passe est mauvais");
                return null;
            }

        }
        System.out.println("le mail n'existe pas");
        return null;
    }

    public ArrayList<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(ArrayList<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }
}
