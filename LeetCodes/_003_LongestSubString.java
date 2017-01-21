import java.util.HashMap;
import java.util.Map;

/**
Given a string, find the length of the longest substring without repeating characters.

Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. 
		Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class _003_LongestSubString {
	public static void main(String[] args) {
		int count = lengthOfLongestSubstring("pwwkew");
		System.out.println(count);
	}
	public static int lengthOfLongestSubstring(String str) {
		int count = 0;
		int lastRepeatPos = -1;
		Map< String, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			String s = str.charAt(i)+"";
			if(map.containsKey(s) && lastRepeatPos < map.get(s)){
				lastRepeatPos = map.get(s);
			}
			map.put(s, i);
			if(i - lastRepeatPos > count){
				count = i - lastRepeatPos;
			}
		}
		return count;
	}
}
