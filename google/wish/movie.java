package wish;

import java.util.*;

public class movie {
    public static void main(String[] args) throws Exception {
        Map<String, Set<Integer>> movie = new HashMap<>();
        movie.put("Shining", new HashSet<>(Arrays.asList(12, 13, 16, 17)));
        movie.put("Baby driver", new HashSet<>(Arrays.asList(12, 15, 19)));
        movie.put("Pulp fiction", new HashSet<>(Arrays.asList(11, 17, 18)));
        System.out.print(movieArrange(movie));
    }

    public static String movieArrange(Map<String, Set<Integer>> movie) throws Exception {
        String [] re = new String[]{""};
        help(re,"",movie,new HashSet<>());
        if(re[0].isEmpty()) throw new Exception("There is no valie movie schedual");
        return re[0];
    }

    public static void help(String[] re, String cur, Map<String, Set<Integer>> movie, Set<Integer> time){
        if(re[0].length()!=0) return;
        if(movie.isEmpty()){
            re[0]= cur;
            return;
        }
        Map.Entry<String, Set<Integer>> entry = movie.entrySet().iterator().next();
        movie.remove(entry.getKey());
        for(int t : entry.getValue()){
            if(!time.contains(t)){
                time.add(t);
                help(re,cur+entry.getKey()+t,movie,time);
                time.remove(t);
            }
        }
        movie.put(entry.getKey(),entry.getValue());
    }
}
