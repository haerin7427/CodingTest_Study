// https://school.programmers.co.kr/learn/courses/30/lessons/161990
// title : 바탕화면 정리

public class 바탕화면정리 {
    class Solution {
        public int[] solution(String[] wallpaper) {
            // 드래그 시작점, 끝점
            // wallpaper와 그 원소의 길이의 최대 값은 50이기 때문에
            int lux = 50, luy = 50, rdx = 0, rdy = 0;
            
            for(int i=0;i<wallpaper.length;i++) {
                String[] wall = wallpaper[i].split("");
                
                for(int j=0;j<wall.length;j++) {
                    // 파일일 경우, 해당 좌표 
                    if(wall[j].equals("#")) {
                        if(i < lux) lux = i;
                        if(j < luy) luy = j;
                        if(i+1 > rdx) rdx = i+1;
                        if(j+1 > rdy) rdy = j+1;
                    }
                }
            }
            
            int[] answer = {lux, luy, rdx, rdy};
            
            return answer;
        }
    }
}