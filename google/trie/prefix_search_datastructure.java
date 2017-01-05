package trie;

import java.util.*;

public class prefix_search_datastructure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l = new ArrayList<String>(Arrays.asList("ale","apple", "monkeys", "plea", "app", "appldfd", "appa"));
		String prefix = "app";
		for(String i: search(prefix,l) ){
			System.out.println(i);
		}
	}
	
	/*
	First interview: 
	Design a data structure that stores a dictionary and can return a list of words that has some input prefix. 
	LC: TrieTree . 
	Follow-up: if a dict has n words, average word length is m, 
	input length is s, what's the time/space complexity? 
	*/


	   public static class TrieNode{
	        public boolean finish;
	        public char val;
	        public TrieNode [] c = new TrieNode[26];
	        public TrieNode(){};
	        public TrieNode(char c){
	            this.val = c;
	        };
	    }
	    
	    private static TrieNode root = new TrieNode();

	    // Adds a word into the data structure.
	    public static void addWord(String word) {
	        TrieNode node = root;
	        for(int i=0; i<word.length(); i++){
	            if(node.c[word.charAt(i)-'a'] == null){
	                node.c[word.charAt(i)-'a'] = new TrieNode(word.charAt(i));
	            }
	            node = node.c[word.charAt(i)-'a'];
	        }
	        node.finish = true;
	    }

	    // Returns if the word is in the data structure. A word could
	    // contain the dot character '.' to represent any one letter.
	    public static List<String>  search(String prefix, List<String> l) {
	        List<String>  re = new ArrayList<String>();
	        for(String s:l){
	        		addWord(s);
	        }
	        TrieNode node = root;
	        for(int i =0; i<prefix.length(); i++){
	            if(node.c[prefix.charAt(i)-'a'] == null){
	               break;
	            }
	            node = node.c[prefix.charAt(i)-'a'];
	        }
	        if(node.val != prefix.charAt(prefix.length()-1)) return re;
	        StringBuilder sb = new StringBuilder(prefix);
	        helper(node, sb, re);
	        return re;
	    }
	    
	    public static void helper( TrieNode node, StringBuilder sb, List<String>  re){
	        if(node.finish){
	            StringBuilder newsb = new StringBuilder(sb);
	            re.add(newsb.toString());
	        }
	        for(char c = 'a'; c<='z'; c++){
	            if(node.c[c-'a'] != null){
	               sb.append(c);
	               helper(node.c[c-'a'], sb, re);
	               sb.deleteCharAt(sb.length()-1);
	            }
	        }
	    }

}
