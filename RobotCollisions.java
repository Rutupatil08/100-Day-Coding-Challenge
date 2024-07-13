import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<int[]> robots = new ArrayList<>();
        
        for (int i = 0; i < n; ++i) {
            robots.add(new int[]{positions[i], healths[i], directions.charAt(i), i});
        }

        Collections.sort(robots, Comparator.comparingInt(a -> a[0]));

        Deque<int[]> deque = new ArrayDeque<>();
        
        for (int[] robot : robots) {
            if (robot[2] == 'R' || deque.isEmpty() || deque.peekLast()[2] == 'L') {
                deque.addLast(robot);
            } else {
                while (!deque.isEmpty() && deque.peekLast()[2] == 'R' && robot[1] > 0) {
                    int[] lastRobot = deque.peekLast();
                    if (lastRobot[1] < robot[1]) {
                        robot[1] -= 1;
                        deque.pollLast();
                    } else if (lastRobot[1] > robot[1]) {
                        lastRobot[1] -= 1;
                        robot[1] = 0;
                    } else {
                        deque.pollLast();
                        robot[1] = 0;
                    }
                }
                if (robot[1] > 0) {
                    deque.addLast(robot);
                }
            }
        }

        List<int[]> resultList = new ArrayList<>(deque);
        resultList.sort(Comparator.comparingInt(a -> a[3]));

        List<Integer> result = new ArrayList<>();
        for (int[] robot : resultList) {
            result.add(robot[1]);
        }

        return result;
    }
}
