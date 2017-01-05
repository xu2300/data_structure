package trie;

import java.util.ArrayList;
import java.util.List;

public class prefix_tree__findall_prefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		prefix_tree__findall_prefix pre = new prefix_tree__findall_prefix();
		pre.addWord("aaef");
		pre.addWord("aaefwc");
		pre.addWord("aaefawe");
		pre.addWord("aaefeee");
		pre.addWord("aaeff");
		pre.addWord("aaefeeeee");
		for(String s :pre.search("aaef")){
			System.out.println(s);
		}
	}
	
    
    public class TrieNode{
        public char val;
        public boolean finish;
        public TrieNode [] c = new TrieNode[26];
        public TrieNode(){};
        public TrieNode(char val){
            this.val = val;
        }
    }
    
    private static TrieNode root;
    public prefix_tree__findall_prefix(){
        root = new TrieNode(' ');
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0; i<word.length(); i++){
            if(node.c[word.charAt(i)-'a'] == null){
                node.c[word.charAt(i)-'a'] = new TrieNode();
            }
            node = node.c[word.charAt(i)-'a'];
        }
        node.finish = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public List<String> search(String word) {
    	TrieNode node = root;
    	List<String> r = new ArrayList<String>();
    	for(int i=0; i<word.length(); i++){
        	if(node.c[word.charAt(i)-'a'] == null) return r;
        	else node = node.c[word.charAt(i)-'a'];
        }
    	StringBuilder sb = new StringBuilder(word);
    	helper(node , r, sb);
    	return r;
    }
    
    public void helper(TrieNode node, List<String> r, StringBuilder sb){
    	if(node.finish) { 
    		StringBuilder s = new StringBuilder(sb);
    		r.add(s.toString());
    	}
    	for(int i=0; i<26; i++){
           if(node.c[i] != null){
        	   char m = 'a';
        	   m +=i;
        	   sb.append(m);
        	   helper(node.c[i], r, sb);
        	   sb.deleteCharAt(sb.length()-1);
           }
        }        
    }

}
