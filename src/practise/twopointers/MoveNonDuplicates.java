package practise.twopointers;

public class MoveNonDuplicates {

  public static void main(String[] args) {

  }

  private class Solution {

    private int moveNonDuplicatesOnSortedArray(int[] arr) {
      //todo: handle unit test cases with special case where arr.length =1
      int nextNonD = 1;
      int next = 0;
      while (next < arr.length) {
        if (arr[nextNonD - 1] == arr[next]) {
          next++;
          continue;
        }
        int temp = arr[nextNonD];
        arr[nextNonD++] = arr[next];
        arr[next++] = temp;
      }
      return nextNonD - 1;
    }
  }

}
