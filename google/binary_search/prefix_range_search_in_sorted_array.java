package binary_search;

public class prefix_range_search_in_sorted_array {
	//第二道是给一个排好序的字符串数组，有n个字符串，还有一个前缀prefix字符串，长为m,
	//要求函数返回start index和end index，其中所有字符串都以prefix开始，
	//先用binary search，达到m*log(n)复杂度，面试官挺满意，然后我又给了个Trie树预处
	//理O(所有字符串长之和)，之后每个prefix都可以有O(m)的查找。面试官挺高兴，又聊了聊j
	//ava 8的新feature，保证lamda和stream api。
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String prefix = "abb";
		String [] s = {"aa", "abb","abbsw", "abbsz","abbx","gg","xx","yy"};
		for(int i : help(s,prefix)){
			System.out.println(i);
		}
	}
	
	public static int[] help(String[] s, String prefix){
	    int[] result = new int[2];
	    result[0] = findFirst(s, prefix);
	    result[1] = findLast(s, prefix);
	    return result;
	}
	
	public static int findFirst(String[] s, String prefix){
		int l = 0;
		int h = s.length-1;
		while(l<h){
			int m = l + (h-l)/2;
			if((m==0 || !s[m-1].startsWith(prefix))  && (s[m].startsWith(prefix)))
				return m;
			else if(s[m].compareTo(prefix)<0) l = m+1;
			else h = m-1;
		}
		if(s[l].startsWith(prefix)) return l;
		else return -1;
	}
	
	public static int findLast(String[] s, String prefix){
		int l = 0;
		int h = s.length-1;
		while(l<h){
			int m = l + (h-l)/2;
			if((m==s.length-1 || !s[m+1].startsWith(prefix))  && (s[m].startsWith(prefix)))
				return m;
			else if(s[m].compareTo(prefix)>0 && !s[m].startsWith(prefix))
				h = m-1;
			else l = m+1;
		}
		if(s[l].startsWith(prefix)) return l;
		else return -1;
	}
}
