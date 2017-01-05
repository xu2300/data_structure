package greedy;

import java.util.*;
import java.util.List;

/*
 * 上来直接问我做过的一个Android项目，问的挺细致的，让我讲扫描二维码登陆的具体实现原理。。。 鏉ユ簮涓€浜�.涓夊垎鍦拌鍧�. 
然后做题：
A: 34567. Waral 鍗氬鏈夋洿澶氭枃绔�,
B: 45678
C: 67345-google 1point3acres
交换A中的数字位置，得到一个新的数C，使得C大于B。
我的想法是，每次挑出最大的那个digit跟前面的swap，直到找大于B的，时间复杂度是O(n*n);corner case：当A、B的digits个数不等时，直接返回结果。
这时候小哥给了hint说这本质上是一个sort问题，那么sort问题你ideal复杂度应该是多少呢？sort我就直接想到了quicksort，我就说找最大digit的那个过程可以用quick select，这样就是O(nlogn)了。然后让用test case跑一边quick select，让分析复杂度。

Follow up: 存在很多这样的C，返回其中最小的那个。
第二题follow up我觉得可以先scan一遍B，把A中的digits当做一个bag，尽可能地匹配B

例如
A: 34567
B: 45678

然后我们匹配成了 A' 4567  (3)剩余没有用     B 4567 | 8 

然后我们的目标就是从剩余没用的数字里，找到比 第一个不匹配值 大的 最小值，如果找不到，就往前移一位
，再把A‘的前一位算在没用的里面继续重复上面的运算. 
例如   A' 4567  (3)          B 4567 | 8   找不到比8大的数，我们就往前移一位. 
         A' 456  (7, 3)          B 456 | 7 8  找不到比7大的数，再往前移一位.
         A' 45  (6, 7, 3)          B 45 | 6 7 8  找到了比6大的最小的数为7，
         所以我就设没用的数字里最高位为7， 其他剩余数字就按升序使用就好了，结果就是45736了，
         不过算法复杂度感觉也需要 n^2.



 */
public class next_largest_digit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {3,4,5,6,7};
		int [] b = {4,5,6,7,8};
		for(int i:nextLarget(a,b)){
			System.out.print(i);
		}
	}
	
	public static  List<Integer> nextLarget(int []a, int []b){
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i:a) set.add(i);
		List<Integer> re = new ArrayList<Integer>();
		int i= 0;
		int lenb = b.length;
		int cur = 0;
		while(i<lenb){
			cur = b[i];
			if(set.contains(cur)) {
				set.remove(cur);
				re.add(cur);
				i++;
			}
			else break;
		}
		while(i>=0){
			cur = b[i];
			cur++;
			while(cur<=9 && !set.contains(cur) ){
				cur++;
			}
			if(cur ==10) {
				set.add(re.get(re.size()-1));
				re.remove(re.size()-1);
				i--;
			}
			else break;
		}	
		re.add(cur);
		set.remove(cur);
		List<Integer> l = new ArrayList<Integer>();
		for(int j: set) l.add(j);
		Collections.sort(l);
		for(int j :l) re.add(j);
		return re;
	}

}
