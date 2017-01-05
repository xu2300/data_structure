package backtracking;

import java.util.ArrayList;
import java.util.List;

public class can_I_win {


    static Boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger <= 0 || desiredTotal <= 0) {
            return false;
        }
     
        List<Integer> pool = new ArrayList<>();
        for (int i = 1; i <= maxChoosableInteger; i++) {
            pool.add(i);
        }
     
        return canIWinHelper(pool, desiredTotal);
    }
 
    private static  boolean canIWinHelper(List<Integer> pool, int desiredTotal) {
        if (pool.get(pool.size() - 1) >= desiredTotal) {
            return true;
        }
     
        for (int i = 0; i < pool.size(); i++) {
            int removed = pool.remove(i);
         
            boolean win = !canIWinHelper(pool, desiredTotal - removed);
         
            pool.add(i, removed);
         
            if (win) {
                return true;
            }
        }
     
        return false;
    }
     
    public static boolean canIWin(int[] numbers, int target) {
        if (numbers.length == 0) {
            return false;
        }
        boolean[] used = new boolean[numbers.length];
        return canIWinHelper(numbers, used, target);
    }

    // return if the one who pick can always win
    private static boolean canIWinHelper(int[] numbers, boolean[] used, int target) {
        boolean opponentWin = true;
        for (int i = 0; i < numbers.length; ++i) {
            if (used[i]) {
                continue;
            }
            int num = numbers[i];
            if (num >= target) {
                return true;
            }
            used[i] = true;
            opponentWin = canIWinHelper(numbers, used, target - num);
            used[i] = false;
            if (opponentWin == false) {  // there exist one num that will cause the opponent to lose
                break;
            }
        }
        return !opponentWin;
    }
    
    
    public static void main(String[] args) {
        int max = 10;
        int total = 11;
         
       
        boolean ans = canIWin(max, total);
         
        System.out.println(ans);
    }

}
