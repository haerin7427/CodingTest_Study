// https://school.programmers.co.kr/learn/courses/30/lessons/172928
// title : 공원산책
// type : 구현
// time : 13m
// Created by haerin on 2023-03-26
public class 공원산책 {
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            int x = 0; int y = 0;
            for(int i = 0; i<park.length; i++){
                for(int j=0; j<park[0].length(); j++){
                    if(park[i].charAt(j) == 'S'){
                        y = i;
                        x = j;
                        break;
                    }
                }
            }
            
            for(String route : routes){
                String[] info = route.split(" ");
                int nx = x;
                int ny = y;
                if(info[0].equals("E")){
                    nx += Integer.parseInt(info[1]);
                }else if(info[0].equals("W")){
                    nx -= Integer.parseInt(info[1]);
                }else if(info[0].equals("S")){
                    ny += Integer.parseInt(info[1]);
                }else if(info[0].equals("N")){
                    ny -= Integer.parseInt(info[1]);
                }
                // 이동 후 공원의 범위를 넘어가지 않는 지
                if(0 > nx || park[0].length() <= nx || 0 > ny || park.length <= ny) continue;
                // 중간에 벽이 없는지
                int start=0, end=0;
                boolean flag = true;
                if(info[0].equals("E") || info[0].equals("W")){
                    start = Math.min(x, nx);
                    end = Math.max(x, nx);
                    for(int i=start; i<=end; i++){
                        if(park[y].charAt(i) == 'X'){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) continue;
                }else{
                    start = Math.min(y, ny);
                    end = Math.max(y, ny);
                    for(int i=start; i<=end; i++){
                        if(park[i].charAt(x) == 'X'){
                            flag = false;
                            break;
                        }
                    }
                    if(!flag) continue;
                }
                x = nx;
                y = ny;
            }
            int[] answer = new int[]{y,x};
            return answer;
        }
    }
}
