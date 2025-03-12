import java.io.*;

public class BinaryHeapMain {
    public static void main(String[] args) {
        Minheap mh=new Minheap(1);
        try
        {
            BufferedReader br=new BufferedReader(new FileReader("input.txt"));
            FileOutputStream fs=new FileOutputStream("output.txt");
            System.setOut(new PrintStream(fs));

            String str= null;
            String[]token;
            String function="";
            String data="";
            while((str= br.readLine())!=null)
            {
                token=str.split(" ");
                function=token[0];
                //data=token[1];
                switch (function)
                {
                    case "INS":
                        mh.insert(Integer.valueOf(token[1]));
                        System.out.println("INSERTED"+" "+token[1]);
                        break;
                    case "PRI":
                        System.out.println("Printing the binary heap ...");
                        System.out.println("- - - - - - - - - - - - - - - - - - - -");
                        mh.print();
                        System.out.println("- - - - - - - - - - - - - - - - - - - -");
                        break;
                    case "DEC":
                        System.out.println(token[1]+" decreased to "+token[2]);
                        mh.DecreaseKey(Integer.valueOf(token[1]),Integer.valueOf(token[2]));
                        break;
                    case "FIN":
                        System.out.println("FindMin returned "+mh.Findmin());
                        break;
                    case "EXT":
                        System.out.println("ExtractMin returned "+mh.Extractmin());
                        break;

                }

            }
            br.close();
            fs.close();

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
