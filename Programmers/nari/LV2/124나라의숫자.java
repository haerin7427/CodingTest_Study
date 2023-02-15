// https://school.programmers.co.kr/learn/courses/30/lessons/12899
// title : 124 나라의 숫자

public class 124나라의숫자 {
    class Solution1 {
        public String solution(int n) {
            StringBuilder sb = new StringBuilder();
            int[] num = {0, 1, 2, 4};
            
            while(n > 3){
                int q = n / 3;
                int r = n % 3;
                
                // 나머지는 1~3 중에서 나와야하기 떄문에 0일 경우 예외 처리
                if(r == 0) {
                    q = q - 1;
                    r = r + 3;
                }
                
                n = q;
                sb.append(num[r]);
            }
            
            sb.append(num[n]);
            
            return sb.reverse().toString();
        }
    }

    class Solution2 {
        public String solution(int n) {
            StringBuilder sb = new StringBuilder();
            int[] num = {4, 1, 2};
            
            while(n > 0){
                sb.append(num[n % 3]);
                n = (n - 1) / 3;
            }
            
            return sb.reverse().toString();
        }
    }
}