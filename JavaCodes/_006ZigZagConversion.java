package LeetCode.JavaCodes;
/**
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P      A       H       N
A  P  L   S   I    I   G
Y      I        R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 */
public class _006ZigZagConversion {

	public static void main(String[] args) {

	}

    public String convert(String s, int numRows) {
    		//n行，可以分为  2（n-1）组数据
    		int length = s.length();
    		int zu = length / 2*(numRows - 1);
    		int left = length % 2*(numRows - 1);
    		String res = "";
    		for(int i = 0; i < zu; i++){
    			
    		}
		return s;
    }
	
}
