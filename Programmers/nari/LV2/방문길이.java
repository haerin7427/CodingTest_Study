// https://school.programmers.co.kr/learn/courses/30/lessons/49994
// title : 방문 길이

public class 방문길이 {
    class Solution {
        public int solution(String dirs) {
            int answer = 0;
            String[] dir = dirs.split("");
            int[] position = new int[2];
            int[] nextPosition = new int[2];
            HashMap<Integer, int[][]> map = new HashMap<>();
            boolean check = false;
            int idx = 0;
            
            for(String d : dir) {        
                // 명령어를 이행했을 때, 위치 계산
                if(d.equals("U")) nextPosition[1] += 1;
                else if(d.equals("D")) nextPosition[1] -= 1;
                else if(d.equals("R")) nextPosition[0] += 1;
                else if(d.equals("L")) nextPosition[0] -= 1;
                
                // 위치가 -5보다 적어지거나 5보다 많아지면, 무시
                if(nextPosition[0] < -5) {
                    nextPosition[0] += 1;
                    continue;
                }
                else if(nextPosition[0] > 5) {
                    nextPosition[0] -= 1;
                    continue;
                }
                else if(nextPosition[1] < -5) {
                    nextPosition[1] += 1;
                    continue;
                }
                else if(nextPosition[1] > 5) {
                    nextPosition[1] -= 1;
                    continue;
                }
                
                // 이미 지나온 길인지 확인
                for(int key : map.keySet()) {
                    int[][] value = map.get(key);
                    
                    // a -> b이거나 b -> a인 경우, 같은 길로 판단하도록
                    if(Arrays.equals(position, value[0]) && Arrays.equals(nextPosition, value[1]) || Arrays.equals(position, value[1]) && Arrays.equals(nextPosition, value[0])) {
                        check = true;
                        break;
                    }
                }
                
                // 지나온 길 좌표 저장해두기
                if(check) check = false;
                else {
                    map.put(idx++, new int[][]{{position[0], position[1]}, {nextPosition[0], nextPosition[1]}});
                    answer++;
                }
                
                // 현재 위치로 변경해주기
                position[0] = nextPosition[0];
                position[1] = nextPosition[1];
            }
            
            return answer;
        }
    }
}