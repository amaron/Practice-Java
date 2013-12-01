package Strings;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Karthik Sriram
 * Date: 12/1/13
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class Brackets {

    public static int n;
    public static List<String> L = new LinkedList<String>();

    public static void printBrackets(int l,int r, char a[]){

        if(l==0 && r==0){
             L.add(new String(a));
             return;
        }

        if(l<=r){
             if(l>0){
                 a[2*n-l-r]='(';
                 printBrackets(l-1,r,a);
             }
             a[2*n-l-r]=')';
             printBrackets(l,r-1,a);
        }


    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        n= s.nextInt();
        char[] a = new char[20];
        printBrackets(n/2,n/2,a);

        for(String l:L){
            System.out.println(l);
        }
    }
}
