public class TestsEtudiants {
    public static void main(String[] args) {
        int x=0;
        Etudiant etu=null;
        String nom="";
        for(String s : args) {
            try {
                x=Integer.parseInt(s);
                if(etu!=null) {
                    etu.entrerNote(x);
                }
            } catch (NumberFormatException nEx) {
                nom=s;
                etu = new Etudiant(nom);
            } catch(TabNotesPleinException tabEx) {
                System.out.println("Le tableau de notes de "+nom+" est complet");
            }
        }
        Etudiant.afficherListeEtudiantes();
    }
}
