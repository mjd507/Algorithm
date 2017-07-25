import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class _017_LetterCombinationsOfPhoneNumber {

	public static void main(String[] args) {
		List<String> list = letterCombinations("234");
        System.out.println(list.size());
        System.out.println(list);
	}

    public static List<String> letterCombinations(String digits) {
    	//0 1 2 3 4 5 6 7 8 9
        String[] letters = {"0", "1", "abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        int len = digits.length();
        LinkedList<String> list = new LinkedList<>();
        list.add("");
        for (int i = 0; i < len; i++) {
            int index = Character.getNumericValue(digits.charAt(i));
            while(list.peek().length() == i){
                String rvm = list.remove();
                for(char c : letters[index].toCharArray()){
                    list.add(c+rvm);
                }
            }
        }
        return list;
    }
}