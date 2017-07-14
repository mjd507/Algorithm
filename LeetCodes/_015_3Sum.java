import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _015_3Sum{

	public static void main(String[] args) {
		// int[] S = {0, 0, 0, 0};
		int[] S = {-1, 0, 0, 0, 1, 2, -1, -4};
		// quickSort(S, 0 ,S.length-1);
		// System.out.println(Arrays.toString(S));
		
		List<List<Integer>> list = threeSum(S);
		for (List<Integer> l : list ) {
			for (int a : l ) {
				System.out.print(a+ " ");
			}
			System.out.println();
		}
	}

	//先排序 在遍历，从剩下的数据中找两个总和为零的数
	public static List<List<Integer>> threeSum(int[] nums){
		int len = nums.length;
		quickSort(nums, 0, len - 1);

		List<List<Integer>> list = new ArrayList<>();
		if(len < 3) return list;
		for (int i = 0; i < len - 2; i++) {
	        if (i > 0 && nums[i] == nums[i - 1]) {
	            continue;
	        }
		 	int start = i + 1, end = len - 1;
		 	while(start < end){
		 		int sum = nums[i] + nums[end] + nums[start];
		 		if(sum > 0){
		 			end --;
		 		}else if(sum < 0){
		 			start ++;
		 		}else{
		 			List<Integer> zero = new ArrayList<>();
		 			zero.add(nums[i]);
		 			zero.add(nums[start]);
		 			zero.add(nums[end]);
		 			list.add(zero);
		 			start ++;
		 			end --;
		 			while(start < end && nums[start] == nums[start-1]){
		 				start ++;
		 			}
		 			while(start < end && nums[end] == nums[end+1]){
		 				end --;
		 			}
		 		}
		 	}
		}
		return list;
	}

	public static void quickSort(int[] nums, int startIndex, int endIndex){
		if(startIndex >= endIndex) return;
		int i = startIndex, j = endIndex;
		int key = nums[i];
		while(i < j){
			while( i < j && nums[j] > key){
				j --;
			}
			if(i < j){
				nums[i] = nums[j];
				i++; 
			}
			while( i < j && nums[i] < key){
				i++;
			}
			if(i < j){
				nums[j] = nums[i];
				j--;
			}
		}
		int keyIndex = i;
		nums[keyIndex] = key;
		quickSort(nums, startIndex, keyIndex-1);
		quickSort(nums, keyIndex+1, endIndex);
	}
}