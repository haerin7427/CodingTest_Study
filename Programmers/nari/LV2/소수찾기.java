// https://school.programmers.co.kr/learn/courses/30/lessons/42839
// title : 소수 찾기

public class 소수찾기 {
    // 재귀 함수 사용
    class Solution {
        HashSet<Integer> set = new HashSet<>();
        char[] arr;
        boolean[] visited;
        
        public int solution(String numbers) {
            arr= new char[numbers.length()];
            visited= new boolean[numbers.length()];
            
            for(int i=0;i<numbers.length();i++){
                arr[i] = numbers.charAt(i);
            }
            
            recursion("", 0);
            
            return set.size();
        }
        
        void recursion(String str, int idx){
            if(str.length() != 0) {
                int num= Integer.parseInt(str);
                if(isPrime(num)) set.add(num);
            }
            
            if(idx == arr.length) return;
            
            for(int i=0;i<arr.length;i++){
                if(visited[i]) continue;
                
                visited[i]= true;
                recursion(str+arr[i], idx+1);
                visited[i]= false;
            }
        }
        
        boolean isPrime(int num) {
            if(num < 2) return false;
                
            for(int i=2;i<=Math.sqrt(num);i++) {
                if(num%i == 0) return false;
            }
                
            return true;
        }
    }
}