import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Graph
{
    class Edge
    {
        int src;
        int des;
        Edge(int src,int des)
        {
            this.src=src;
            this.des=des;
        }
    }
    public int vertices;

    public ArrayList<Edge>graph[];

    Graph(int vertices)
    {
        this.vertices=vertices;
        graph=new ArrayList[vertices];

        for(int i=0;i< graph.length;i++)
        {
            graph[i]= new ArrayList<Edge>();
        }
    }
    public void edge(int src,int des)
    {
        graph[src].add(new Edge(src,des));
    }

    public void BFS(int n)
    {
        boolean visited[]=new boolean[vertices];
        System.out.println("Breadth-First Search ->");
        System.out.println();
        System.out.print("Traversal:");
//        for (int i=n;i<vertices;i++)
//        {
//            if (visited[i]==false)
//                bfs(i,visited);
//        }
        bfs(n,visited);
    }
    public void bfs(int current,boolean visited[])
    {
        Queue<Integer>queue=new LinkedList<>();
        queue.add(current);
        while(!(queue.isEmpty()))
        {
            int curr=queue.remove();
            if(visited[curr]==false)
            {
                System.out.print(curr+" ");
                visited[curr]=true;
                for (int j=0;j<graph[curr].size();j++)
                {
                    Edge a=graph[curr].get(j);
                    queue.add(a.des);
                }
            }
        }
    }
    public void DFS(int n)
    {
        boolean vis[]=new boolean[vertices];
        System.out.println();
        System.out.println("Depth-First Search ->");
        System.out.println();
        System.out.print("Traversal:");
//        for(int i=n;i<vertices;i++)
//        {
//            if(vis[i]==false)
//                dfs(i,vis);
//        }
        dfs(n,vis);
    }

    public void dfs(int curr,boolean vis[])
    {
        System.out.print(curr+" ");
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++)
        {
            Edge a=graph[curr].get(i);
            if(vis[a.des]==false)
            {
                dfs(a.des,vis);
            }
        }
//        System.out.println();
//        vis[curr]=true;
//        for(int i=0;i<graph[curr].size();i++)
//        {
//            Edge a=graph[curr].get(i);
//            if(vis[a.des]==false)
//            {
//                System.out.print("("+a.src+"->"+a.des+")"+" ");
//                dfs(a.des,vis);
//            }
//        }
    }
}
