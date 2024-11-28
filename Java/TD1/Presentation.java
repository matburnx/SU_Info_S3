public class Presentation {
    public static void main(String[] args) {
        Personne p1 = new Personne("Paul",25);
        Personne p2 = new Personne("Pierre",37);
        System.out.println(p1.getAge());
	for (int i = 0; i<10 ; i++) {
	    p1.vieillir();
	    p2.vieillir();
	}

	for (int j = 0; j<10 ; j++) {
	    p1.vieillir();
	}

	System.out.println(p1.getAge());
	System.out.println(p2.getAge());
    }
}
