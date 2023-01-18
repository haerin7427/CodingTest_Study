// https://school.programmers.co.kr/learn/courses/30/lessons/1845
// title : 폰켓몬

import java.util.*;

public class 폰켓몬 {
    class Solution1 {
        public int solution(int[] nums) {
            int answer = 0;
            
            // 배열을 HashSet으로 변환
            HashSet<Integer> set = new HashSet<Integer>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
            
            return set.size()>nums.length/2 ? nums.length/2 : set.size();
        }
    }

    // 1보다 빠름
    class Solution2 {
        public int solution(int[] nums) {
            int answer = 0;
            
            HashSet<Integer> set = new HashSet<>();

            for(int i =0; i<nums.length;i++) {
                set.add(nums[i]);
            }
            
            return set.size()>nums.length/2 ? nums.length/2 : set.size();
        }
    }
}