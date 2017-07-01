public class _011_ContainerWithMostWater{

	public static void main(String[] args) {
		int[] arr = {3,1, 29, 6, 32, 0, 9};
		System.out.print(maxArea(arr));
	}
	public static int maxArea(int[] height) {
		int len =  height.length;
		int i = 0, j = len - 1, maxArea = 0;
		while(i < j){
			boolean isIshort = height[i] < height[j];
			//取短板
			int minHeight = isIshort ? height[i] : height[j];
			int area = (j - i) * minHeight;
			if(maxArea < area){
				maxArea = area;
			}
			if(isIshort){
				i++;
			}else{
				j--;
			}
		}
		return maxArea;
	}
}