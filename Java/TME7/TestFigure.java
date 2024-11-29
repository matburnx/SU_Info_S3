public class TestFigure {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(3, 4);
        Carre car = new Carre(5);
        Ellipse e = new Ellipse(4, 3);
        Cercle cer = new Cercle(10);
        Figure2D[] fig = {r,car,e,cer};
        for(Figure2D f : fig) {
            System.out.println("Surface : "+f.surface());
            System.out.println("Perimetre : "+f.perimetre());
        }
    }
}
