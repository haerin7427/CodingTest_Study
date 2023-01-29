// https://school.programmers.co.kr/learn/courses/30/lessons/133499
// title : 옹알이(2)
// time : 38m + help
// type : 문자열
// Created by haerin on 2023-01-29
public class 옹알이2 {
    class Solution {
        public int solution(String[] babbling) {
            int answer = 0;
            String[] rules1 = new String[]{"aya", "ye", "woo", "ma" };
            String[] rules2 = new String[]{"ayaaya", "yeye", "woowoo", "mama"};
            
            for(String str : babbling) {
                boolean flag = true;
    
                for(String rule : rules2) {
                    if(str.contains(rule)) {
                        flag = false;
                        break;
                    }
                }
                if(!flag) continue;
                
                for(int i=0; i<rules1.length; i++ ) {
                    str = str.replaceAll(rules1[i], "1");
                }
                str = str.replaceAll("1", "");
                if(str.equals("")) answer += 1;
                
            }
            return answer;
        }
    }
    // 실패 버전
    class Solution2 {
        public int solution(String[] babbling) {
            int answer = 0;
            String[] rules = new String[]{"aya", "ye", "woo", "ma" };
            for(String str : babbling) {
                boolean flag = true;
    
                for(int i=0; i<rules.length; i++ ) {
                    // 이 경우 rules의 문자열이 연속된 형태만 조건문에 해당 "ayaayama" 경우 조건문으로 거르지 못함
                    if(str.matches("("+rules[i]+"){2,}")) { 
                        flag = false;
                        break;
                    }
                }
                if(!flag) continue;
                
                for(int i=0; i<rules.length; i++ ) {
                    str = str.replaceAll(rules[i], "1");
                }
                str = str.replaceAll("1", "");
                if(str.equals("")) answer += 1;
                
            }
            return answer;
        }
    }
    class Solution3 {
        public int solution(String[] babblings) {
            // "aya", "ye", "woo", "ma" 4가지 발음만 가능
            int answer = 0;
            for(int i = 0; i < babblings.length; i++) {
                if(babblings[i].contains("ayaaya") || babblings[i].contains("yeye") || babblings[i].contains("woowoo") || babblings[i].contains("mama")) {
                    continue;
                }
    
                babblings[i] = babblings[i].replace("aya", " ");
                babblings[i] = babblings[i].replace("ye", " ");
                babblings[i] = babblings[i].replace("woo", " ");
                babblings[i] = babblings[i].replace("ma", " ");
                babblings[i] = babblings[i].replace(" ", "");
    
                if(babblings[i].length()  == 0) answer++;
    
            }
            return answer;
        }
    }
}
