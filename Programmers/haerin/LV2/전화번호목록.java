package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/42577
// title : 전화번호 목록
// type :
// time : 16m
// Created by haerin on 2023-02-15
import java.util.*;
public class 전화번호목록 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            Arrays.sort(phone_book);
            for(int i = 0; i<phone_book.length-1; i++){
                // phone_book[i+1].matches("^"+phone_book[i]+".*") matches함수보다 startsWith함수가 속도 빠름
                if(phone_book[i+1].startsWith(phone_book[i])){
                        answer = false;
                        break;
                }
            }
            return answer;
        }
    }
}
