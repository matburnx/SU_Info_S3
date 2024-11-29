import javax.security.auth.callback.Callback;

public class TestTracteur {
    public static void main(String[] args) {
        Roue gr1 = new Roue(120);
        Roue gr2 = new Roue(120);
        Roue pr1 = new Roue();
        Roue pr2 = new Roue();

        Cabine cab = new Cabine(3, "bleue");

        Tracteur t1 = new Tracteur(cab,pr1,pr2,gr1,gr2);
        Tracteur t2 = new Tracteur(t1);

        t2.peindre("rouge");

        System.out.println(t1.toString());
        System.out.println(t2.toString());
    }
}
