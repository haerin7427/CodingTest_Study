// https://school.programmers.co.kr/learn/courses/30/lessons/12936
// title : 줄 서는 방법

import java.util.*;

public class 줄서는방법 {
    // 규칙: 순열
    // 예) n = 3, k = 5
    // 경우의 수 = n! = 3! = 3 x 2 x 1 = 6
    // 첫번째 자리수 = n!/n = (n - 1)! = 2! = 2 x 1 = 2 마다 바뀜
    // (n - 1)! / k = 첫 번째 자리수
    // (n - 1)! % k = 다음 자리를 구할 때 k

    class Solution {
        public int[] solution(int n, long k) {
            int[] answer = new int[n];
            ArrayList<Integer> list = new ArrayList<>();
            long fac = 1;
            int idx = 0;
            
            for(int i=1;i<=n;i++) {
                fac *= i;
                list.add(i);
            }
            
            // index를 구할 것이기 때문에 -1
            k--;
            while(n > 0) {
                // 1~n 번째 자리에 들어갈 경우의 수 (n -> 첫번째 자리, n-1 -> 두번째 자리, ...)
                fac /= n;
                
                // 해당 번째 자리의 들어올 index
                int index = (int) (k / fac);
                answer[idx++] = list.get(index);
                list.remove(index);

                // 다음 번째 자리수를 구하기 위해 k를 fac로 나눈 나머지
                k %= fac;
                n--;
            }
            
            return answer;
        }
    }
}