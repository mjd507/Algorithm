 import java.lang.StringBuilder;

 public class _007_ReverseInteger{

 	public static void main(String[] args) {
 		int result = reverse(-123);
 		System.out.println(result);
 	}

 	public static int reverse(int x) {
        char[] c = String.valueOf(x).toCharArray();
        StringBuilder sb = new StringBuilder();
        if(String.valueOf(c[0]).equals("+") || String.valueOf(c[0]).equals("-")){
        	sb.append(c[0]);
        	for (int i = c.length - 1; i >= 1; i--) {
        		sb.append(c[i]);
        	}
        }else{
	        for (int i = c.length - 1; i >= 0; i--) {
	        	sb.append(c[i]);
	        }
        }
        long result = Long.parseLong(sb.toString());
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
        	return 0;
        }else{
        	return (int)result;
        }
    }
 }