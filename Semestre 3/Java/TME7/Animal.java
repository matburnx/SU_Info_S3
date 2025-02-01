public abstract class Animal {
    protected String name;
    protected int age;

    public Animal(int age, String name) {
        this.age=age;
        this.name=name;
    }

    public Animal(String name) {
        this(1,name);
    }

    public String toString() {
        return "Age : "+age+" Nom : "+name;
    }

    public abstract void crier();
    
    public void vieillir() {
        this.age++;
    }
}
