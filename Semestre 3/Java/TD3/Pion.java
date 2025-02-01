public class Pion {
  private String nom;
  private Point position;

  public Pion(String n) {
    nom = n;
    position = new Point();
  }

  public Pion(Pion p) {
    nom = p.nom;
    position = p.position;
  }

  public void setNom(String n){ nom = n;}
  public String getNom() { return nom; }

  public void seDeplacer() {
    position.bouger();
  }
}
