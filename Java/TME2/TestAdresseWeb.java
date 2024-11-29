public class TestAdresseWeb {
    public static void main(String[] args) {
        AdresseWeb addr1 = new AdresseWeb("example.com");
        AdresseWeb addr2 = new AdresseWeb("wikipedia.fr","/mentions-legales/");
        AdresseWeb addr3 = new AdresseWeb("https","google.com","/maps");
        // 13.2 La surcharge permet de creer un objet en ayant des valeurs par défaut
        // Utiliser this() limite la duplication de code
        System.out.println(addr1.toString());
        System.out.println(addr2.toString());
        System.out.println(addr3.toString());
    }
}
