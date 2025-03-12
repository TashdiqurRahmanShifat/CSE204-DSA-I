public class ArrayBasedQueue {
    MyLst listarray=new MyLst();
    ArrayBasedQueue(int size)
    {
        listarray=new MyLst(size);
    }
    public void clear()
    {
        listarray.clear();
    }
    public void enqueue(int item)
    {
        listarray.pushBack(item);
    }
    public Object dequeue()
    {
        if(listarray.size()==0)
        {
            //System.out.println("Faka");
            return null;
        }
        listarray.setToBegin();
        return listarray.erase();
    }
    public int length()
    {
        return listarray.size();
    }
    public Object frontValue()
    {
        if(listarray.size()==0)
        {
           // System.out.println("Faka");
            return null;
        }
        listarray.setToBegin();
        return listarray.getValue();
    }
    public Object rearValue()
    {
        if(listarray.size()==0)
        {
            //System.out.println("Faka");
            return null;
        }
        listarray.setToEnd();
        return listarray.getValue();
    }
    public Object leaveQueue()
    {
        if(listarray.size()==0)
        {
           // System.out.println("Faka");
            return null;
        }
        listarray.setToEnd();
        return listarray.erase();
    }
    public String show()
    {
        return listarray.display();
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
