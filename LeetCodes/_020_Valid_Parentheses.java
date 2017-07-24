
public class _020_Valid_Parentheses{

	public static void main(String[] args) {
		boolean isVaild = isValid("({[()]})");
		System.out.println(isVaild + "");
	}


	public static boolean isValid(String s) {
		if(s == null || s.length() == 0 || s.length() % 2 != 0){
			return false;
		}
		char[] c = s.toCharArray();
		int mid = c.length / 2;
        //(){}[]
        //({[]})
		if(!isPair(c[mid-1],c[mid])){ //中间两个不对称
			return isPairs1(c);
		}else {
			//1. 左右两边 两个一对称
			//2. 左右两边 整体对称
			boolean one = isPairs1(c);
			boolean two = isPairs2(c);
			// System.out.println(one + "" + two);
			return one || two;
		}
	}
	public static boolean isPairs2(char[] c){
		int len = c.length;
		for (int i = 0, j = len - 1; i < j-1; i++,j--) {
			if(!isPair(c[i], c[j])){
				return false;
			}
		}
		return true;
	}
	public static boolean isPairs1(char[] c) {
		int len = c.length;
		for (int i = 0; i < len - 1; i++) {
			if(!isPair(c[i], c[i+1])){
				return false;
			}
			i++;
		}
		return true;
	}
	public static boolean isPair(char a, char b) {
		if( a == '(' && b == ')' ) {
			return true;
		}
		if( a == '{' && b == '}' ) {
			return true;
		}
		if( a == '[' && b == ']' ) {
			return true;
		}
		return false;
	}

}