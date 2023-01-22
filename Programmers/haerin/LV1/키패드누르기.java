// https://school.programmers.co.kr/learn/courses/30/lessons/67256
// title : 키패드누르기
// type : ...
// time : 47m
// Created by haerin on 2023-01-21
public class 키패드누르기 {
    class Solution {
        public String solution(int[] numbers, String hand) {
            int[] left = new int[]{3,0};
            int[] right = new int[]{3,2};
            
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<numbers.length; i++) {
                if(numbers[i] %3 == 1) {
                    left[0] = numbers[i] / 3;
                    left[1] = 0;
                    sb.append("L");
                } else if (numbers[i] != 0 && numbers[i] %3 == 0) {
                    right[0] = (numbers[i] / 3) - 1;
                    right[1] = 2;
                    sb.append("R");
                } else {
                    int leftDistance = getDistance(left, numbers[i]);
                    int rightDistance = getDistance(right, numbers[i]);
                    
                    if(leftDistance < rightDistance) {
                        left[0] = (numbers[i] == 0) ? 3 : numbers[i] / 3;
                        left[1] = 1;
                        sb.append("L");
                    } else if(leftDistance > rightDistance) {
                        right[0] = (numbers[i] == 0) ? 3 : numbers[i] / 3;
                        right[1] = 1;
                        sb.append("R");
                    } else {
                        if(hand.equals("left")) {
                            left[0] = (numbers[i] == 0) ? 3 : numbers[i] / 3;
                            left[1] = 1;
                            sb.append("L");
                        } else {
                            right[0] = (numbers[i] == 0) ? 3 : numbers[i] / 3;
                            right[1] = 1;
                            sb.append("R");
                        }
                    }
                }
            }
            return sb.toString();
        }
        
        public int getDistance (int[] location, int num) {
            int[] numLocation = new int[2];
            numLocation[1] = 1;
            if(num == 0) {
                numLocation[0] = 3;
            } else {
                numLocation[0] = num/3;
            }
            return Math.abs(location[0]-numLocation[0]) + Math.abs(location[1]-numLocation[1]);
        }
    }
}
