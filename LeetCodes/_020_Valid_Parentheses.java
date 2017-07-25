import java.util.Stack;
import java.lang.Character;
public class _020_Valid_Parentheses{

	public static void main(String[] args) {
		boolean isVaild = isValid("{({[()]})");
		System.out.println(isVaild + "");
	}


	public static boolean isValid(String s) {
		if(s == null || s.length() == 0 || s.length() % 2 != 0){
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		char[] charArr = s.toCharArray();
		for(char c : charArr){
			if(c == '(' || c == '{' || c == '['){
				stack.push(c);
			}else{
				if(stack.empty()) return false;
				if(c == ')' && stack.peek() != '(') return false;
				if(c == '}' && stack.peek() != '{') return false;
				if(c == ']' && stack.peek() != '[') return false;
				stack.pop();
			}
		}
		return stack.empty();
	}