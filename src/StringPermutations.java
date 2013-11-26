/**
 * Created with IntelliJ IDEA.
 * User: Karthik Sriram
 * Date: 11/16/13
 * Time: 10:23 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class StringPermutations
{
    public static void main (String[] args) throws java.lang.Exception
    {
        List<String> finalPermutations = new LinkedList<String>();
        String str="abcd";
        permute(str,0,4,finalPermutations);
        for(String perm: finalPermutations){
            System.out.println(perm);
        }
    }

    public static void permute(String st,int i, int n, List<String> finalPermutations){
        if(i==n){
            finalPermutations.add(st);
            return;
        }
        int j;
        for(j=i;j<n;j++){
            StringBuilder str = new StringBuilder(st);
            Character t = st.charAt(i);
            str.setCharAt(i,st.charAt(j));
            str.setCharAt(j,t);
            permute(str.toString(),i+1,n,finalPermutations);
            t = st.charAt(i);
            str.setCharAt(i,st.charAt(j));
            str.setCharAt(j,t);
        }
    }
}