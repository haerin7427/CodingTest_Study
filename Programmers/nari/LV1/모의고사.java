// https://school.programmers.co.kr/learn/courses/30/lessons/42840
// title : 모의고사

import java.util.*;

public class 모의고사 {
    class Solution1 {
        public int[] solution(int[] answers) {
            int[] one = {1, 2, 3, 4, 5};
            int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            int oneCnt = 0, twoCnt = 0, threeCnt = 0;
            
            for(int i=0;i<answers.length;i++) {
                if(answers[i] == one[i%5]) oneCnt++;
                if(answers[i] == two[i%8]) twoCnt++;
                if(answers[i] == three[i%10]) threeCnt++;
            }
            
            if(oneCnt > twoCnt) {
                if(oneCnt > threeCnt) return new int[] {1};
                else if(oneCnt == threeCnt) return new int[] {1, 3};
                else return new int[] {3};
            }
            else if(oneCnt == twoCnt) {
                if(oneCnt > threeCnt) return new int[] {1, 2};
                else if(oneCnt == threeCnt) return new int[] {1, 2, 3};
                else return new int[] {3};
            }
            else {
                if(twoCnt > threeCnt) return new int[] {2};
                else if(twoCnt == threeCnt) return new int[] {2, 3};
                else return new int[] {3};
            }
        }
    }

    class Solution2 {
        public int[] solution(int[] answers) {
            int[] one = {1, 2, 3, 4, 5};
            int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
            int oneCnt = 0, twoCnt = 0, threeCnt = 0;
            
            for(int i=0;i<answers.length;i++) {
                if(answers[i] == one[i%5]) oneCnt++;
                if(answers[i] == two[i%8]) twoCnt++;
                if(answers[i] == three[i%10]) threeCnt++;
            }
            
            int max = Math.max(oneCnt, Math.max(twoCnt, threeCnt));
            ArrayList<Integer> list = new ArrayList<>();
            if(max == oneCnt) list.add(1);
            if(max == twoCnt) list.add(2);
            if(max == threeCnt) list.add(3);
            
            int[] answer = new int[list.size()];
            for(int i=0;i<list.size();i++) {
                answer[i] = list.get(i);
            }
            
            return answer;
        }
    }
}