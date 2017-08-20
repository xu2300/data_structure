package map;

import java.util.*;

/**
 * Created by junweixu on 3/14/17.
 */
public class Longest_substring_K_Stream {
    public static void main(String[] args) {
        System.out.print(lengthOfLongestSubstringKDistinct("eaeesad",3));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        Collection<Integer> l = new ArrayList<>();
        streamreader streamreader = new streamreader(s);
        char c;
        int front = 0; // first char's index of valid substring
        int cur = 0;  // current char's index of valid substring
        int maxLen = 0; // max length of valid substring
        HashMap<Character,Integer> lastIndex = new HashMap<Character,Integer>();
        while((c = streamreader.reader()) != '\0'){
            lastIndex.put(c,cur);
            while(lastIndex.size() > k){
                char charWithLeastIndex ='a';
                int leastIndex = Integer.MAX_VALUE;
                for(Map.Entry<Character,Integer> entry : lastIndex.entrySet()){
                    int curIndex = entry.getValue();
                    char curChar = entry.getKey();
                    if(curIndex < leastIndex){
                        leastIndex = curIndex;
                        charWithLeastIndex = curChar;
                    }
                }
                lastIndex.remove(charWithLeastIndex);
                front = leastIndex+1;
            }
            maxLen = Math.max(maxLen,cur-front+1);
            cur++;
        }
        return maxLen;
    }
//eceba
    public static class streamreader{
        String s;
        int index;
        public streamreader(String s){
            this.s = s;
            index = 0;
        }
        public char reader(){
            if(index<s.length())
            return s.charAt(index++);
            else return '\0';
        }
    }
}




