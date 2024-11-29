import java.util.ArrayList;

public class Foret {
    private Object[][] terrain;
    public Foret(int taille) {
        terrain=new Object[taille][taille];
    }

    public boolean placer(Object obj) {
        int x=(int)(Math.random()*terrain.length);
        int y=(int)(Math.random()*terrain.length);
        if(terrain[x][y]==null) {
            terrain[x][y]=obj;
            return true;
        }
        return false;
    }

    public String toString() {
        String s="";
        for(int i=0;i<terrain.length;i++) {
            s=s+"|";
            for(int j=0;j<terrain[i].length;j++) {
                if(terrain[i][j]!=null)
                    s=s+(terrain[i][j].toString()).charAt(0);
                else
                    s=s+" ";
            }
            s=s+"|\n";
        }

        return s;
    }

    public ArrayList<Champignon> ramasserChampignons() {
        ArrayList<Champignon> liste = new ArrayList<Champignon> ();

        for(int i=0;i<terrain.length;i++) {
            for(int j=0;j<terrain[i].length;j++) {
                if(terrain[i][j] instanceof Champignon)
                    liste.add((Champignon)terrain[i][j]);
            }
        }
        return liste;
    }

    public ArrayList<Ramassable> ramasserTout() {
        ArrayList<Ramassable> liste = new ArrayList<Ramassable> ();

        for(int i=0;i<terrain.length;i++) {
            for(int j=0;j<terrain[i].length;j++) {
                if(terrain[i][j] instanceof Ramassable)
                    liste.add((Ramassable)terrain[i][j]);
            }
        }
        return liste;
    }

    public void ramasser(Panier p) {
        for(int i=0;i<terrain.length;i++) {
            for(int j=0;j<terrain[i].length;j++) {
                if(terrain[i][j] instanceof Ramassable)
                    p.add((Ramassable)terrain[i][j]);
            }
        }
    }
}