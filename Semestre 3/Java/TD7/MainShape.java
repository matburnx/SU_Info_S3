public class MainShape {
    public static void main(String[] args) {
        Circle c1 = new Circle(1,2,3);
        Circle c2 = new Circle();
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle(9,7,2,3);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(r1.toString());
        System.out.println(r2.toString());
    }
}
