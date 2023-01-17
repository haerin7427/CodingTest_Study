// https://school.programmers.co.kr/learn/courses/30/lessons/12948
// title : 핸드폰 번호 가리기
// time : 4m
// type : 문자열 
// Created by haerin on 2023/01/16
public class 핸드폰번호가리기 {
    class Solution {
        public String solution(String phone_number) {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< phone_number.length()-4; i++)
                sb.append("*");
            sb.append(phone_number.substring(phone_number.length()-4));
            return sb.toString();
            // return phone_number.replaceAll(".(?=.{4})", "*");
        }
    }
}
