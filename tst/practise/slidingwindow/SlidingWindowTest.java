package practise.slidingwindow;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import practise.slidingwindow.SlidingWindow;

public class SlidingWindowTest {

  @Test
  public void testSumBruteForce() {
    SlidingWindow slidingWindow = new SlidingWindow();
    int[] arr = {5, 2, 7, 8, 9};
    int[] results = slidingWindow.sumBruteForce(arr, 3);
    assertTrue(results.length == 3);
    assertTrue(results[0] == 14);
    assertTrue(results[1] == 17);
    assertTrue(results[2] == 24);
  }
}