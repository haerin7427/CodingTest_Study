package Leetcode.haerin.Medium;
// https://leetcode.com/problems/3sum/
// title : 3Sum
// type : Sorting
// time : 20m
// Created by haerin on 2023-05-15
import java.util.*;
public class threeSum {
    // 시간초과
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            List<List<Integer>> answer = new ArrayList<>();
            for(int x=0; x<nums.length-2; x++){
                for(int y=x+1; y<nums.length-1; y++){
                    for(int z=y+1; z<nums.length; z++){
                        if(nums[x] + nums[y] + nums[z] == 0){
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[x]);
                            list.add(nums[y]);
                            list.add(nums[z]);
                            if(!answer.contains(list)){
                                answer.add(list);
                            }
                        }
                    }
                }
            }
            return answer;
        }
    }
    // 성공
    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> answer = new HashSet<>();
    
            for(int i=0; i<nums.length-2; i++){
                int p1 = i+1;
                int p2 = nums.length-1;
                while(p1 < p2){
                    int sum = nums[i] + nums[p1] + nums[p2];
                    if(sum == 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[p1]);
                        list.add(nums[p2]);
                        answer.add(list);
    
                        p1 += 1;
                    }else if(sum < 0){
                        p1 += 1;
                    }else{
                        p2 -= 1;
                    }
                }
            }
            return new ArrayList<>(answer);
        }
    }
}
