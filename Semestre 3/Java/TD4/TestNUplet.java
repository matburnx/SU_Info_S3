public class TestNUplet {
  public static void main(String[] args) {
    NUplet uplet3 = new NUplet(7,8,9);
    NUplet uplet2 = new NUplet(7,8,9);
    NUplet uplet1 = new NUplet(3,2);
    System.out.println(uplet3.somme());
    System.out.println(uplet3.egal(uplet2));
    System.out.println(uplet1.egal(uplet3));
  }
}
