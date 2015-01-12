package Graphs;
import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Test
{
    public static void main (String[] args) throws java.lang.Exception
    {
        // your code goes here
        Graph G = new Graph(5,false);
        G.add(1,2);G.add(2,3);
        G.add(1,4);G.add(2,5);

        G.DFS();
        G.BFS();
    }
}

public class Graph{
    HashMap<Integer,LinkedList<Integer>> graph = new HashMap<Integer,LinkedList<Integer>>();
    int size;
    boolean isDirected;
    Boolean[] visited;
    Boolean[] visiting;

    public Graph(int n, boolean isDirected){
        this.size = n;
        this.isDirected = isDirected;
        visited = new Boolean[n];
        visiting = new Boolean[n];
        for(int i=0;i<n;i++){
            graph.put(i+1,new LinkedList<Integer>());
        }
    }

    void add(int u, int v){
        graph.get(u).add(v);
        if(!isDirected){
            graph.get(v).add(u);
        }
    }

    void DFS(){

        Arrays.fill(visited,Boolean.FALSE);

        Arrays.fill(visiting,Boolean.FALSE);
        for(int i=0;i<size;i++)
        {
            if(!visited[i])
                DFS(i+1,-1);
        }
    }

    void DFS(int u, int parent){

        System.out.println(u);
        visiting[u-1] = true;
        for(int v: graph.get(u)){
            if(visiting[v-1] && v==parent) continue;
            if(!visited[v-1])
                DFS(v,u);
        }

        visited[u-1]=true;


    }

    void BFS(){

        Arrays.fill(visited,Boolean.FALSE);
        Arrays.fill(visiting,Boolean.FALSE);
        for(int i=0;i<size;i++)
        {
            if(!visited[i])
                BFS(i+1);
        }
    }

    void BFS(int u){
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(u);
        int prevVisiting = -1;
        while(!q.isEmpty())
        {
            int v = q.peek();
            q.remove();
            System.out.println(v);
            visiting[v-1]=true;
            for(int i:graph.get(v)){
                if(visiting[i-1] && prevVisiting==i) continue;
                if(!visited[i-1]){
                    q.add(i);
                }
            }
            prevVisiting = v;
            visited[v-1]=true;
        }
    }
}