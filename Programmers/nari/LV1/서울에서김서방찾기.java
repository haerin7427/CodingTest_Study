// https://school.programmers.co.kr/learn/courses/30/lessons/12919
// title : 서울에서 김서방 찾기

import java.util.Arrays;

public class 서울에서김서방찾기 {
    // 테스트 케이스 14개 기준 평균 속도 9.36ms
    class Solution1 {
        public String solution(String[] seoul) {
            int index = 0;
            
            for(int i=0;i<seoul.length;i++) {
                if(seoul[i].equals("Kim")) {
                    index = i;
                    break;
                }
            }
            
            return "김서방은 " + index + "에 있다";
        }
    }

    // 테스트 케이스 14개 기준 평균 속도 11.06ms
    class Solution2 {
        public String solution(String[] seoul) {
            int index = Arrays.asList(seoul).indexOf("Kim");
            
            return "김서방은 " + index + "에 있다";
        }
    }
}