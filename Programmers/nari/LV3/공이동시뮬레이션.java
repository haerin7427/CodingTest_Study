// https://school.programmers.co.kr/learn/courses/30/lessons/87391
// title : 공 이동 시뮬레이션

public class 공이동시뮬레이션 {
    class Solution {
        public long solution(int n, int m, int x, int y, int[][] queries) {
            // 공이 위치할 수 있는 범위를 구하기 위해 각 행, 열의 start 위치와 end 위치 변수
            long rowStart = x, rowEnd = x, colStart = y, colEnd = y;
            
            // n x m 배열에 모두 공이 가득차있고, query를 수행할때마다 cnt만큼 기울인다고 생각
            // 뒤에서부터 시작하기 때문에 방향과 반대로 연산
            for(int i=queries.length-1;i>=0;i--) {
                int dir = queries[i][0], cnt = queries[i][1];
                
                // 열 번호가 감소하는 방향 = 좌
                if(dir == 0) {
                    // colStart가 0인 아닌 경우, 감소하는 방향으로 이동하기가 가능 -> 더하기
                    if(colStart > 0) colStart += cnt;
                    
                    // 최대 공이 위치할 수 있는 end point 
                    colEnd = Math.min(m-1, colEnd+cnt);
                } 
                // 열 번호가 증가하는 방향 = 우
                else if(dir == 1) {
                    // colEnd가 m을 넘지 않는 경우, 증가하는 방향으로 이동하기가 가능 -> 빼기
                    if(colEnd < m-1) colEnd -= cnt;
                    
                    // 최대 공이 위치할 수 있는 start point 
                    colStart = Math.max(0, colStart-cnt);
                } 
                // 행 번호가 감소하는 방향 = 상
                else if(dir == 2) {
                    // rowStart 0인 아닌 경우, 감소하는 방향으로 이동하기가 가능 -> 더하기
                    if(rowStart > 0) rowStart += cnt;
                    
                    // 최대 공이 위치할 수 있는 end point 
                    rowEnd = Math.min(n-1, rowEnd+cnt);
                } 
                // 행 번호가 증가하는 방향 = 하
                else {
                    // rowEnd가 n을 넘지 않는 경우, 증가하는 방향으로 이동하기가 가능 -> 빼기
                    if(rowEnd < n-1) rowEnd -= cnt;
                    
                    // 최대 공이 위치할 수 있는 start point
                    rowStart = Math.max(0, rowStart-cnt);
                }
                
                // 주어진 쿼리만으로 x, y에 절대 도착하지 못하는 경우
                if(rowStart >= n || rowEnd < 0 || colStart >= m || colEnd < 0) return 0;	
            }
            
            // 구한 범위 곱하기
            return (rowEnd-rowStart+1) * (colEnd-colStart+1);
        }
    }
}