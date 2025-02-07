import java.io.Serializable;

public class Employe extends Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;

    public Employe(String email, String mdp) {
        super(email, mdp);
    }
}
