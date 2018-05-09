package binarySearch;

public class VC {

    private Character[] versions;

    public VC(Character[] versions) {
        this.versions = versions;
    }

    private boolean isBadVersion(int version){
        return this.versions[version - 1] == 'B';
    }

    public  int searchFirstBadVersion(int n){
        // corner case
        int left = 1;
        int right = n;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        Character[] versions1 = {'G','G','G','B','B','B','B'};

        VC vc1 = new VC(versions1);

        int n = versions1.length;

        int index = vc1.searchFirstBadVersion(n);

        if(index == -1) System.out.println("Not find");
        else System.out.println("The first bad version is at: " + index);
    }


}
