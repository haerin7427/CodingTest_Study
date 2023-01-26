// https://school.programmers.co.kr/learn/courses/30/lessons/42748
// title : K번째수

import java.util.*;

public class K번째수 {
    // 속도 0.1ms 차이로 빠름
    class Solution1 {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            
            // commands 1차원 수만큼 for문
            for(int i=0;i<commands.length;i++) {
                // Arrays.copyOfRange() 메소드를 이용하여, 배열의 특정 영역을 복사
                int[] newArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
                // Arrays.sort() 메소드를 이용하여, 배열 정렬
                Arrays.sort(newArray);

                answer[i] = newArray[commands[i][2]-1];
            }
            
            return answer;
        }
    }

    class Solution2 {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            
            for(int i=0;i<commands.length;i++) {
                int[] arr = new int[commands[i][1]-commands[i][0]+1];
                int cnt = 0;
                
                for(int j=commands[i][0]-1;j<commands[i][1];j++) {
                    arr[cnt] = array[j];
                    cnt++;
                }
                
                Arrays.sort(arr);
                answer[i] = arr[commands[i][2]-1];
            }

            return answer;
        }
    }
}