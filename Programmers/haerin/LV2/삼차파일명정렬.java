package Programmers.haerin.LV2;
// https://school.programmers.co.kr/learn/courses/30/lessons/17686
// title : [3차] 파일명 정렬
// type : 정렬
// time : 39m
// Created by haerin on 2023-02-15
import java.util.*;
public class 삼차파일명정렬 {
    class Solution {
        class File {
            String head;
            int number;
            String fileName;
            File(String h, int n, String f){
                this.head = h;
                this.number = n;
                this.fileName = f;
            }
        }
        public String[] solution(String[] files) {
            List<File> fileList = getList(files);
            Collections.sort(fileList, new Comparator<File>(){
                @Override
                public int compare(File f1, File f2){
                    if(f1.head.equals(f2.head)){
                        if(f1.number > f2.number)
                            return 1;
                        else if(f1.number < f2.number)
                            return -1;
                        else
                            return 0;
                    }else
                        return f1.head.compareTo(f2.head);
                }
            });
            
            String[] answer = new String[files.length];
            int idx=0;
            for(File file : fileList){
                answer[idx++] = file.fileName;
            }
            
            return answer;
        }
        
        public List<File> getList(String[] files){
            List<File> list = new ArrayList<>();
            for(String file : files){
                int flag1 = 0;
                for(char c : file.toLowerCase().toCharArray()){
                    if(c >= '0' && c <= '9'){
                        break;
                    }else{
                        flag1 += 1;
                    }  
                }
                int flag2 = flag1;
                for(char c : file.substring(flag1).toCharArray()){
                    if(c < '0' || c > '9'){
                        break;
                    }else{
                        flag2 += 1;
                    }  
                }
                if(flag2-flag1 > 5){
                    flag2 = 5-flag1;
                }   
                list.add(new File(file.substring(0,flag1).toLowerCase(), Integer.valueOf(file.substring(flag1,flag2)), file));
            }
            return list;
        }
    }
}
