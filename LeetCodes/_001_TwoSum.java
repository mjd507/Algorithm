import java.util.HashMap;
import java.util.Arrays;
/**
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution.

Example
		Given nums = [2, 7, 11, 15], target = 9,

		Because nums[0] + nums[1] = 2 + 7 = 9,
		return [0, 1].
 */
public class _001_TwoSum {

	public static void main(String[] args) {
		int[] nums = {150,24,79,50,88,345,3};
		int[] twoSum = twoSum2(nums, 200);
		System.out.println("["+twoSum[0]+","+twoSum[1]+"]");
	}


	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int result[] = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])){
				result[0] = map.get(target - nums[i]);
				result[1] = i; 
			}else{
				map.put(nums[i], i);
			}
		}
		return result;
	}

	public static int[] twoSum2(int[] nums, int target) {
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			int end = len - 1;
			while(i < end){
				int delta = nums[i] + nums[end] - target;
				if(delta != 0){
					end--;
				}else{
					System.out.println(i + "" + end);
					return new int[]{i,end};
				}
			}
		}
		return new int[]{0,0};
	}
}
