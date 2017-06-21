import java.util.ArrayList;
import java.util.HashMap;

public class _005_LongestPalindromicSubstring{

	public static void main(String[] args) {
		String str = longestPalindrome("abcda");
		System.out.println(str);
	}

	public static String longestPalindrome(String s) {
		if(s == null || s.length() == 0) return "";
        char[] arr = s.toCharArray();
        HashMap<String,ArrayList<Integer>> map = new HashMap<>();
        int longest = 0;
        int[] index = new int[2];
        for (int i = 0; i < arr.length; i++) {
        	String element = arr[i] + "";
        	if(map.get(element) == null){
        		ArrayList<Integer> list = new ArrayList<>();
        		list.add(i);
        		map.put(element,list);
        	}else{
        		ArrayList<Integer> list = map.get(element);
        		list.add(i);
        		int len = i - list.get(0);
        		if(len > longest){
        			longest = len;
        			index[0] = list.get(0);
        			index[1] = i;
        		}
        	}
        }
        return s.substring(index[0],index[1]+1);
    }
}