package simple_question;

import java.util.HashMap;
import java.util.Map;

public class application_configuration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String,String> map1 = new HashMap<String,String>();
		HashMap<String,String> map2 = new HashMap<String,String>();
		map1.put("key1", "key2");
		map1.put("key2", "key3");
		map1.put("key3", "foo");
		map2.put("key1", "haha");
		map2.put("key4", "ha2");
		for(Map.Entry<String,String> m: help1(map1,map2).entrySet()){
			System.out.println(m.getKey()+" "+m.getValue());
		}
	}
	/*
	 * oding. 1) For an application, it has 2 configurations, 
	 * a global configuration and a app configuration, 
	 * a configuration is just a map with key and value. 
	 * If the app configuration has some keys that exist in the global configuration, 
	 * it should overwrite the value in the global configuration. 
	 * write a function to return the final configuration.. 
	 */
	
	public HashMap<String,String> help(HashMap<String,String> map1, HashMap<String,String> map2){
		for(String s : map1.keySet()){
			if(map2.containsKey(s)){
				map1.put(s, map2.get(s));
			}
		}
		return map1;
	}
	/*
	 * follow up: if value of some keys has references: e.g.. more info on 1point3acres.com
key1: $key2
key2: $key3
key3: "foo"
rewrite the function that return the final configuration, 
resolve all the references. 
Notice that assume global configuration has no knowledge about app configuration,
 so references in global config can't refer 
	 */
	public static HashMap<String,String> help1(HashMap<String,String> map1, HashMap<String,String> map2){
		for(String s : map1.keySet()){
			String key = s;
			while(map1.containsKey(map1.get(key))){
				key = map1.get(key);
			}
			map1.put(s, map1.get(key));
		}
		
		for(String s : map1.keySet()){
			if(map2.containsKey(s)){
				map1.put(s, map2.get(s));
			}
		}
		return map1;
	}
}
