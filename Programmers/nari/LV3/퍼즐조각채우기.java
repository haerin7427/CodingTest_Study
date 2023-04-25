// https://school.programmers.co.kr/learn/courses/30/lessons/84021
// title : 퍼즐 조각 채우기

import java.util.*;

public class 퍼즐조각채우기 {
    class Solution {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        public int solution(int[][] game_board, int[][] table) {
            int boardLen = game_board.length;
            int tableLen = table.length;
            boolean[][] visitedTable = new boolean[tableLen][tableLen];
            boolean[][] visitedBoard = new boolean[boardLen][boardLen];
            ArrayList<ArrayList<int[]>> boardList = new ArrayList<>();
            ArrayList<ArrayList<int[]>> tableList = new ArrayList<>();

            for(int i=0;i<tableLen;i++) {
                for(int j=0;j<tableLen;j++) {
                    // tableList에 조각 좌표 담기
                    // table에 조각이 놓여있고, 방문한 적 없는 경우
                    if(table[i][j] == 1 && !visitedTable[i][j])
                        bfs(i, j, visitedTable, table, 1, tableList);

                    // boardList에 빈칸 좌표 담기
                    // game_board이 빈칸이고, 방문한 적 없는 경우
                    if(game_board[i][j] == 0 && !visitedBoard[i][j])
                        bfs(i, j, visitedBoard, game_board, 0, boardList);
                }
            }
            
            return findBlock(boardList, tableList);
        }
        
        public void bfs(int curX, int curY, boolean[][] visited, int[][] graph, int blockOrEmpty, ArrayList<ArrayList<int[]>> list) {
            Queue<int[]> queue = new LinkedList<>();
            int len = graph.length;
            
            visited[curX][curY] = true;
            queue.add(new int[]{curX, curY});
            ArrayList<int[]> subList = new ArrayList<>();
            // [0, 0]에서 시작하는 좌표로 만들기 -> [curX-curX, curY-curY]
            subList.add(new int[]{0, 0});

            while(!queue.isEmpty()) {
                int[] cur = queue.remove();
                int x = cur[0];
                int y = cur[1];

                for(int i=0;i<4;i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    // 판을 벗어난 경우
                    if(0 > nx || nx >= len || 0 > ny || ny >= len) continue;
                    
                    // 이동할 위치에 방문한 적 없고, 
                    // board = 0, table = 1인 경우
                    if(!visited[nx][ny] && graph[nx][ny] == blockOrEmpty) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                        subList.add(new int[]{nx - curX, ny - curY});
                    }
                }
            }
            
            list.add(subList);
        }
        
        public int findBlock(ArrayList<ArrayList<int[]>> board, ArrayList<ArrayList<int[]>> table) {
            int size = 0;
            int boardLen = board.size();
            int tableLen = table.size();
            boolean[] visitedBoard = new boolean[boardLen];
            
            // table의 조각 좌표들
            for(int i=0;i<tableLen;i++) {
                ArrayList<int[]> tablePoints = table.get(i);
                
                // game_board의 빈칸 좌표들
                for(int j=0;j<boardLen;j++) {
                    ArrayList<int[]> boardPoints = board.get(j);

                    // 좌표 개수가 같고, 해당 game_board 좌표에 방문한 적 없는 경우
                    if(tablePoints.size() == boardPoints.size() && !visitedBoard[j]) { 
                        // 회전해서 조각을 채워 넣을 수 있는지 확인
                        if(isRotate(boardPoints, tablePoints)) { 
                            // 몇 칸을 채울 수 있는지가 return 값 -> table의 조각 좌표들 갯수
                            size += tablePoints.size();
                            visitedBoard[j] = true;
                            break;
                        }
                    }
                }
            }

            return size;
        }
        
        public boolean isRotate(ArrayList<int[]> board, ArrayList<int[]> table) {
            // 조각이 완전히 맞는지
            boolean isCollect = false;
            int boardLen = board.size();
            int tableLen = table.size();

            board.sort((o1, o2) -> {
                // x 좌표 기준으로 오름차순, 동일할 경우 y 좌표 기준 오름차순
                return o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]);
            });

            // table 조각 0, 90, 180, 270도 회전
            for(int i=0;i<4;i++) { 
                table.sort((o1, o2) -> {
                    // x 좌표 기준으로 오름차순, 동일할 경우 y 좌표 기준 오름차순
                    return o1[0] > o2[0] ? 1 : o1[0] < o2[0] ? -1 : Integer.compare(o1[1], o2[1]);
                });
                
                // 0도일 경우엔 무조건 [0, 0] 시작이라 if(i != 0) 조건문 추가 -> 10, 12 케이스 실패 -> 제거
                // [0, 0]에서 시작하는 좌표로 만들기 -> [curX-curX, curY-curY]
                int x = table.get(0)[0];
                int y = table.get(0)[1];

                for(int j=0;j<tableLen;j++) {
                    table.get(j)[0] -= x;
                    table.get(j)[1] -= y;
                }

                // 좌표 하나하나가 맞는지
                boolean isCollectPoint = true;
                
                // 좌표 비교
                for(int j=0;j<boardLen;j++) { 
                    int[] boardPoint = board.get(j);
                    int[] tablePoint = table.get(j);

                    // 좌표가 일치하지 않는 경우
                    if(boardPoint[0] != tablePoint[0] || boardPoint[1] != tablePoint[1]) {
                        isCollectPoint = false;
                        break;
                    }
                }

                if(isCollectPoint) {
                    isCollect = true;
                    break;
                } 
                else { 
                    // 90도 회전 : [x, y] -> [y, -x]
                    for(int j=0;j<tableLen;j++) {
                        int temp = table.get(j)[0];
                        table.get(j)[0] = table.get(j)[1];
                        table.get(j)[1] = -temp;
                    }
                }
            }
            
            return isCollect;
        }
    }
}