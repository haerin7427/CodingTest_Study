package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42860
// title : 조이스틱
// type : Greedy
// time : 17m
// Created by haerin on 2023-03-08
public class 조이스틱 {
    class Solution {
        public int solution(String name) {
            
            int num_change_alpha = 0; // 알파벳 조작 횟수
            int num_move_cursor = name.length()-1; //default, 좌우 이동 횟수
            
            for(int i=0; i< name.length(); i++){
                num_change_alpha += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i)+1);
                
                // 문자열 중간에 A가 있다면 어떤 순서로 알파벳을 조작하는 것이 좌우 이동 횟수를 최소화 할 수 있는 지 검사
                int idx = i+1;
                while(idx<name.length() && name.charAt(idx) == 'A')
                    idx++;
                num_move_cursor = Math.min(num_move_cursor, i*2 + (name.length()-idx));
                num_move_cursor = Math.min(num_move_cursor, (name.length()-idx)*2 + i); 
            }
            
            return num_change_alpha+num_move_cursor;
        }
    }
}
