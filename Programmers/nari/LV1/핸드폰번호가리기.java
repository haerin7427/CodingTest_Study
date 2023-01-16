// https://school.programmers.co.kr/learn/courses/30/lessons/12948
// title : 핸드폰 번호 가리기

public class 핸드폰번호가리기 {
    // 테스트 케이스 13개 기준 평균 속도 약 0.05ms
    class Solution1 {
        public String solution(String phone_number) {
            StringBuilder sb = new StringBuilder();
            
            for(int i=0;i<phone_number.length();i++) {
                if(i > phone_number.length()-5)
                    sb.append(Character.getNumericValue(phone_number.charAt(i)));
                else sb.append("*");
            }
            
            return sb.toString();
        }
    }

    // 테스트 케이스 13개 기준 평균 속도 약 0.02ms
    class Solution2 {
        public String solution(String phone_number) {
            char[] ch = phone_number.toCharArray();
            
            for(int i=0;i<ch.length-4;i++){
                ch[i] = '*';
            }
            
            return String.valueOf(ch);
        }
    }

    // 테스트 케이스 13개 기준 평균 속도 약 0.4ms
    class Solution3 {
        public String solution(String phone_number) {
            return phone_number.replaceAll(".(?=.{4})", "*");
        }
    }
}