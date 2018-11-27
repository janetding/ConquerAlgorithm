package binarySearch;

/**
 * Created by janet1 on 8/17/18.
 */

public class LC278FirstBadVersion {
    private Character[] versions;
    public LC278FirstBadVersion(Character[] versions){
        this.versions = versions;
    }

    /*
    * Approach #1 (Linear Scan) [Time Limit Exceeded]
    The straight forward way is to brute force it by doing a linear scan : firstBadVersion1(int n)
        Complexity analysis
            Time complexity: O(n). Assume that isBadVersion(version) takes constant time to check if a version is bad. It takes
            at most n-1 checks, therefore the overall time complexity is O(n).
         Space complexity: O(1)
     */
    public int firstBadVersion1(int n) {
        //i < n as there will be at least one bad version, maybe the last one
        //i is the number of bad eggs
        for (int i = 1; i < n; i++) {
            if (isBadVersion(i)) {
                return i;
            }
        }
        return n;
    }

      /*
     *  Approach #2 (Binary Search) [Accepted]
     *
     *  It is not difficult to see that this could be solved using a  classic algorithm - Binary search. Let us see how the
     *  seach space could be halved each time below.
     *
     *  Scenario #1: isBadVesion(mid) => false
     *
     *  1 2 3 4 5 6 7 8 9
     *  G G G G G G B B B            G = Good, B = Bad
     *  |       |       |
     *  left    mid    right
     *
     *  Let us loot at the first scenario above where isBadVersion(mid) => false. We know that all versions preceding and
     *  including mid are all good. So we set left = mid + 1 to indicate that the new search space is the interval [mid + 1,
     *  right] (inclusive)
     *
     *  Scenario #2: isBadVersion(mid) => true
     *
     *  1 2 3 4 5 6 7 8 9
     *  G G G B B B B B B       G = Good, B = Bad
     *  |       |       |
     *  left    mid    right
     *
     *  The only scenario left is where isBadVersion(mid) => true. This tells us that mid may or may not be the first bad
     *  version, but we can tell for sure that all verions after mid can be discarded. Therefore we set right = mid as the
     *  new search space of interval [left, mid] (inclusive)
     *
     *  In our case, we indicate left and right as the boundary of our search space (both inclusive). This is why we initialize
     *  left = 1 and right = n. How about the terminating condition? We could guess that left and right eventually both meet
     *  and it must be the first bad version, but how could you tell for sure?
     *
     *  The formal way is to prove by induction, which you can read up yourself if you are interested. Here is a helpful tip
     *  to quickly prove the correctness of your binary search algorithm during an interview. We just need to test an input of
     *  size 2. Check if it reduces the search space to a single element (which must be the answer) for both of the scenario
     *  above. If not, your algorithm will never terminate.
     *
     *  If you are setting mid = (left + right) / 2, you have to very careful. Unless you are using a language that does not
     *  overflow such as Python, left + right could overflow. One way to fix this is to use left + (right - left) / 2 instead.
     *
     *  If you fall into this subtle overflow bug, you are not alone. Even Jon Bentley's own implementation of binary search had
     *  this overflow bug and remained undetected for over twenty years.
     *
     *  Time complexity: O(log n). The search space is halved each time, so the time complexity is O(log n).
     *  Space complexity: O(1)
         */
      public int firstBadVersion2(int n){
          int left = 1, right = n;
          int mid = 0;
          while (left <= right){
              mid = left + ((right-left)>>2);
              if(isBadVersion(mid)) right = mid -1;
              else left = mid+1;
          }

          return left;

      }

//    private  boolean isBadVersion(int version) {
//        return versions.charAt(i-1) == 'B';
//    }
    private boolean isBadVersion(int version){
        if (this.versions[version - 1] == 'B') return true;
        else return false;
    }

    public static void main(String[] args) {

        Character[] versions2 = {'G','G','G','G','G', 'B','B','B','B'};

        firstBadVersion fb = new firstBadVersion(versions2);

        int n = versions2.length;

        int index = fb.firstBadVersion1(n);

        if(index == -1) System.out.println("Not find");
        else System.out.println("The first bad version is at: " + index);
    }
}
