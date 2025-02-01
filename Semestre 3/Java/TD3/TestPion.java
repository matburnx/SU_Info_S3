public class TestPion {
  public static void main(String[] args) {
    Pion p1 = new Pion("Atchoum");
    Pion p2 = p1;
    Pion p3 = new Pion(p1);
    //p2.setNom("Dormeur");
    p3.setNom("Dormeur");
    //System.out.println(p1.getNom());
    System.out.println(p1.getNom());
    p3.seDeplacer();
  }
}
