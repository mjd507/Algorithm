import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class _012_IntToRoman {

    private static Map<String, Map> romanMap = new HashMap<>();

    public static void main(String[] args) {
        // 取0-3999之间的随机数
        Random random = new Random();
        int num = random.nextInt(3999);
        // 获取罗马数字
        String roman = intToRoman(num);
        if (roman != null && roman.length() != 0) {
            System.out.println("The roman number corresponding to " + num + " is " + roman);
        }
    }

    public static String intToRoman(int num) {
        // 初始化
        initRomanMap();
        StringBuffer romanSb = new StringBuffer();

        if (num < 1 || num > 3999) {
            System.out.println("The number should be greater than 0, less than 3999");
            return "";
        } else {
            // 把输入的数字倒序排列 在做处理
            StringBuffer sbReverse = new StringBuffer(String.valueOf(num)).reverse();
            String reverseStr = sbReverse.toString();

            // 0(single) 1(tens) 2(hundreds) 3(thousands)
            for (int i = 0; i < reverseStr.length(); i++) {

                StringBuffer sb = new StringBuffer();
                int numInt = Character.getNumericValue(reverseStr.charAt(i));
                Map<String, String> digitMap = getDigitMap(i);

                if (numInt > 0 && numInt < 4) {
                    for (int j = 0; j < numInt; j++) {
                        sb.append(digitMap.get("one"));
                    }
                } else if (numInt == 4) {
                    sb.append(digitMap.get("one"));
                    sb.append(digitMap.get("five"));
                } else if (numInt == 5) {
                    sb.append(digitMap.get("five"));
                } else if (numInt > 5 && numInt < 9) {
                    sb.append(digitMap.get("five"));
                    for (int j = 5; j < numInt; j++) {
                        sb.append(digitMap.get("one"));
                    }
                } else if (numInt == 9) {
                    Map<String, String> nextDigitMap = getDigitMap(i + 1);
                    sb.append(digitMap.get("one"));
                    sb.append(nextDigitMap.get("one"));
                }

                romanSb.insert(0, sb.toString());
            }
        }
        return romanSb.toString();
    }

    /**
     * Symbol    I     V     X      L      C       D       M
     * Value     1     5     10     50     100     500     1,000
     */
    private static void initRomanMap() {

        // single tens hundreds and thousands digit
        Map<String, String> singleMap = new HashMap<>();
        Map<String, String> tensMap = new HashMap<>();
        Map<String, String> hundredsMap = new HashMap<>();
        Map<String, String> thousandsMap = new HashMap<>();

        singleMap.put("one", "I");
        singleMap.put("five", "V");

        tensMap.put("one", "X");
        tensMap.put("five", "L");

        hundredsMap.put("one", "C");
        hundredsMap.put("five", "D");

        thousandsMap.put("one", "M");

        romanMap.put("single", singleMap);
        romanMap.put("tens", tensMap);
        romanMap.put("hundreds", hundredsMap);
        romanMap.put("thousands", thousandsMap);
    }

    private static Map<String, String> getDigitMap(int digit) {

        Map<String, String> digitMap = new HashMap<>();
        switch (digit) {
            case 0:
                digitMap = romanMap.get("single");
                break;
            case 1:
                digitMap = romanMap.get("tens");
                break;
            case 2:
                digitMap = romanMap.get("hundreds");
                break;
            case 3:
                digitMap = romanMap.get("thousands");
                break;
        }
        return digitMap;
    }
}
