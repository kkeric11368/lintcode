//Using O(1) time to check whether an integer n is a power of 2.

//Example
//For n=4, return true;
//
//For n=5, return false;

//Challenge
//O(1) time



public class Solution {
    public boolean checkPowerOf2(int n) {
        return (n & (n - 1)) == 0 && n > 0;
    }
}



