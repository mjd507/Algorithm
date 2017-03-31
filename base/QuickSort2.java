import java.util.Random;
import java.util.Arrays;

public class QuickSort2{

	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[100000];
		for (int i = 0; i < 100000; i++) {
			arr[i] = random.nextInt(200000);
		}
		//System.out.println(Arrays.toString(arr));
		_CalculateTimeUtils timeUtils = new _CalculateTimeUtils() {
			@Override
			public void method() {
				quickSort(arr, 0, arr.length - 1);
			}
		};
		timeUtils.outputMethodTime();
		//System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int arr[], int start, int end){
		if(start < end){
			int startIndex = start, endIndex = end, key = arr[start];
			while(start < end){

				// 从后向前找第一个小于 key 的数  
				while(start < end && arr[end] > key){
					end--;
				}
				if(start < end){
					arr[start] = arr[end];
					start++;
				}

				// 从前向后找第一个大于 key 的数  
				while(start < end && arr[start] < key){
					start++;
				}
				if(start < end){
					arr[end] = arr[start];
					end--;
				}
			
			}

			//start == end
			int keyIndex = start;
			arr[keyIndex] = key;

			quickSort(arr, startIndex, keyIndex - 1);
			quickSort(arr, keyIndex + 1, endIndex);

		}

	}

}