// https://school.programmers.co.kr/learn/courses/30/lessons/1845
// title : 폰켓몬
// time : 3m
// type : HashSet
// Created by haerin on 2023/01/18
import java.util.*;
public class 폰켓몬 {
    class Solution {
        public int solution(int[] nums) {
            HashSet<Integer> set = new HashSet<>();
            for(int num : nums) {
                set.add(num);
            }
            return nums.length/2 < set.size() ? nums.length/2 : set.size();
        }
    }
}
