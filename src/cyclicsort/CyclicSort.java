package cyclicsort;

import java.util.Arrays;

public class CyclicSort {

  public static void main(String[] args) {
    int[] input = {2, 5, 4, 1, 3}; //{1,2,3,4,5}
    CyclicSort cyclicSort = new CyclicSort();
    cyclicSort.sortArray(input);
    Arrays.stream(input).forEach(v -> System.out.print(v + ","));
  }

  public void sortArray(int[] array) {
    int index = 1;
    while (index <= array.length) {
      if (array[index - 1] != index) {
        int temp = array[index - 1];
        array[index - 1] = array[temp - 1];
        array[temp - 1] = temp;
      } else {
        index++;
      }

    }
  }

}
