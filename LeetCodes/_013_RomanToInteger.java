
public class _013_RomanToInteger{
	public static void main(String[] args) {
		romanToInt("MMMDLXXXVI");
	}
	public static int romanToInt(String s){
	    int len = s.length();
	    int result = 0;
	    for (int i = 0; i < len; i++) {
	    	String e = s.charAt(i) + "";
	    	if(e.equals("M")){
	    		result += 1000;
	    	}else if(e.equals("D")){
	    		result += 500;
	    	}else if(e.equals("C")){
	    		result += 100;
	    	}else if(e.equals("L")){
	    		result += 50;
	    	}else if(e.equals("X")){
	    		result += 10;
	    	}else if(e.equals("V")){
	    		result += 5;
	    	}else if(e.equals("I")){
	    		result += 1;
	    	}
	    }
	    if(s.indexOf("CM") != -1 || s.indexOf("CD") != -1){
	    	result -= 200;
	    }
	    if(s.indexOf("XC") != -1 || s.indexOf("XL") != -1){
	    	result -= 20;
	    }
	    if(s.indexOf("IX") != -1 || s.indexOf("IV") != -1){
	    	result -= 2;
	    }
	    System.out.println(result);
	    return result;
	}
}