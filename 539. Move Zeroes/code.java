//Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

//Example
//Given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].


    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        
        int left = 0;
        int right = 0;
        while (right < nums.length){
            if (nums[right] == 0){
                right++;
            }
            else {
                nums[left] = nums[right];
                right++;
                left++;
            }
        }
        for (int i  = left; i < nums.length; i++){
            nums[i] = 0;
        }
    }
    
    
