public class MyLst {
    private int maxsize;
    private int listsize;
    private int current;
    private int sIze;
    private int [] arraylist;
    MyLst(int size)
    {
        maxsize=size;//listsize=current=0;
        arraylist=new int[size];
    }
    MyLst()
    {
        maxsize=sIze=listsize=current=0;
    }
    public void clear()
    {
        listsize=current=0;
    }
    public void push(int value)
    {
        if(listsize>=maxsize){
            maxsize=listsize;
            int[] newarraylist=new int[maxsize*2];
            for(int i=0;i<listsize;i++)
            {
                newarraylist[i]=arraylist[i];
            }
            arraylist= newarraylist;

        }

        for(int i=listsize;i>current;i--)
            arraylist[i]=arraylist[i-1];
        arraylist[current]=value;
        listsize++;

    }
    public void pushBack(int value)
    {
        if(listsize>=maxsize)
        {
            maxsize=listsize;
            int[] newarraylist=new int[maxsize*2];
            for(int i=0;i<listsize;i++)
            {
                newarraylist[i]=arraylist[i];
            }
            arraylist= newarraylist;
            //maxsize=listsize;

        }

        arraylist[listsize++]= value;
    }
    public int erase()
    {
        if(current<0||current>=listsize)return -1;
        // System.out.println("No Current Element");
        int obj=arraylist[current];
        for(int i=current;i<listsize-1;i++)
        {
            arraylist[i]=arraylist[i+1];
        }
        if(current==listsize-1)prev();
        listsize--;
        return obj;
    }
    public void setToBegin()
    {
        current=0;
    }
    public void setToEnd()
    {
        current=listsize-1;
    }
    public void prev()
    {
        if(current!=0)
            current--;
    }
    public void next()
    {
        int y=current;
        if(current<listsize)
            current++;
        if(current==listsize)
            current=y;
    }
    public int size()
    {
        return listsize;
    }
    public int currPos()
    {
        return current;
    }
    public void setToPos(int pos)
    {
        if(pos<0||pos>listsize){
            //System.out.println("Invalid Position");
            return;}
        current=pos;
    }
    public int getValue()
    {
        if(current<0||current>listsize)return -1;
        // System.out.println("No Current Element");
        return arraylist[current];
    }

    public int find(int item)
    {

        for(int i=0;i<listsize;i++)
        {

            if(arraylist[i]==item)
            {

                return i;
            }
        }
        return -1;

    }

    public String display()
    {
        String s="<";
        for(int i=0;i<listsize;i++){
            if(current==i)
                s+=("|"+" ");
            s+=(arraylist[i]+" ");}
        s+=">";
        return s;
    }
    public String sHowList()
    {
        String s="";
        for (int i=1;i<=listsize;i++)
        {
            s+=(i+" "+arraylist[i-1]);
            s+=(System.lineSeparator());
        }
        return s;
    }




}
