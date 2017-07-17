import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
public class _018_4Sum{

	public static void main(String[] args) {
		int[] arr = {1, 0, -1, 0, -2, 2};
		List<List<Integer>> list = fourSum(arr,0);
		System.out.println(Arrays.toString(arr));
        System.out.println(list.toString());
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
		int len = nums.length;
		mergeSort(nums, 0 , len - 1, new int[len]);
        List<List<Integer>> list = new ArrayList<>();
        if(len < 4) return list;
        for (int i = 0; i < len - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < len - 2; j++) {
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                int m = j + 1, n = len - 1;
                while(m < n){
                    int sum = nums[i] + nums[j] + nums[m] + nums[n];
                    if (sum < target) {
                        m ++;
                    }else if(sum > target){
                        n --;
                    }else{
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[m]);
                        l.add(nums[n]);
                        list.add(l);
                        m ++;
                        n --;
                        while(m < n && nums[m] == nums[m-1]){
                            m ++;
                        }
                        while(m < n && nums[n] == nums[n+1]){
                            n --;
                        }
                    }
                }
            }
        }
        return list;
    }

    public static void mergeSort(int[] nums, int startIndex, int endIndex, int[] temp){
    	if(startIndex >= endIndex) return;
    	int midIndex = (startIndex + endIndex) / 2;
    	mergeSort(nums, startIndex, midIndex, temp);
    	mergeSort(nums, midIndex+1, endIndex, temp);
    	int i = startIndex, j = midIndex + 1;
    	while(startIndex <= midIndex && j <= endIndex){
    		if(nums[startIndex] <= nums[j]){
    			temp[i++] = nums[startIndex++];
    		}else{
    			temp[i++] = nums[j++];
    		}
    	}
    	while(startIndex <= midIndex){
    		temp[i++] = nums[startIndex++];
    	}
    	while(j <= endIndex){
    		temp[i++] = nums[j++];
    	}
    	System.arraycopy(temp, 0, nums, 0, i);
    }
}