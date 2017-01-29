import java.util.Random;
import java.util.Arrays;

public class InsertSortBinarySearch {

	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[100000];
		for (int i = 0; i < 100000; i++) {
			arr[i] = random.nextInt(100000);
		}
		//System.out.println(Arrays.toString(arr));
		_CalculateTimeUtils timeUtils = new _CalculateTimeUtils() {
			@Override
			public void method() {
				insertSortBinarySearch(arr);
			}
		};
		timeUtils.outputMethodTime();
		//System.out.println(Arrays.toString(arr));
	}

	public static void insertSortBinarySearch(int[] arr){
		//System.out.println(Arrays.toString(arr));
		for(int i = 0; i < arr.length - 1; i ++){
			int index = findIndex(arr, 0, i, arr[i+1]);
			//System.out.println("insert pos = "+ index);
			int temp = arr[i+1];
			for (int j = i+1; j > index; j--) {
				arr[j] = arr[j-1];
			}
			arr[index] = temp;
			//System.out.println("iter result = "+Arrays.toString(arr));
		}
	}

	public static int findIndex(int[] arr, int first, int last, int value){
		int mid = -1;
		int index = -1;
		while(first <= last){
			mid = (first + last)/2;
			if(value == arr[mid]){ 
				index = mid;
				return index;
			}
			if(value < arr[mid]){ //left
				last = mid - 1;
			}else{ //right
				first = mid + 1;
			}
		}
		//no match value, find the closer index
		if(value < arr[mid]){
			index = mid;
		}else{
			index = mid + 1;
		}
		return index;

	}



}