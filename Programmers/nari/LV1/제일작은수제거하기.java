// https://school.programmers.co.kr/learn/courses/30/lessons/12935
// title : 제일 작은 수 제거하기

import java.util.*;
import java.util.stream.Stream;

public class 제일작은수제거하기 {
    class Solution1 {
        public int[] solution(int[] arr) {
            int[] answer = new int[arr.length>1 ? arr.length-1 : 1];
            
            if(arr.length==1) answer[0] = -1;
            else {
                int min = arr[0], idx = 0;
                
                for(int i=1;i<arr.length;i++) {
                    if(min > arr[i]) min = arr[i];
                }
                
                for(int i=0;i<arr.length;i++) {
                    if(min == arr[i]) continue;
                    else {
                        answer[idx] = arr[i];
                        idx++;
                    }
                }
            }
            
            return answer;
        }
    }

    // 확실히 stream이 느림
    class Solution2 {
        public int[] solution(int[] arr) {
            if (arr.length <= 1) return new int[]{-1};
            
            int min = Arrays.stream(arr).min().getAsInt();
            
            return Arrays.stream(arr).filter(i -> i != min).toArray();
        }
    }
}