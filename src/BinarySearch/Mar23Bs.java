package BinarySearch;

public class Mar23Bs {

   int  searchInXSortedArrayIterative(int arr[], int target){
       int low=0;
       int high=arr.length-1;

       while(low<=high){

        int mid=low+(high-low)/2;
        if(arr[mid]==target) return mid;
        else if(arr[mid]>target) high= mid-1;
        else low= mid+1;

       }
       return -1;
   }

    int searchInXSortedArrayRecursion(int arr[], int target, int low, int high){
       if(low>high) return -1;
       int mid= low+(high-low)/2;

       if(arr[mid]==target) return mid;
       else if(target>mid){
           return  searchInXSortedArrayRecursion(arr, target,mid+1, high);
       }
       else return searchInXSortedArrayRecursion(arr, target,low, mid-1);
    }



}
