// https://school.programmers.co.kr/learn/courses/30/lessons/12949
// title : 행렬의 곱셈

public class 행렬의곱셈 {
    class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];
            
            for(int i=0;i<arr1.length;i++) {
                for(int a=0;a<arr2[0].length;a++) {
                    for(int j=0;j<arr1[i].length;j++) {
                        answer[i][a] += arr1[i][j] * arr2[j][a];
                    }
                }
            }
            
            return answer;
        }
    }
}