// https://leetcode.com/problems/where-will-the-ball-fall/
// title : 1706. Where Will the Ball Fall
// time taken : 15 m 5 s

public class WhereWilltheBallFall {
    class Solution {
        int m = 0, n = 0;

        public int[] findBall(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            int[] ball = new int[n];

            for(int i=0;i<n;i++) {
                int x = i, y = 0;

                while(y < m && !isBlocked(grid, y, x)) {
                    x += grid[y][x];
                    y += 1;
                }

                // 도착지점 x 좌표 or -1
                ball[i] = y == m ? x : -1;
            }

            return ball;
        }

        public boolean isBlocked(int[][] grid, int y, int x) {
            // \ 가림막인데, x 좌표가 제일 오른쪽인 경우 -> 벽에 막힘
            // / 가림막인데, x 좌표가 제일 왼쪽인 경우 -> 벽에 막힘
            // \ 가림막인데, 오른쪽 가림막이 /로, V 형태가 된 경우 -> 막힘
            // / 가림막인데, 왼쪽 가림막이 \로, V 형태가 된 경우 -> 막힘
            return (grid[y][x] == 1 && x == n - 1)
                || (grid[y][x] == -1 && x == 0)
                || (grid[y][x] == 1 && grid[y][x + 1] == -1)
                || (grid[y][x] == -1 && grid[y][x - 1] == 1);
        }
    }
}
