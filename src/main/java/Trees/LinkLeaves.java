package Trees;

/**
 * Created with IntelliJ IDEA.
 * User: Karthik Sriram
 * Date: 12/26/13
 * Time: 11:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class LinkLeaves {
    public static void main(String[] args) {
        BinaryTreeNode<String> root = new BinaryTreeNode<String>("a");
        BinaryTreeNode<String> b = new BinaryTreeNode<String>("b");
        BinaryTreeNode<String> c = new BinaryTreeNode<String>("c");
        BinaryTreeNode<String> d = new BinaryTreeNode<String>("d");

        root.right = c;
        root.left= b;
        c.left=d;
        d.left=new BinaryTreeNode<String>("e");
        d.right = new BinaryTreeNode<String>("f");

        BinaryTreeNode<String> head = connectLeaves(root);
    }

    static BinaryTreeNode<String> connectLeaves(BinaryTreeNode<String> root){
                 return null;
    }
}
