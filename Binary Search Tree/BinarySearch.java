public class BinarySearch {

    Node root;

    int flag=0;
    BinarySearch() {
        root = null;
    }

    public class Node {
        Node leftsubtree;
        Node rightsubtree;
        int value;

        Node(int value)
        {
            this.value = value;
        }
    }

    public Node insert(int val)
    {
        root = insertat(root, val);
        return root;
    }

    public Node insertat(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.value > val) {
            root.leftsubtree = insertat(root.leftsubtree, val);
        } else if (root.value < val) {
            root.rightsubtree = insertat(root.rightsubtree, val);
        }
        return root;
    }
    public void delete(int val)
    {
        root=dlt(root,val);
        if(flag==1)
            System.out.println(currentstate());
        else System.out.println("Invalid Operation");
        flag=0;
    }
    public Node dlt(Node root, int val)
    {

        if(root==null)return null;
        if(root.value>val)
            root.leftsubtree=dlt(root.leftsubtree,val);
        else if (root.value<val)
        {
            root.rightsubtree=dlt(root.rightsubtree,val);
        }
        else {
            if(root.leftsubtree==null&&root.rightsubtree==null) {
                flag=1;
                return null;

            }
        }


        return root;
    }

    public void find(int value)
    {
        Node x=search(root,value);
        if(x==null) System.out.println("False");
            //return false;
        else System.out.println("True");
            //return true;
    }
    public Node search(Node root,int val)
    {
        if(root==null)
            return null;
        if(root.value==val)
            return root;
        if(root.value>val)
            return search(root.leftsubtree,val);
        return search(root.rightsubtree,val);
    }

    public String inorder() {
        return in_order(root);
    }

    public String in_order(Node root) {

        if(root==null)
            return "";
        String left= in_order(root.leftsubtree);
        String right=in_order(root.rightsubtree);
        return left+root.value+" "+right;

    }

    public String preorder()
    {
        return pre_order(root);
    }
    public String pre_order(Node root)
    {
        if(root==null)
            return "";
        String left= pre_order(root.leftsubtree);
        String right=pre_order(root.rightsubtree);
        return root.value+" "+left+right;
    }

    public String currentstate()
    {
        return currentState(root);
    }
    public String currentState(Node root)
    {
        if (root == null)
            return "";

        String left=currentState(root.leftsubtree);
        String right=currentState(root.rightsubtree);
        if(!(root.leftsubtree==null&&root.rightsubtree==null))
            left="("+left+")";
        if(root.leftsubtree!=null&&root.rightsubtree==null)
            right="("+")";

        if(root.rightsubtree!=null)
            right="("+right+")";

        return root.value+left+right;
    }


    public String postorder()
    {
        return post_order(root);
    }
  public String post_order(Node root)
    {
        if(root==null)
            return "";
        String left= post_order(root.leftsubtree);
        String right=post_order(root.rightsubtree);
        return left+right+root.value+" ";
    }



//    public static void main(String[] args) {
//        BinarySearch bs=new BinarySearch();
//
//        try
//        {
//            BufferedReader br=new BufferedReader(new FileReader("input.txt"));
//            FileOutputStream fs = new FileOutputStream("output.txt");
//            System.setOut(new PrintStream(fs));
//
//
//            BinarySearch bst=new BinarySearch();
//            String str= null;
//            String []token;
//            String function="";
//            String data="";
//
//            while((str= br.readLine())!=null)
//            {
//
//                token=str.split(" ");
//
//                function=token[0];
//                data=token[1];
//                switch (function)
//                {
//                    case "I":
//                        bst.insert(Integer.valueOf(data));
//                        System.out.println(bst.currentstate());
//                        break;
//                    case "F":
//                        bst.find(Integer.valueOf(data));
//                        break;
//                    case "T": {
//                        if (data.equalsIgnoreCase("In")) {
//
//                            System.out.println(bst.inorder());
//                        } else if (data.equalsIgnoreCase("Pre")) {
//
//                            System.out.println(bst.preorder());
//                        } else if (data.equalsIgnoreCase("Post")) {
//
//                            System.out.println(bst.postorder());
//                        }
//                        break;
//                    }
//                    case "D":
//                        bst.delete(Integer.valueOf(data));
//                        break;
//                }
//
//            }
//            br.close();
//
//            fs.close();
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//    }

}
