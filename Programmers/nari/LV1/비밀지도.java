// https://school.programmers.co.kr/learn/courses/30/lessons/17681
// title : [1차] 비밀지도

public class 비밀지도 {
    class Solution1 {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            
            for(int i=0;i<n;i++) {
                String str1 = Integer.toBinaryString(arr1[i]);
                String str2 = Integer.toBinaryString(arr2[i]);
                StringBuilder sb = new StringBuilder();
                
                if(str1.length() < n) {
                    while(str1.length() != n) {
                        str1 = "0" + str1;
                    }
                }
                if(str2.length() < n) {
                    while(str2.length() != n) {
                        str2 = "0" + str2;
                    }
                }
                
                for(int j=0;j<n;j++) {
                    if(str1.charAt(j) == '1') sb.append("#");
                    else if(str2.charAt(j) == '1') sb.append("#");
                    else sb.append(" ");
                }
                
                answer[i] = sb.toString();
            }
            
            return answer;
        }
    }

    class Solution2 {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];

            for (int i=0;i<n;i++) {
                // answer[i] = String.format("%" + n + "s", answer[i]);
                // "%" + n + "s" 보다 빠르다.
                // n의 최대 수는 16 -> 조건에 나와있다.
                answer[i] = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
                answer[i] = answer[i].substring(answer[i].length() - n);
                answer[i] = answer[i].replaceAll("1", "#");
                answer[i] = answer[i].replaceAll("0", " ");
            }
            
            return answer;
        }
    }
}