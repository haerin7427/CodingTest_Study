// https://leetcode.com/problems/count-sorted-vowel-strings/
// title : 1641. Count Sorted Vowel Strings
// time taken : 11 m 55 s

public class CountSortedVowelStrings {
    class Solution {
        public int countVowelStrings(int n) {
            int a = 1, e = 1, i = 1, o = 1, u = 1;

            for(int k=1;k<n;k++) {
                // a는 모든 모음과 조합 가능
                a = a+e+i+o+u;
                // e는 a를 제외한 모음과 조합 가능
                e = e+i+o+u;
                // i는 a, e를 제외한 모음과 조합 가능
                i = i+o+u;
                // o는 a, e, i를 제외한 모음과 조합 가능
                o = o+u;
                // u는 자기자신과의 조합만 가능
            }

            return a + e + i + o + u;
        }
    }
}
