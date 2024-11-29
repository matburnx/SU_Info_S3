public class TrianglePascal {
    private int[][] triangle;

    public TrianglePascal(int n) {
        triangle=new int[n][];
        for(int i=0; i<triangle.length; i++) {
            triangle[i] = new int[i+1];
        }
    }

    public void remplirTriangle() {
        for(int i=0; i<triangle.length; i++) {
            for(int j=0; j<=i; j++) {
                if(j==0 || j==i) {
                    triangle[i][j]=1;
                } else {
                    triangle[i][j]=triangle[i-1][j-1]+triangle[i-1][j];
                }
            }
        }
    }

    public String toString() {
        String s="";
        for(int[] l:triangle) {
            for(int c:l) {
                s=s+c+" ";
            }
            s=s+"\n";
        }
        return s;
    }
}
