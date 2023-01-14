// https://school.programmers.co.kr/learn/courses/30/lessons/12919
// title : 서울에서 김서방 찾기
// time : 3m
// type : 문자열
// Created by haerin on 2023/01/14
public class 서울에서김서방찾기 {
    class Solution {
        public String solution(String[] seoul) {
            int idx=0;
            for(int i=0; i<seoul.length; i++) {
                if(seoul[i].equals("Kim")) {
                    idx = i;
                    break;
                }
            }
            return "김서방은 "+ idx +"에 있다"; // 속도 면에서 더 나음
            // return "김서방은 "+ String.valueOf(idx)+"에 있다";
        }
    }
}
