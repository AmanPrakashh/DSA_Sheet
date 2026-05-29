package Arrays;
class Solution {
    public int maxSubArray(int[] nums) {

        int maxSum=0;
        int currSum=nums[0];
        for(int i=1; i<nums.length; i++)
        {
            if(currSum>=0)
            {
                currSum+=nums[i];
                if(maxSum<currSum) maxSum=currSum;
            }
        else{
            currSum=nums[i];
            if(maxSum<currSum) maxSum=currSum;
        }
        }
            return maxSum;
    }
}
