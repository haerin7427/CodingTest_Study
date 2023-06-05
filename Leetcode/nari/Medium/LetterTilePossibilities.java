// https://leetcode.com/problems/letter-tile-possibilities/
// title : 1079. Letter Tile Possibilities
// time taken : 

public class LetterTilePossibilities {
    class Solution {
        HashSet<String> set = new HashSet<>();
        String Tiles;
        int len;

        public int numTilePossibilities(String tiles) {
            Tiles = tiles;
            len = tiles.length();
            boolean[] visited;

            for(int i=1;i<=len;i++) {
                visited = new boolean[len];

                backtracking(i, new StringBuilder(), visited);
            }

            return set.size();
        }

        private void backtracking(int limit, StringBuilder sb, boolean[] visited) {
            if(limit == sb.length()) {
                set.add(sb.toString());
                return;
            }

            for(int i=0;i<len;i++) {
                if(visited[i]) continue;

                StringBuilder newSb = new StringBuilder(sb);

                visited[i] = true;
                backtracking(limit, newSb.append(Tiles.charAt(i)), visited);
                visited[i] = false;
            }
        }
    }
}
