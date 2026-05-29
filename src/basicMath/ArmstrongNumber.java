package basicMath;

public class ArmstrongNumber {
    static boolean armstrongNumber(int n)
    {
        int copyOfN=n;
        int target=0;
        int i = String.valueOf(n).length();
        while(n>0)
        {
            int rem= n%10;
            int pow =(int)Math.pow(rem, i);
            target+=pow;
            n=n/10;

        }
        if(target==copyOfN)
        {
            return true;
        }
        return false;
    }


    // this can also be used instead of String.valueOf(n).length();
  static int giveNumberOfDigit(int n)
  {
      int total=0;
      while(n>0)
      {
          total++;
          n=n/10;
      }

      return total;
  }

    public static void main(String[] args) {
        System.out.println(armstrongNumber(153));
    }
}
