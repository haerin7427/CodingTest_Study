// https://leetcode.com/problems/sort-the-students-by-their-kth-score/
// title : 2545. Sort the Students by Their Kth Score
// time taken : 14 m 15 s

import java.util.*;

public class SorttheStudentsbyTheirKthScore {
    class Solution1 {
        public int[][] sortTheStudents(int[][] score, int k) {
            int len1 = score.length, len2 = score[0].length;
            int[][] answer = new int[len1][len2];
            ArrayList<int[]> list = new ArrayList<>();

            for(int[] s : score) {
                list.add(s);
            }

            // Collections.sort(list, (a, b) -> b[k] - a[k]);
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return b[k] - a[k];
                }
            });

            int idx = 0;
            
            for(int[] s : list) {
                for(int i=0;i<len2;i++) {
                    answer[idx][i] = s[i];
                }
                
                idx++;
            }

            return answer;
        }
    }

    class Solution2 {
        public int[][] sortTheStudents(int[][] score, int k) {
            Arrays.sort(score, (a, b) -> b[k] - a[k]);

            return score;
        }
    }
}
