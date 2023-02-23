package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/49993
// title : 스킬트리
// type : 문자열
// time : 7m
// Created by haerin on 2023-02-23
public class 스킬트리 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            for(String s : skill_trees){
                String test = s.replaceAll("[^"+skill+"]", "");
                if(skill.startsWith(test)){
                    answer += 1;
                }
            }
            return answer;
        }
    }
}
