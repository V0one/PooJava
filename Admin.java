import java.util.ArrayList;

public class Admin extends Utilisateur implements Role {
    public Admin(String email, String mdp) {
        super(email, mdp);
    }

    public void ajouterUtilisateur(Utilisateur utilisateur, ArrayList<Utilisateur> utilisateurs) {
        if (utilisateurs.size() == 0) {
            utilisateurs.add(utilisateur);
            return;
        }
        for (Utilisateur utilisateurBoucle : utilisateurs) {
            if (utilisateur.getEmail().toUpperCase().equals(utilisateurBoucle.getEmail().toUpperCase())) {
                System.out.println("L'email existe déjà impossible d'ajouter un utilisateur");
                return;
            }
        }
        utilisateurs.add(utilisateur);

    }

    public void supprimerUtilisateur(String email, ArrayList<Utilisateur> utilisateurs) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getEmail().equals(email)) {
                utilisateurs.remove(utilisateur);
            }
        }
    }


}
