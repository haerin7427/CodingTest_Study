// https://school.programmers.co.kr/learn/courses/30/lessons/17682
// title : [1차] 다트 게임
// type : 문자열
// time : 20m
// Created by haerin on 2023-01-31
public class 일차다트게임 {
    class Solution {
        public int solution(String dartResult) {
            int[] scores = new int[3];
            int idx=0;
            for(int i=0; i<scores.length; i++) {
                int end_idx=dartResult.length();
                for(int j=idx+1; j<dartResult.length(); j++) {
                    if(dartResult.charAt(j) >= '0' && dartResult.charAt(j) <= '9' && dartResult.charAt(j-1) != '1' ){
                        end_idx = j;
                        break;
                    }
                }
                String temp = dartResult.substring(idx, end_idx);
                int score = Integer.parseInt(temp.replaceAll("[^0-9]",""));
                String pow = temp.replaceAll("[^SDT]","");
                if(pow.equals("S")) {
                    scores[i] = score;
                }else if(pow.equals("D")) {
                    scores[i] = (int)Math.pow(score, 2);
                } else {
                    scores[i] = (int)Math.pow(score, 3);
                }
                if(temp.contains("*")) {
                    scores[i] *= 2;
                    if(i>0) {
                        scores[i-1] *= 2;
                    }
                } else if(temp.contains("#")) {
                    scores[i] *= -1;
                }
                idx = end_idx;
            }
            int answer = 0;
            for(int s : scores) {
                answer += s;
            }
            return answer;
        }
    }
}
