package basicRecursion;

public class Factorial {

  static int factorial(int n)
    {
        if(n>2)
        {
            return factorial(n-1)*n;
        }
        return n;
    }
    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
