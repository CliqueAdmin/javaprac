package practise;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class Solution {

  public static void main(String[] args) {

    Solution sol = new Solution();
    int[] cuts = {3, 6, 1, 9};
    sol.CopyArrIncSizeBy2(9, cuts);
    for (String arg : args) {
      System.out.println("arg = " + arg);
    }

    int[][] trips = {{2, 3, 3}, {1, 2, 4}, {4, 6, 4}};
    sol.treeMapOfInts(trips, 5);
    sol.treeMapOfTrips(trips, 6);

    int result = sol.longestValidParenthesesDp("())((())");
    System.out.println("result = " + result);
  }

  public void CopyArrIncSizeBy2(int n, int[] cuts) {
    if (cuts == null || cuts.length == 0) {
      return;
    }
    Arrays.sort(cuts);
    int[] newCuts = new int[cuts.length + 2];
    newCuts[0] = 0;
    System.arraycopy(cuts, 0, newCuts, 1, cuts.length);
    newCuts[newCuts.length - 1] = n;
    for (int cut : newCuts) {
      System.out.println("cut = " + cut);
    }
  }

  public void treeMapOfInts(int[][] trips, int capacity) {
    Map<Integer, Integer> tripsSorted = new TreeMap<>();
    for (int[] trip : trips) {
      tripsSorted.put(trip[0], trip[1]);
    }
    System.out.println("tripsSorted = " + tripsSorted);
    System.out.println("capacity = " + capacity);
  }

  public void treeMapOfTrips(int[][] trips, int capacity) {
    Map<Integer, Integer> tripMap = new TreeMap<>();
    for (int[] trip : trips) {
      int startPassenger = tripMap.getOrDefault(trip[0], 0) + trip[2];
      tripMap.put(trip[0], startPassenger);
      int endPassenger = tripMap.getOrDefault(trip[1], 0) - trip[2];
      tripMap.put(trip[1], endPassenger);
    }
    System.out.println("tripMap = " + tripMap);
    System.out.println("capacity = " + capacity);
    System.out.println("tripMap.values() = " + tripMap.values());
    int usedCapacity = 0;
    for (int passengerChange : tripMap.values()) {
      usedCapacity += passengerChange;
      System.out.println("usedCapacity = " + usedCapacity);
      if (usedCapacity > capacity) {
        System.out.println("Trip Not possible");
        return;
      }
    }
    System.out.println("Trip is possible");

  }

  public int longestValidParentheses(String s) {
    int right = 0, left = 0, maxlength = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if (left == right) {
        maxlength = Math.max(maxlength, 2 * right);
      } else if (right > left) {
        left = right = 0;
      }
    }
    left = right = 0;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == '(') {
        left++;
      } else {
        right++;
      }
      if (left == right) {
        maxlength = Math.max(maxlength, 2 * left);
      } else if (left > right) {
        left = right = 0;
      }
    }
    return maxlength;
  }

  public int longestValidParenthesesDp(String str) {
    int maxans = 0;
    int dp[] = new int[str.length()];
    for (int i = 1; i < str.length(); i++) {
      if (str.charAt(i) == ')') {
        if (str.charAt(i - 1) == '(') {
          dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
        } else if (i - dp[i - 1] > 0 && str.charAt(i - dp[i - 1] - 1) == '(') {
          dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
        }
        maxans = Math.max(maxans, dp[i]);
      }
    }
    return maxans;
  }

  /*
  //'())'

  -1
  ans =2
   */
  public int longestValidParenthesisStack(String s) {
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        int top = stack.pop();
        if (stack.empty()) {
          stack.push(i);
        } else {
          result = Math.max((i - stack.peek()), result);
        }
      }
    }
    return result;
  }

}
