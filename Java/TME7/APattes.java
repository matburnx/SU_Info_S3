public abstract class APattes extends Animal {
    protected int nbPattes;

    public APattes(int age, String name) {
        super(age,name);
    }

    public APattes(String name) {
        super(name);
    }

    public String toString() {
        return super.toString()+" Pattes : "+nbPattes;
    }

    public abstract void crier();
}
