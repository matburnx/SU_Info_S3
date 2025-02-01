public class Feu {
  private Lampe vert;
  private Lampe orange;
  private Lampe rouge;

  public Feu(Lampe vert,Lampe orange, Lampe rouge) {
    this.vert = vert;
    this.orange = orange;
    this.rouge = rouge;
  }
  public Feu(){
    this(new Lampe(), new Lampe(), new Lampe());
  }
  public Feu(Feu feu){
    this(new Lampe(feu.vert), new Lampe(feu.orange), new Lampe(feu.vert));
  }
}
