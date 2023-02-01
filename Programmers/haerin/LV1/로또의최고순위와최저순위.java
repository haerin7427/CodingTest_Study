// https://school.programmers.co.kr/learn/courses/30/lessons/77484
// title : 로또의 최고 순위와 최저 순위
// type : 
// time : 10m
// Created by haerin on 23-02-01
public class 로또의최고순위와최저순위 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int win_cnt = 0;
            int remove_cnt = 0;
            for(int i=0; i<lottos.length; i++) {
                
                if(lottos[i] == 0) {
                    remove_cnt += 1;
                }else {
                    for(int j=0; j<win_nums.length; j++) {
                        if(lottos[i] == win_nums[j]){
                            win_cnt += 1;
                            break;
                        }
                    }
                    
                }
            }
            int[] answer = new int[2];
            answer[0] += rank(win_cnt+remove_cnt);
            answer[1] += rank(win_cnt);
            return answer;
        }
        private int rank (int score) {
            if(score == 6) 
                return 1;
            else if (score == 5) 
                return 2;
            else if (score == 4) 
                return 3;
            else if (score == 3) 
                return 4;
            else if (score == 2) 
                return 5;
            else
                return 6;
        }
    }
}
