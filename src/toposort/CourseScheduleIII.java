package toposort;

import java.util.Arrays;

/**
 * There are n different online courses numbered from 1 to n. Each course has some duration(course length) t
 * and closed on dth day. A course should be taken continuously for t days and must be finished before or on
 * the dth day. You will start at the 1st day.
 * <p>
 * Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that
 * can be taken.
 * <p>
 * Example:
 * <p>
 * Input: [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]] Output: 3 Explanation: There're totally 4
 * courses, but you can take 3 courses at most: First, take the 1st course, it costs 100 days so you will
 * finish it on the 100th day, and ready to take the next course on the 101st day. Second, take the 3rd
 * course, it costs 1000 days so you will finish it on the 1100th day, and ready to take the next course on
 * the 1101st day. Third, take the 2nd course, it costs 200 days so you will finish it on the 1300th day. The
 * 4th course cannot be taken now, since you will finish it on the 3300th day, which exceeds the closed date.
 */
public class CourseScheduleIII {

  public static void main(String[] args) {
    int[][] input = {{3, 5}, {5, 7}, {10, 14}, {10, 18}};
    CourseScheduleIII courseSchedule = new CourseScheduleIII();
    courseSchedule.scheduleCourse(input);
  }

  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, (a, b) -> a[1] - b[1]);
    //{{3, 5}, {5, 7}, {10, 14}, {10, 18}};
    int time = 0;
    int count = 0;

    for (int i = 0; i < courses.length; i++) {
      if (time + courses[i][0] <= courses[i][1]) {
        time = time + courses[i][0];
        count++;
      } else {
        int max_i = i;
        for (int j = 0; j < i; j++) {
          if (courses[j][0] > courses[max_i][0]) {
            max_i = j;
          }
        }//todo: Trick to find max value index for course schedules

        if (courses[max_i][0] > courses[i][0]) {
          time += courses[i][0] - courses[max_i][0];
        }
        courses[max_i][0] = -1;
      }
    }

    return count;
  }
}
