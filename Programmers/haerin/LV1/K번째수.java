// https://school.programmers.co.kr/learn/courses/30/lessons/42748
// title : K번째수
// time : 7m
// type : 정수
// Created by haerin on 2023-01-27
import java.util.*;
public class K번째수 {
    // 0.40ms
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for(int i=0; i<commands.length; i++) {
                int[] temp = new int[commands[i][1]-commands[i][0]+1];
                int j = commands[i][0]-1;
                for(int idx=0; idx<temp.length; idx++) {
                    temp[idx] = array[j++];
                }
                Arrays.sort(temp);
                
                answer[i] = temp[commands[i][2]-1];          
            }
            return answer;
        }
    }
    // 0.38ms
    class Solution2 {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            for(int i=0; i<commands.length; i++) {
                int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                Arrays.sort(temp);
                
                answer[i] = temp[commands[i][2]-1];          
            }
            return answer;
        }
    }
}
