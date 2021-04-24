package practise.matrix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MineSweeperBFS {

  int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {1, 1}, {-1, 1}, {-1, -1}, {1, -1}};

  public static void main(String[] args) {
    MineSweeperBFS msB = new MineSweeperBFS();
    char[][] board = {
        {'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'M', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'},
        {'E', 'E', 'E', 'E', 'E'}
    };
    int[] click = {3, 9};
    msB.updateBoard(board, click);
  }

  public char[][] updateBoard(char[][] board, int[] click) {
    int row = click[0];
    int col = click[1];
    //todo: good way to keep n and m reusable
    int n = board.length, m = board[0].length;

    //if bee then mark it X and return.
    if (board[row][col] == 'M') {
      board[row][col] = 'X';
      return board;
    }
    int[][] count = new int[n][m];
    // pre process the counts
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 'M') {
          for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            //todo: is grid a good idea to check if the surrounding is in the  valid bounds
            if (isInGrid(x, y, board)) {

              count[x][y]++;
            }
          }
        }
      }
    }

    //todo : BFS on two dimensional array
    Queue<int[]> q = new LinkedList<>();
    q.add(click);
    while (!q.isEmpty()) {
      int[] cur = q.poll();
      int x = cur[0];
      int y = cur[1];
      if (board[x][y] == 'E') {
        if (count[x][y] > 0) {
          board[x][y] = (char) (count[x][y] + '0');
        } else {
          board[x][y] = 'B';
          for (int[] dir : dirs) {
            int newX = x + dir[0];
            int newY = y + dir[1];
            if (isInGrid(newX, newY, board) && board[newX][newY] == 'E') {
              q.offer(new int[]{newX, newY});
            }
          }
        }
      }
    }
    printGrid(board);
    return board;
  }

  private void printGrid(char[][] board) {
    System.out.println(Arrays.deepToString(board));
  }

  private boolean isInGrid(int i, int j, char[][] board) {
    int n = board.length;
    int m = board[0].length;
    return i >= 0 && i < n && j >= 0 && j < m;
  }
}
