package practise.slidingwindow;

public class SlidingWindow {

  /**
   * O(n^2)
   *
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

  public int[] sumSlidingWindow(int[] arr, int groupSize) {
    //todo:validations
    int[] results = new int[(arr.length - groupSize) + 1];
    int sum = 0;
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      if (i >= groupSize) {
        results[i - groupSize] = sum;
        sum = sum - arr[i - groupSize];
      }
      sum = sum + arr[i];
    }
    results[results.length - 1] = sum;
    return results;
  }

}