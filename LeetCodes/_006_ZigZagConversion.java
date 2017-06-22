import java.lang.StringBuilder;
public class _006_ZigZagConversion {

	public static void main(String[] args) {
	    String result = convert("PAYPALISHIRING",3);
	    System.out.println(result);
	}
	
	/**
	 * abcdefg
	 *
	 * a # # g
	 * b # f #
	 * c e # #
	 * d # # #
	 */
	public static String convert(String s, int numRows) {
	    int len = s.length();
	    char[] arr = s.toCharArray();
	    StringBuilder[] builders = new StringBuilder[numRows]; 
	    for (int i = 0; i < numRows; i++) {
	    	builders[i] = new StringBuilder();
	    }

	    int cursor = 0;
	    while(cursor < len){
	    	//从上到下
	    	for (int index = 0; index < numRows; index++) {
	    		if(cursor < len){
	    			builders[index].append(arr[cursor]);
	    			cursor++;
	    		}
	    	}
	    	//从下到上
	    	for (int index = numRows - 2; index >= 1; index--) {
	    		if(cursor < len){
	    			builders[index].append(arr[cursor]);
	    			cursor++;
	    		}
	    	}
	    }
	    for (int i = 1; i < numRows; i++) {
	    	builders[0].append(builders[i]);
	    }
		return builders[0].toString();
	}
}
