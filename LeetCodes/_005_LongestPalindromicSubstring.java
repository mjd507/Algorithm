

public class _005_LongestPalindromicSubstring{

    public static int maxLen = 0;
    public static int startIndex = 0;

	public static void main(String[] args) {
		String str = longestPalindrome("cbbd");
		System.out.println(str);
	}

    //abcbabc
	public static String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;
        for (int i = 0; i < len; i++) {
            findLongest(s, i, i); //奇数最长回文
            findLongest(s, i, i+1); //偶数最长回文
        }
        return s.substring(startIndex, startIndex + maxLen);
    }

    public static void findLongest(String s, int j, int k){
        while(j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)){
            j--;
            k++;
        }
        if(maxLen < k-j-1){
            startIndex = j + 1;
            maxLen = k-j-1;
        }
    }
}