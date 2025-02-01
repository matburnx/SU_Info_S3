import java.util.ArrayList;

public class Etudiant {
    private static ArrayList<Etudiant> listeEtudiants= new ArrayList<Etudiant>();
    private final String nom;
    private int[] notes;
    private int i;

    public Etudiant(String nom) {
        this.nom=nom;
        this.notes = new int[5];
        this.i=0;
        listeEtudiants.add(this);
    }

    void entrerNote(int note) throws TabNotesPleinException {
        if(i>=notes.length) {
            throw new TabNotesPleinException();
        } else {
            notes[i]=note;
            i++;
        }
    }

    public static void afficherListeEtudiantes() {
        for(int i=0; i<listeEtudiants.size(); i++) {
            System.out.println(listeEtudiants.get(i).toString());
        }
    }

    public String toString() {
        String s=this.nom+"\nNotes : ";
        for(int i=0; i<notes.length; i++) {
            s=s+notes[i]+" ";
        }
        return s;
    }
}
