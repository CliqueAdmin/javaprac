package practise.mergeintervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeOverLappingIntervals {

  public static void main(String[] args) {
    MergeOverLappingIntervals problem = new MergeOverLappingIntervals();

  }

  public List<int[]> mergeOverlappingIntervals(int[][] intervals) {
    LinkedList<int[]> merged = new LinkedList<>();
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    for (int[] interval : intervals) {
      if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
        merged.add(interval);
      } else {
        merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
      }
    }
    return merged;
  }


}
