import java.util.Random;
import java.util.Arrays;

public class MergeSort{

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
				int[] result = new int[arr.length];
				mergeSort(arr,0, arr.length - 1, result);
			}
		};
		timeUtils.outputMethodTime();
		//System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr, int first, int last, int[] temp){
		if(first < last){
			int mid = (first + last)/2;
			
			mergeSort(arr, first, mid, temp); //左边递归
			mergeSort(arr, mid + 1, last, temp); //右边递归

			int m = mid + 1;
			int k = first;
			while(first <= mid && m <= last){
				if(arr[first] < arr[m]){
					temp[k++] = arr[first++];
				}else {
					temp[k++] = arr[m++];
				}
			}
			while(first <= mid){
				temp[k++] = arr[first++];
			}
			while(m <= last){
				temp[k++] = arr[m++];
			}
			// for (int i = 0; i < k; i++) {
			// 	arr[i] = temp[i];
			// }
			System.arraycopy(temp, 0, arr, 0, k);
		}
	}




}