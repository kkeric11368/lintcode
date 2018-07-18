//Say you have an array for which the ith element is the price of a given stock on day i.

//Design an algorithm to find the maximum profit. You may complete at most two transactions.

//You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

//Example
//Given an example [4,4,6,1,1,4,2,5], return 6.



    public int maxProfit(int[] prices) {
        int buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int price : prices) {
            buy1 = buy1 > -price ? buy1 : -price;
            sell1 = sell1 > buy1 + price ? sell1 : buy1 + price;
            buy2 = buy2 > sell1 - price ? buy2 : sell1 - price;
            sell2 = sell2 > buy2 + price ? sell2 : buy2 + price;
        }
        return sell2;
    }
    
    
    
    
