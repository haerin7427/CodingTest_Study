// https://leetcode.com/problems/jump-game/
// title : 5. Longest Palindromic Substring
// time taken : 12 m 23 s

import java.util.*;

public class JumpGame {
    // Time Limit Exceed
    class Solution1 {
        public boolean canJump(int[] nums) {
            int len = nums.length - 1;
            Queue<int[]> queue = new LinkedList<>();

            queue.add(new int[]{nums[0], 0});

            while(!queue.isEmpty()) {
                int[] info = queue.poll();

                if(info[1] >= len) return true;

                for(int i=info[1]+1;i<=info[0]+info[1];i++) {
                    if(i > len) break;

                    queue.add(new int[]{nums[i], i});
                }
            }

            return false;
        }
    }

    class Solution2 {
        public boolean canJump(int[] nums) {
            int len = nums.length - 1;
            int boundary = 0;

            for(int i=0;i<=boundary;i++) {
                // 제일 멀리 갈 수 있는 값으로 boundary 갱신
                boundary = Math.max(boundary, i+nums[i]);

                if(boundary >= len) return true;
            }

            return false;
        }
    }
}
