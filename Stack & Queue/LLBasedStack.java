public class LLBasedStack {
    MyList ml=new MyList();
    public void clear()
    {
        ml.clear();
    }
    public void push(int item)
    {
        ml.pushBack(item);
    }
    public Object pop()
    {
        if(ml.size()==0)
        {
            //System.out.println("Empty");
            return null;
        }

        ml.setToEnd();
        return ml.erase();

    }
    public int length()
    {
        return ml.size();
    }
    public Object topValue()
    {
        if(ml.size()==0)
            return null;
        ml.setToEnd();
        return ml.getValue();
    }
    public String show()
    {
        return ml.display();
    }

//    public static void main(String[] args) {
//        LLBasedStack llBasedStack=new LLBasedStack();
//        llBasedStack.push(20);
//        System.out.println(llBasedStack.show());
//        llBasedStack.push(23);
//        System.out.println(llBasedStack.show());
//        llBasedStack.push(12);
//        System.out.println(llBasedStack.show());
//        llBasedStack.push(15);
//        System.out.println(llBasedStack.topValue());
//        System.out.println(llBasedStack.show());
//        llBasedStack.push(-1);
//        System.out.println(llBasedStack.topValue());
//        System.out.println(llBasedStack.show());
//        System.out.println(llBasedStack.length());
//       //llBasedStack.clear();
//        //System.out.println(llBasedStack.show());
//        llBasedStack.pop();
//        System.out.println(llBasedStack.show());
//        System.out.println(llBasedStack.length());
//        llBasedStack.pop();
//        System.out.println(llBasedStack.show());
//        System.out.println(llBasedStack.length());
//        llBasedStack.pop();
//        System.out.println(llBasedStack.show());
//        System.out.println(llBasedStack.length());
//        llBasedStack.pop();
//        System.out.println(llBasedStack.show());
//        System.out.println(llBasedStack.length());
//        llBasedStack.pop();
//        System.out.println(llBasedStack.show());
//        System.out.println(llBasedStack.length());
//        llBasedStack.pop();
//        System.out.println(llBasedStack.show());
//        System.out.println(llBasedStack.length());
//    }
public static void main(String[] args) {
    LLBasedStack s=new LLBasedStack();
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
