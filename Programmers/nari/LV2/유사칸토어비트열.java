// https://school.programmers.co.kr/learn/courses/30/lessons/148652
// title : 유사 칸토어 비트열

public class 유사칸토어비트열 {
    class Solution1 {
        public int solution(int n, long l, long r) {
            // n = 1 일 때 size = 5 = 5의 1승
            // n = 2 일 때 size = 25 = 5의 2승
            // n = 3 일 때 size = 125 = 5의 3승
            // ... n일 때 size = 5^n
            
            // 1의 개수는 4의 n승
            // n = 1 , 11011 => 4^1
            // n = 2 , 11011 11011 00000 11011 11011 => 4^2
            // n = 3 , 11011 11011 00000 11011 11011 / 11011 11011 00000 11011 11011 / 00000 00000 00000 00000 00000 / ... => 4^3
            
            // n은 n-1의 전체 개수가 5개 모여 만들어진다. = 5개의 영역으로 구분이 가능하다
            // n = 1 11011 -> 5개
            // n = 2 5개 5개 5개 5개 5개 -> 25개
            // n = 3 25개 25개 25개 25개 25개 -> 125개
            // n = 4 125개 125개 125개 125개 125개 -> 625개
            
            int answer = 0;
            
            for(long i=l;i<=r;i++) {
                // 0인지 1인지 구분
                int flag = 1;
                
                // 5개씩 끊었을 때, 3번째에 0이 존재하기 때문에
                if(i % 5 == 3) continue;
                
                long temp = i;
                
                // '11011' 
                while(true) {
                    if(temp % 5 == 0) temp /= 5;
                    else temp = (temp / 5) + 1;
                    
                    // 3번째는 0
                    if(temp % 5 == 3) {
                        flag = 0;
                        break;
                    }
                    else if(temp <= 5) {
                        flag = 1;
                        break;
                    }
                }

                if(flag == 1) answer++;
            }
            
            return answer;
        }
    }

    class Solution2 {
        public int solution(int n, long l, long r) {
            int answer = 0;
            
            for(long i=l;i<=r;i++) {
                answer += query(n, i-1);
            }
            
            return answer;
        }
        
        int query(int n, long l) {
            if(n == 0 || l == 0) return 1;
            // 3번째인 경우, 0
            if (l % 5 == 2) return 0;
            
            return query(n-1, l / 5);
        }
    }
}