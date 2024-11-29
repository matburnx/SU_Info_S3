public class TestVillageois {
    public static void main(String[] args) {
        Villageois v1 = new Villageois("Eric");
		Villageois v2 = new Villageois("Marinne");
		Villageois v3 = new Villageois("Jordane");
		Villageois v4 = new Villageois("Jean-Marie");
		
		System.out.println(v1.toString());
		System.out.println(v2.toString());
		System.out.println(v3.toString());
		System.out.println(v4.toString());

		System.out.println(v1.getNom() + " " + v1.getPoids() + " " + v1.getMalade());
		System.out.println(v2.getNom() + " " + v2.getPoids() + " " + v2.getMalade());
		System.out.println(v3.getNom() + " " + v3.getPoids() + " " + v3.getMalade());
		System.out.println(v4.getNom() + " " + v4.getPoids() + " " + v4.getMalade());
		
		double poidsTotal = v1.poidsSouleve() + v2.poidsSouleve() + v3.poidsSouleve() + v4.poidsSouleve();
		if(poidsTotal>100.0)
			System.out.println("Les villageois peuvent soulever le rocher.");
		else
			System.out.println("Les villageois ne peuvent pas soulever le rocher.");
    }
}
