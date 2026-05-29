package arraysEasy;

public class SecondLargestElement {


    static int secondLargest(int arr[]) {
        if (arr.length < 2) {
            return -1;
        }
        int largest = Integer.MIN_VALUE;
        int secondLargst = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                secondLargst = largest;
                largest = arr[i];
            }
            if (arr[i] > secondLargst && arr[i] < largest) {
                secondLargst = arr[i];
            }
        }
        return secondLargst;
    }

    public static void main(String[] args) {
        int[] arr = {3, 25, 55, 1, 2, 73, 72};
        System.out.println(secondLargest(arr));
    }
}
