// https://school.programmers.co.kr/learn/courses/30/lessons/62048
// title : 멀쩡한 사각형

public class 멀쩡한사각형 {
    class Solution {
        public long solution(int w, int h) {
            // 규칙 : (전체 크기) - (한 패턴 직사각형 당 사용하지 못하는 정사각형 크기 * 반복횟수)
            //       (w * h) - (((w / 최대공약수) + (h / 최대공약수) - 1) * 최대공약수)
            
            long gcd = gcd((long) w, (long) h);
            long wl = (long) w, hl = (long) h;
            
            return (wl * hl) - (((wl / gcd) + (hl / gcd) - 1) * gcd);
        }
        
        long gcd(long num1, long num2) {
            if(num2 == 0) return num1;
            else return gcd(num2, num1 % num2);
        }
    }
}