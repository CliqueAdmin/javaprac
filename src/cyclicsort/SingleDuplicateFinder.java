package cyclicsort;

public class SingleDuplicateFinder {

  public static void main(String[] args) {
    int[] input = {3, 5, 2, 2, 4};
    /**
     {2,5,3,2,4}
     {5,2,3,2,4}
     {4,2,3,2,5}
     {2,2,3,4,5}
     **/;

  }

  public int findSingleDuplicate(int[] array) {
    int index = 1;
    int duplicate = -1;
    while (index <= array.length) {
      if (array[index - 1] != index) {
        int temp = array[index - 1];
        array[index - 1] = array[temp - 1];
        array[temp - 1] = temp;
      } else {
        duplicate = array[index - 1];
        index++;
      }

    }
    return -1;
  }
}
