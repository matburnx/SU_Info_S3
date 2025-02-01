public class TestForet {
    public static void main(String[] args) {
        Foret f = new Foret(10);
        double alea;
        Panier p=new Panier(8.);

        for(int i=0;i<10;i++){
            alea=Math.random();
            if(alea>0.7) {
                f.placer(new Champignon("Cèpe"));
            } else {
                f.placer(new Arbre("Pin"));
            }

            if(i<4) {
                f.placer(new ChampignonToxique("Amanite"));
            }
        }

        System.out.println(f.toString());
        f.ramasser(p);
        System.out.println(p.toString());
    }
}
