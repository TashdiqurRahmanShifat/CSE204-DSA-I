public class ArrayBasedStack {

    //private int maxsize;
//    private int top;
//    private int size;
    MyLst m=new MyLst();
//    Stack()
//    {
//        this.size=0;
//    }
    ArrayBasedStack(int size)
    {
        //maxsize=size;
       // top= -1;
        m=new MyLst(size);
    }


    public void clear()
    {
        m.clear();
    }
    public void push(int item)
    {

        m.pushBack(item);
        m.setToEnd();
    }
    public Object pop()
    {
        if(m.size()==0)
        {
           // System.out.println("Empty");
            return null;
        }
        m.setToEnd();
          return m.erase();
    }
    public int  length()
    {
       return m.size();
    }
    public Object topValue()
    {
        if(m.size()==0)
            return null;
        m.setToEnd();
       return m.getValue();
    }
    public String show()
    {
       return m.display();
    }
    public static void main(String[] args) {
        ArrayBasedStack s=new ArrayBasedStack(1);
        s.push(20);
        s.push(23);
        s.push(12);
        s.push(15);
        System.out.println(s.topValue());
        System.out.println(s.length());
        // System.out.println( s.show());
        System.out.println( s.show());
        s.clear();
        System.out.println(s.length());
        System.out.println( s.show());
        s.push(-1);
        System.out.println(s.topValue());
        System.out.println(s.length());
        // System.out.println( s.show());
        System.out.println( s.show());
        s.pop();
        System.out.println( s.show());
        s.pop();
        System.out.println( s.show());
        s.pop();
        System.out.println( s.show());
        s.pop();
        System.out.println( s.show());
        s.pop();
        System.out.println( s.show());
        s.pop();
        System.out.println( s.show());
        System.out.println(s.topValue());
        System.out.println(s.length());
        System.out.println( s.show());


    }

}
