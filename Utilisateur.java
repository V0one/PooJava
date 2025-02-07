import java.io.Serializable;

public abstract class Utilisateur implements Serializable {
    private static final long serialVersionUID = 1L;

    private String email ;
    private String mdp ;


    public Utilisateur( String email, String mdp) {
        this.email = email;
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


}
