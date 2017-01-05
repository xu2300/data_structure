import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class group_information {
    static class Contact {
		List<String> contactList;
		String name;
		Contact(List<String> contactList, String name)  {
			this.contactList = contactList;
			this.name = name;
		}
	}

    public static void main(String[] args) {
        String [][]contacts =  {{"John", "john@gmail.com", "john@fb.com"},
								{"Dan", "dan@gmail.com", "+1234567"},
								{"john123", "5412312", "john123@skype.com"},
								{"john1985", "5412312", "john@fb.com"},
								{"john19856", "john123@skype.com", "john@fb1.com"},
								{"Dan2", "dan123@gmail.com", "+1234567"},{"Dan3", "dan@gmail.com", "+123456712312"},
								{"Sandy", "sandy@gmail.com", "+123456712"},{"sandy4", "sandy@fb.com", "sandy@gmail.com"}};

		List<Contact> conList = new ArrayList<Contact>();
		for(int i = 0 ; i < contacts.length; i++) {
			List<String> contactList = new ArrayList<String>();
			for(int j = 1 ; j < contacts[i].length; j++) {
				contactList.add(contacts[i][j]);
			}
			Contact con = new Contact(contactList, contacts[i][0]);
			conList.add(con);
		}
		List<List<String>> r = group(conList);
		for(List<String> l :r){
			System.out.println(l);
		}
    }

    public static List<List<String>> group(List<Contact> l){
        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        for(int i=0; i<l.size(); i++) {
        	Contact c = l.get(i);
        	List<Integer> indexList = new ArrayList<Integer>();
			for(String detail: c.contactList) {
				if(map.containsKey(detail)) {
					indexList = map.get(detail);
					indexList.add(i);
					map.put(detail, indexList);

				} else {
					indexList.add(i);
					map.put(detail, indexList);
				}
			}
		}
        int[]father = new int[l.size()];
        for(int i =0; i<l.size(); i++){
            father[i] = i;
        }
        for( List<Integer> list: map.values()){
            for(int i=0; i<list.size()-1; i++){
            	union(list.get(i),list.get(i+1),father);
            }
        }
        HashMap<Integer, List<String>> re = new HashMap<Integer, List<String>>();
        for(int i =0; i<l.size(); i++){
        	int m = find(i,father);
        	List<String> ind = new ArrayList<String>();
        	if(re.containsKey(m)) {
				ind = re.get(m);
				ind.add(l.get(i).name);
				re.put(m, ind);
			} else {
				ind.add(l.get(i).name);
				re.put(m, ind);
			}
        }
        List<List<String>> result = new ArrayList<List<String>>();
        for(List<String> list : re.values()){
        	result.add(list);
        }
        return result;
    }


    public static void union(int x, int y,int [] father){
            x = find(x,father);
            y = find(y,father);
            if(x == y) return;
            else father[x] = y;
    }

    public static int find(int x, int[] father){
    	if(x==father[x]) return x;
        return find(father[x], father);
    }

}
