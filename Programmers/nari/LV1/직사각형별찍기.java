// https://school.programmers.co.kr/learn/courses/30/lessons/12969
// title : 직사각형 별찍기

import java.util.Scanner;
import java.util.stream.IntStream;

public class 직사각형별찍기 {
    class Solution1 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            for(int i=0;i<b;i++) {
                for(int j=0;j<a;j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }

    class Solution2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            StringBuilder sb = new StringBuilder();
            IntStream.range(0, a).forEach(s -> sb.append("*"));
            IntStream.range(0, b).forEach(s -> System.out.println(sb.toString()));
        }
    }
}