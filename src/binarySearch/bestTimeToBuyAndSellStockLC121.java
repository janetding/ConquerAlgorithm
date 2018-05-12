package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by janet1 on 5/12/18.
 */
public class bestTimeToBuyAndSellStockLC121 {
    public int maxProfit(int[] prices) {
        // DP
            //corner case
            if( prices == null || prices.length <= 1) return 0;
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int i =0; i < prices.length; i ++){
                min = min < prices[i] ? min : prices[i];
                max = max > prices[i] - min ? max : prices[i] - min;
            }
            return max;

        }
        //Iteration two for loop
    /**
       if( prices == null || prices.length <= 1) return 0;
      int temp = 0, result =0;
     for (int i =0; i < prices.length; i ++){
        for (int j = i; j < prices.length; j ++) {
      temp = prices[j] - prices[i];
     if (temp < 0 ) break;
      result = result > temp ? result : temp;
     }
     return result;
     }}
     */


    public static int[] stringToIntegerArray(String input) {
            input = input.trim();
            input = input.substring(1, input.length() - 1);
            if (input.length() == 0) {
                return new int[0];
            }

            String[] parts = input.split(",");
            int[] output = new int[parts.length];
            for(int index = 0; index < parts.length; index++) {
                String part = parts[index].trim();
                output[index] = Integer.parseInt(part);
            }
            return output;
        }

        public static void main(String[] args) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String line;
            while ((line = in.readLine()) != null) {
                int[] prices = stringToIntegerArray(line);

                int ret = new bestTimeToBuyAndSellStockLC121().maxProfit(prices);

                String out = String.valueOf(ret);

                System.out.print(out);
            }
        }
    }