// https://school.programmers.co.kr/learn/courses/30/lessons/12947
// title : 하샤드 수
// time : 3m
// 유형 : 계산
// Created by haerin on 2023/01/14
import java.util.*;

public class 하샤드수 {
    // 속도는 solution1이 더 빠름
    class Solution {
        public boolean solution(int x) {
            int sum = 0;
            for(char num : String.valueOf(x).toCharArray()) {
                sum += (num - '0');
            }
            
            return x%sum == 0;
        }
    }
    class Solution2 {
        private int sum = 0;
        public boolean solution(int x) {
            Integer.toString(x).chars().forEach(num -> sum += num - '0');
    
            return x%sum == 0;
        }
    }
}
