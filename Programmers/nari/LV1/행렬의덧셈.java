// https://school.programmers.co.kr/learn/courses/30/lessons/12925
// title : 행렬의 덧셈

public class 행렬의덧셈 {
    class Solution1 {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr1[0].length];
            
            for(int i=0;i<arr1.length;i++) {
                for(int j=0;j<arr1[0].length;j++) {
                    answer[i][j] = arr1[i][j] + arr2[i][j];
                }
            }

            return answer;
        }
    }

    // 1보다 조금 더 빠르긴 함
    // arr1이랑 answer랑 같은걸 가리키니까 arr1도 변하지 않는가?...
    class Solution2 {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = arr1;
            
            for(int i=0;i<arr1.length;i++) {
                for(int j=0;j<arr1[0].length;j++) {
                    answer[i][j] += arr2[i][j];
                }
            }

            return answer;
        }
    }
}