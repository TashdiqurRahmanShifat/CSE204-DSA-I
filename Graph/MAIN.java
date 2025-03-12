import java.io.*;

public class MAIN {

    public static void main(String[] args) {

        try
        {
            BufferedReader br=new BufferedReader(new FileReader("input.txt"));
            FileOutputStream fs=new FileOutputStream("output.txt");
            System.setOut(new PrintStream(fs));

            String str= br.readLine();
            String[] token=str.split(" ");

            String vertices=token[0];
            String edges=token[1];
            int readline=Integer.parseInt(edges);
            Graph graph=new Graph(Integer.parseInt(vertices)+1);
            while (readline!=0)
            {
                str= br.readLine();
                token=str.split(" ");
                String src=token[0];
                String des=token[1];
                graph.edge(Integer.parseInt(src),Integer.parseInt(des));
                readline--;

            }
            str=br.readLine();
            token=str.split(" ");
            String starting_point=token[0];
            graph.BFS(Integer.parseInt(starting_point));
            graph.DFS(Integer.parseInt(starting_point));

            br.close();
            fs.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
