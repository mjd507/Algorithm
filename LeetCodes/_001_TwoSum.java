import java.util.HashMap;

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
		int[] nums = {2, 7, 11, 15};
		int[] twoSum = twoSum(nums, 9);
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
}
