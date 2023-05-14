// https://leetcode.com/problems/3sum/
// title : 15. 3Sum
// time taken: 21 m 56 s

import java.util.*;

public class 3Sum {
    // time taken : 9 m 28 s
    // Time Limit Exceeded = 실패
    class Solution1 {
        public List<List<Integer>> threeSum(int[] nums) {
            int len = nums.length;
            List<List<Integer>> list = new ArrayList<>();
            HashSet<List<Integer>> set = new HashSet<>();

            // 중복값 구분하기 위해
            Arrays.sort(nums);

            for(int i=0;i<len-2;i++) {
                for(int j=i+1;j<len-1;j++) {
                    for(int k=j+1;k<len;k++) {
                        if(nums[i] + nums[j] + nums[k] == 0) {
                            ArrayList<Integer> l = new ArrayList<>();

                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[k]);

                            set.add(l);
                        }
                    }
                }
            }

            for(List<Integer> l : set) {
                list.add(l);
            }

            return list;
        }
    }

    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            int len = nums.length;
            List<List<Integer>> list = new ArrayList<>();
            HashSet<List<Integer>> set = new HashSet<>();

            // 중복값 구분하기 위해
            Arrays.sort(nums);

            for(int i=0;i<len-2;i++) {
                int j = i+1;
                int k = len-1;

                while(j < k) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if(sum == 0) {
                        ArrayList<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[k]);
                        
                        set.add(l);
                        j++;
                    }
                    // 0보다 작을 경우 j를 높은 숫자로
                    else if(sum < 0) j++;
                    // 0보다 클 경우 k를 낮은 숫자로
                    else k--;
                }
            }

            // runtime 4ms 느리고, memory 0.6 MB 더 차지
            // return new ArrayList<>(set);

            for(List<Integer> l : set) {
                list.add(l);
            }

            return list;
        }
    }
}