package Misc;

/**
 * Created with IntelliJ IDEA.
 * User: Karthik Sriram
 * Date: 12/12/13
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
import Arrays.BinarySearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

// To execute Java, please define "static void main" on a class named Solution

class Solution {
    public static void main(String[] args) {
         BinarySearch<Integer> bs = new BinarySearch<Integer>();
         ArrayList<Integer> a = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int i=0;
        while(i<n){
            a.add(scan.nextInt());
            i++;
        }

        Collections.sort(a);
        for(int nl: a){
            System.out.println(nl);
        }

        int searchFor = scan.nextInt();
        System.out.println(bs.binSearch(a,searchFor,0,n-1));

       /* BST< Integer > tree = new BST<Integer>();
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(20);
        tree.add(12);

        tree.print();
        System.out.println("-----");
        for (int i : tree) {
            System.out.println(i);
        }
    }*/
    }
}

class BTreeNode<T>{
    BTreeNode<T> l = null;
    BTreeNode<T> r = null;
    BTreeNode<T> parent = null;
    T data = null;

    BTreeNode(T data, BTreeNode<T> l,BTreeNode<T> r, BTreeNode<T> parent){
        this.data = data;
        this.l = l;
        this.r = r;
        this.parent = parent;
    }
}

class Iter<T> implements Iterator<T> {
    BTreeNode<T> cur = null;
    BTreeNode<T> root = null;
    public Iter(BTreeNode<T> root) {
        cur=root;

        while(cur.l!=null){
            cur=cur.l;
        }

        this.root = root;
    }

    public boolean hasNext() {
        return cur != null;
    }

    public T next() {
        T ret = cur.data;
        if(cur.r!=null){
            BTreeNode<T> tempNode = cur.r;
            while(tempNode.l!=null){
                tempNode=tempNode.l;
            }
            cur=tempNode;
        } else {

            while(cur.parent != null && cur.parent.l!=cur){
                cur=cur.parent;
            }
            cur = cur.parent;
        }

        return ret;

/*
    x
    /
    y
    /
    z
    \
    cur
*/


    }

    public void remove() {
        throw new RuntimeException("not impl");
    }
}

class BST<T extends Comparable<T>> implements Iterable<T> {
    BTreeNode<T> root = null;

    //BST<T>(){};

    void add(T data){
        if(root==null){
            root = new BTreeNode<T>(data,null,null,null);
            return;
        }

        BTreeNode<T> prev = root;
        BTreeNode<T> cur = root;

        while(cur!=null){
            prev=cur;
            if(cur.data.compareTo(data)>0){
                cur=cur.l;
            }else{
                cur=cur.r;
            }
        }

        if(prev.data.compareTo(data)>0){
            prev.l=new BTreeNode<T>(data,null,null,prev);
        }else prev.r = new BTreeNode<T>(data,null, null,prev);

        return;

    }

    public Iterator<T> iterator() {
        return new Iter<T>(root);
    }

    public void print() {
        print(root);
    }

    private void print(BTreeNode<T> node) {
        if (node == null) return;
        print(node.l);
        System.out.println(node.data);
        print(node.r);
    }
}