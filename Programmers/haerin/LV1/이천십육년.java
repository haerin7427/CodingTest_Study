// https://school.programmers.co.kr/learn/courses/30/lessons/12901
// title : 2016년
// time : 11m
// type : 숫자 계산
// Created by haerin on 2023/01/17
import java.time.*;
public class 이천십육년 {
    class Solution {
        public String solution(int a, int b) {
            // 일자를 7로 나눌때, 나머지 값과 동일한 순서 ex. 1월 1일이 금요일일때, 1 % 7 = 1 -> WEEK[1] = "FRI"
            String[] WEEK = new String[]{"THU","FRI", "SAT","SUN","MON","TUE","WED"}; 
            int[] days = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
            int sum = b;
            for(int i=0; i<a-1; i++) {
                sum += days[i];
            }
            String answer = WEEK[sum%7];
            return answer;
        }
    }
    class Solution2 {
        public String solution(int a, int b) {
            return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0,3);
        }
    }
}
