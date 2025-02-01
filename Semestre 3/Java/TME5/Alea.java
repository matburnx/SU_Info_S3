public class Alea {
    public static char letter() {
        return (char)(Math.random()*('z'-'a'+1)+'a');
    }

    public static String chaine() {
        String s="";
        for(int i=0; i<10; i++) {
            s=s+Alea.letter();
        }
        return s;
    }

    private Alea() {}

    public static void main(String[] args) {
        System.out.println(Alea.chaine());
    }
}
