package lab1;

import java.util.*;

public class see_level_over_terror {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] terrain = {1,5,1,4,3,2,-1,3,4,5,7};
		int sea_level = 5;
		for(int i: waterSumFollowUp(terrain,sea_level)){
			System.out.print(i+" ");
		}
	}

	public static int[] waterSum(int [] terrain, int sea_level){
		int tlen = terrain.length;
		int i=0;
		int sum = 0;
		int cur = 0;
		List<Integer> re = new ArrayList<Integer>();
		while(i<tlen){
			if(terrain[i]< sea_level){
				cur = sea_level-terrain[i];
				sum+=cur;
			}
			else if(sum!=0){
				re.add(sum);
				sum =0;
			}
			i++;
		}
		int[] ret = new int[re.size()];   
		int index =0;
		for (int j:re) {       
		    ret[index++] = j;                
		}                                        
		return ret;  
	}
	
	public static int[] waterSumFollowUp(int [] terrain, int sea_level){
		int tlen = terrain.length;
		int [] sea = new int [tlen];
		for(int i=0; i<tlen; i++){
			if(terrain[i]!=-1){
				sea[i] = sea_level;
			}
			else{
				int curSea = 0;
				int j=i;
 				while(j>=0){
 					if(terrain[j] >= sea_level){
 						break;
 					}
 					else if(terrain[j]>=curSea){
 						curSea = terrain[j];
 						sea[j] = curSea;
 					}
 					else{
 						sea[j] = curSea;
 					}
 					j--;
				}
 				i++;
 				curSea = 0;
 				while(i<=tlen){
 					if(terrain[i] >= sea_level){
 						i--;
 						break;
 					}
 					else if(terrain[i]>=curSea){
 						curSea = terrain[i];
 						sea[i] = curSea;
 					}
 					else{
 						sea[i] = curSea;
 					}
 					i++;
				}
 				
			}
		}
		return sea;
	}
}
