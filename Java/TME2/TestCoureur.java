public class TestCoureur {
    public static void main(String[] args) {
        Coureur c1 = new Coureur();
        Coureur c2 = new Coureur();
        Coureur c3 = new Coureur();
        Coureur c4 = new Coureur();

        System.out.println("Dossard du premier coureur : "+c1.getNumDossard());
        System.out.println("Temps du premier coureur : "+c1.getTempsAu100());
        System.out.println("Coureur a le temoin ? "+c1.getPossedeTemoin());
        c1.setPossedeTemoin(true);
        System.out.println("Coureur a le temoin ? "+c1.getPossedeTemoin());
        
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c3.toString());

        c1.courir();
        c1.passeTemoin(c2);
        c2.courir();
        c2.passeTemoin(c3);
        c3.courir();
        c3.passeTemoin(c4);
        c4.courir();
        double tempsTot=c1.getTempsAu100()+c2.getTempsAu100()+c3.getTempsAu100()+c4.getTempsAu100();
        System.out.println("Temps total : " + String.format("%.2f",tempsTot) +"s");
    }
}
