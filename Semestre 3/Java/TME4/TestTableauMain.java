public class TestTableauMain {
    public static void main(String[] args) {
        System.out.println("Il y a "+args.length+" arguments");
        
        for(int i=0; i<args.length; i++) {
            System.out.println("args["+i+"]="+args[i]);
        }
    }
}