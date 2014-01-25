package Trees;

import java.util.LinkedList;
import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * User: Karthik Sriram
 * Date: 12/20/13
 * Time: 8:03 PM
 * To change this template use File | Settings | File Templates.
 */



// To execute Java, please define "static void main" on a class named Solution

/*
*  Tree of strings
*
*             ab
*          c  h  d
*        ef       g
*  abf(c(ef())h()d(g()))


*  String flatten(Tree);
*  Tree unflatten(String);
*  unflatten(flatten(tree)).equals(tree);
*/

class flatten {
    public static void main(String[] args) {

        TreeNode ab = new TreeNode("ab");
        TreeNode c = new TreeNode("c");
        TreeNode d = new TreeNode("d");
        ab.children.add(c);
        ab.children.add(new TreeNode("h"));
        ab.children.add(d);
        c.children.add(new TreeNode("ef"));
        d.children.add(new TreeNode("g"));

        System.out.println(flattenTree(ab));
        System.out.println(flattenTree(unflatten(flattenTree(ab))));
    }

    static class TreeNode{
        LinkedList<TreeNode> children = new LinkedList<TreeNode>();
        String data;
        public TreeNode(String data){
            this.data = data;
        }
    }

    static TreeNode unflatten(String val){
        Stack<TreeNode> stack = new Stack<TreeNode>();
        char[] charArray = val.toCharArray();
        String curNodeVal="";
        TreeNode parent = null,root=null;
        for(int i=0;i<charArray.length;i++){
           if(charArray[i]=='('){
               TreeNode curNode = new TreeNode(curNodeVal);
               if(parent==null)root=curNode;
               if(parent!=null)
                parent.children.add(curNode);
               stack.push(curNode);
               curNodeVal="";
           } else if(charArray[i]==')'){
                if(!stack.isEmpty())
                    parent = stack.pop();
                curNodeVal = "";
            }else curNodeVal +=Character.toString(charArray[i]);
        }
        return root;
        // root -> find first (
        // encounter ( and push to stack

    }

    static String flattenTree(TreeNode treeNode){
        String val="";
        if(treeNode==null){
            val = "(";
        }
        else {
            val = treeNode.data + "(";
            for(TreeNode child: treeNode.children){
                val+=flattenTree(child);
            }
        }
        val += ")";
        return val;

    }
}


// toString(List<List<String>>) [ child ]
//List<List<String>>.toString()


//2ab1c2ef
//ab#c#ef