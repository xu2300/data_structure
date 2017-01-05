package goo;

import java.util.ArrayList;
import java.util.List;

public class replace_ALL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abcdbc";
		String find = "bc";
		String replace = "e";
		System.out.println(replaceAll(s,find,replace));
		System.out.println(replace(s,find, replace));
		System.out.println(replace1(s,find,replace));
	}
	
	public static String replaceAll(String s, String find, String replace){
		if(s.length()==0) return "";
		int index = s.indexOf(find);
		if(index == -1) return s;
		int len = find.length();
		return s.substring(0,index) + replace + replaceAll(s.substring(index+len), find, replace);
	}
	
	public static String replace(String s, String find, String replace){
		List<Integer> re=findall(s, find);
		StringBuilder sb = new StringBuilder();
		int i =0,k =0;
		while(i<s.length()){
			if(k<re.size() && i == re.get(k)){
				sb.append(replace);
				k++;
				i+=find.length();
			}
			else{
				sb.append(s.charAt(i++));
			}
		}
		return sb.toString();
	}
	
	public static String replace1(String s, String find, String replace){
		List<Integer> re=findall(s, find);
		StringBuilder sb = new StringBuilder();
		int i =0;
		for(int k : re){
			sb.append(s.substring(i,k));
			sb.append(replace);
			i = k+find.length();
		}
		sb.append(s.substring(i));
		return sb.toString();
	}
	
	public static List<Integer> findall(String s, String find){
		List<Integer> re = new ArrayList<Integer>();
		int lenf = find.length();
		int lens = s.length();
		int i = 0;
		while(i+lenf<=lens){
			int k = i;
			int j = 0;
			while(j<lenf){
				if(s.charAt(k) == find.charAt(j)){
					k++;
					j++;
				}
				else break;
			}
			if(j == lenf) {
				re.add(i);
				i = i+lenf;
			}
			else i++;
		}
		return re;
	}

}
