public class GenerateurIP {
    private static int[] tab={192,168,0,0};

    private GenerateurIP() {}

    public static String getIP() {
        String s="";
        for(int i=0; i<tab.length-1;i++) {
            s=s+tab[i]+".";
        }
        s=s+tab[tab.length-1];

        if(tab[3]<255)
            tab[3]++;
        else
            tab[2]++;

        return s;
    }
}
