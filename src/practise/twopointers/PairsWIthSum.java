package practise.twopointers;

public class PairsWIthSum {

  public static void main(String[] args) {

  }

  private class Solution {

    public int[] pairWithSum(int[] arr, int sum) {
      int start = 0;
      int end = arr.length;

      while (start < end) {
        int currentSum = arr[start] + arr[end];
        if (currentSum == sum) {
          return new int[]{start, end};
        }
        if (sum > currentSum) {
          start++;
        } else {
          end--;
        }

      }
      return new int[]{-1, -1};
    }
  }
}
