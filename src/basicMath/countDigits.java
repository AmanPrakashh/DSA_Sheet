package basicMath;

public class countDigits {

    //brute force is to  divide the number and increase count until number<0
    public static int countDigitBrute(int n)
    {   int count=0;
        while(n>0) {
            count++;
            n=n/10;
        }
        return count;
    }

    //chad way of doing the same is to find log base 10 of the number

    static int countDigitChad(int n) {
        return  (int) (Math.log10(n) + 1); }

    public static void main(String[] args) {
        System.out.println(countDigitBrute(100));
        System.out.println(countDigitChad(1000));
    }
}
