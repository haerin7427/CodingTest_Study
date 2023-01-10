// https://school.programmers.co.kr/learn/courses/30/lessons/12932
// title : 자연수뒤집어배열로만들기
// time : 5m
// Created by haerin on 2023/01/09
public class 자연수뒤집어배열로만들기 {
    class Solution {
        public int[] solution(long n) {
            String str = String.valueOf(n);
            int[] answer = new int[str.length()];
            int idx = str.length() - 1;
            for(char num : str.toCharArray()) {
                answer[idx--] = num - '0';
            }
            return answer;
        }
    }
    class Solution2 {
        public int[] solution(long n) {
            return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
        }
    }
}
