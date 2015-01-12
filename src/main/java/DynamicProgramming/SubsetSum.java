package DynamicProgramming;

import java.io.*;
import java.util.Scanner;

/**
 * author: karthik
 * date: 1/10/15
 */
public class SubsetSum {
    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter("sample_out.txt");
        Scanner in = new Scanner("sample_in.txt");
        try {
            int T = in.nextInt();
            int P,C,F;
            P = in.nextInt();C = in.nextInt(); F = in.nextInt();
            int N = in.nextInt();
            int[][] a= new int[N][3];
            for(int i=0;i<N;i++){
                a[i][0] = in.nextInt();
                a[i][1] = in.nextInt();
                a[i][2] = in.nextInt();
            }

            int[] dp = new int[1000];

            forj


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
