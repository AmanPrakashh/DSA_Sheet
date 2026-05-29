package Arrays;

import java.util.Arrays;

public class sorting1 {

    public static int[] selectionSort(int arr[]) {
        //you select the first element and replace it with the smallest element in the array

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }


    public static int [] insertionSort(int arr[])
    {
        for(int i=1; i<arr.length; i++) {
            for(int j=i-1; j<0; j--) {
                if(arr[j]>arr[j+1]);
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
        return arr;
    }


    public static int[] bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }


        public static void main (String[]args){
            int[] ar = {4, 5, 2, 10, 19};
            int[] ar1 = insertionSort(ar);
            Arrays.stream(ar1).forEach(System.out::println);
        }

    }