public class Boa extends SansPattes {
    public Boa(int age, String name) {
        super(age, name);
    }

    public String toString() {
        return "Serpent : "+super.toString();
    }

    public void crier() {
        System.out.println("Sss");
    }
}
