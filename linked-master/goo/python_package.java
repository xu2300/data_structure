package goo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class python_package {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, List<String>> map = new HashMap<String, List<String>> ();
		map.put("a", new ArrayList<String>(Arrays.asList("b","c")));
		map.put("b", new ArrayList<String>(Arrays.asList("c","d")));
		map.put("d", new ArrayList<String>(Arrays.asList("m")));
		HashSet<String> set = new HashSet<String>();
		set.add("a");
		for(String s : preInstall("a",map,set)){
			System.out.println(s);
		}
	}
	
	public static Set<String> preInstall(String a, Map<String, List<String>> map,HashSet<String> set){
		Set<String> re = new HashSet<String>();
		List<String> l = new ArrayList<String>();
		if(!map.containsKey(a)) return re;
		else l = map.get(a);
		if(l == null) return re;
		for(String b : l){
			if(set.contains(b)) {
				re.add("there is a circle");
				return re;
			}
			set.add(b);
			re.add(b);
			re.addAll(preInstall(b,map,set));
			set.remove(b);
		}
		return re;
	}
	
	/*public static Set<String> pre(String a, Map<String, List<String>> map){
		Set<String> re = new HashSet<String>();
		Queue<String> q = new LinkedList<String>();
		q.add(a);
		while(!q.isEmpty()){
			int size = q.size();
			for(int i =0; i<size; i++){
				String cur = q.poll();
				if(re.contains(cur) && map.containsKey(cur)) return new HashSet<String>();
				re.add(cur);
				if(map.containsKey(cur)){
					
				}
			}
		}
	}*/

}
