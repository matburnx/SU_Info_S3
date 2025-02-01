public abstract class SansPattes extends Animal {
    public SansPattes(int age, String name) {
        super(age, name);
    }

    public String toString() {
        return super.toString()+" sans pattes";
    }

    public abstract void crier();
}
