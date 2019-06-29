public class NaiveGauss_Elimination {

    private double[][] A;
    private double[] b;

    public NaiveGauss_Elimination(double[][] A, double[] b){               //constructor
        if( A == null || b == null)
            throw new NullPointerException();
        if( A.length != b.length)
            throw  new IllegalArgumentException();
        this.A = A;
        this.b = b;
    }                                                                           //

    public double[] solvemethod(){                        //solving method----------------------------------------------
        int n = A.length;
        double pivot, factor;

        for( int i =0; i<n ; i++) {

            pivot = A[i][i];
            for (int j = 0; j < n; j++) {
                A[i][j] /= pivot;
            }
            b[i] /= pivot;

            for (int k = 0; k < n; k++) {
                if (k != i && k > i) {
                    factor = A[k][i];
                    for (int j = 0; j < n; j++) {
                        A[k][j] -= factor * A[i][j];
                    }
                    b[k] -= factor * b[i];
                }
            }
        }

        for(int i=0; i<n; i++){                                                    //print the co effiecients of X as matrix
            for(int j=0; j<n; j++) {
                System.out.printf("%.3f      ", A[i][j]);
            }
            System.out.println();
        }                                                                                       //

        double[] x = new double[n];                                       //initialise the values of x1,x2,x3 =0
        for(int i=0; i<n; i++){
            x[i]=0;
        }                                                                               //

        int m = n-1;                                                          //calculate the values of x1,x2,x3
        for( int i=m ; i>=0; i--){
            double sum = 0;
            for(int j=m; j >=0; j--){
                if( i != j && j > i){
                    sum += A[i][j]*x[j];
                }
            }
            x[i] = (b[i] - sum)/ A[i][i];
        }                                                                               //
        return  x;
        }

}
