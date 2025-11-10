import java.util.Scanner;

public class A1_Fib {

    public static int FibRecursive(int n){
        if(n<=1){
            return n;
        }else{
            return FibRecursive(n-1)+FibRecursive(n-2);
        }
    }

    public static void FibIterative(int n){
        int a = 0, b = 1, c;
        System.out.print(a + " " + b + " ");
        for(int i = 2; i<n; i++){
            c=a+b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number of terms for fibbonacci seris: ");
        int n = sc.nextInt();

        //int n = 10;

        System.out.println("---Fibbonacci Non-Recursive-------");
        FibIterative(n);

        System.out.println("----Fibbonacci Recursive-----------");
        for(int i=0; i<n; i++){
            System.out.print(FibRecursive(i) + " ");
        }
        System.out.println();
    }
}
