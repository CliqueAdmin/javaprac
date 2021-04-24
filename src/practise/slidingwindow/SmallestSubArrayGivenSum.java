package practise.slidingwindow;

public class SmallestSubArrayGivenSum {

  /**
   * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous
   * subarray whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
   *
   * @param arr
   * @param sum
   * @return length of the smallest contiguous subarray
   */
  public int findSmallestSubArrayForGivenSum(int[] arr, int sum) {
    int result = 0;
    int currSum = 0;
    int wE = 0; // windowEnd
    int wS = 0; // windowStart
    while (wS >= 0 && wE < arr.length - 1) {
      wS++;
      wE++;

    }
    return result;
  }

}
