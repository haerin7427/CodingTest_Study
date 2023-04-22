package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/1833
// title : 캠핑
// type : DP
// time : ...
// Created by haerin on 2023-04-21
import java.util.*;
public class 캠핑 {
    // 테스트 케이스 통과!
    // 최적화 조건 참고 : https://jaejin0me.github.io/post/algo47/
    class Solution {
        public int solution(int n, int[][] data) {
            Arrays.sort(data, (o1, o2) -> (o1[0] - o2[0]));
            int answer = 0;
            for(int i=0; i<data.length-1; i++){
                for(int j=i+1; j<data.length; j++){
                    if(data[i][0] == data[j][0] || data[i][1] == data[j][1]) continue;
    
                    int minY = Math.min(data[i][1], data[j][1]);
                    int maxY = Math.max(data[i][1], data[j][1]);
                    int minX = data[i][0];
                    int maxX = data[j][0];
    
                    // x기준으로 정렬했으니, j보다 작은 인덱스 점들만 검사
                    for(int f=j; f>=0; f--){
                        if(minX < data[f][0] && data[f][0] < maxX && minY < data[f][1] && data[f][1] < maxY){
                            answer -= 1; // 쐐기가 존재하면 마이너스
                            break; // 하나라도 존재하면 직사각형 못만드니까 검사 중단
                        }
                    }
                    answer += 1; // 쐐기의 존재 여부 확인없이 플러스
                }
            }
            return answer;
        }
    }
    // 통과
    class Solution2 {
        public int solution(int n, int[][] data) {
            // 2^31-1 크기의 int 배열은 선언이 불가
            // 좌표 압축
            ArrayList<Integer> xList = new ArrayList<>();
            ArrayList<Integer> yList = new ArrayList<>();
    
            for (int[] p : data) {
                xList.add(p[0]);
                yList.add(p[1]);
            }
    
            ArrayList<Integer> uniqueXList = new ArrayList<>(new HashSet<Integer>(xList));
            ArrayList<Integer> uniqueYList = new ArrayList<>(new HashSet<Integer>(yList));
    
            Collections.sort(uniqueXList);
            Collections.sort(uniqueYList);
            
            // dp[i][j]는 (0,0) ~ (i,j) 범위의 직사각형 내부에 존재하는 쐐기의 개수
            int[][] dp = new int[5000][5000];
            for (int i = 0; i < n; i++) {
                data[i][0] = uniqueXList.indexOf(xList.get(i));
                data[i][1] = uniqueYList.indexOf(yList.get(i));
    
                dp[data[i][1]][data[i][0]] = 1;
            }
    
            // dp(구간합) 구하기
            for (int r = 0; r < 5000; r++) {
                for (int c = 0; c < 5000; c++) {
                    if (r - 1 >= 0) {
                        dp[r][c] += dp[r - 1][c];
                    }
    
                    if (c - 1 >= 0) {
                        dp[r][c] += dp[r][c - 1];
                    }
    
                    if (r - 1 >= 0 & c - 1 >= 0) {
                        dp[r][c] -= dp[r - 1][c - 1];
                    }
                }
            }
            // x좌표 기준으로 정렬
            Arrays.sort(data, (o1, o2) -> (o1[0] - o2[0]));
            int answer = 0;
            for(int i=0; i<data.length-1; i++){
                for(int j=i+1; j<data.length; j++){
                    if(data[i][0] == data[j][0] || data[i][1] == data[j][1]) continue;
                    
                    int minY = Math.min(data[i][1], data[j][1]);
                    int maxY = Math.max(data[i][1], data[j][1]);
                    int minX = data[i][0];
                    int maxX = data[j][0];
                    
                    int count = dp[maxY - 1][maxX - 1] - dp[maxY - 1][minX] - 
                                  dp[minY][maxX - 1] + dp[minY][minX];
                                  
                    if (count == 0) {
                        answer += 1;
                    }
                }
            }
            return answer;
        }
    }
}
