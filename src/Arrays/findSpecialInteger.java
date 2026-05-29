package Arrays;


//find if a number appeared more than 25 percent
public class findSpecialInteger {
    public int findSpecialInteger(int[] arr) {

        int n=arr.length;
        int threshold=n/4;
        int count=1;

        if(n==1)
        {
            return arr[0];
        }

        for(int i=1; i<n; i++)
        {
            if(arr[i]==arr[i-1])
            {
                count++;
                if(count>threshold)
                {
                    return arr[i];
                }
            }
            else
            {
                count=1;
            }
        }
        return 0;
    }
}
