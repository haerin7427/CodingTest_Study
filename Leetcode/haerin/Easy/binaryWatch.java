package Leetcode.haerin.Easy;
// https://leetcode.com/problems/binary-watch/description/
// title : 401. Binary Watch
// type : Bit
// time : 10m
// Created by haerin on 2023-05-30
import java.util.*;
public class binaryWatch {
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> answer = new ArrayList<>();
            for(int hour = 0; hour < 12; hour++){
                for(int minute=0; minute<60; minute++){
                    if(Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn){
                        answer.add(String.format("%d:%02d", hour, minute));
                    }
                }
            }
            return answer;
        }
    }
}
