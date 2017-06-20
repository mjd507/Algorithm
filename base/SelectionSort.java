import java.util.Random;
import java.util.Arrays;

public class SelectionSort{

	public static void main(String[] args) {
		Random random = new Random();
		int[] arr = new int[20000];
		for (int i = 0; i < 20000; i++) {
			arr[i] = random.nextInt(20000);
		}
		//System.out.println(Arrays.toString(arr));
		_CalculateTimeUtils timeUtils = new _CalculateTimeUtils() {
			@Override
			public void method() {
				selectionSort(arr);
			}
		};
		timeUtils.outputMethodTime();
		//System.out.println(Arrays.toString(arr));
	}

	public static void selectionSort(int[] arr){
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) { 
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			//j 完整遍历一次，确认一个最小值
		}
	}

}
