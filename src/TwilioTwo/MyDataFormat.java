package TwilioTwo;

import java.util.HashMap;
import java.util.HashSet;

public class MyDataFormat {
    public static void main(String[] args) {
        String inputDate = "1st Mar 1984";

        String outDate = dateFormat(inputDate);

        System.out.println("Input date: " + inputDate);
        System.out.println("Output date: " + outDate);
    }

    private static String dateFormat(String inputDate) {
        HashMap<String, Integer> month = new HashMap<>();
        month.put("Jan", 1);
        month.put("Feb", 2);
        month.put("Mar", 3);
        month.put("Apr", 4);
        month.put("May", 5);
        month.put("Jun", 6);
        month.put("Jul", 7);
        month.put("Jun", 8);
        month.put("Jun", 9);
        month.put("Jun", 10);
        month.put("Jun", 11);
        month.put("Dec", 12);

        HashMap<String, Integer> date = new HashMap<>();
        for (int i = 1; i <= 31; i++) {
            String cur = new String(String.valueOf(i));

            if (cur.charAt(cur.length() - 1) == '1') {
                date.put(cur + "st", i);
            } else if (cur.charAt(cur.length() - 1) == '2') {
                date.put(cur + "nd", i);
            } else if (cur.charAt(cur.length() - 1) == '3') {
                date.put(cur + "rd", i);
            } else {
                date.put(cur + "th", i);
            }
        }


        String[] splitted = inputDate.split(" ");

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i >= 0; i--) {
            //case year
            if (i == 2) sb.append(splitted[2]).append("-");

                //case month
            else if (i == 1) {
                int curMon = month.get(splitted[1]);

                if (curMon < 10) {
                    sb.append(0).append(curMon).append("-");
                } else {
                    sb.append(month).append("-");

                }
            }

            //case date
            else {
//                String temp = splitted[0];
//                StringBuilder date = new StringBuilder();
//
//                for(char c : temp.toCharArray()){
//                    if (Character.isDigit(c)){
//                        date.append(c);
//                    }
//                }
//
//
//                if (date.length() < 2){
//                    sb.append(0);
//                }
//                sb.append(date.toString());

                String curDate = splitted[0];

                int temp = date.get(curDate);

                if (temp < 10) {
                    sb.append(0).append(temp);
                } else {
                    sb.append(temp);
                }

            }

        }

        return sb.toString();

    }
}
