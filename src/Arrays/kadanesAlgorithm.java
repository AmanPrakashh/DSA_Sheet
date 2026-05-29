package Arrays;

import java.util.*;

public class kadanesAlgorithm {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> returnList= new ArrayList<>();
        List<Integer> l1= new ArrayList();
        l1.add(1);
        List<Integer> l2= new ArrayList();
        l2.add(1);
        l2.add(1);

        for(int i=3; i<numRows+1; i++)
        {
            List<Integer> list=getbyRowNumber(i);
            returnList.add(list);
        }
        return returnList;
    }

    public static List<Integer> getbyRowNumber(int n) {
        List<Integer> row = new ArrayList<>();
        int val = 1;
        for (int i = 0; i <= n; i++) {
            row.add(val);
            val = val * (n - i) / (i + 1);
        }
        return row;
    }


    public int[][] merge(int[][] intervals) {

        if(intervals.length==0 || intervals==null) return new int[0][];

        Arrays.sort(intervals, (a, b)->Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];


        for(int i=1; i<intervals.length; i++)
        {
            if(intervals[i][0]<current[1])
            {
                current[1]=intervals[i][1];
            }
            else{
                merged.add(current);
                current=intervals[0];
            }
        }
        int[][] array = merged.toArray(new int[0][]);
        return array;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix[0].length;
        for(int i=0; i<matrix.length; i++)
        {
            if(matrix[i].length>=0 && target>=matrix[i][0] && target<=matrix[i][n-1]){
                if(Arrays.binarySearch(matrix[i], target)>=0)return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        lengthOfLongestSubstring("abba");
    }




    public static int lengthOfLongestSubstring(String s) {
        int max=0;
        HashMap<Character, Integer> map = new HashMap<>();
        int j=0;

        for(int i=0; i<s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                j= map.get(s.charAt(i))+1;
            }
            map.put(s.charAt(i), i);
            max= Math.max(max, i-j+1);
        }

        return max;
    }




    class Item{
        private int val;
        private int wt;

        public Item(int val, int wt)
        {
            this.val=val;
            this.wt= wt;
        }

        public int getVal()
        {
            return val;
        }
        public int getWt()
        {
            return wt;
        }
    }



    class Solution {
        // Function to get the maximum total value in the knapsack.
        double fractionalKnapsack(List<Integer> val, List<Integer> wt, int capacity) {

            List<Item> items= new ArrayList<>();

            for(int i=0; i<val.size(); i++)
            {
                Item item= new Item(val.get(i), wt.get(i));
                items.add(item);
            }

            Collections.sort(items, (i1, i2)->Double.compare((double)i1.getVal()/i1.getWt(),(double)i2.getVal()/i2.getWt()));
            double value=0;
            for(Item item: items)
            {
                if(item.getWt()<capacity)
                {
                    value+=item.getVal();
                    capacity-=item.getWt();
                }
                else{
                    value+=capacity*((double)item.getWt()/item.getVal());
                    break;
                }
            }
            return value;
        }
    }
}
