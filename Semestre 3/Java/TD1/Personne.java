public class Personne {
    private int age;
    private String nom;

    public Personne(String n, int a) {
        nom=n;
        age=a;
    }

    public int getAge() {
	return age;
    }

    public String toString() {
        String s = "Je m'appelle " + nom + ", j'ai " + age + " ans";
        return s;
    }

    private void sePresenter() {
	System.out.println(this.toString());
    }

    public void vieillir() {
        age++;
    }

}
