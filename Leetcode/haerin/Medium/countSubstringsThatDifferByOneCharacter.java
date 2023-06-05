package Leetcode.haerin.Medium;
// https://leetcode.com/problems/count-substrings-that-differ-by-one-character/description/
// title : 1638. Count Substrings That Differ by One Character
// type : ...
// time : ...
// Created by haerin on 2023-06-05
public class countSubstringsThatDifferByOneCharacter {
    class Solution {
        public int countSubstrings(String s, String t) {
            char[] s1=s.toCharArray();
            char[] t1=t.toCharArray();
    
            int answer = 0;
            int N = s.length();
            int M = t.length();
    
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    int a = i, b = j;
                    int d = 0;
                    while(a < N && b < M) {
                        if(s1[a++] != t1[b++]) {
                            d += 1;
                        }
                        if(d==1) {
                            answer += 1;
                        }else if(d == 2) {
                            break;
                        }
                    }
                }
            }
            return answer;
        }
    }
}
