package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/81302
// title : 거리두기 확인하기
// type : bfs
// time : ...
// Created by haerin on 2023-03-03
import java.util.*;
public class 거리두기확인하기 {
    class Solution {
        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];
            int[][] d = new int[][]{{1,0}, {-1,0},{0,1},{0,-1}};
            int th=0;
            for(String[] place : places){
                
                boolean flag = true;
                for (int r = 0; r < 5 && flag; r++) {
                    for (int c = 0; c < 5 && flag; c++) {
                        if (place[r].charAt(c) == 'P') {
                            if (!bfs(r, c, place))
                                flag = false;
                        }
                    }
                }
                if(flag){
                    answer[th++] = 1;
                }else{
                    answer[th++] = 0;
                }
            }
            return answer;
        }
        private boolean bfs(int r, int c, String[] p) {
            int dr[] = { -1, 1, 0, 0 };
            int dc[] = { 0, 0, -1, 1 };

            Queue<int[]> queue = new LinkedList<int[]>();
            queue.offer(new int[] { r, c });

            while (!queue.isEmpty()) {
                int[] position = queue.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = position[0] + dr[i];
                    int nc = position[1] + dc[i];

                    if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5 || (nr == r && nc == c))
                        continue;

                    int d = Math.abs(nr - r) + Math.abs(nc - c);

                    if (p[nr].charAt(nc) == 'P' && d <= 2)
                        return false;
                    else if (p[nr].charAt(nc) == 'O' && d < 2)
                        queue.offer(new int[] { nr, nc });
                }
            }

            return true;
        }
    }
}
