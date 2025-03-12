public class Minheap
{
    private int [] Heap;
    private int size;
    private int index;
    private int count=0;
    public Minheap(int size)
    {
        this.size=size;
        this.index=0;
        Heap=new int[size];
    }
    private int parent(int pos)
    {
        return (pos-1)/2;
    }
    private int leftchild(int pos)
    {
        return (2*pos)+1;
    }
    private int rightchild(int pos)
    {
        return (2*pos)+2;
    }
    public void insert(int element)
    {

        if(index>=size)
        {

            int[] arrayHeap=new int[2*size];
            for(int i=0;i<index;i++)
            {
                arrayHeap[i]=Heap[i];
            }
            Heap=arrayHeap;
            size=size*2;
        }
        //System.out.println(size+"op");

        Heap[index]=element;
        int current=index;
        while(Heap[current]<Heap[parent(current)])
        {
            swap(current,parent(current));
            current=parent(current);
        }
        count++;
        index++;
    }
    private void swap(int pos1,int pos2)
    {
        int temp=Heap[pos1];
        Heap[pos1]=Heap[pos2];
        Heap[pos2]=temp;
    }
    public int Extractmin()
    {
        int min=Heap[0];
        Heap[0]=Heap[--index];
        minheapify(0);
        //size--;
        return min;
    }
    public boolean isleaf(int pos)
    {
        if(rightchild(pos)>index||leftchild(pos)>index)
            return true;
        return false;
    }
    public void minheapify(int pos)
    {
        if(!isleaf(pos))
        {
            if(Heap[pos]>Heap[leftchild(pos)]||Heap[pos]>Heap[rightchild(pos)])
            {
//                if(Heap[leftchild(pos)]<=index&&Heap[rightchild(pos)]>index)
//                {
//                    swap(pos,leftchild(pos));
//                }
                if(Heap[leftchild(pos)]<Heap[rightchild(pos)])
                {
                    swap(pos,leftchild(pos));
                    minheapify(leftchild(pos));
                }

                else
                {
                    swap(pos,rightchild(pos));
                    minheapify(rightchild(pos));
                }
            }

        }
    }
    public int Findmin()
    {
        int min=Heap[0];
        return min;
    }
    public int find(int val)
    {
        for(int i=0;i< Heap.length;i++)
        {
            if(Heap[i]==val)
                return i;
        }
        return -1;
    }
    public void DecreaseKey(int prevKey,int newKey)
    {
        int getval=find(prevKey);
        if(getval==-1)
            return;
        Heap[getval]=newKey;
        int getvalParent=parent(getval);
        while(Heap[getval]<Heap[parent(getval)])
        {
            swap(getval,parent(getval));
            getval=getvalParent;
            getvalParent=parent(getvalParent);
        }
    }


    public void print()
    {
        int N=(int)(Math.log(index)/Math.log(2));
        for (int i=0;i<=N;i++)
        {
            int flag=0;
            for(int j=0;(j<Math.pow(2,i)&&(j+Math.pow(2,i))<=index);j++)
            {
                if(flag==0)
                {
                System.out.print("Level "+i+":");
                flag=1;
                }
                System.out.print(Heap[j+(int)Math.pow(2,i)-1]+" ");
            }
            System.out.println();
        }

    }

}


