public class TestPoint {
  public static void main(String[] args) {
    int[] t1 = new int[3];
    t1[0]=1;
    t1[1]=2;
    t1[2]=3;
    int[]t2={1,2,3};

    int[][]t3=new int[2][3];
    t3[0][0]=4;
    t3[0][1]=5;
    t3[0][2]=6;
    int[][]t4={{4,5,6},{7,8,9}};

    double[] tabD = new double[10];
    for(int k=0; k<tabD.length;k++)
      tabD[k]=Math.random()*10;

    Point[] tabP = new Point[10];
    for(int j = 0; j<10;j++) {
      tabP[j]= new Point();
    }
    for(Point p:tabP) {
      System.out.println(p.toString());
    }
    int[] t5 = {1,2,3};
    int[] t6 = {1,2,3};
    int[] t7 = t1;
    System.out.println(t5==t6);
    System.out.println(t5==t7);

    int[][] triangle = new int[3][];
    for(int n=0; n<triangle.length; n++){
      triangle[n] = new int[n+1];
      for(int m=0; m<=n; m++) {
        triangle[n][m]=n+1;
      }
    }

    for(int[] l:triangle) {
      for(int c:l) {
        System.out.print(c+"\t");
      }
      System.out.println();
    }
  }
}
