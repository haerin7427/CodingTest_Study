// https://leetcode.com/problems/jump-game-ii/
// title : 45. Jump Game II
// time taken : 21 m

import java.util.*;

public class JumpGameII {
    // Time Limit Exceeded
    class Solution1 {
        class Info {
            int index;
            int value;
            int count;

            public Info(int idx, int val, int cnt) {
                index = idx;
                value = val;
                count = cnt;
            }
        }

        public int jump(int[] nums) {
            int min = Integer.MAX_VALUE;
            Queue<Info> queue = new LinkedList<>();
            int len = nums.length;

            if(len == 1) return 0;

            queue.add(new Info(0, nums[0], 1));

            while(!queue.isEmpty()) {
                Info info = queue.poll();

                if(info.value == 0) continue;

                if(info.index + info.value >= len-1) {
                    min = Math.min(min, info.count);
                }

                for(int i=info.index+1;i<=info.index+info.value;i++) {
                    if(i >= len) continue;

                    queue.add(new Info(i, nums[i], info.count+1));
                }
            }

            return min;
        }
    }

    class Solution2 {
        public int jump(int[] nums) {
            int cnt = 0, curMax = 0, nextMax = 0;
            int len = nums.length;

            if(len == 1) return 0;

            // index 최댓값을 이용
            for(int i=0;i<len-1;i++) {
                // 다음 index 최댓값과 현재 index에서 해당 nums만큼 움직인 값 중 최댓값 갱신
                nextMax = Math.max(nextMax, i + nums[i]);

                // 현재 index 최댓값과 현재 index가 동일한 경우
                if(i == curMax) {
                    cnt++;
                    curMax = nextMax;
                }
            }

            return cnt;
        }
    }
}
