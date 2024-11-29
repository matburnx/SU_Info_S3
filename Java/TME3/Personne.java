public class Personne {
    private String nom;
    private Personne conjoint;

    public Personne(String nom) {
        this.nom = nom;
        conjoint = null;
    }

    public Personne() {
        this("Pers"+(char)(Math.random()*('Z'-'A'+1)+'A'));
    }

    public String toString() {
        String s = nom + ", ";
        if(conjoint!=null)
            s+="marié(e)";
        else
            s+="célibataire";
        return s;
    }

    public void epouser(Personne p) {
        if (this.conjoint!=null || p==null || p.conjoint!=null || p.nom==this.nom) {
            System.out.println(this.toString()+" se marie avec "+p.toString()+", mariage impossible");
        } else {
            System.out.println(this.toString()+" se marie avec "+p.toString());
            this.conjoint=p;
            p.conjoint=this;
        }
    }

    public void divorcer() {
        if(this.conjoint!=null) {
            System.out.println(this.toString()+" divorce de "+this.conjoint.toString());
            this.conjoint.conjoint=null;
            this.conjoint=null;
        } else {
            System.out.println(this.toString()+" divorce impossible");
        }
    }
}
