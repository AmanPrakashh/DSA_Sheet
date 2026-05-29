package Arrays;

import basicMath.CheckPrime;

import java.util.*;

public class BasicRecursion {


    public static int factorial(int n)
    {
        if(n==1 || n==0)
        {
            return n;
        }
        else {
            return n*factorial(n-1);
        }
    }

    public static boolean isPalindrome(String str, int start, int end) {
        if (str.length() == 1) return true;

        if (start >= end) return true;

        if (str.charAt(start) != str.charAt(end)) return false;

        return isPalindrome(str, start + 1, end - 1);
    }

//
//    public static void main(String[] args) {
//        System.out.println(factorial(6));
//
//        String str=new String("alua");
//        int n =str.length();
//        boolean palindrome = isPalindrome(str, 0, n - 1);
//        System.out.println(palindrome);
//    }


    static char secondNonRepeatingChar(String str)
    {
        if(str.length()<2){
            return 0;
        }
        Map<Character, Integer> map = new LinkedHashMap<>();

        for(char c : str.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        int count=0;
        for(char c : str.toCharArray()){
            if(map.get(c)==1){
                count++;
                if(count==2)
                return c;
            }
        }

        return 0;
    }

    public static List<Integer> returnDuplicate(List<Integer>list)
    {

        // base case
        if (list.isEmpty()) return null;
        Map<Integer, Integer> map =new  HashMap <>();
        List<Integer> returnArray = new ArrayList<>();

        for(int num : list) {
            if (map.containsKey(num)) {
                if (returnArray.contains(num)) {
                } else {
                    returnArray.add(num);
                }
            }
            map.put(num, 1);
        }
        return returnArray;
    }





    public static void main(String[] arg){

    }
}
