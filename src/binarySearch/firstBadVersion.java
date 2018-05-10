package binarySearch;

public class firstBadVersion {
	private Character[] versions;

    private firstBadVersion(Character[] versions) {
        this.versions = versions;
    }

    private boolean isBadVersion(int version){
        if (this.versions[version - 1] == 'B') return true;
        else return false;
    }
//    public class BadVersion extends VersionControl {
        public int firstBadVersion1(int n) {
            int left =1, right = n,  mid ;
            while (left < right) {
                mid = left + ((right - left) >> 1);
                if (isBadVersion(mid)) right = mid;
                else left = mid +1;
            }
            return left;
        }

    public static void main(String[] args) {
        Character[] versions1 = {'G','G','G','G','G','G','G', 'B','B','B','B'};

        firstBadVersion fb = new firstBadVersion(versions1);

        int n = versions1.length;

        int index = fb.firstBadVersion1(n);

        if(index == -1) System.out.println("Not find");
        else System.out.println("The first bad version is at: " + index);
        }
    }



