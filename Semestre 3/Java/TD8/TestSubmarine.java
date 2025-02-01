public class TestSubmarine {
    public static void main(String[] args) {
        Ocean o = new Ocean();
        o.subs.add(new Merlu());
        o.subs.add(new Dauphin());
        o.subs.add(new SousMarin());
        o.subs.add(new ChatSub());
        for(Submarine s : o.subs) {
            s.seDeplacer();
        }
    }
}
