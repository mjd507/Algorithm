public class _010_RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(isMatch("abc", "abc")); // true
        System.out.println(isMatch("a", "")); // false
        System.out.println(isMatch("", "aa")); // false
        System.out.println(isMatch("a", "aa")); // false
        System.out.println(isMatch("a", ".*")); // true
        System.out.println(isMatch("aa", ".*")); // true
        System.out.println(isMatch("abcd", "d*")); // false
        System.out.println(isMatch("bbbba", ".*a*a")); // true
        System.out.println(isMatch("aab", "c*a*b")); // true
        System.out.println(isMatch("aaa", "aaaa")); // false
        System.out.println(isMatch("aaa", "ab*a")); // false
        System.out.println(isMatch("aaa", "a*a")); // true
        System.out.println(isMatch("aaa", "ab*ac*a")); // true
        System.out.println(isMatch("aaa", "ab*a*c*a")); // true
        System.out.println(isMatch("a", "ab*")); // true
        System.out.println(isMatch("", "b*")); // true
        System.out.println(isMatch("a", ".*..a*")); //false
        System.out.println(isMatch("", ".")); //false
        System.out.println(isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s")); // true
        System.out.println(isMatch("aasdfasdf", "aasdf.*asdf")); // true
        System.out.println(isMatch("b", "aaa.")); // false
        System.out.println(isMatch("abbbcd", "ab*bbbcd")); // true
        System.out.println(isMatch("bbba", ".*b")); // false
        System.out.println(isMatch("acaabbaccbbacaabbbb", "a*.*b*.*a*aa*a*")); // false
        System.out.println(isMatch("aab", "aa*")); // false
        System.out.println(isMatch("a", "ab*a")); // false
        System.out.println(isMatch("ab", ".*..c*")); //true
        System.out.println(isMatch("aab", "b.*")); //false
        System.out.println(isMatch("cabbbbcbcacbabc", ".*b.*.ab*.*b*a*c")); //true
        System.out.println(isMatch("cabb", ".*b.*")); // true
        System.out.println(isMatch("cabb", ".*b.*.")); // true
    }

    public static boolean isMatch(String s, String p) {

        if (s.length() == 0 && p.length() == 0) {
            return true;
        }

        char[] pArr = p.toCharArray();
        char[] sArr = s.toCharArray();

        int pLen = pArr.length;
        int sLen = sArr.length;

        int num = 0;
        // 有多少*
        for (int i = 0; i < pLen; i++) {
            if (pArr[i] == '*') {
                num++;
            }
        }

        int rLen = pLen - num;
        int rIndex = 0;
        char[] rArr = new char[rLen];

        // #代表0个或多个任意字符 A-Z 代表0个或多个a-z
        for (int i = 0; i < pLen; i++) {
            if (i + 1 < pLen && pArr[i + 1] == '*') {
                if (pArr[i] == '.') {
                    // #代表0个或多个任意字符
                    rArr[rIndex++] = '#';
                } else {
                    // 变成大写 代表0个或多个a-z
                    rArr[rIndex++] = Character.toUpperCase(pArr[i]);
                }
                i++;
            } else {
                rArr[rIndex++] = pArr[i];
            }
        }

        if (sLen != 0 && rLen == 0) {
            return false;
        }
        if (sLen == 0 && rLen != 0) {
            for (int i = 0; i < rLen; i++) {
                if (isLowerCase(rArr, i))
                    return false;
            }
        }

        // 正则数组的value记录的是s的位置 初始化：都是-1
        int[] rIndexArr = new int[rLen];
        for (int i = 0; i < rLen; i++) {
            rIndexArr[i] = -1;
        }

        // 遍历s数组 取得返回的正则数组： 判断每个字符是否满足条件 把s的位置记录到正则数组
        for (int i = 0; i < sLen; i++) {
            rIndexArr = getRIndexArr(sArr, rArr, i, rIndexArr);
        }

        // 如果正则数组的最后一个值是s数组的最后一个字符的下标 返回true 否则false
        return rIndexArr[rLen - 1] == sLen - 1;
    }

    /**
     * 根据s的字符取得正则数组
     * @param sArr
     * @param rArr
     * @param sIndex
     * @param rIndexArr
     * @return
     */
    private static int[] getRIndexArr(char[] sArr, char[] rArr, int sIndex, int[] rIndexArr) {

        int rLen = rArr.length;
        boolean lowerCaseHasMatch = false;

        // 记载上个字符匹配的正则数组
        int[] preRIndexArr = new int[rLen];
        int preRLastIndex = -1;
        for (int i = 0; i < rLen; i++) {
            preRIndexArr[i] = rIndexArr[i];
            if (preRIndexArr[i] + 1 >= sIndex) {
                preRLastIndex = i;
            }
        }
        for (int r = 0; r < rLen; r++) {
            // A-Z 的情况下 如果上个字符满足条件则这个字符也满足
            if (r > 0 && isSingleUpperCase(rArr, r)) {
                if (rIndexArr[r - 1] >= sIndex) {
                    rIndexArr[r] = rIndexArr[r - 1];
                }
            }
            // 上个字符满足条件 才匹配当前字符
            if (preRIndexArr[r] + 1 >= sIndex) {
                int index = -1;
                // 第一个字符或这个字符是A-Z或# 要匹配自己
                if (sIndex == 0 || isUpperCase(rArr, r)) {
                    index = isMatch(sArr, rArr, sIndex, r);
                    if (index != -1 && isLowerCase(rArr, index)) {
                        // 之前匹配成功过 && 是小写字符 && 上个字符匹配成功的已经都遍历过了 直接跳出循环
                        if (lowerCaseHasMatch && (sIndex == 0 || r > preRLastIndex + 1)) {
                            break;
                        }
                        lowerCaseHasMatch = true;
                    }
                    if (index != -1) {
                        rIndexArr[index] = sIndex;
                    }
                    // 第一个字符 没匹配成功直接跳出循环
                    if (sIndex == 0 && index == -1) {
                        break;
                    }
                }
                // 判断下个字符 是否符合
                index = isMatch(sArr, rArr, sIndex, r + 1);
                if (index != -1 && isLowerCase(rArr, index)) {
                    // 之前匹配成功过 && 是小写字符 && 上个字符匹配成功的已经都遍历过了 直接跳出循环
                    if (lowerCaseHasMatch && (sIndex == 0 || r + 1 > preRLastIndex + 1)) {
                        break;
                    }
                    lowerCaseHasMatch = true;
                }
                if (index != -1) {
                    rIndexArr[index] = sIndex;
                    preRIndexArr[index] = sIndex;
                }
            }
        }
        return rIndexArr;
    }

    /**
     * s数组和正则数组的单个字符是否匹配
     * 匹配失败： 返回-1
     * 匹配成功： 返回正则数组的下标
     * @param sArr
     * @param rArr
     * @param sIndex
     * @param rIndex
     * @return 正则数组
     */
    private static int isMatch(char[] sArr, char[] rArr, int sIndex, int rIndex) {
        if (sIndex >= sArr.length || rIndex >= rArr.length) {
            return -1;
        }
        if (rArr[rIndex] == '#') {
            return rIndex;
        } else if (isSingleUpperCase(rArr, rIndex) && sArr[sIndex] == Character.toLowerCase(rArr[rIndex])) {
            return rIndex;
        } else if (rArr[rIndex] == '.') {
            return rIndex;
        } else if (sArr[sIndex] == rArr[rIndex]) {
            return rIndex;
        } else if (isSingleUpperCase(rArr, rIndex)) {
            if (rIndex + 1 == rArr.length) {
                return -1;
            } else {
                return isMatch(sArr, rArr, sIndex, rIndex + 1);
            }
        } else {
            return -1;
        }
    }

    private static boolean isLowerCase(char[] rArr, int rIndex) {
        return rIndex < rArr.length && ((rArr[rIndex] >= 'a' && rArr[rIndex] <= 'z') || rArr[rIndex] == '.');
    }

    private static boolean isSingleUpperCase(char[] rArr, int rIndex) {
        return rIndex < rArr.length && (rArr[rIndex] >= 'A' && rArr[rIndex] <= 'Z');
    }

    private static boolean isUpperCase(char[] rArr, int rIndex) {
        return rIndex < rArr.length && ((rArr[rIndex] >= 'A' && rArr[rIndex] <= 'Z') || rArr[rIndex] == '#');
    }
}