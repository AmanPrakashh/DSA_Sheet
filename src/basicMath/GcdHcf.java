package basicMath;

public class GcdHcf {
    static int brute(int n, int m)
    {
        int gcd=0;
        for(int i=1;i<Math.min(n,m); i++)
        {
            if(n%i==0&&m%i==0)
            {
                gcd=i;            }
        }
        return gcd;
    }



    //using Euclidean Algorithm
    //idea is we divide the greater one with smaller and the
    // remainder will become the one which got divided.
   static int optimal(int a , int  b)
   {
       while(a>0  && b>0) {
           if(a>b) a=a%b;
           else b=b%a;
       }
       if(a==0) return b;
       return a;
   }
}
