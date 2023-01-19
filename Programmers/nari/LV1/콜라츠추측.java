// https://school.programmers.co.kr/learn/courses/30/lessons/12943
// title : 콜라츠 추측

public class 콜라츠추측 {
    // 두 방식의 속도는 비슷
    
    class Solution1 {
        public int solution(int num) {
            int answer = 0;
            // int 형으로 했다가 오버플로우
            long n = num;
            
            if(n == 1) return 0;
            else {
                while(n != 1) {
                    if(answer==500) {
                        answer = -1;
                        break;
                    }
                    
                    if(n%2 == 0) n /= 2;
                    else n = n * 3 + 1;

                    answer++;
                }

                return answer;
            }
        }
    }

    class Solution2 {
        public int solution(int num) {
            int answer = 0;
            // int 형으로 했다가 오버플로우
            long n = num;
            
            if(n == 1) return 0;
            else {
                for(int i=0;i<500;i++) {
                    if(n==1) return i;
                    
                    n = (n%2==0) ? n/2 : n*3+1;
                }
            }
            
            return -1;
        }
    }
}