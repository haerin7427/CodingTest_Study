// https://school.programmers.co.kr/learn/courses/30/lessons/42860
// title : 조이스틱

public class 조이스틱 {
    class Solution {
        public int solution(String name) {
            // 상하 이동 count, 좌우 이동 count (왼쪽에서 오른쪽으로 순서대로 이동했을 경우)
            int upDown = 0, leftRight = name.length() - 1;
            
            for(int i=0;i<name.length();i++) {
                // 알파벳 갯수 중간을 기준으로
                // 중간보다 작을 경우, a에서 up
                // 중간보다 클 경우, a에서 down
                if(name.charAt(i) < 'N') upDown += name.charAt(i) - 'A';
                else upDown += 'Z' - name.charAt(i) + 1;
                
                // 연속되는 A의 갯수를 기반으로 A기준 뒷부분의 길이, A기준 앞부분의 길이 판단
                // 이 두 길이를 기반으로 앞쪽, 뒷쪽 중 어디가 더 빠른지 계산
                // 연속되는 A의 마지막 index
                int idx = i + 1;
                while(idx < name.length() && name.charAt(idx) == 'A') {
                    idx++;
                }
                
                // 좌우이동
                // i + name.length() - idx = 바로 옆의 연속되는 A들을 제외한 다른 문자들의 길이 - 1
                // Math.min(i, name.length() - idx) = 왼쪽에서 접근하는 경우와 오른쪽에서 접근하는 경우 중 작은 숫자
                leftRight = Math.min(leftRight, i + name.length() - idx + Math.min(i, name.length() - idx));
            }
            
            return upDown + leftRight;
        }
    }
}