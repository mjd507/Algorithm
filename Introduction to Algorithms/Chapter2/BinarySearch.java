
public class BinarySearch{

	public static void main(String[] args) {
		int[] arr = new int[]{12,23,28,34,46,61,87,99};
		int index = binarySearch(arr,0,arr.length - 1, 12);
		System.out.println(index);
	}

	public static int binarySearch(int[] arr, int first, int last, int value){

		// find mid value mid，
		// if value < mid，then find mid value between first to mid; vice versa.
		// repeat until find the value

		if(first < last){
			int mid = (last + first)/2;
			if(value == arr[mid]){ 
				return mid;
			}
			if(value < arr[mid]){ //left
				return binarySearch(arr,first,mid - 1, value);
			}else{ //right
				return binarySearch(arr, mid, last + 1, value);
			}
		}
		return first;

	}

}