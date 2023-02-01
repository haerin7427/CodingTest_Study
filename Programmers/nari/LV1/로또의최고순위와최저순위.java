// https://school.programmers.co.kr/learn/courses/30/lessons/77484
// title : 로또의 최고 순위와 최저 순위

import java.util.*;

public class 로또의최고순위와최저순위 {
    class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int num : win_nums) {
                list.add(num);
            }
            
            int rank = 1, zero = 0;
        
            for(int i=0;i<lottos.length;i++) {
                if(lottos[i] == 0) zero++;
                else if(!list.contains(lottos[i])) rank++;
            }
            
            int[] answer = {rank==7 ? 6 : rank, zero==6 || rank==7 ? 6 : zero + rank};
            
            return answer;
        }
    }
}