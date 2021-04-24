package practise.twoheaps;

import java.util.PriorityQueue;

public class MaximizeCapital {

  public static void main(String[] args) {

  }

  public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    int initialCapital = W;
    int numOfProjects = k;
    int n = Profits.length;
    PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (i1, i2) -> (Profits[i2] - Profits[i1]));
    PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (i1, i2) -> (Capital[i1] - Capital[i2]));

    for (int i = 0; i < n; i++) {
      minCapitalHeap.offer(i);
    }

    int availableCapital = initialCapital;
    for (int i = 0; i < numOfProjects; i++) {
      while (!minCapitalHeap.isEmpty() && Capital[minCapitalHeap.peek()] <= availableCapital) {
        maxProfitHeap.add(minCapitalHeap.poll());
      }
      if (maxProfitHeap.isEmpty()) {
        break;
      }
      availableCapital += Profits[maxProfitHeap.poll()];
    }
    return availableCapital;
  }
}
