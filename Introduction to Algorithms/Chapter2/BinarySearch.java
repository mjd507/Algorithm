
public class BinarySearch{

	public static void main(String[] args) {
		int[] arr = new int[]{12,23,28,34,46,61,87,99};
		int index = binarySearch(arr,0,arr.length - 1, 11);
		System.out.println(index);
	}

	public static int binarySearch(int[] arr, int first, int last, int value){

		// find mid value mid，
		// if value < mid，then find mid value between first to mid; vice versa.
		// repeat until find the value

		while(first <= last){
			int mid = (first + last)/2;
			if(value == arr[mid]){ 
				return mid;
			}
			if(value < arr[mid]){ //left
				last = mid - 1;
			}else{ //right
				first = mid + 1;
			}
		}
		return -1;

	}

}