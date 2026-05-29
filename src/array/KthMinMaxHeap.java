package array;

import java.util.*;

public class KthMinMaxHeap {
//    public static void main(String[] args) {
//        int[] arr = {12, 5, 7, 25, 3, 19};
//        int k = 3;
//
//        // Kth Minimum using Max Heap
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
//        for (int num : arr) {
//            maxHeap.add(num);
//            if (maxHeap.size() > k) {
//                maxHeap.poll();
//            }
//        }
//        int kthMin = maxHeap.peek();
//
//        // Kth Maximum using Min Heap
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        for (int num : arr) {
//            minHeap.add(num);
//            if (minHeap.size() > k) {
//                minHeap.poll();
//            }
//        }
//        int kthMax = minHeap.peek();
//
//        System.out.println(k + "th Minimum element: " + kthMin);
//        System.out.println(k + "th Maximum element: " + kthMax);
//    }


//    public static void main(String[] args) {
//        dutchNationalFlag(new int [] {2, 1, 0, 0, 1, 1, 0});
//    }

    public static void dutchNationalFlag(int [] arr)
    {
        int low=0;
        int mid=0;
        int high= arr.length-1;


        while (mid < high) {
            if (arr[mid] == 0) {
                arr[mid] = arr[low];
                arr[low] = 0;
                low++;
                mid++;
            }
            if (arr[mid] == 1) mid++;


            if (arr[mid] == 2) {
                arr[mid] = arr[high];
                arr[high] = 2;
                high--;
            }
        }
        System.out.println(Arrays.toString(arr));
    }



    static char secondNonRepeatingChar(String str)
    {
        int [] freq = new int[26];

        for(char c : str.toCharArray()) {
            if(c!=' '){freq[c-'a']++;}}
        int count=0;
        for(int i=0; i<str.length(); i++) {
            if (str.charAt(i) != ' ') {
                if (freq[str.charAt(i) - 'a'] == 1) {
                    count++;
                    if (count == 2) {
                        return str.charAt(i);
                    }
                }
            }
        }
        return 0;

    }


    public static void main(String[] args) {
        System.out.println( secondNonRepeatingChar("today is my interview"));
    }
}
