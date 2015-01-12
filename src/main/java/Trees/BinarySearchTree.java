package Trees;

/**
 * Created with IntelliJ IDEA.
 * User: Karthik Sriram
 * Date: 12/1/13
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */

 public class BinarySearchTree<T extends Comparable<T>>{
     public BinaryTreeNode<T> root=null;
     public int numNodes;
     void insertNode(T data){

         BinaryTreeNode<T> newData = new BinaryTreeNode<T>(data);
         if(root==null){
             this.root=newData;
             numNodes++;
             return;
         }

         BinaryTreeNode<T> temp=root;
         BinaryTreeNode<T> prev=root;

         while(temp!=null){
             prev=temp;
             if(temp.data.compareTo(data)>0){
                  temp=temp.left;
             }else temp=temp.right;
         }

         if(prev.data.compareTo(data)>0){
             prev.left=newData;
         }else{
             prev.right=newData;
         }

         numNodes++;

     }

     private void inorder(BinaryTreeNode<T> t){
         if(t==null)return;
         inorder(t.left);
         System.out.println(t.data.toString());
         inorder(t.right);
     }

     void inorderTraverse(){
         inorder(root);
     }
 }
