

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class updown_relationship {

	public static void main(String[] args) {
		final String DATA =
	            "mfly, Marty, McFly, jblogs\n" +
	            "jblogs, Joe, Blogs, rboss\n" +
	            "nmuller, Nicolas, Muller, jblogs\n" +
	            "rboss, Robert, Boss \n" +
	            "trice, Travis, Rice, rboss\n";
			print(DATA);
		
	}
	
	public static void print(String DATE){
		HashMap<String,node> map = new HashMap<String,node>();
		for(String str : DATE.split("\\n")){
			String [] word = str.split("\\,");
			String id = word[0].trim();
            String fName = word[1].trim();
            String lName = word[2].trim();
            String boss = null;
            if(word.length >3)
            boss = word[3].trim();
            node n = new node(id,fName,lName,boss);
            map.put(id,n);   
		}
		
        node root = null;
        for (String line : DATE.split("\\n")) {
            String[] split = line.split(",");
            String id = split[0].trim();
            if(split.length == 4){
            		map.get(split[3].trim()).dec.add(id);
            }
            else{
            		root = map.get(id);
            }
        }
        dfs(root,0,map);
	}
	
	public static void dfs(node root, int level,HashMap<String,node> map){
		 System.out.println(
	                new String(new char[level * 3]).replace("\0", " ") +
	                String.format("%d. %s %s (%s)", level + 1, root.firstname,root.lastname, root.id)
	        );
	        for (String child : root.dec) {
	            dfs(map.get(child), level + 1,map);
	        }
	}
	
	public static class node{
		public String id;
		public String firstname;
		public String lastname;
		public String bossid;
		List<String> dec ;
		public node(String id,String firstname,String lastname,String bossid){
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.bossid = bossid;
			dec = new ArrayList<String>();
		}
	}

}
