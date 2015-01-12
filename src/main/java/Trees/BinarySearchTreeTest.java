package Trees;

/**
 * Created with IntelliJ IDEA.
 * User: Karthik Sriram
 * Date: 12/1/13
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
import Trees.BinarySearchTree;
public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> btree = new BinarySearchTree<Integer>();

        int i;
        int a[] = { 4,3,2,6,1,7,5,10,8,9};

        for(i=0;i<10;i++){
            btree.insertNode(a[i]);
        }

        btree.inorderTraverse();


    }
}
