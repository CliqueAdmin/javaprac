package practise.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MaxRectangleSum {

  public static void main(String[] args) {
    int[][] gd = {
        {0, 0, 7, 1},
        {2, 0, 6, 1},
        {3, 4, 0, 0},
        {0, 0, 4, 1}
    };

    MaxRectangleSum mRS = new MaxRectangleSum();
    int result = mRS.calculateRectangleSum(gd);
    System.out.println("result = " + result);
  }

  public int calculateRectangleSum(int[][] grid) {
    int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m = grid.length;
    int n = grid[0].length;
    Queue<Integer> q = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    int maxSum = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        int sum = 0;
        q.add(twoToOne(new int[]{i, j}, m));
        while (!q.isEmpty()) {
          int idx = q.poll();
          int[] pos = oneToTwo(idx, n);
          if (visited.contains(idx)) {
            continue;
          }

          for (int[] dir : DIRECTIONS) {
            int x = pos[0] + dir[0];
            int y = pos[1] + dir[1];
            if (isInBounds(x, y, m, n) && grid[x][y] > 0) {
              q.add(twoToOne(new int[]{x, y}, n));
            }
          }
          sum += grid[pos[0]][pos[1]];
          visited.add(idx);
        }
        if (sum > 0) {
          maxSum = Math.max(maxSum, sum);
        }
      }
    }
    return maxSum;
  }

  private boolean isInBounds(int x, int y, int m, int n) {
    return x >= 0 && y >= 0 && x < m && y < n;
  }

  private int twoToOne(int[] pos, int numCols) {
    return pos[0] * numCols + pos[1];
  }

  private int[] oneToTwo(int value, int numCols) {
    int x = value / numCols;
    int y = value % numCols;
    return new int[]{x, y};
  }
}
