
public class _027_RemoveElement{

  public static void main(String[] args) {
    
  }
  public int removeElement(int[] nums, int val) {
    int len = 0;
    for (int i = nums.length - 1; i >= 0; i--) {
      if(nums[i] == val){
        len ++;
        // nums[i] = null;
        int j = i;
        while(j < nums.length - 1){
          nums[j] = nums[j+1];
          j++;
        }
      }
    }
    return nums.length - len;
  }
}