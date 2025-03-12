import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class LRUCache {
    private static final String INPUT_FILE_NAME="lru_input.txt";
    private int capacity=0;

    //MyLst keys=new MyLst();
    MyList keys=new MyList();


    //MyLst values=new MyLst();//
    MyList values=new MyList();


    LRUCache(int capacity)
    {
        this.capacity=capacity;
       // keys=new MyLst(capacity);
       // values=new MyLst(capacity);
    }
    public int get(int key)
    {
        if(keys.find(key)!=-1)
        {
            int index=keys.find(key);
            //System.out.println(index);
            keys.setToPos(index);
            values.setToPos(index);
            int value = values.getValue();
            //System.out.println(value);
            keys.erase();
            values.erase();
            keys.pushBack(key);
            values.pushBack(value);
            return value;
        }
        return -1;
    }
    public void put(int key,int value)
    {
        if(keys.find(key)!=-1)
        {
            int index = keys.find(key);

            keys.setToPos(index);
            values.setToPos(index);
            keys.erase();
            values.erase();
        }
        else if(capacity==keys.size())
        {
            keys.setToPos(0);
            values.setToPos(0);
            keys.erase();
            values.erase();
        }
        keys.pushBack(key);
        values.pushBack(value);

    }

    public static void main(String[] args)throws Exception {

        BufferedReader br=new BufferedReader(new FileReader(INPUT_FILE_NAME));
        BufferedWriter bw=new BufferedWriter(new FileWriter("lru_output.txt"));
        String str= br.readLine();
        String []token=str.split(" ");
        String capaCity=token[0];
        int initialCapacity= Integer.parseInt(capaCity);
        str= br.readLine();
        token=str.split(" ");
        String operationNum=token[0];
        int opNumber= Integer.parseInt(operationNum);
        LRUCache lrucache=new LRUCache(initialCapacity);
        while (opNumber!=0)
        {
            str= br.readLine();
            token=str.split(" ");
            int parameter= Integer.parseInt(token[0]);
            if(parameter==2)
            {
                lrucache.put(Integer.parseInt(token[1]),Integer.parseInt(token[2]));
            }
            if(parameter==1)
            {
                int val=lrucache.get(Integer.parseInt(token[1]));
                bw.write(String.valueOf(val));
                bw.write(System.lineSeparator());
            }

            opNumber--;

        }

        br.close();
        bw.close();
    }

}
