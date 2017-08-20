package wish;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by junweixu on 8/20/17.
 */
public class keyBoard {
    public static void main(String[] args) {
        String s = "423692";
        String k = "923857614";
        System.out.print(generate(s,k));
    }

    public static int generate(String s, String k){
        if(s==null || s.length()==0 || k==null || k.length()==0) return -1;
        int len = s.length();
        if(len ==1) return 0;

        char [][] key = new char [3][3];
        char [] charK = k.toCharArray();
        int index = 0;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                key[i][j] = charK[index++];
            }
        }

        Map<Character, Set<Character>> oneStepMap = new HashMap<Character, Set<Character>>();
        int [][] dir = new int [][] {{0,-1},{0,1},{-1,0},{1,0},{-1,-1},{-1,1},{1,-1},{1,1}};
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++) {
                Set<Character> set = new HashSet<>();
                for(int m=0; m<dir.length; m++){
                    int x = i+dir[m][0];
                    int y = j+dir[m][1];
                    if(x>=0 && x<3 && y>=0 && y<3){
                        set.add(key[x][y]);
                    }
                }
                set.add(key[i][j]);
                oneStepMap.put(key[i][j], set);
            }
        }

        int count = 0;
        char [] charS = s.toCharArray();
        for(int i=0; i<charS.length-1; i++){
            if(oneStepMap.get(charS[i]).contains(charS[i+1])){
                    count+=1;
            }
            else {
                    count+=2;
            }
        }
        return count;
    }
}
