import java.util.Random;
import java.util.Arrays;

public class MergeSort{

	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[]{3, 9, 16, 2, 42,67};
		// for (int i = 0; i < 10; i++) {
		// 	arr[i] = random.nextInt(10);
		// }
		System.out.println(Arrays.toString(arr));
		_CalculateTimeUtils timeUtils = new _CalculateTimeUtils() {
			@Override
			public void method() {
				mergeSort(arr);
			}
		};
		timeUtils.outputMethodTime();
		System.out.println(Arrays.toString(arr));
	}

	//将一个数组的两个有序的部分合并到一个有序数组中。
	public static void mergeSort(int[] arr){
		int[] result = new int[arr.length];
		
		int first = 0, mid = arr.length/2, last = arr.length;
		int m = mid;
		int k = 0;
		while(first < mid && m < last){
			if(arr[first] < arr[m]){
				result[k++] = arr[first++];
			}else{
				result[k++] = arr[m++];
			}
		}

		while(first < mid){
			result[k++] = arr[first++];
		}
		while(m < last){
			result[k++] = arr[m++];
		}

		for (int i = 0; i < last; i++) {
			arr[i] = result[i];
		}
	}




}