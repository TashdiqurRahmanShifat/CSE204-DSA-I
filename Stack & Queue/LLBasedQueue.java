public class LLBasedQueue {
    MyList myList=new MyList();
    public void clear()
    {
        myList.clear();
    }
    public void enqueue(int item)
    {
        myList.pushBack(item);
    }
    public Object dequeue()
    {
        if(myList.size()==0)
        {
           // System.out.println("Faka");
            return null;
        }
        myList.setToBegin();
        return myList.erase();
    }
    public int length()
    {
        return myList.size();
    }
    public Object frontValue()
    {
        if(myList.size()==0)
        {
            //System.out.println("Faka");
            return null;
        }
        myList.setToBegin();
        return myList.getValue();
    }
    public Object rearValue()
    {
        if(myList.size()==0)
        {
            //System.out.println("Faka");
            return null;
        }
        myList.setToEnd();
        return myList.getValue();
    }
    public Object leaveQueue()
    {
        if(myList.size()==0)
        {
            //System.out.println("Faka");
            return null;
        }
        myList.setToEnd();
        return myList.erase();
    }
    public String show()
    {
        return myList.display();
    }

    public static void main(String[] args) {
        ArrayBasedQueue arrayBasedQueue=new ArrayBasedQueue(2);
        arrayBasedQueue.enqueue(20);
        arrayBasedQueue.enqueue(23);
        arrayBasedQueue.enqueue(12);
        arrayBasedQueue.enqueue(15);
        arrayBasedQueue.enqueue(67);
        System.out.println(arrayBasedQueue.show());
        arrayBasedQueue.enqueue(19);
        System.out.println(arrayBasedQueue.show());
        System.out.println(arrayBasedQueue.length());
        // arrayBasedQueue.clear();
        System.out.println(arrayBasedQueue.show());
        System.out.println(arrayBasedQueue.length());
        arrayBasedQueue.dequeue();
        System.out.println(arrayBasedQueue.show());
        System.out.println(arrayBasedQueue.length());
        System.out.println(arrayBasedQueue.frontValue());
        System.out.println(arrayBasedQueue.rearValue());
        System.out.println(arrayBasedQueue.leaveQueue());
        System.out.println(arrayBasedQueue.show());
        arrayBasedQueue.dequeue();
        System.out.println(arrayBasedQueue.show());




    }
}
