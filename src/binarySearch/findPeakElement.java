package binarySearch;

/**
 * Created by janet1 on 5/10/18.
 */
public class findPeakElement {
 public static int findPeakElementProb(int[] nums) {
            //corner case
            if ( nums == null || nums.length == 0) return -1;
            int start = 0; int end =nums.length -1; int mid;
            while(start + 1 < end) {
                mid = start + ((end - start) >> 1);
                if (nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) {
                    return mid;
                }else if(nums[mid] < nums[mid +1] && nums[mid] > nums[mid-1]){
                    start = mid;
                }else{
                    end = mid;
                }

            }
            return nums[start] > nums[end] ? start : end;
        }
 /**
 *using BST to get valley number
 *To the opporsite way
 * Heights[left] , Heights[right] ,which one is smaller, choose that one
 public static int findOneValley(int[] heights) {
			
			int left =0,  right = heights.length - 1; 
			
			//try{
				if (heights == null || heights.length == 0) {
					throw new UnsupportedOperationException("Not implemented");
				}
				
				while (left + 1 < right){
					int mid = left + ((right - left) >> 1);
					if (heights[mid] < heights[mid+1] && heights[mid] < heights[mid-1]) {
						return mid;
					}
					else if (heights[mid] < heights[mid+1] && heights[mid] > heights[mid-1])  {
						right = mid;
					}
					else {
						left = mid;
					}
				}
				
				if(heights[left] < heights[right]){
					return left;
				}
				else if(heights[left] > heights[right]){
					return right;
				}
				else{
					return -1;
				}*/			




    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10,4};

        System.out.println("Index: " + findPeakElementProb(arr) );
    }
}




