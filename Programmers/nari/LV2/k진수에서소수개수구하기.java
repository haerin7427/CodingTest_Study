// https://school.programmers.co.kr/learn/courses/30/lessons/92335
// title : k진수에서 소수 개수 구하기

public class k진수에서소수개수구하기 {
    class Solution {
        public int solution(int n, int k) {
            int answer = 0;
            StringBuilder sb = new StringBuilder();
            
            while(n > 0) {
                sb.append(n % k);
                n /= k;
            }
            
            String s = sb.reverse().toString();
            String[] str = s.split("0");
            
            for(String ss : str){
                if(ss.equals("")) continue;
                    
                long num = Long.parseLong(ss);
                
                if(isPrime(num)) answer++;
            }
            
            return answer;
        }
        
        boolean isPrime(long num) {
            if(num < 2) return false;
            
            for(int i=2;i<=Math.sqrt(num);i++) {
                if(num%i == 0) return false;
            }
            
            return true;
        }
    }
}