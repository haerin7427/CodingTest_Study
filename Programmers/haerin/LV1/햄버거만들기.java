// https://school.programmers.co.kr/learn/courses/30/lessons/133502
// title : 햄버거 만들기
// type : ...
// time : help
// Created by haerin on 2023-01-31, 2023-02-04(2)
import java.util.*;
public class 햄버거만들기 {
    class Solution {
        public int solution(int[] ingredient) {
            Stack<Integer> stack = new Stack<>();
            int answer = 0;
            for(int food : ingredient) {
                if(food == 1 && stack.size() >= 3 && stack.lastIndexOf(3) == stack.size()-1 && stack.lastIndexOf(2) == stack.size()-2 && stack.lastIndexOf(1) == stack.size()-3){
                    answer+=1;
                    stack.pop();
                    stack.pop();
                    stack.pop();
                }else {
                    stack.push(food);
                }
            }
            return answer;
        }
    }
    // 속도 훨씬 빠름
    class Solution2 {
        public int solution(int[] ingredient) {
            int[] s = new int[ingredient.length];
            int answer = 0;
            int idx = 0;
            for(int i=0; i<ingredient.length; i++){
                if(ingredient[i] == 1 && idx > 2 && s[idx-3] == 1 && s[idx-2] == 2 && s[idx-1] == 3) {
                    answer += 1;
                    idx -= 3;
                }else{
                    s[idx++] = ingredient[i];
                }
            }
            return answer;
        }
    }
}
