// https://school.programmers.co.kr/learn/courses/30/lessons/42840
// title : 모의고사
// type : 정수
// time : 19m
// Created by haerin on 2023-01-27
public class 모의고사 {
    class Solution {
        public int[] solution(int[] answers) {
            // int[][] types = {
            //     {1, 2, 3, 4, 5},
            //     {2, 1, 2, 3, 2, 4, 2, 5},
            //     {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
            // };
            int[] type1 = new int[]{1, 2, 3, 4, 5};
            int[] type2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
            int[] type3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            
            int[] scores = new int[3];
            for(int i=0; i<answers.length; i++) {            
                if(answers[i] == type1[i%type1.length]) {
                    scores[0] += 1;
                }
                if(answers[i] == type2[i%type2.length]) {
                    scores[1] += 1;
                }
                if(answers[i] == type3[i%type3.length]) {
                    scores[2] += 1;
                }
            }
            
            int bestScore = 0;
            // int bestScore = Math.max(scores[0], Math.max(scores[1], scores[2]));

            int count = 0;
            for(int score : scores) {
                if(bestScore < score) {
                    bestScore = score;
                    count = 1;
                }else if(bestScore == score) {
                    count += 1;
                }
            }
            
            int[] answer = new int[count];
            int idx = 0;
            for(int i=0; i<3; i++) {
                if(bestScore == scores[i]) {
                    answer[idx++] = (i+1);
                }
            }
            return answer;
        }
    }
}
