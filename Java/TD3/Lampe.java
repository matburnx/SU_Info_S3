public class Lampe {
  private boolean etat;
  public Lampe() {
    etat=false;
  }

  public void allumer() {
    etat=true;
  }

  public void eteindre() {
    etat=false;
  }
}
