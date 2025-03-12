import java.io.*;

public class MAIN {
   // private final String INPUT_FILE_NAME="input.txt";

    public static void main(String[] args) {
        try{
            BufferedReader br=new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt"));

            String str= br.readLine();
            String[]token=str.split(" ");

            String initialLength=token[0];
            String initialCapacity=token[1];

            ArrayBasedQueue queue=new ArrayBasedQueue(Integer.parseInt(initialCapacity));
           //LLBasedQueue queue=new LLBasedQueue();

            //int func
            str= br.readLine();
            token=str.split(" ");
            for(int i=0;i<Integer.parseInt(initialLength);i++)
            {
                int x=Integer.parseInt(token[i]);
                queue.enqueue(x);
            }
            bw.write(queue.show());
            bw.write(System.lineSeparator());

            ArrayBasedStack stack=new ArrayBasedStack(Integer.parseInt(initialCapacity));
            //LLBasedStack stack=new LLBasedStack();

            str= br.readLine();
            token=str.split(" ");

            String initiallength=token[0];
            String initialcapacity=token[1];

            str= br.readLine();
            token=str.split(" ");
            for(int i=0;i<Integer.parseInt(initiallength);i++)
            {
                int x=Integer.parseInt(token[i]);
                stack.push(x);
            }
            bw.write(stack.show());
            bw.write(System.lineSeparator());
            int functionNumber=-1;
            int choice=-1;
            int parameter=-1;

            str=br.readLine();
            token=str.split(" ");
            String numberOfOperations=token[0];
            int operationCount=Integer.parseInt(numberOfOperations);
            while(operationCount!=0)
            {
                str= br.readLine();
                token=str.split(" ");
                functionNumber=Integer.parseInt(token[0]);
                choice=functionNumber;
                parameter=Integer.parseInt(token[1]);
                switch (choice)
                {
                    case 1:
                        queue.clear();
                        bw.write(queue.show());
                        bw.write(System.lineSeparator());
                        bw.write("-1");
                        break;
                    case 2:
                        queue.enqueue(parameter);
                        bw.write(queue.show());
                        bw.write(System.lineSeparator());
                        bw.write("-1");
                        break;
                    case 3:
                        String value=String.valueOf(queue.dequeue());
                        bw.write(queue.show());
                        bw.write(System.lineSeparator());
                        bw.write(value);
                        break;
                    case 4:
                        String value1=String.valueOf(queue.length());
                        bw.write(queue.show());
                        bw.write(System.lineSeparator());
                        bw.write(value1);
                        break;
                    case 5:
                        String frontval=String.valueOf(queue.frontValue());
                        bw.write(queue.show());
                        bw.write(System.lineSeparator());
                        bw.write(frontval);
                        break;
                    case 6:
                        String rearVal=String.valueOf(queue.rearValue());
                        bw.write(queue.show());
                        bw.write(System.lineSeparator());
                        bw.write(rearVal);
                        break;
                    case 7:
                        String lastElement=String.valueOf(queue.leaveQueue());
                        bw.write(queue.show());
                        bw.write(System.lineSeparator());
                        bw.write(lastElement);
                        break;
                    case 8:
                        stack.clear();
                        bw.write(stack.show());
                        bw.write(System.lineSeparator());
                        bw.write("-1");
                        break;
                    case 9:
                        stack.push(parameter);
                        bw.write(stack.show());
                        bw.write(System.lineSeparator());
                        bw.write("-1");
                        break;
                    case 10:
                        String val=String.valueOf(stack.pop());
                        bw.write(stack.show());
                        bw.write(System.lineSeparator());
                        bw.write(val);
                        break;
                    case 11:
                        String stacklength=String.valueOf(stack.length());
                        bw.write(stack.show());
                        bw.write(System.lineSeparator());
                        bw.write(stacklength);
                        break;
                    case 12:
                        String getTop=String.valueOf(stack.topValue());
                        bw.write(stack.show());
                        bw.write(System.lineSeparator());
                        bw.write(getTop);
                        break;



                }
                bw.write(System.lineSeparator());
                operationCount--;





            }
            br.close();
            bw.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
