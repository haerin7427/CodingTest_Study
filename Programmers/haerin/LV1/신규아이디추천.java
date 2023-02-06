// https://school.programmers.co.kr/learn/courses/30/lessons/72410
// title : 신규 아이디 추천
// type : 문자열
// time : 28m
// Created by haerin on 23-02-01, 23-02-05
public class 신규아이디추천 {
    class Solution {
        public String solution(String new_id) {
            String answer = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]","").replaceAll("[.]{2,}",".");
    
            if(answer.length() > 0 &&answer.charAt(0) == '.') {
                answer = answer.substring(1);
            }
            if(answer.length() > 0 && answer.charAt(answer.length()-1) == '.'){
                answer = answer.substring(0, answer.length()-1);
            }
            
            
            if(answer.length() == 0){
                answer = "aaa";
            }else if(answer.length() <= 2) {
                String temp = answer.substring(answer.length()-1);
                while(answer.length() < 3){
                    answer += temp;
                }
            }else if (answer.length() > 15) {
                if(answer.charAt(14) == '.'){
                    answer = answer.substring(0, 14);
                } else {
                    answer = answer.substring(0, 15);
                }
            }
            return answer;
        }
    }
    class Solution2 {
        public String solution(String new_id) {
            String answer = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]","").replaceAll("[.]+",".").replaceAll("^[.]|[.]$","");
            
            if(answer.length() == 0){
                answer = "aaa";
            }else if(answer.length() <= 2) {
                while(answer.length() < 3){
                    answer += answer.charAt(answer.length()-1);
                }
            }else if (answer.length() > 15) {
                answer = answer.substring(0, 15).replaceAll("[.]$","");
            }
            return answer;
        }
    }

    class Solution3 {
        public String solution(String new_id) {
            String s = new_id.toLowerCase().replaceAll("[^a-z0-9-_.]","").replaceAll("[.]{2,}",".");
            if(s.length() > 0 && s.charAt(0)=='.'){
                s = s.substring(1);
            }
            if(s.length() > 0 && s.charAt(s.length()-1)=='.'){
                s = s.substring(0, s.length()-1);
            }
            if(s.equals("")) {
                s = "aaa";
            }
            if(s.length() > 15) {
                if(s.charAt(14) == '.'){
                    s = s.substring(0, 14);
                }else {
                    s = s.substring(0, 15);
                }
            }
            while(s.length() < 3) {
                s += s.charAt(s.length()-1);
            }
            return s;
        }
    }
}
