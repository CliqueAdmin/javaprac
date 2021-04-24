package practise.peakandvalley;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in
 * the future to sell that stock.
 * <p>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return
 * 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: prices = [7,1,5,3,6,4] Output: 5 Explanation: Buy on day 2 (price = 1) and sell on day 5 (price =
 * 6), profit = 6-1 = 5. Note that buying on day 2 and selling on day 1 is not allowed because you must buy
 * before you sell. Example 2:
 * <p>
 * Input: prices = [7,6,4,3,1] Output: 0 Explanation: In this case, no transactions are done and the max
 * profit = 0.
 */
public class BestTimeStock {

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr = {7, 1, 0};
    int profit = solution.maxProfitToBuyAndSellStock(arr);
    System.out.println("profit = " + profit);
  }
}

class Solution {

  public int maxProfitToBuyAndSellStock(int[] prices) {
    if (prices.length == 1) {
      return 0;
    }
    int buyingIndex = 0;
    int maxProfit = -1 * Integer.MAX_VALUE; //-100
    while (buyingIndex < prices.length - 1) {
      int sellingIndex = buyingIndex + 1;
      while (sellingIndex < prices.length) {
        int profit = prices[sellingIndex] - prices[buyingIndex];
        maxProfit = Math.max(profit, maxProfit);
        sellingIndex++;
      }
      buyingIndex++;
    }
    return Math.max(maxProfit, 0);
  }
//[7,1,5,3,6,4]
  public int maxProfitToBuyAndSellStockOnePass(int[] prices) {
    int result = 0;
    int maxElev = -1 * Integer.MAX_VALUE;
    for (int i = 1; i < prices.length; i++) {
      int elev = prices[i] - prices[i - 1];

      maxElev = Math.max(elev, maxElev);
    }

    return Math.max(maxElev, 0);
  }
}
