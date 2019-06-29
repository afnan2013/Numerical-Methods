public class GaussJordan_Elimination {
    private double[][] A;
    private double[] b;

    public GaussJordan_Elimination(double[][] A, double[] b){          //constructor
        if(A == null || b == null)
            throw new NullPointerException();
        if(A.length != b.length)
            throw new IllegalArgumentException();
        this.A = A;
        this.b = b;                                                                   //
    }
    public double[] Gauss_Jordan_method(){
        double[][] temp = this.A;

        double pivot,factor;
        int n = b.length;

        for(int i=0; i<n; i++){
            pivot = temp[i][i];

            for(int j=0; j<n; j++){
              temp[i][j] = temp[i][j]/pivot;
            }
            b[i] = b[i]/pivot;

            for(int k=0; k<n;k++){
               if(k != i){
                   factor = temp[k][i];
                   for(int j=0; j<n; j++){
                       temp[k][j] = temp[k][j] - factor*temp[i][j];
                   }
                   b[k] = b[k] - factor*b[i];
               }
            }
        }
        for(int i=0; i<n; i++){                                                                             // identity matrix check
            for(int j=0; j<n; j++){
                double identity = Math.abs(temp[i][j]);
                System.out.print(identity+"    ");
            }
            System.out.print("\n");
        }
        return b;
    }
}
