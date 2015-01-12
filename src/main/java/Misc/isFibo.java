package Misc;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Karthik Sriram
 * Date: 1/17/14
 * Time: 8:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class isFibo {
    public static void main(String[] args) {
        Set<Long> fibs = new HashSet<Long>();
        fibs.add(0L);
        long a=0,b=1,c=1;
        for(int i=0;i<50;i++){
            c=a+b;
            a=b;
            b=c;
            fibs.add(c);
        }

        Scanner scan = new Scanner(System.in);
        int t;
        t=scan.nextInt();
        while(t--!=0){
            Long n=scan.nextLong();
            if(fibs.contains(n)){
                System.out.println("IsFibo");
            }else System.out.println("IsNotFibo");
        }
    }
}
