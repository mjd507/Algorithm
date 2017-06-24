import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class _008_String2Integer {

	public static void main(String[] args) {
		int result = myAtoi("abc");
		System.out.println(result);
	}

	/**
	 * 转化时跳过前面的空格字符，直到遇上数字或正负符号才开始做转换，
	 * 而再遇到非数字或字符串结束时('/0')才结束转换，并将结果返回
	 */

    public static int myAtoi(String str) {
        char[] charArr =  str.trim().toCharArray();
        int len = charArr.length;
        if(len == 0) return 0;
        int index = 0;
        Pattern pattern = Pattern.compile("[(\\d)(\\+)(\\-)]");//匹配数字 或+ 或-
        while(index < len){
        	String element = charArr[index] + "";
        	if(pattern.matcher(element).find()){
        		break;
        	}
        	index ++;
        }
        if(index == len) return 0;
        Pattern numPattern = Pattern.compile("\\d");//匹配数字
        String firstEle = charArr[index] + "";
        StringBuilder builder = new StringBuilder();
        if(!numPattern.matcher(firstEle).find()){
        	builder.append(firstEle);
        	index = index + 1;
        }
        while(index < len){
        	String element = charArr[index] + "";
        	if(!numPattern.matcher(element).find()){
        		break;
        	}
        	builder.append(element);
        	index ++;
        }
        String resultStr = builder.toString();
        if(!numPattern.matcher(resultStr).find()){ //不是数字
        	return 0;
        }
        	
		int result = 0;
        try {
        	result = Integer.parseInt(resultStr);
        }catch(Exception e) {
        	if(resultStr.charAt(0) == '-'){
        		result = Integer.MIN_VALUE;
        	}else{
        		result = Integer.MAX_VALUE;
        	}
        }
        return result;
    }

	// public static int myAtoi(String str) {
	// 	if(str == null) return 0;
	// 	str = str.trim();
	// 	Pattern pattern = Pattern.compile("^([+-]|[0-9])[0-9]+");
	// 	Matcher m = pattern.matcher(str);
	// 	if(m.find()){
	// 		str = str.substring(m.start(), m.end());
 //        } else {
 //        	return 0;
 //        }
 //        int result = 0;
 //        try{
 //        	result = Integer.parseInt(str);
 //        }catch(Exception e){
 //        	if(str.charAt(0) == '-'){
 //        		result = Integer.MIN_VALUE;
 //        	}else{
 //        		result = Integer.MAX_VALUE;
 //        	}
 //        }
 //        return result;
	// }
}