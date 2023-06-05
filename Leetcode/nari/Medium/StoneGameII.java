// https://leetcode.com/problems/stone-game-ii/
// title : 1140. Stone Game II
// time taken : 

public class StoneGameII {
    class Solution {
        int[] Piles;
        int len;
        int[][] dp;
        int[] sum;

        public int stoneGameII(int[] piles) {
            Piles = piles;
            len = piles.length;
            dp = new int[len][len];
            sum = new int[len];

            sum[len-1] = piles[len-1];

            for(int i=len-2;i>=0;i--) {
                sum[i] = piles[i] + sum[i+1];
            }

            return dfs(0, 1);
        }

        private int dfs(int idx, int M) {
            // 모든 배열 탐색 완료
            if(idx == len) return 0;
            // 현재 index에서 최대 범위가 배열의 길이보다 크거나 같을 경우, sum return
            if(idx + 2*M >= len) return sum[idx];
            // 이미 값이 존재하는 경우
            if(dp[idx][M] != 0) return dp[idx][M];

            int max = 0;

            // x의 범위만큼 반복하면서 최댓값 찾기
            for(int x=1;x<=2*M;x++) {
                max = Math.max(max, sum[idx] - dfs(idx+x, Math.max(M, x)));
            }

            dp[idx][M] = max;

            return max;
        }
    }
}
