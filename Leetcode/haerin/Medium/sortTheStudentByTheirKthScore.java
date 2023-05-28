package Leetcode.haerin.Medium;
// https://leetcode.com/problems/sort-the-students-by-their-kth-score/submissions/958655357/
// title : 2545. Sort the Students by Their Kth Score
// time : 5m
// Created by haerin on 2023-05-28
import java.util.*;
public class sortTheStudentByTheirKthScore {
    // 속도, 메모리 성능 모두 더 좋음
    class Solution {
        public int[][] sortTheStudents(int[][] score, int k) {
            Arrays.sort(score, new Comparator<int[]>(){
                @Override
                public int compare(int[] o1, int[] o2){
                    return o2[k] - o1[k];
                }
            });
            return score;
        }
    }
    class Solution2 {
        public int[][] sortTheStudents(int[][] score, int k) {
            Arrays.sort(score, (o1, o2) -> o2[k] - o1[k]);
            return score;
        }
    }
}
