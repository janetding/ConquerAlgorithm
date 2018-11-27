package Practise;

/**
 * Created by janet1 on 9/2/18.
 */
    public class AddDecimal {
    static String addDecimal(String a, String b) {
        //initialize string
        String result = " ";
        //initialize digits
        int s = 0;
        int i = a.length()-1;
        int j = b.length()-1;

        while( i >= 0 || j >= 0 || s == 1 ){
            s += (( i >= 0 ) ? a.charAt(i) - '0' : 0) ;
            s += (( j >= 0 ) ? b.charAt(j) - '0' : 0) ;

            result = (char)( s % 2 + '0') + result;

            s /= 2;

            i --; j--;


        }
        return result;
    }

    public static void main(String[] args) {
        String a ="11";
        String b ="10";
        System.out.print("Final result : " +addDecimal(a,b));
    }
}
