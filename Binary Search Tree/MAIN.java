import java.io.*;

public class MAIN {

        public static void main(String[] args) {
            BinarySearch bs=new BinarySearch();

            try
            {
                BufferedReader br=new BufferedReader(new FileReader("input.txt"));
                FileOutputStream fs = new FileOutputStream("output.txt");
                System.setOut(new PrintStream(fs));


                BinarySearch bst=new BinarySearch();
                String str= null;
                String []token;
                String function="";
                String data="";

                while((str= br.readLine())!=null)
                {

                    token=str.split(" ");

                    function=token[0];
                    data=token[1];
                    switch (function)
                    {
                        case "I":
                            bst.insert(Integer.valueOf(data));
                            System.out.println(bst.currentstate());
                            break;
                        case "F":
                            bst.find(Integer.valueOf(data));
                            break;
                        case "T": {
                            if (data.equalsIgnoreCase("In")) {

                                System.out.println(bst.inorder());
                            } else if (data.equalsIgnoreCase("Pre")) {

                                System.out.println(bst.preorder());
                            } else if (data.equalsIgnoreCase("Post")) {

                                System.out.println(bst.postorder());
                            }
                            break;
                        }
                        case "D":
                            bst.delete(Integer.valueOf(data));
                            break;
                    }

                }
                br.close();

                fs.close();

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }

        }

}
