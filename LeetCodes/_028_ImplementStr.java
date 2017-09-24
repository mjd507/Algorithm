
public class _028_ImplementStr{

  public static void main(String[] args) {
    int index = strStr("","");
    System.out.println(index);
  }
  public static int strStr(String haystack, String needle) {
    if(needle.length() == 0) return 0;
    int stackLen = haystack.length();
    int needLen = needle.length();
    for (int i = 0; i <= stackLen - needLen; i++) {
      for (int j = 0; j < needLen && needle.charAt(j) == haystack.charAt(i+j); j++) {
        if(j == needLen - 1) return i;
      }
    }
    return -1;
  }
}