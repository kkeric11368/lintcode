//Given an array of integers, 
//find how many pairs in the array such that their sum is bigger than a specific target number. 
//Please return the number of pairs.

//Example
//Given numbers = [2, 7, 11, 15], target = 24. Return 1. (11 + 15 is the only pair)

//Challenge
//Do it in O(1) extra space and O(nlogn) time.


    public int twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        
        Arrays.sort(nums);
        
        int counter = 0;
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right){
            if (nums[left] + nums[right] <= target){
                left++;
            }
            else {
                counter += right - left;
                right--;
            }
        }
        
        return counter;        
    }
    
    
