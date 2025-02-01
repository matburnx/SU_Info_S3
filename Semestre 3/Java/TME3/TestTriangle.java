public class TestTriangle {
    public static void main(String[] args) {
        Point p1 = new Point(3,5);
        Point p2 = new Point();

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p1.distance(p2));

        Point p3 = new Point(1,4);

        Triangle t1 = new Triangle(p1,p2,p3);

        System.out.println(t1.toString());
        System.out.println(t1.getPerimetre());

        Triangle t2 = new Triangle(t1);
        System.out.println(t2.toString());
        System.out.println(t2.getPerimetre());
        p1.deplaceToi(5, 3);

        System.out.println(t1.toString());
        System.out.println(t2.toString());
    }
}
