import java.io.Serializable;

public class Categorie implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nom;

    public Categorie(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
