package Graphs; /**
 * Created with IntelliJ IDEA.
 * User: Karthik Sriram
 * Date: 11/17/13
 * Time: 12:46 AM
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;
import java.lang.*;

/* Name of the class has to be "Main" only if the class is public. */
public class BFS
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int n,i,j,e,k;
        Scanner input = new Scanner(System.in);
        n=input.nextInt();
        Node[] Graph = new Node[n+1];
        for(i=0;i<n;i++){
            j=input.nextInt();
            e=input.nextInt();
            Graph[j]=new Node(j);
            for(k=0;k<e;k++){
                Graph[j].addChild(new Node(input.nextInt()));
            }
        }

       /* for(i=1;i<=n;i++){
            for (Graphs.Node t : Graph[i].children) {
                 System.out.print(t.data+" ");
            }
            System.out.println();
        }
       */
        BFS1(Graph);

    }

    public static void BFS1(Node[] Graph){
        Queue<Node> q = new LinkedList<Node>();
        q.add(Graph[1]); // starting Graphs.BFS from node 1
        int[] visited = new int[Graph.length];
        for(int i=0;i<Graph.length;i++){
                visited[i]=0;
        }

        while(!q.isEmpty()){
            Node current = q.poll();
            System.out.println(current.data);
            for(Node child: current.children){
                if(visited[child.data]!=1 && child.data!=current.data )
                q.offer(Graph[child.data]);
            }
            visited[current.data]=1;
        }
    }

}

class Node{
    LinkedList<Node> children= new LinkedList<Node>();
    int data;
    Node(int data){
        this.data=data;
    }

    public void addChild(Node child){
        this.children.add(child);
    }

}