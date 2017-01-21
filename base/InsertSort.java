import java.util.Random;

public class InsertSort{

	public static void main(String[] args) {
		Random random = new Random(100000);
		int[] arr = new int[100000];
		for (int i = 0; i < 100000; i++) {
			arr[i] = random.nextInt();
		}
		_CalculateTimeUtils timeUtils = new _CalculateTimeUtils() {
			@Override
			public void method() {
				insertSort(arr);
			}
		};
		timeUtils.outputMethodTime();
	}

	public static void insertSort(int[] arr){
		int temp;
		for(int i = 0; i < arr.length - 1; i ++){
			for(int j = i + 1; j > 0; j --){
				if(arr[j-1] > arr [j]){
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}else{
					break;
				}
			}
		}
	}
}
