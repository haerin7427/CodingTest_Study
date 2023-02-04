// https://school.programmers.co.kr/learn/courses/30/lessons/42842
// title : 카펫

public class 카펫 {
    class Solution1 {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];
            
            if(Math.sqrt(yellow) == (int) Math.sqrt(yellow)) {
                int sqrt = (int) Math.sqrt(brown + yellow);
                answer = new int[] {sqrt, sqrt};
            }
            else {
                // browm + yellow의 약수가 행, 열
                int total = brown + yellow;
                
                // yellow는 최소 1이니까 행, 열은 각 최소 3
                for(int i=3;i<=Math.sqrt(total);i++) {
                    if(total % i == 0) {
                        int x = total / i, y = i;
                        
                        // x-2 * y-2 == yellow
                        if((x-2) * (y-2) == yellow) {
                            answer[0] = x;
                            answer[1] = y;
                            break;
                        }
                    }
                }
            }
            
            return answer;
        }
    }

    // 근의공식 이용
    class Solution2 {
        public int[] solution(int brown, int yellow) {
            // 근의 공식
            // a는 완성된 카펫의 가로+세로
            int a = (brown + 4) / 2;
            // b는 주어진 타일의 개수를 모두 합친 값
            int b = brown + yellow;
            
            // 두 해 x1, x2가 가로,세로인 x2-ax+b=0 이차방정식을 만들어 근의공식을 이용해 푼다
            // a는 두 해의 합, b는 두 해의 곱
            int[] answer = {(int)(a + Math.sqrt(a*a - 4*b)) / 2, (int)(a - Math.sqrt(a*a - 4*b)) / 2};
            
            return answer;
        }
    }
}