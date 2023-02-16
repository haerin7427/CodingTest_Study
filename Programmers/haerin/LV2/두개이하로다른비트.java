package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/77885
// title : 2개 이하로 다른 비트
// type : 숫자 규칙
// time : 50m
// Created by haerin on 2023-02-16
public class 두개이하로다른비트 {
    class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];
            for(int i=0; i<numbers.length; i++){
                if(numbers[i] % 2 == 0 ){
                    answer[i] = numbers[i]+1;
                }else{
                    answer[i] = Long.parseLong(findZero(numbers[i]),2);                
                }
            }
            return answer;
        }
        
        public String findZero(long num){
            String number = Long.toBinaryString(num);
            for(int i=number.length()-1; i>=0; i--) {
                if(number.charAt(i) == '0'){
                    return number.substring(0,i) + "10" + number.substring(i+2);
                }
            }
            return "10" + number.substring(1);
        }
    }
}
