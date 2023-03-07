// https://school.programmers.co.kr/learn/courses/30/lessons/1829
// title : 카카오프렌즈 컬러링북

public class 카카오프렌즈컬러링북 {
    class Solution {
        boolean[][] visited;
        int size = 0;
        // 1. 상 / 2. 하 / 3. 좌 / 4. 우
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        public int[] solution(int m, int n, int[][] picture) {
            int numberOfArea = 0;
            int maxSizeOfOneArea = 0;
            visited = new boolean[m][n];
            
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    // 해당 영역이 색칠한 영역이고, 방문한 적 없는 경우
                    if(picture[i][j] != 0 && !visited[i][j]) {
                        // 영역 갯수 count
                        numberOfArea++;
                        dfs(i, j, picture);
                    }
                    
                    // count한 size와 max size 비교해서 max
                    if(size > maxSizeOfOneArea) maxSizeOfOneArea = size;
                    size = 0;
                }
            }

            int[] answer = new int[2];
            answer[0] = numberOfArea;
            answer[1] = maxSizeOfOneArea;
            
            return answer;
        }
        
        void dfs(int x, int y,int[][] picture) {
            visited[x][y] = true;
            // 해당 영역의 size count
            size++;
            
            // 상하좌우로 연결된 같은 색상인지
            for(int i=0;i<4;i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                // 그림의 영역을 벗어난 경우
                if(nextX < 0 || nextX >= picture.length || nextY<0 || nextY >= picture[0].length) 
                    continue;

                // 현재 영역과 다음 영역이 같은 색상이고, 방문한 적 없는 경우
                if(picture[x][y] == picture[nextX][nextY] && !visited[nextX][nextY])
                    dfs(nextX, nextY, picture);
            }
        }
    }
}