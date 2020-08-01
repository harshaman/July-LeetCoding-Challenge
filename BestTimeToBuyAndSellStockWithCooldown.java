/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]
*/

class Solution {
    public int maxProfit(int[] prices) {
        int l =prices.length;
        
        if(l<=1)
            return 0;
        if(l==2){
            return Math.max(0,prices[1]-prices[0]);
        }
        int b=0,s=-prices[0], c=0;

        for(int i =1; i<l;++i){
            int yest = c;
            c = s + prices[i];
            s = Math.max(b - prices[i], s);
            b = Math.max(b, yest);
        }
        return Math.max(b,c);
    }
}
