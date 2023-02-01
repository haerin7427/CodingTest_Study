// https://school.programmers.co.kr/learn/courses/30/lessons/72410
// title : 신규 아이디 추천

import java.util.*;

public class 신규아이디추천 {
    // ArrayList와 StringBuilder 사용
    class Solution1 {
        public String solution(String new_id) {
            ArrayList<Character> list = new ArrayList<>();
            
            // 1단계 모든 대문자를 소문자로 치환
            for(int i=0;i<new_id.length();i++) {
                char c = new_id.charAt(i);
                
                if(Character.isUpperCase(c)) 
                    list.add(Character.toLowerCase(c));
                else list.add(c);
            }
            
            // 2단계 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
            for(int i=0;i<list.size();i++) {
                char c = list.get(i);
                
                if(!Character.isLowerCase(c) && !Character.isDigit(c) && c != '-' &&  c != '_' &&  c != '.') {
                    list.remove(i);
                    i--;
                }
            }
            
            // 3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
            for(int i=1;i<list.size();i++) {
                if(list.get(i-1) == '.' && list.get(i) == '.') {
                    list.remove(i);
                    i--;
                }
            }
            
            // 4단계 마침표(.)가 처음이나 끝에 위치하면, 제거
            if(list.size() != 0 && list.get(0) == '.') list.remove(0);
            if(list.size() != 0 && list.get(list.size()-1) == '.') list.remove(list.size()-1);
            
            StringBuilder sb = new StringBuilder();

            // 5단계 빈 문자열이라면, "a" 대입
            if(list.size() == 0) {
                sb.append('a');
            }
            else {
                for(Character ch : list) {
                    sb.append(ch);
                }
            }
            
            // 6단계 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
            // 제거 후, 마침표(.)가 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
            if(sb.length() >= 16) sb.setLength(15);
            if(sb.length()-1 == sb.lastIndexOf(".")) sb.deleteCharAt(sb.length()-1);
            
            // 7단계 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복
            while(sb.length() < 3) {
                sb.append(sb.charAt(sb.length()-1));
            }
            
            return sb.toString();
        }
    }

    // String만 사용 -> 확실히 1보다 느림
    class Solution2 {
        public String solution(String new_id) {
            // 1단계 모든 대문자를 소문자로 치환
            String answer = new_id.toLowerCase();
            
            // 2단계 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
            answer = answer.replaceAll("[^-_.a-z0-9]","");
            
            // 3단계 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
            answer = answer.replaceAll("[.]{2,}",".");

            // 4단계 마침표(.)가 처음이나 끝에 위치하면, 제거
            answer = answer.replaceAll("^[.]|[.]$","");

            // 5단계 빈 문자열이라면, "a" 대입
            if(answer.equals("")) answer += "a";
            
            // 6단계 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
            // 제거 후, 마침표(.)가 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거
            if(answer.length() >= 16){
                answer = answer.substring(0, 15);
                answer = answer.replaceAll("^[.]|[.]$","");
            }
            
            // 7단계 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복
            while(answer.length() < 3) {
                answer += answer.charAt(answer.length()-1);
            }
            
            return answer;
        }
    }
}