// https://school.programmers.co.kr/learn/courses/30/lessons/12901
// title : 2016년

import java.time.*;
import java.util.*;

public class 2016년 {
    // 런타임 에러
    // class Solution {
    //     public String solution(int a, int b) {
    //         String[] week = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    //         LocalDate date = LocalDate.of(2016, a, b);
    //         DayOfWeek dayOfWeek = date.getDayOfWeek();
            
    //         return week[dayOfWeek.getValue()];
    //     }
    // }

    // 굉장히 느림
    class Solution1 {
        public String solution(int a, int b) {
            String[] week = {"", "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
            Calendar cal = Calendar.getInstance();
            cal.set(2016, a-1, b);
            
            return week[cal.get(Calendar.DAY_OF_WEEK)];
        }
    }

    // 1보단 빠르다
    class Solution2 {
        public String solution(int a, int b) {
            return LocalDate.of(2016, a, b).getDayOfWeek().toString().substring(0,3);
        }
    }

    // 제일 빠르다
    // 라이브러리를 사용하지 않고, "2016년 1월 1일이 금요일" 이라는 정보를 가지고 계산
    class Solution3 {
        public String solution(int a, int b) {
            String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
            int[] date = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            int allDate = 0;
            
            // 해당하는 달 이전까지 일 수 더하기
            for (int i=0;i<a-1;i++) {
                allDate += date[i];
            }
            
            // string 배열의 index는 0부터 시작하기 때문에 1부터 시작하는 b에서 1을 빼서 더해주기
            allDate += (b-1);
            
            return day[allDate % 7];
        }
    }
}