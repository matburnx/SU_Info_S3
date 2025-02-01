public class VectN {
    private int[] tab;

    private VectN(int n) {
        tab=new int[n];
    }

    public VectN(int n, int valMax) {
        this(n);
        for(int i = 0; i<tab.length; i++) {
            tab[i]=(int)(Math.random()*valMax);
        }
    }

    public VectN() {
        this(5,9);
    }

    public VectN(int a, int b, int c) {
        this(3);
        tab[0]=a;
        tab[1]=b;
        tab[2]=c;
    }

    public int somme() {
        int s=0;
        for(int i:tab) {
            s+=i;
        }
        return s;
    }

    public String toString() {
        String s="[";
        for(int i=0; i<tab.length-1;i++) {
            s=s+tab[i]+",";
        }
        s=s+tab[tab.length-1]+"]";
        return s;
    }

    public int[] getTab() {
        int[] newTab = new int[tab.length];
        for(int i=0; i<newTab.length; i++) {
            newTab[i]=tab[i];
        }
        return newTab;
    }
}
