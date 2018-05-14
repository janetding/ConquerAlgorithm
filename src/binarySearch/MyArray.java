package binarySearch;
import java.util.ArrayList;

/**
 * Created by janet1 on 5/14/18.
 * MyArray streamming flow
 * probing -> hash collision -> check website up
 * s______e
 * -------s--------e
 * ________________s________________e
 */
public class MyArray {
    public long unknownSizePosition(MyArray myArray,  int t){
        // corner case
        int start =0, end =1;

        while (myArray.get(end) != null && myArray.get(end) < target){
            start = end;
            end *= 2;

        }
        //
        while (start < end) {
            int mid = start + (end - start) / 2;
            if ( myArray.get(mid) != null && myArray.get(mid) == t) return mid;
            else if( myArray.get(mid) != null &&  myArray.get(mid) < t) start = mid +1;
            else  end = mid -1; // myArray.get(mid) == null || myArray.get(mid) > t;
        }
        return -1;

    }
}
