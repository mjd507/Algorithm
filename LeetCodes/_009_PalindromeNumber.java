
public class _009_PalindromeNumber{
	public static void main(String[] args) {
		boolean isPalindrome = isPalindrome(123);
		System.out.println(isPalindrome);
	}

    public static boolean isPalindrome(int x) {
        int origin = x;
        int result = 0;
        if(x < 0) return false;
        while(origin > 0){
        	result = result * 10 + origin % 10;
        	origin = origin / 10;
        }
        return result == x;
    }

}