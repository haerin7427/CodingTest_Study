package Programmers.haerin.LV3;
// https://school.programmers.co.kr/learn/courses/30/lessons/42892
// title : 길 찾기 게임
// type : 이진트리
// time : 45m
// Created by haerin on 2023-03-30
import java.util.*;
public class 길찾기게임 {
    class Solution {
        private int idx =0;
        class Node {
            int index;
            int y;
            int x;
            Node left;
            Node right;
            
            Node(int index, int y, int x){
                this.index = index;
                this.y = y;
                this.x = x;
            }
        }
        public int[][] solution(int[][] nodeinfo) {
            List<Node> nodeList = new ArrayList<>();
            for(int i=0; i<nodeinfo.length; i++){
                nodeList.add(new Node(i+1, nodeinfo[i][1], nodeinfo[i][0]));
            }
            Collections.sort(nodeList, new Comparator<Node>(){
                @Override
                public int compare(Node n1, Node n2){
                    if(n1.y != n2.y){
                        return n2.y - n1.y;
                    }else{
                        return n1.x - n2.x;
                    }
                }
            });
            
            // 이진 트리 그리기
            Node parent = nodeList.get(0);
            for(int i=1;i<nodeList.size();i++){
                MakeTree(parent,nodeList.get(i));
            }
            
            
            int[][] answer = new int[2][nodeinfo.length];
            // 전위순회
            preorder(nodeList.get(0), answer);
            idx = 0;
            // 후위순회
            postorder(nodeList.get(0), answer);
            return answer;
        }
        
        public void preorder(Node root, int[][] answer){
            if(root!=null){
                answer[0][idx++]=root.index;
                preorder(root.left, answer);
                preorder(root.right, answer);
    
            }
        }
        
        public void postorder(Node root, int[][] answer){
            if(root!=null){
                postorder(root.left, answer);
                postorder(root.right, answer);
                answer[1][idx++]=root.index;
            }
        }
        
        public void MakeTree (Node parent, Node child){
          if(parent.x<child.x){      
            if(parent.right==null){
                parent.right=child;
            }
             else{
                MakeTree(parent.right,child);
             }
          }
          else{
            if(parent.left==null){
                parent.left=child;
            }
            else{
                MakeTree(parent.left,child);
            }
          }  
        }
    }
}
