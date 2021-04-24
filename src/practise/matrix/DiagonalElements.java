package practise.matrix;

public class DiagonalElements {

  private int[][] grid;

  public static void main(String[] args) {
    DiagonalElements dE = new DiagonalElements();
    int[] cd = {1, 1};
    dE.findZerosInDiagonalElements(cd);
  }

  public void findZerosInDiagonalElements(int[] cd) {
    int[][] gd = {
        {1, 8, 7, 1},
        {2, 0, 6, 1},
        {3, 4, 5, 1},
        {0, 0, 0, 1}
    };
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    int x = cd[0];
    int y = cd[1];
    for (int[] dir : dirs) {
      int value = gd[x + dir[0]][y + dir[1]];
      System.out.println("value = " + value);

    }
  }
}
