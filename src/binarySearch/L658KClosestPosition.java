package binarySearch;

/**
 * Created by janet1 on 7/22/18.
 */
public class L658KClosestPosition {



    //L658 K closest position to target
    /*
    Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.
    Example 1:
    Input: [1,2,3,4,5], k=4, x=3
    Output: [1,2,3,4]
    */
//分两步走，第一步先找好有效的位置，第二部就是从left+1开始，将符合要求的element加入到//result list中去。要注意的是，left可能会出界的问题
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        if(arr == null || arr.length ==0)return null;
        List<Integer> res = new ArrayList<Integer>();
        int left = 0;
        int right = arr.length-1;
        int mid = 0;
        while(left + 1 < right){
            mid = left + (right-left)/2;
            if(arr[mid] < x){
                left = mid;
            }else{
                right = mid;
            }
        }
        for(int i = 0; i < k; i++){
            if(left>=0 && right <= arr.length-1){
                if(Math.abs(arr[left]-x)<=Math.abs(arr[right]-x)){
                    left--;
                }else{
                    right++;
                }
            }else if(left < 0){
                right++;
            }else{
                left--;
            }
        }
        int start = left < 0 ? 0 : left+1;//left跳出之后是在起始位置的左边一个值
        for(int i = 0; i < k; i++){
            res.add(arr[start+i]);
        }
        return res;
    }}
