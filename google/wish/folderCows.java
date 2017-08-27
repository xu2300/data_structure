package wish;

import java.util.*;

/**
 * Created by junweixu on 8/25/17.
 */
public class folderCows {
    public static void main(String[] args) {
        node n2 = new node(2, new ArrayList<>(), true,
                new ArrayList<>(Arrays.asList(1,3)));
        node n3 = new node(3, new ArrayList<>(), false,
                new ArrayList<>(Arrays.asList(2,3)));
        node n1 = new node(1, new ArrayList<>(Arrays.asList(n2,n3)), true,
                new ArrayList<>(Arrays.asList(1,2)));
        List<node> point = new ArrayList<>(Arrays.asList(n1,n2,n3));
        List<node> e1 = new ArrayList<>(Arrays.asList(n1,n3));
        List<node> e2 = new ArrayList<>(Arrays.asList(n1,n2));
        List<List<node>> edge = new ArrayList<>();
        edge.add(e1);
        edge.add(e2);
        Set<Integer> re = new HashSet<>();
        findCows(findRoot(point,edge), new ArrayList<>(), re);
        for(int i:re)
        System.out.println(i);

        System.out.println(findRoot(point,edge).val);
    }

    public static class node{
        int val;
        List<node> c;
        boolean shared;
        List<Integer> cows;
        public node(int val, List<node> c, boolean shared, List<Integer> cows){
            this.val = val;
            this.c = c;
            this.shared = shared;
            this.cows = cows;
        }
    }

    public static void findCows (node root, List<Integer> fatherMembers, Set<Integer> re){
        if(root.shared){
            for(int fatherMember : fatherMembers ){
                if(!root.cows.contains(fatherMember)){
                    root.cows.add(fatherMember);
                }
            }
        }

        if(root.c.isEmpty()){
            if(re.isEmpty()){
                re.addAll(root.cows);
            }else{
                Set<Integer> newResult = new HashSet<>();
                for(int cow : root.cows){
                    if(re.contains(cow)){
                        newResult.add(cow);
                    }
                }
                re.clear();
                re.addAll(newResult);
            }
            return;
        }

        for(node child : root.c){
            findCows(child, root.cows, re);
        }
    }


    public static node findRoot(List<node> point, List<List<node>> edge){
        HashSet<node> indegree = new HashSet<>();
        for(List<node> cur : edge){
            indegree.add(cur.get(1));
        }
        for(node cur : point){
            if(!indegree.contains(cur)){
                return cur;
            }
        }
        return null;
    }
}
