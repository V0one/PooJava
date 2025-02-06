import java.util.ArrayList;

public class Admin extends Utilisateur implements Role {
    public Admin(String email, String mdp) {
        super(email, mdp);
    }

    public void ajouterUtilisateur(String email, String mdp, ArrayList<Utilisateur> utilisateurs) {
        if (utilisateurs.size() == 0) {
            utilisateurs.add(new Utilisateur(email, mdp) {
            });
            return;
        }
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getEmail().equals(email)) {
                System.out.println("L'email existe déjà impossible d'ajouter un utilisateur");
                return;
            }
        }
        utilisateurs.add(new Utilisateur(email, mdp) {});

    }

    public void supprimerUtilisateur(String email, ArrayList<Utilisateur> utilisateurs) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getEmail().equals(email)) {
                utilisateurs.remove(utilisateur);
            }
        }
    }


}
