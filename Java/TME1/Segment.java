public class Segment {
    int x, y;
    public Segment(int extX, int extY) {
        x=extX;
	y=extY;
    }

    public int longueur() {
        if(x<y)
	    return y-x;
	else
	    return x-y;
    }

    public String toString() {
        String s = "Segment [ "+ x +", " + y + " ]";
	return s;
    }
}
