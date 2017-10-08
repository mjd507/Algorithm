public class _035_SearchInsertPosition{
  public static void main(String[] args) {
    int[] arr = new int[]{1,3,5,6};
    int index = searchInsert(arr,0);
    System.out.println(index);
  }
  public static int searchInsert(int[] nums, int target) {
    int s = 0, e = nums.length - 1;
    int m = 0;
    while(s <= e){
      m = (s + e)/2;
      if(nums[m] == target){
        return m;
      }else if(nums[m] > target){
        e = m - 1;
      }else{
        s = m + 1;
      }
    }
    if(nums[m] > target) return m;
    return m+1;
  }
}