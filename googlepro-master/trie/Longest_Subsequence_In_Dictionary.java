package trie;

import java.util.*;

public class Longest_Subsequence_In_Dictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set = new HashSet<String>(Arrays.asList("ale","apple", "monkeys", "plea"));
		String s = "abmpcpolenakeyewxs";
		System.out.println(longest(s,set));
	}

	//给一个String和一个字典，找字典里面长度最长的能由String里面删去某些字符后组成的单词
	//比如S = abpcplea， Dict = {ale, apple, monkey, plea}, 就返回apple
/*
 * 即使用O(|s|)时间判断字典中每个单词w是否是s的sunsequence，那么总时间O(|s|*|D|)也会有很多浪费的地方。例如当字典中2个单词有公用prefix的时候，这时公共的prefix只需要在s中查找一次，所以这个O(|s|*|D|)的是个很大的上界（与|s|成正比）。. 鍥磋鎴戜滑@1point 3 acres
为了避免重复prefix matching，还是应该将字典中所有长度不超过|s|的单词建立一个Trie，pre-calculate 每个字母在s.substr(j)中的初始位置，然后DFS在Trie中寻找最长matching.. visit 1point3acres.com for more.
时间复杂度：建立Trie = O(L), L=字典中所有长度不超过|s|的单词总长；
pre-calculate 每个字母在s.substr(j)中的初始位置=O(|s|);. more info on 1point3acres.com
DFS: O(Trie node个数) <= O(L)
总复杂度 = O(|s| + L). 这个比O(|s|*|D|)是小很多的，尤其是|s|很大而字典单词并不长的时候。
 * 
 */
	private static trie root = new trie();
	private static int max = 0;
	private static List<Integer> re =new ArrayList<Integer>();
	public static String longest(String s, HashSet<String> set){
	    int lens = s.length();
	    int [][] dp = new int[26][lens];
	    for(char c = 'a'; c<='z'; c++){
	        int i =0; 
	        int start =0;
	        while(i<lens){
	            while(i<lens && s.charAt(i) != c) i++;
	            for(int j = start; j<lens && j<=i; j++){
	                dp[c-'a'][j] = i==lens? -1:i;
	            }
	            i++;
	            start = i;
	        }
	    }
	    getTrie(set);
	    dfs(root,0,s,dp,0,new ArrayList<Integer>());
	    StringBuilder sb = new StringBuilder();
	    for(int i:re){
	        sb.append(s.charAt(i));
	    }
	    return sb.toString();
	}

	public static void dfs(trie root, int start, String s, int[][]dp, int len, List<Integer> cur){
	    if(root.end && len>max){
	        max = len;
	        re = new ArrayList<Integer>(cur);
	    }
	    for(char c = 'a'; c<='z'; c++){
	        if(root.child[c-'a'] != null && dp[c-'a'][start] !=-1){
	            cur.add(dp[c-'a'][start]);
	            dfs(root.child[c-'a'], dp[c-'a'][start], s, dp,len+1, cur);
	            cur.remove(cur.size()-1);
	        }
	    }
	}

	public static void getTrie(HashSet<String> set){
	    for(String s: set){
	        trie cur = root;
	        for(char c : s.toCharArray()){
	            if(cur.child[c-'a']==null){
	                cur.child[c-'a'] = new trie();
	            }
	            cur = cur.child[c-'a'];
	        }
	        cur.end = true;
	    }
	}


	public static class trie{
	    boolean end;
	    trie [] child = new trie[26];
	    public trie(){};
	}
}
