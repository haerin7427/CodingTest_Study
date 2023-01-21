// https://school.programmers.co.kr/learn/courses/30/lessons/17681
// title : [1차] 비밀지도
// time : 15m
// type : ...
// Created by haerin on 2023-01-21
public class 비밀지도 {
    // 0.057ms
    class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            int[][] map1 = changeToMap(n,arr1);
            int[][] map2 = changeToMap(n,arr2);
            for(int y=0; y<n; y++) {
                StringBuilder sb = new StringBuilder();
                for(int x=0; x<n; x++) {
                    if(map1[y][x] == 0 && map2[y][x] == 0)
                        sb.append(" ");
                    else
                        sb.append("#");
                }
                answer[y] = sb.toString();
            }
            return answer;
        }
        
        public int[][] changeToMap(int n, int[] arr){
            int[][] map = new int[n][n];
            
            for(int y=0; y<n; y++){
                int num = arr[y];
                for(int x=n-1; x>=0; x--){
                    if(num == 1) {
                        map[y][x] = 1;
                        break;
                    }
                    map[y][x] = num%2;
                    num /= 2;
                }
            }
            return map;
        }
    }
    class Solution2 {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            
            for(int i=0; i<n; i++) {
                // String temp = String.format("%"+n+"s", Integer.toBinaryString(arr1[i] | arr2[i])); // 보다 일단 최대 길이 16으로 설정하고 자르는 게 속도가 빠름 > 7.62ms vs 1.42ms
                String temp = String.format("%16s", Integer.toBinaryString(arr1[i] | arr2[i]));
                answer[i] = temp.substring(temp.length()-n).replaceAll("1","#").replaceAll("0", " ");
            }
            return answer;
        }
    } 
}
