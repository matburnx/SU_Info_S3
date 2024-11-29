public class Assiette {
    private int diametre;
    
    public Assiette(int d) {
        this.diametre = d;
    }

    public Assiette() {
        this(26);
    }

    public String toString() {
        String s = "Assiette "+diametre+" cm";
        return s;
    }
}
