// https://school.programmers.co.kr/learn/courses/30/lessons/42883
// title : 큰 수 만들기

public class 큰수만들기 {
    class Solution {
        public String solution(String number, int k) {
            StringBuilder sb = new StringBuilder();
            int idx = 0;

            // number에서 k를 뺀 길이 만큼 반복 = 반환값과 동일한 길이
            for(int i=0;i<number.length()-k;i++) {
                int max = 0;
                
                // max의 index부터 i+k 만큼 반복
                for(int j=idx;j<=i+k;j++) {
                    int num = Character.getNumericValue(number.charAt(j));
                    
                    if(max < num) {
                        max = num;
                        idx = j+1;
                    }

                    // 추가하면 시간 초과 해결
                    // 9는 제일 큰 숫자기 때문에 더이상 반복문을 돌 필요가 없다.
                    if(max == 9) break;
                }
                
                sb.append(max);
            }
            
            return sb.toString();
        }
    }
}