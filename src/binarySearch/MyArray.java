package binarySearch;


/**
 * Created by janet1 on 5/14/18.
 * MyArray streamming flow
 * probing -> hash collision -> check website up
 * s______e
 * -------s--------e
 * ________________s________________e
 */
public class MyArray {
    public long unknownSizePosition(int[] array,  int t){//TODO: Generics
        // corner case
        if(array == null || array.get(0) = 0) throw new IllegalArgumentException();
        int start =0, end =1;

        while ((array.get(end) != null) && (array.get(end) < t)){
            start = end;
            end *= 2;

        }
        //binary search
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (array.get(mid) != null && array.get(mid) == t) return mid;
            else if( array.get(mid) != null &&  array.get(mid) < t) start = mid +1;
            else  end = mid -1; // myArray.get(mid) == null || myArray.get(mid) > t;
        }
        return -1;

    }
}
