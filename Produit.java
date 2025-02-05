public class Produit {

    private String nom ;
    private float prix ;
    private int quantite ;
    private Categorie categorie ;
    private int id ;

    private static int idCounter = 1;

    public Produit(String nom, int quantite, float prix, Categorie categorie) {
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
        this.categorie = categorie;
        this.id = idCounter++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Nom: " + nom + ", Prix: " + prix + "€, Quantité: " + quantite + ", Catégorie: " + categorie.getNom();
    }

    public int getId() {
        return id;
    }

}
