package TwilioTwo;

import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class HostName {
    @Test
    public void test1() throws IOException {
        String inPath = "/Users/janet1/Desktop/ConquerAlgorithm/src/TwilioTwo/hostnames.txt" ;
        String outPath = "/Users/janet1/Desktop/ConquerAlgorithm/src/TwilioTwo/output.txt";
        analysisHostNames(inPath, outPath);
    }

    private void analysisHostNames(String inPath, String outPath) throws IOException {
        HashMap<String, Integer> res = new HashMap<>();

        if (inPath==null||inPath.length() == 0) return;

        Scanner sc = new Scanner(new File(inPath));

        while (sc.hasNext()){

            String data = sc.nextLine();

            String[] slitted = data.split("- -");


            String hostName = slitted[0];


            res.put(hostName, res.getOrDefault(hostName, 0) + 1);
        }

        sc.close();

        PrintWriter printWriter = new PrintWriter(new FileWriter(outPath));
        StringBuilder sb = new StringBuilder();

        for(String name : res.keySet()){
            String s = name + "\t" + res.get(name) ;
            System.out.println(s);
            sb.append(s).append("\n");
        }
        printWriter.write(sb.toString());
        printWriter.close();
    }

}
