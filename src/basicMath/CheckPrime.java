package basicMath;

public class CheckPrime {
    static boolean isPrime(int n) {
        int cnt = 0;

        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                cnt++;
                if (n / i != i) {
                    cnt = cnt + 1;
                }
            }
        }
        if (cnt == 2) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(17));
    }
}
