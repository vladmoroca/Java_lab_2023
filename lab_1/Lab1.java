import java.util.Scanner;

public class Lab1 {
    /* 
    variant 1121
    C2 = 1
    O1 = -
    С  = C3 = 2
    С5 = 1
    О2 = /
    С7 = 4
    i,j = short
    */
    
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a: ");
        short a = scanner.nextShort();
        System.out.print("Enter n: ");
        short n = scanner.nextShort();
        if(n <= a) throw new Exception("n must be greater than a");
        System.out.print("Enter b: ");
        short b = scanner.nextShort();
        System.out.print("Enter m: ");
        short m = scanner.nextShort();
        if(m <= b) throw new Exception("m must be greater than b");
        double result = Lab1.calculate(a,n,b,m);
        System.out.println("S: " + (result != 0 ? result : "S is Undefined"));
    }
        
    private static double calculate(int a, int n, int b, int m){
        final int C = 2;

        double S = 0;
        loop:
        for (int i = a; i <= n; i++) {
            for (int j = b; j <= m; j++) {
                if((i - C) == 0 || j == 0){
                    System.out.println("Error: division by zero");
                    S = 0;
                    break loop;
                } else {
                    S += ((double) i / j) / (i - C);
                }
            }
        }
        return S;
    }
}