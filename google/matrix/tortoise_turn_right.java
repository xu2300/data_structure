package matrix;

/*A tortoise is at (0,0) of an x-y coordinator system. It can face to east/west/south/north. 
a) Write 2 functions for the tortoise to:
    i) turn right
    ii) move 1 step along the direction it's facing
b) Write a function that returns its position after a command such as FRRRFFFR (F for move forward, R for turn right) 
c) How about there are numbers in the command, such as F3R3F1R (short for FRRRFFFR)?  
d) How about there are parentheses in the command, such as F(3R5(FR)) (short for FRRRFRFRFRFRFR)?
*/


public class tortoise_turn_right {
	private int x = 0;
	private int y = 0;
	private int dir = 0;
	int [][] direction = {{1,0}, {0,-1}, {-1,0}, {0,1} };
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tortoise_turn_right tor = new tortoise_turn_right();
		int [] r = tor.command("F3R3F1R2F");
		System.out.println(r[0] + " "+ r[1]);
	}
	
	public void turnR(){
		dir = (dir+1) % 4;
	}
	
	public void moveF(){
		int[] d = direction[dir];
		x = x+d[0];
		y = y+d[1];
	}
	
	public int[] command(String com){
		int [] re = new int [2];
		int len = com.length();
		int i =0;
		while(i<len){
			boolean digit = false;
			int start = i;
			while( i<len && Character.isDigit(com.charAt(i))){
				digit = true;
				i++;
			}
			int num = 0;
			if(digit){
				num = Integer.valueOf(com.substring(start,i));
			}
			
			if(num == 0){
				comm(com.charAt(i));
			}
			else{
				for(int j=0; j<num; j++)
					comm(com.charAt(i));
			}
			i++;
		}
		re[0] = x;
		re[1] = y;
		return re;
	}
	
	public void comm(char c){
		if(c == 'R') turnR();
		else if(c == 'F') moveF();
	}
}
