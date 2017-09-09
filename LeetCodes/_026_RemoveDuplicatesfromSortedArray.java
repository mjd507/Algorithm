import java.util.ArrayList;
import java.util.Arrays;
public class _026_RemoveDuplicatesfromSortedArray {
  public static void main(String[] args) {
    int[] nums = {1,1,1,2,2,2};
    int len = removeDuplicates(nums);
    System.out.println("len = " + len);
  }
  public static int removeDuplicates(int[] nums) {
    if(nums.length < 1) return nums.length;
    int index = 0;
    for (int i = 1; i < nums.length; i++) {
      if(nums[index] != nums[i]){
        index++;
        nums[index] = nums[i];
      }
    }
    return index + 1;
  }
}