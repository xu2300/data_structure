package VIDEO;

import java.util.*;

/**
 * Created by junweixu on 4/20/17.
 */
public class CACULATI_TRAFFIC {
    public static void main(String[] args) {
        String s = "aaaaaaa";
        List<String> str = new ArrayList<>(Arrays.asList("aaaa","aaa"));
        wordBreak(s,str);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if(s.length() == 0) return result;
        dfs(s,wordDict,new ArrayList<>(), result, 0, new HashMap<String, List<List<String>>>());
        return result;
    }

    public static void dfs(String s, List<String> wordDict, List<String> curs, List<String> result, int index, HashMap<String, List<List<String>>> memory){
        int len = s.length();

        if( memory.containsKey(s.substring(index,len))){
            for(List<String> subList : memory.get(s.substring(index,len))){
                List<String> tmp = new ArrayList<>(curs);
                tmp.addAll(subList);
                StringBuilder sb = new StringBuilder();
                for(String cur : tmp){
                    sb.append(cur+" ");
                }
                result.add(sb.toString().trim());
            }
            return;
        }


        if(index==len){
            StringBuilder sb = new StringBuilder();
            for(String cur : curs){
                sb.append(cur+" ");
            }
            result.add(sb.toString().trim());
            return;
        }

        for(int i = index+1; i<=len; i++){
            if(wordDict.contains(s.substring(index, i))){
                curs.add(s.substring(index, i));

                if(!memory.containsKey(s.substring(0, i))){
                    memory.put(s.substring(0, i), new ArrayList<List<String>>());
                }
                memory.get(s.substring(0, i)).add(curs);

                dfs(s,wordDict,curs,result,i, memory);
                curs.remove(curs.size()-1);
            }
        }
    }
}
