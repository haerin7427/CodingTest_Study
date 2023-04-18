package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/150366
// title : 표병합
// type : Union-Find 알고리즘
// time : ...
// Created by haerin on 2023-04-17
import java.util.*;
public class 표병합 {
    class Solution {
        String[] board = new String[2501];
        int[] root = new int[2501];

        public int find(int a) {
            if (root[a] == a)
                return a;
            else
                return root[a] = find(root[a]);
        }

        public void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a != b)
                root[b] = a;
        }
        
        public String[] solution(String[] commands) {
            for(int i=1; i<board.length; i++){
                root[i] = i;
                board[i] = "";
            }
            List<String> printList = new ArrayList<>();
            
            for(String command : commands){
                String[] info = command.split(" ");
                
                if(info[0].equals("UPDATE")){
                    if(info.length == 3){
                        String before = info[1];
                        String after = info[2];
                        
                        for(int i=1; i<board.length; i++){
                            if(board[i].equals(before)){
                                board[i] = after;
                            }
                        }
                    }else{
                        int r = Integer.parseInt(info[1]);
                        int c = Integer.parseInt(info[2]);
                        String value = info[3];
                        
                        int idx = getIndex(r, c);
                        board[find(idx)] = value;
                    }
                }else if(info[0].equals("MERGE")){
                    int r1 = Integer.parseInt(info[1]);
                    int c1 = Integer.parseInt(info[2]);
                    int r2 = Integer.parseInt(info[3]);
                    int c2 = Integer.parseInt(info[4]);
                    
                    int idx1 = getIndex(r1, c1);
                    int idx2 = getIndex(r2, c2);
                    int root1 = find(idx1);
                    int root2 = find(idx2);
                    if(root1 == root2) continue;
                    String rootString = board[root1].isBlank() ? board[root2] : board[root1];
                    board[root1] = "";
                    board[root2] = "";
                    union(root1, root2);
                    board[root1] = rootString;
                    
                }else if(info[0].equals("UNMERGE")){
                    int r = Integer.parseInt(info[1]);
                    int c = Integer.parseInt(info[2]);
                    int idx = getIndex(r, c);
                    int rootIdx = find(idx);
                    String value = board[rootIdx];
                    
                    
                    List<Integer> deleteList = new ArrayList<>();
                    for(int i=1; i<root.length; i++){
                        if(rootIdx == find(i)){
                            deleteList.add(i);
                        }
                    }
                    
                    for(int i : deleteList){
                        root[i] = i;
                        board[i] = "";
                    }
                    board[idx] = value;
                }else{
                    int r = Integer.parseInt(info[1]);
                    int c = Integer.parseInt(info[2]);
                    int idx = getIndex(r, c);
                    int rootIdx = find(idx);
                    if(board[rootIdx].isBlank()){
                        printList.add("EMPTY");
                    }else{
                        printList.add(board[rootIdx]);
                    }
                }
            }
            String[] answer = new String[printList.size()];
            int idx = 0;
            for(String s : printList){
                answer[idx++] = s;
            }
            return answer;
        }
        
        private int getIndex(int r, int c){
            return (r-1) * 50 + c ;
        }
    }
}
