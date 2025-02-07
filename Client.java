import java.io.Serializable;

public class Client extends Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;

    public Client(String email, String mdp) {
        super(email, mdp);
    }
}
