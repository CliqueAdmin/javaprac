package practise.bfs;

import java.util.Arrays;

public class BFSTricks {

  public static void main(String[] args) {
    int[][] gd = {
        {1, 0, 7, 1},
        {2, 0, 6, 1},
        {3, 4, 0, 1},
        {0, 0, 0, 1}
    };

//    int[][] gd = {
//        {0, 1, 2, 3},
//        {4, 5, 6, 7},
//        {8, 9, 10, 11},
//        {12, 13, 14, 15}
//    };

    BFSTricks bfsTricks = new BFSTricks();
    bfsTricks.TwoD_1DConversion(gd);
  }

  public void TwoD_1DConversion(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;
    int[][] result = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        result[i][j] = twoToOne(new int[]{i, j}, m);
      }
    }
    System.out.println("Arrays.deepToString(result) = " + Arrays.deepToString(result));
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        int x = oneToTwo(result[i][j], m)[0];
        int y = oneToTwo(result[i][j], m)[1];
        result[i][j] = matrix[x][y];
      }
    }

    System.out.println("Arrays.deepToString(result) = " + Arrays.deepToString(result));
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
