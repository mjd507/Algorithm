
public class _016_3SumClosest{
	public static void main(String[] args) {
		int[] S = {0,1,2};
		int target = 1;
		int result = threeSumClosest(S,target);
		System.out.println(result);
	}

	public static int threeSumClosest(int[] nums, int target) {
		int len = nums.length;
        quickSort(nums, 0, len - 1);
        int closePosValue = Integer.MAX_VALUE;
        int closeNeaValue = Integer.MIN_VALUE;
        int result = 0;
        //-3 0 1 2
        for (int i = 0; i < len - 2; i++) {
        	int j = i + 1, k = len - 1;
        	while(j < k){
        		int sum = nums[i] + nums[j] + nums[k];
        		int delta = sum - target;
        		if(delta > 0){
		        	if(delta < closePosValue){
		        		closePosValue = delta;
		        	}
		        	k--;
        		}else if(delta < 0){
        			if(delta > closeNeaValue){
		        		closeNeaValue = delta;
		        	}
		        	j++;
        		}else{
        			return sum;
        		}
        	}
        }
        if(closeNeaValue > -closePosValue){
        	result = closeNeaValue + target;
        }else{
        	result = closePosValue + target;
        }
        return result;
    }

    public static void quickSort(int[] nums, int startIndex, int endIndex){
    	if(startIndex >= endIndex) return;
    	int i = startIndex, j = endIndex;
    	int key = nums[startIndex];
    	while(startIndex < endIndex){
    		while(startIndex < endIndex && nums[endIndex] > key){
    			endIndex --;
    		}
    		if(startIndex < endIndex){
    			nums[startIndex] = nums[endIndex];
    			startIndex ++;
    		}
    		while(startIndex < endIndex && nums[startIndex] < key){
    			startIndex ++;
    		}
    		if(startIndex < endIndex){
    			nums[endIndex] = nums[startIndex];
    			endIndex --;
    		}
    	}
    	int keyIndex = startIndex;
    	nums[keyIndex] = key;
    	quickSort(nums, i, keyIndex - 1);
    	quickSort(nums, keyIndex + 1, j);
    }
}