import java.io.*;
import java.util.Scanner;

public class FIFAMAIN {
    MyLst myLst=new MyLst(8);

    public void put(int data)
    {
        myLst.pushBack(data);
    }

    public String showlist()
    {
        return myLst.sHowList();

    }

    public static void main(String[] args)  {

        try
        {
        BufferedReader br = new BufferedReader(new FileReader("TaskInputFile.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("TaskOutputFile.txt"));


        LLBasedStack stack=new LLBasedStack();
        //LLBasedQueue queue1=new LLBasedQueue();
        FIFAMAIN obj = new FIFAMAIN();

        String sr= br.readLine();
        String[]token=sr.split(" ");

        int playerCount =Integer.parseInt(token[0]) ;
        int totalTime=Integer.parseInt(token[1]);
        ArrayBasedQueue queue = new ArrayBasedQueue(playerCount);
        ArrayBasedQueue queue1 = new ArrayBasedQueue(playerCount);
        //ArrayBasedStack stack = new ArrayBasedStack(playerCount);
        ArrayBasedQueue queue2 = new ArrayBasedQueue(playerCount);
        int sum = 0, sum1 = 0;
        while (playerCount != 0) {

            sr= br.readLine();
            token=sr.split(" ");

            int x = Integer.parseInt(token[0]);
            int y = Integer.parseInt(token[1]);

            int k = x;
            if (queue1.length() != 0 && k >= (int) queue1.frontValue()) {
                queue1.dequeue();
            }
            if (stack.length() != 0 && k >= (int) stack.topValue()) {
                stack.pop();
            }

            if (queue1.length() == 0) {

                sum += x + y;
                queue1.enqueue(sum);
                obj.put(sum);

            } else if (sum > y && queue1.length() < 4) {

                sum += y;
                queue1.enqueue(sum);
                if (sum > totalTime) sum = totalTime;
                obj.put(sum);
            } else if (queue1.length() > 3 && stack.length() == 0) {
                sum1 += x + y;
                stack.push(sum1);
                obj.put(sum1);
            } else if (sum1 > y && queue1.length() > 3 && stack.length() != 0) {
                queue.enqueue(y);
            }


            playerCount--;
        }
        int r = queue.length();
        int s = 0;
        for (int o = 0; o < r; o++) {
            s += (int) queue.frontValue();
            queue2.enqueue((int) queue.frontValue());
            queue.dequeue();
        }

        for (int l = 0; l < r; l++) {
            int tq = sum1;


            int d = sum1 + s;
            if (d > totalTime) d = totalTime;
            obj.put(d);
            //sum1=d;
            s = s - (int) queue2.frontValue();
            queue2.dequeue();
        }
       bw.write( obj.showlist());
            //System.out.println(obj.showlist());
        br.close();
        bw.close();
    }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}