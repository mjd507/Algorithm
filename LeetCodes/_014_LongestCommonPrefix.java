import java.util.Arrays;
public class _014_LongestCommonPrefix{

	public static void main(String[] args) {
		String[] str = {"c","c"};
		longestCommonPrefix(str);
	}

	public static String longestCommonPrefix(String[] strs) {
        //["abcdefg","bcdjhgl"]
        //1. find the shortest String in given array.
        //2. list all the combines in the String. 
        //3. judge other strs ，is contains the list str.
        if(strs.length == 0) return "";

        String shortestStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
        	if(strs[i].length() < shortestStr.length()){
        		shortestStr = strs[i];
        	}
        }
        //System.out.println(shortestStr);

        int len = shortestStr.length();
        int combinesCount = (1 + len) * len / 2;
        String[] allCombines = new String[combinesCount];
        //System.out.println(combinesCount);

        int k = 0;
        for (int i = 0; i < len; i++) {
        	for (int j = len; j > i; j--) {
        		allCombines[k++] = shortestStr.substring(i,j);
        	}
        }
        //System.out.println(Arrays.toString(allCombines));

        int count = 0;
        String longestStr = "";
        for (int i = 0; i < combinesCount; i++) {
        	String str = allCombines[i];
            for (String s : strs) {
                if(s.indexOf(str) == -1){
                    count = 0;
                    break;
                }else{
                    count++;
                }
            }
            if(count == strs.length && longestStr.length() < str.length()){
                longestStr = str;
            }
        }
        //System.out.println(longestStr);
        return longestStr;
    }

}