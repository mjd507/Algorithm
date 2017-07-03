import java.util.HashMap;

public class _012_IntegerToRoman{

    public static HashMap<Integer, String> map;

	public static void main(String[] args) {
		String str = intToRoman(90);
        System.out.println(str);
	}

    public static String intToRoman(int num) {
    	//0 - 3999
        initMap();
    	String str = String.valueOf(num);
    	int len = str.length();
        int beiShu = 1;
        String result = "";
    	for (int i = len - 1; i >= 0; i--) {
            int e = Integer.parseInt(str.charAt(i)+"") * beiShu;
            result = map.get(e) + result;
            beiShu = beiShu * 10;
            //System.out.println(result);
        }
        return result;
    }
    /**
     * Symbol    I     V     X      L      C       D       M
     * Value     1     5     10     50     100     500     1,000
     */
    public static void initMap(){
        map = new HashMap<Integer, String>();
        // 千 百 十 个
        map.put(0, "");
        //添加个位数映射
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        
        //添加十位数映射
        map.put(10, "X");
        map.put(20, "XX");
        map.put(30, "XXX");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(60, "LX");
        map.put(70, "LXX");
        map.put(80, "LXXX");
        map.put(90, "XC");

        //添加百位数映射
        map.put(100, "C");
        map.put(200, "CC");
        map.put(300, "CCC");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(600, "DC");
        map.put(700, "DCC");
        map.put(800, "DCCC");
        map.put(900, "CM");
 
         //添加千位数映射 最大 3999
        map.put(1000, "M");
        map.put(2000, "MM");
        map.put(3000, "MMM");
 
    }
}