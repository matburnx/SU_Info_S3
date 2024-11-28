public class TestTruc {
    public static void main(String[] args) {
        Truc t1 = new Truc();
        Truc t2 = t1;
        Truc[] tabA = new Truc[3];
        tabA[0] = new Truc();
        tabA[1] = t1;
        tabA[2] = t2;
        Truc[] tabB = tabA;
        Truc t3 = tabB[2];
    }
}
