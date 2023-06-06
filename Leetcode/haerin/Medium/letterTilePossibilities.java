package Leetcode.haerin.Medium;
// https://leetcode.com/problems/letter-tile-possibilities/description/
// title : 1079. Letter Tile Possibilities
// type : Backtracking
// time : ...
// Created by haerin on 2023-06-05
import java.util.*;
public class letterTilePossibilities {
    class Solution {
        public int numTilePossibilities(String tiles) {
            Set<String> set = new HashSet<>();
            boolean[] isVisited = new boolean[tiles.length()];
            makeString(tiles, "", set, isVisited);
            return set.size()-1;
        }
    
        private void makeString(String tiles, String cur, Set<String> set, boolean[] isVisited){
            set.add(cur);
            for(int i=0; i<tiles.length(); i++) {
                if(!isVisited[i]){
                    isVisited[i]=true;
                    makeString(tiles, cur+tiles.charAt(i), set, isVisited);
                    isVisited[i]=false;
                }
            }
        }
    }
}
