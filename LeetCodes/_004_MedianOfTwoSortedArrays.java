import java.util.Arrays;
public class _004_MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] arr1 = {3,6,25,44,57,66};
		int[] arr2 = {2,10,24,38,99,120};
		double count = findMedianSortedArrays(arr1,arr2);
		System.out.println(count);
	}

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	int nums1Length = nums1.length;
    	int nums2Length = nums2.length;
        int[] allNums = new int[(nums1Length + nums2Length)];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < nums1Length && j < nums2Length){
        	while(i < nums1Length && j < nums2Length && nums1[i] <= nums2[j]){
        		allNums[k++] = nums1[i++];
        	}
        	while(i < nums1Length && j < nums2Length && nums1[i] > nums2[j]){
        		allNums[k++] = nums2[j++];
        	}
        }
        System.out.println(Arrays.toString(allNums));
        if(i < nums1Length){
        	System.arraycopy(nums1, i, allNums, k, nums1Length - i);
        }
        if(j < nums2Length){
        	System.arraycopy(nums2, j, allNums, k, nums2Length - j);
        }
        System.out.println(Arrays.toString(allNums));

        int length = allNums.length;
        double result;
        if(length%2 == 0){
        	int index = length/2;
        	result = (allNums[index-1] + allNums[index])*1.0/2;
        }else{
        	int index = length/2;
        	result = allNums[index];
        }
        return result;
    }

}