import java.util.ArrayList;

public interface Role {


    public void ajouterUtilisateur(Utilisateur utilisateur, ArrayList<Utilisateur> utilisateurs);

    public void supprimerUtilisateur(String email, ArrayList<Utilisateur> utilisateurs);

}
