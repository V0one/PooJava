import java.util.ArrayList;

public interface Role {


    public void ajouterUtilisateur(String email, String mdp, ArrayList<Utilisateur> utilisateurs);

    public void supprimerUtilisateur(String email, ArrayList<Utilisateur> utilisateurs);

}
