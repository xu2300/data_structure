import java.util.HashMap;

public class task_schedule {
	public static void main(String[] args) {
		int [] thread = {1,2,3,1,2,3};
		//1 2 _ 1 _ _ 1 2 _ 1 3 _ _ 3
		System.out.println(schedule_time(thread,3));
	}
	
	public static int schedule_time(int[] thread, int cooldown){
		int sum = 0;
		int lastTime = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int t : thread){
			if(map.containsKey(t)){
				lastTime = map.get(t);
				if(sum <= lastTime+cooldown){
					sum = lastTime + cooldown + 1;
				}
				else{
					sum++;
				}
			}
			else{
				sum++;
			}
			map.put(t, sum);
		}
		return sum;
	}
}
