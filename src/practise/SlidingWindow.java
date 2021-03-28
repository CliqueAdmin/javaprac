package practise;

public class SlidingWindow {

  /**
   * O(n^2)
   * @param arr
   * @return
   */
  public int[] sumBruteForce(int[] arr, int groupSize) {
    int numGroups = (arr.length - groupSize) + 1;
    int[] results = new int[numGroups];
    for (int i = 0; i <= arr.length - groupSize; i++) {
      int sum = 0;
      for (int k = 0; k < groupSize; k++) {
        sum += arr[i + k];
      }
      results[i] = sum;
    }
    return results;
  }

}