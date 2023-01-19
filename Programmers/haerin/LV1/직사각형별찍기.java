// https://school.programmers.co.kr/learn/courses/30/lessons/12969
// title : 직삭각형 별찍기
// time : 2m
// type : 
// Created by haerin on 2023-01-19
import java.util.Scanner;
public class 직사각형별찍기 {
    class Solution {
        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            for(int y=0; y<b; y++){
                for(int x=0; x<a; x++){
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
    class Solution2 {
        public void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            StringBuilder sb = new StringBuilder();
            
            for(int x=0; x<a; x++) {
                sb.append("*");
            }
            
            for(int y=0; y<b; y++) {
                System.out.println(sb.toString());
            }
        }
    }
}
