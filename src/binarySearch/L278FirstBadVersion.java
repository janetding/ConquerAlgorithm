package binarySearch;

/**
 * Created by janet1 on 7/22/18.
 */
public class L278FirstBadVersion {
    private Character[] versions;
   L278FirstBadVersion(Character[] versions) {

        this.versions = versions;
    }
private  boolean isBadVersion(int version){
       if(this.versions[version -1] =='B') return true;
       return false;

}


//
//    private Character[] versions;
//
//    firstBadVersion(Character[] versions) {
//
//        this.versions = versions;
//    }

//    private boolean isBadVersion(int version){
//        if (this.versions[version - 1] == 'B') return true;
//        else return false;
//    }

    // L278 first bad version
    /*
    You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
    Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
    You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
    */
    public int firstBadVersionOne(int n) {
        int left = 1;//这里的left不是index，所以应该从1开始。这样后面就不需要check
        int right = n;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
       Character[] arr = { 'G','G','B'};
        L278FirstBadVersion fb = new L278FirstBadVersion(arr);
        int n = arr.length-1;
        int index = fb.firstBadVersionOne(n-1);
        if(index ==-1)
            System.out.println("not find");
        System.out.println("The first bad version at: " + index);
//        System.out.println(fb.firstBadVersionOne(arr));
//        firstBadVersion fb = new firstBadVersion(versions1);
//
//        int n = versions1.length;
//
//        int index = fb.firstBadVersion1(n);
//
//        if(index == -1) System.out.println("Not find");
//        else System.out.println("The first bad version is at: " + index);
//    }
}}