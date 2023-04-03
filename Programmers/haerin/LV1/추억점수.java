// https://school.programmers.co.kr/learn/courses/30/lessons/176963
// title : 추억 점수
// type : Hashmap
// time : 3m
// Created by haerin on 2023-04-02
import java.util.*;
public class 추억점수 {
    class Solution {
        public int[] solution(String[] name, int[] yearning, String[][] photo) {
            Map<String, Integer> hashmap = new HashMap<>();
            for(int i=0; i<name.length; i++){
                hashmap.put(name[i], yearning[i]);
            }
            int[] answer = new int[photo.length];
            for(int i=0; i<photo.length; i++){
                int sum = 0;
                for(String person : photo[i]){
                    sum += hashmap.getOrDefault(person, 0);
                }
                answer[i] = sum;
            }
            return answer;
        }
    }
}
