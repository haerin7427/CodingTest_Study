// https://school.programmers.co.kr/learn/courses/30/lessons/1833
// title : 캠핑

// 구간합 dp 방식

// 좌표 압축
// 주어진 x 좌표가 [0, 100, 10000, 2345520]인 경우 -> 좌표 압축을 통해 [0, 1, 2, 3] 으로 표현 가능
// 주어진 (x, y)좌표가 [0, 0], [100, 100], [0, 200], [200, 0] 인 경우 -> [0, 0], [1, 1], [0, 2], [2, 0] 으로 압축 가능
// ===> 좌표 압축 기법을 사용하여 sum 배열의 사이즈를 (2^31-1 2^31-1) 가 아닌 (N * N)으로 설정 가능

import java.util.*;

public class 캠핑 {
    class Solution {
        public int solution(int n, int[][] data) {
            int answer = 0;
            // 좌표 압축
            HashSet<Integer> xSet = new HashSet<>();
            HashSet<Integer> ySet = new HashSet<>();

            for(int[] d : data) {
                xSet.add(d[0]);
                ySet.add(d[1]);
            }
            
            ArrayList<Integer> xList = new ArrayList<>(xSet);
            ArrayList<Integer> yList = new ArrayList<>(ySet);

            Collections.sort(xList);
            Collections.sort(yList);
            
            // 구간합 배열
            // sum[i][j] = (0, 0) ~ (i, j) 범위의 직사각형 내부에 존재하는 쐐기의 개수
            int[][] sum = new int[n][n];
            
            for(int[] d : data) {
                int x = xList.indexOf(new Integer(d[0]));
                int y = yList.indexOf(new Integer(d[1]));
                
                // 좌표 압축 적용
                d[0] = x;
                d[1] = y;
                
                // 구간합 배열 초기값
                sum[x][y] = 1;
            }
            
            // N^2 구간합 구하기
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    // 미리 구해놓은 sum 배열의 값을 검사하여 값이 0인 경우, 내부에 쐐기가 없음
                    //   => 텐트를 설치할 수 있음을 쉽게 판단
                    sum[i][j] += (i - 1 >= 0 ? sum[i-1][j] : 0)
                        + (j - 1 >= 0 ? sum[i][j-1] : 0)
                        - (i - 1 >= 0 && j - 1 >= 0 ? sum[i-1][j-1] : 0);
                }
            }
            
            // N^2 모든 쐐기 조합에 대하여 검사
            for(int i=0;i<n;i++) {
                for(int j=i+1;j<n;j++) {
                    // 직사각형이 아닌 경우
                    if(data[i][0] == data[j][0] || data[i][1] == data[j][1]) continue;
                    
                    int startX = 0, startY = 0, endX = 0, endY = 0;

                    startX = Math.min(data[i][0], data[j][0]);
                    startY = Math.min(data[i][1], data[j][1]);
                    endX = Math.max(data[i][0], data[j][0]);
                    endY = Math.max(data[i][1], data[j][1]);

                    int cnt;

                    // 예를 들어, (2, 2) ~ (4, 4) 범위의 직사각형 내부에 쐐기가 존재하는지 검사하려면? 
                    // sum[3][3] - sum[1][3] - sum[3][1] + sum[1][1]
                    if(startX + 1 > endX - 1 || startY + 1 > endY - 1) cnt = 0;
                    // 내부에 쐐기가 존재하는 경우
                    else cnt = sum[endX-1][endY-1] - sum[endX-1][startY] - sum[startX][endY-1] + sum[startX][startY];
                        
                    if(cnt == 0) answer++;
                }
            }
            
            return answer;
        }
    }
}