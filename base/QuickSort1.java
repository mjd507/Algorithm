import java.util.Random;
import java.util.Arrays;

public class QuickSort1{

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
			boolean fromEnd = true; // 控制从后面开始遍历的变量，false 表示从前开始遍历
			while(start < end){
				if(fromEnd){
					if(arr[end] < key){
						arr[start] = arr[end];
						fromEnd = false;
					}else{
						end--;
						continue;
					}		
				}else{
					if(arr[start] > key){
						arr[end] = arr[start];
						fromEnd = true;
					}else{
						start++;
						continue;
					}				
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