package basicMath;

import java.util.*;
import java.util.stream.Collectors;

public class ReverseNumber {


    public static void main(String[] args) {
//        List<Integer> arr = new ArrayList<>();
//        arr.add(1);
//        arr.add(2);
//        arr.add(3);
//        arr.add(4);
//        arr.add(5);
//
//        List<Integer> test = test(arr, 1);
//        System.out.println(test);

//
//        stream(Arrays.asList("Aman", "Ankit", null,"Ramesh", null));
        //Character character = word("characterrr");

       // System.out.println(character);
      //  System.out.println( sum(5));
      //  System.out.println(reverse(new int []{1, 2, 3,4,5}, 0, 4));


//       int arr[]= reverse(new int []{1, 2, 3,4,5}, 0, 4);
//       for(int num: arr)
//       {
//           System.out.print(num+" ");
//       }



//        int arr[]= reverse1(new int []{1, 2, 3,4,5}, 0);
//        for(int num: arr)
//        {
//            System.out.print(num+" ");
//        }


     //   System.out.println(checkPalindromRecursion("racecar",0));

       // System.out.println(  fibonachiUsingRecursion(8));

//        for(int i=0; i<=9; i++)
//        {
//            System.out.println(fibonachiUsingRecursion(i));
//        }

        int [] arr={1, 2, 3};
        List<Integer> current= new ArrayList<Integer>();
        printAllSubsequenceUsingRecursion(arr, 0, current);

    }

    public static List<Integer> test(List<Integer> arr ,int target)
    {
        List<Integer> returningList = new ArrayList<>();
        for(int i=target+1; i<arr.size(); i++) {
            returningList.add(arr.get(i));
        }
        for(int i=0; i<target+1; i++)
        {
            returningList.add(arr.get(i));
        }
        return returningList;
    }


    public static List<String> stream(List<String> list)
    {
        List<String> collect = list.stream().filter(l -> l != null).collect(Collectors.toList());
        List<String> collect1 = list.stream().filter(l -> l == null).collect(Collectors.toList());
        collect1.addAll(collect);
        System.out.println(collect1);
        return collect1;


    }

    public static Character word(String arr)
    {
        List<Character> reserve1 =  new ArrayList<Character>();
        List<Character> reserve2 =  new ArrayList<Character>();
        for(int i=0; i<arr.length(); i++)
        {
            if(reserve1.contains(arr.charAt(i)) || reserve2.contains(arr.charAt(i)))
            {
                reserve1.remove((Character)arr.charAt(i));
                reserve2.add(arr.charAt(i));
            }
            else {
             reserve1.add(arr.charAt(i));
            }
        }
        return reserve1.get(0);
    }


    public static int sum(int n)
    {

        if(n>1)
        {
           return  n+sum(n-1);
        }
        return 0;
    }


    public static int[] reverse(int arr[], int l, int r)
    {
        if(l<r)
        {
            int temp= arr[l];
             arr[l]= arr[r];
             arr[r]=temp;
         return reverse(arr, ++l, --r);
        }
        else{
            return arr;
        }
    }

    public static int[] reverse1(int arr[], int l)
    {
      if(l<arr.length-1-l)
      {
          int temp= l;
           arr[l]= arr[arr.length-1-l];
           arr[arr.length-l-1]=l;
           return reverse1(arr, ++l);
      }
      else {
          return arr;
      }
    }

    public static boolean checkPalindromRecursion(String str, int l)
    {
        if(l<str.length())
        {
            if(str.charAt(l)!=str.charAt(str.length()-l-1)) return false;
            else{
                return checkPalindromRecursion(str, ++l);
            }
        }
        return true;
    }

    public static int fibonachiUsingRecursion(int num)
    {
        if(num==0) return 0;
        if(num==1) return 1;
        else return fibonachiUsingRecursion(num-1)+fibonachiUsingRecursion(num-2);

    }

//    public static void printAllSubsequenceUsingRecursion(int [] arr, int index, List<Integer> current)
//    {
//        if(index==arr.length){
//            System.out.println(current);
//            return;
//        }
//        printAllSubsequenceUsingRecursion(arr, index+1, current);
//        current.add(arr[index]);
//        printAllSubsequenceUsingRecursion(arr, index+1, current);
//
//    }




    public static void printAllSubsequenceUsingRecursion(int[] arr, int index, List<Integer> current) {
        if (index == arr.length) {
            System.out.println(current);
            return;
        }

        printAllSubsequenceUsingRecursion(arr, index + 1, current);
        current.add(arr[index]);
        printAllSubsequenceUsingRecursion(arr, index + 1, current);

        // Backtrack: remove last added element
        current.remove(current.size() - 1);
    }





}

