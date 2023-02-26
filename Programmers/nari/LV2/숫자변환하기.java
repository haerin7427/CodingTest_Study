// https://school.programmers.co.kr/learn/courses/30/lessons/154538
// title : 숫자 변환하기

import java.util.*;

public class 숫자변환하기 {
    class Solution {
        public int solution(int x, int y, int n) {
            int answer = 0;
            // x에 연산된 값들
            HashSet<Integer> nums = new HashSet<>();
            nums.add(x);
            
            // nums에 있는 값들이 y보다 커질 경우 -> 반복 stop
            while(!nums.isEmpty()) {
                // y가 만들어진 경우
                if(nums.contains(y)) return answer;
                
                // nums의 값들을 연산한 값들
                HashSet<Integer> com = new HashSet<>(); 
                for(int num : nums) {
                    // n 더하기
                    if(num + n <= y) com.add(num + n);
                    // 2 곱하기
                    if(num * 2 <= y) com.add(num * 2);
                    // 3 곱하기
                    if(num * 3 <= y) com.add(num * 3);
                }
                
                // 연산된 값들로 바꿔주기
                nums = com;
                answer++;
            }
            
            // x를 y로 만들 수 없는 경우
            return -1;
        }
    }
}