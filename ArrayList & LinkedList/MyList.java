class MyList {

    Node head;
    Node current;

    private int sIze;
    MyList()
    {
        sIze=0;
        head=current=null;
    }
    MyList(int sIze){this();}
    public class Node {
        int item;
        Node next;
        Node(int item)
        {
            this.item=item;
            this.next=null;
            sIze++;
        }
    }
    public void push(int item)
    {
        Node newNode=new Node(item);

        if(head==null)
        {
            head=newNode;
            current=head;
        }
        else if(current==head){
            current=newNode;
            current.next=head;
            head=current;
        }

        else{
        Node y=current;
        Node x=head;
        while(x.next!=y)
        {
            x=x.next;
        }
        x.next=newNode;
        newNode.next=current;
        current=newNode;}
    }
   public void pushBack(int item)
    {
        Node newNode=new Node(item);
        Node x=current;
        current=this.head;
        if(head==null)
        {
            head=newNode;
            current=head;

        }

        else{
            while(current.next!=null)
            {
                current=current.next;
            }
            current.next=newNode;

            newNode.next=null;
            current=x;


        }



    }
   public int find(int item)
    {
        Node newNode=head;int i;
        for(i=0;newNode!=null;i++) {
            if(newNode.item==item){
                return i;}
            newNode = newNode.next;

        }
        return -1;
    }
    public void setToPos(int pos)
    {

        if(pos>sIze||pos<0){
            //System.out.println("Invalid position");

        }
        int i;
        if(head!=null){

            current=this.head;
            for( i=0;i<pos;i++) {
                current=current.next;
            }
        }
    }
    public int erase()
    {
        if(current.next==null)
        {
            int data=current.item;
            prev();
            sIze--;
            return data;
        }
        int value=current.item;

        current.item=current.next.item;
        current.next=current.next.next;
        sIze--;
        return value;
    }
    public int getValue()
    {

        if(head==null)
            return -1;
//        if(current.next==null)
//            return -1;

        return current.item;
    }
   public void clear()
    {
        head=null;
        sIze=0;
    }
    public void setToBegin()
    {
        if(head!=null)
            current=head;
        //else current=null;
    }
    public void setToEnd()
    {
        if(head==null)
            current=null;
        while(current.next!=null)
            current=current.next;
    }
    public int size(){
        return sIze;
    }
    public void prev()
    {
        if(current==head)
            return;
        Node newNode=head;
        while (newNode.next!=current)
            // current=current.next;
            newNode=newNode.next;
        current=newNode;
    }
    public void next()
    {
         while (current.next!=null)
        current=current.next;
    }
    public int currPos()
    {
        Node newNode=head;int i;
        for(i=0;newNode!=current;i++)
        {
            newNode=newNode.next;
        }
        return i;

    }
    public String display()
    {
        Node currentItem=head;
        String s=("< ");
        while(currentItem!=null)
        {
            if(currentItem==current)
                s+=("|"+" ");
            s+=(currentItem.item+" ");
            currentItem=currentItem.next;
        }
        s+=(">");
        return s;

    }

}



