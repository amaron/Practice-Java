package Arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Karthik Sriram
 * Date: 12/19/13
 * Time: 7:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearch<T extends  Comparable<T>> {
      public int binSearch(ArrayList<T> list, T val, int start, int end ){


          while(start<=end){
              int mid = start + (end - start)/2;
              if(val.compareTo(list.get(mid))<0){
                  end=mid-1;
              }else if(val.compareTo(list.get(mid))>0){
                  start = mid+1;
              }else return mid;
          }

          return -1;
      }
}
