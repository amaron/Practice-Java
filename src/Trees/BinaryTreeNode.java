package Trees;

/**
 * Created with IntelliJ IDEA.
 * User: Karthik Sriram
 * Date: 12/1/13
 * Time: 11:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinaryTreeNode<T extends Comparable<T>> {

    public BinaryTreeNode<T> left=null;
    public BinaryTreeNode<T> right=null;
    public T data;

    BinaryTreeNode(T data){
        this.data=data;
    }

}
