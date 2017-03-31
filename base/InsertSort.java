import java.util.Random;
import java.util.Arrays;

public class InsertSort{

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
				insertSort(arr);
			}
		};
		timeUtils.outputMethodTime();
		//System.out.println(Arrays.toString(arr));
	}

	public static void insertSort(int[] arr){
		for(int i = 0; i < arr.length - 1; i ++){
			for(int j = i + 1; j > 0; j --){
				if(arr[j-1] > arr [j]){
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}else{
					break;
				}
			}
		}
	}
}
