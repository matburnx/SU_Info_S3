public class TestLettre {
	public static void main(String[] args) {
		for(char letter = 'a' ; (int)letter<=(int)'z' ; letter++) {
			Lettre car = new Lettre(letter);
			if((car.getCodeAscii()-96)%5==0)
				System.out.println(car.getCarac() + " ");
			else
				System.out.print(car.getCarac()+ " ");
		}
		System.out.println();
	}
}
