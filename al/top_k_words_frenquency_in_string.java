

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;

public class top_k_words_frenquency_in_string {

	public static void main(String[] args) {
		List<node> r = count_words_instring("   aa bb   cc   aa ss dd aa cc cc bb vfva vfva vfva vfva vfva vfva" , 4);
		for(node n1:r){
			System.out.print(n1.s);
			System.out.println(n1.num);	
		}
	}
	
	public static List<node> count_words_instring(String s,int k){
	        String[] str = s.trim().split("\\s+");
	        List<node> r = new ArrayList<node>();
	        Map<String,Integer> map = new HashMap<String,Integer> ();
	        for(String news : str){
	            if(map.containsKey(news)){
	                map.put(news,map.get(news)+1);
	            }   
	            else map.put(news,1);
	        }
	        PriorityQueue<node> pq = new PriorityQueue<node>(k+1, new Comparator<node>(){
	            public int compare(node n1, node n2){
	                return n1.num-n2.num;
	            }
	        });
	        if(k<=0) return r;
	        for(String str1: map.keySet()){
	            node n1 = new node(str1,map.get(str1));
	            if(pq.size()<k) pq.offer(n1);
	            else{
	                if(n1.num > pq.peek().num){
	                    pq.poll();
	                    pq.offer(n1);
	                }
	            }
	        }
	        node [] arr = pq.toArray(new node[0]);
	        for(node node1 : arr){
	            r.add(node1);
	        }
	        return r;
	    }
	    
	    public static class node{
	        private String s;
	        private int num;
	        public node(String s, int num){
	            this.s =s;
	            this.num = num;
	        }
	    }
}
