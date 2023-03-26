// https://school.programmers.co.kr/learn/courses/30/lessons/172928
// title : 공원 산책

public class 공원산책 {
    class Solution {
        public int[] solution(String[] park, String[] routes) {
            int[] answer = new int[2];
            // 공원 세로길이, 가로길이
            int h = park.length, w = park[0].length();
            
            for(int i=0;i<park.length;i++) {
                if(park[i].indexOf("S") != -1) {
                    answer[0] = i;
                    answer[1] = park[i].indexOf("S");
                    break;
                }
            }

            for(String route : routes) {
                // 이동할 방향
                char op = route.charAt(0);
                // 이동할 칸의 수
                int n = route.charAt(2) - '0';
                // 장애물 판단
                boolean isBlock = false;
                
                // 북쪽이고, 공원을 벗어나지 않는 경우 -> 위로
                if(op == 'N' && answer[0]-n >= 0) {
                    for(int i=1;i<=n;i++) {
                        if(park[answer[0]-i].charAt(answer[1]) == 'X') {
                            isBlock = true;
                            break;
                        }
                    }
                    
                    if(isBlock) continue;
                    
                    answer[0] -= n;
                }
                // 남쪽이고, 공원을 벗어나지 않는 경우 -> 아래로
                else if(op == 'S' && answer[0]+n < h) {
                    for(int i=1;i<=n;i++) {
                        if(park[answer[0]+i].charAt(answer[1]) == 'X') {
                            isBlock = true;
                            break;
                        }
                    }
                    
                    if(isBlock) continue;
                    
                    answer[0] += n;
                }
                // 서쪽이고, 공원을 벗어나지 않는 경우 -> 좌로
                else if(op == 'W' && answer[1]-n >= 0) {
                    for(int i=1;i<=n;i++) {
                        if(park[answer[0]].charAt(answer[1]-i) == 'X') {
                            isBlock = true;
                            break;
                        }
                    }
                    
                    if(isBlock) continue;
                    
                    answer[1] -= n;
                }
                // 동쪽이고, 공원을 벗어나지 않는 경우 -> 우로
                else if(op == 'E' && answer[1]+n < w) {
                    for(int i=1;i<=n;i++) {
                        if(park[answer[0]].charAt(answer[1]+i) == 'X') {
                            isBlock = true;
                            break;
                        }
                    }
                    
                    if(isBlock) continue;
                    
                    answer[1] += n;
                }
            }
            
            return answer;
        }
    }
}