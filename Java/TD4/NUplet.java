public class NUplet {
  private int[] tab;
  
  public NUplet(int n) {
    this.tab=new int[n];
  }

  public NUplet(int n, int x) {
    this(n);
    for(int i=0; i<tab.length;i++) {
      tab[i]=x;
    }
  }

  public NUplet(int a, int b, int c) {
    this(3);
    tab[0]=a;
    tab[1]=b;
    tab[2]=c;
  }

  public NUplet(int[] tab) {
    this.tab=tab;
  }

  public String toString() {
    if(tab.length==0) return "()";
    String s="(";
    for(int i=0; i<(tab.length-1); i++) {
      s=s+tab[i]+",";
    }
    s=s+tab[tab.length-1]+")";
    return s;
  }

  public int[] getTab() {
    return tab;
  }

  public int somme() {
    int s=0;
    for(int i:tab) {
      s+=i;
    }
    return s;
  }

  public boolean egal(NUplet n2) {
    if(this.tab.length == n2.tab.length) {
      for(int i=0; i<this.tab.length;i++) {
        if(this.tab[i]!=n2.tab[i])
          return false;
      }
      return true;
    } else {
      return false;
    }
  }
}
