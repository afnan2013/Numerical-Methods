import java.util.Scanner;

public class Main_method {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);

        double[][] matrix;
        double[] b;

        while(true) {

            System.out.println("Number of Unknowns :");                  //input the system of equations
            int n = sc.nextInt();
            matrix = new double[n][n];
            b = new double[n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextDouble();
                }
                b[i] = sc.nextDouble();
            }                                                                                                    //


            System.out.println("\nChoose which method you want to apply : \n1.Naive Gauss\n2.Gauss Jordan\n3.Gauss Seidal\n");

            int choice = sc.nextInt();

            //NaiveGauss_Elimination
            if (choice == 1) {
                NaiveGauss_Elimination nge_object = new NaiveGauss_Elimination(matrix, b);
                double[] x = nge_object.solvemethod();
                System.out.println();
                for (int i = 0; i < n; i++) {
                    System.out.printf("x[%d] = %.6f\n", i + 1, x[i]);
                }
            }

            //GaussJordan_Elimination
            else if (choice == 2) {
                GaussJordan_Elimination gje_object = new GaussJordan_Elimination(matrix, b);
                double[] x = gje_object.Gauss_Jordan_method();
                System.out.println();
                for (int i = 0; i < n; i++) {
                    System.out.printf("x[%d] = %.6f\n", i + 1, x[i]);
                }
            }

            //GaussSeidal_Elimination
            else if (choice == 3) {
                System.out.println("Enter the Error Criterion Es % : ");
                double epsilon = sc.nextDouble();
                GaussSeidal_Method gsm_object = new GaussSeidal_Method(matrix, b);
                double[] x = gsm_object.solve_method(epsilon);

            }

            else{
                System.out.println("Invalid Input.. Please choose a correct option....");
            }
            System.out.println();

        }
    }
}
