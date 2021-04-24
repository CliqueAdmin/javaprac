package practise.twopointers;

public class MakeSquares {

  public static void main(String[] args) {

  }

  private class Solution {

    //todo: write unit tests for these
    private int[] makeSquares(int[] arr) {
      int pve = 0;
      int nve = 0;
      for (int i = 0; i < arr.length; i++) {
        if (arr[i] >= 0) {
          pve = i;
          break;
        }
      }
      nve = pve > 0 ? pve - 1 : -1;

      int[] result = new int[arr.length];
      int index = 0;
      while (nve >= 0 && pve < arr.length) {
        int pveS = arr[pve] * arr[pve];
        int nveS = arr[nve] * arr[nve];
        if (pveS >= nveS) {
          result[index++] = nveS;
          result[index++] = pveS;
        } else {
          result[index++] = pveS;
          result[index++] = nveS;
        }
        pve++;
        nve--;
      }
      while (nve >= 0) {
        result[index++] = arr[nve] * arr[nve];
      }
      while (pve < arr.length) {
        result[index++] = arr[pve] * arr[pve];
      }
      return result;
    }
  }

}
