package Strings;

import java.io.*;

/**
 * author: karthik
 * date: 1/10/15
 */
public class DigitSwapping {
    static int T;
    public static void main(String[] args) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream("TestDigitSwapping.txt")));
        PrintWriter pw = new PrintWriter("DigitSwappingOutput.txt");

        try {
            T = Integer.parseInt(br.readLine());
            int j = 0;
            while(j++<T) {
                char[] N = br.readLine().toCharArray();

                if(N.length == 1){
                    pw.println("Case #" + j + ": " + String.valueOf(N) + " " + String.valueOf(N));
                    continue;
                }
                char[] minN = N.clone(), maxN = N.clone();
                char maxC = '0', minC = '9';
                int max = 0, min = 0;
                for (int i = 0; i < N.length; i++) {
                    if (maxC < N[i]) {
                        maxC = N[i];
                        max = i;
                    }
                    if (minC > N[i]i && minC!='0') {
                        minC = N[i];
                        min = i;
                    }
                }

               
                char t = minN[0];
                minN[0] = minC;
                minN[min] = t;
              
                char t = maxN[0];
                maxN[0] = maxC;
                maxN[max] = t;

                pw.println("Case #" + j + ": " + String.valueOf(minN) + " " + String.valueOf(maxN));
            }

            pw.close();
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
