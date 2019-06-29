public class GaussSeidal_Method {

    private double[][] A;
    private double[] b;

    public GaussSeidal_Method(double[][] A, double[] b){          //constructor
        if(A == null || b == null)
            throw new NullPointerException();
        if(A.length != b.length)
            throw new IllegalArgumentException();
        this.A = A;
        this.b = b;                                                                   //
    }

    public double[] solve_method(double epsilon){          //solving method----------------------------------------
        int n = A.length;

        double[] x = new double[n];                                         //temporary values of x assign to 0
        for(int i=0; i< n; i++) {
            x[i] = 0;
        }                                                                                         //

        int loopcount =0;
        double[] temp_x = new double[n];
        double[] EaList = new double[n];

        while(true) {                                   //total iteration starts
            loopcount++;
            //x1,x2,x3 calculation
            for (int i = 0; i < n; i++) {
                double sum = 0;

                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        sum += A[i][j] * x[j];
                    }
                }
                x[i] = (b[i] - sum) / A[i][i];
             //

                if(loopcount==1) {                    //first values of x1,x2,x3
                    temp_x[i] = x[i];
                }
                else if(loopcount > 1){
                    EaList[i] = EaCalculate(x[i],temp_x[i]);
                    temp_x[i] = x[i];
                }

            }

            if(loopcount ==1) {                                            //for only the first row whre Ea doesnt exist
                for (int i = 0; i < n; i++) {
                    System.out.printf("x[%d] = %.6f       ", i + 1, x[i]);
                }
            }
            else{
                for (int i = 0; i < n; i++) {                                                        //print the x1,x2,x3 values
                    System.out.printf("x[%d] = %.6f       ", i + 1, x[i]);
                }
                for (int i = 0; i < n; i++) {                                                         // print the Ea values of x1,x2,x3
                    System.out.printf("Ea_x[%d] = %.6f       ", i + 1, EaList[i]);
                }

                int count =0;                                                       //loop break checking
                for(int k =0; k<n; k++){
                    if(EaList[k]<epsilon)
                        count++;
                }
                if(count>=3) {
                    break;
                }
            }
            System.out.println();

        }
        return x;
    }

    private double EaCalculate(double now, double old){
        return Math.abs(((now-old)/now)*100);
    }

}
