import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _015_3Sum{

	public static void main(String[] args) {
		// int[] S = [-1, 0, 1, 2, -1, -4];
		int[] S = {-1, 0, 0, 0, 1, 2, -1, -4};
		//quickSort(S, 0 ,S.length-1);
		//[-4, -1, -1, 0, 1, 2]
		List<List<Integer>> list = threeSum(S);
		for (List<Integer> l : list ) {
			for (int a : l ) {
				System.out.print(a+ " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> threeSum(int[] nums){
		int len = nums.length;
		List<List<Integer>> list = new ArrayList<>();
		List<Integer> tripletsNums;

		if(len < 3) return list;

		int zeroCoutn = 0;
		for (int i = 0; i < len; i++) {
			if(nums[i] == 0){
				zeroCoutn ++;
			}
		}
		if(zeroCoutn >= 3){
			tripletsNums = new ArrayList<>();
			tripletsNums.add(0);
			tripletsNums.add(0);
			tripletsNums.add(0);
			list.add(tripletsNums);
		}

		for (int i = 0; i < len-2; i++) {
			for (int j = i+1; j < len - 1; j++) {
				for (int k = j+1; k < len; k++) {
					if(nums[i] + nums[j] + nums[k] == 0){
						tripletsNums = new ArrayList<>();
						tripletsNums.add(nums[i]);
						tripletsNums.add(nums[j]);
						tripletsNums.add(nums[k]);
						boolean isContains = false;
						boolean isZero = false;
						for (List<Integer> l: list) {
							if(l.contains(nums[i]) 
								&& l.contains(nums[j]) 
								&& l.contains(nums[k])
								|| (nums[i] == nums[j] && nums[i] == 0)){
								isContains = true;
								break;
							}
						}
						if(!isContains){
							list.add(tripletsNums);
						}	
						
					}
				}
			}
		}
		return list;
	}

	public static void quickSort(int[] nums, int startIndex, int endIndex){
		if(startIndex >= endIndex) return;
		int i = startIndex, j = endIndex;
		int key = nums[startIndex];
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
		quickSort(nums, 0, keyIndex-1);
		quickSort(nums, keyIndex+1, endIndex);
	}
}