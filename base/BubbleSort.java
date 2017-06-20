import java.util.Random;
import java.util.Arrays;

public class BubbleSort{

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
				bubbleSort(arr);
			}
		};
		timeUtils.outputMethodTime();
		//System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort(int[] arr){
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				if(arr[j] > arr[j+1]){
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			//j 完整遍历一次，确认一个最大值
		}
	}

}
