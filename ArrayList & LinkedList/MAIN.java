import java.io.*;


public class MAIN {
    private static final String INPUT_FILE_NAME = "list_input.txt";
    public static void main(String args[]) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
            BufferedWriter bw = new BufferedWriter(new FileWriter("list_output.txt"));


            String str = br.readLine();
            String[] token = str.split(" ");

            String initialLength = token[0];
            String initialCapacity = token[1];

            //MyLst m = new MyLst(Integer.parseInt(initialCapacity));
            MyList m=new MyList();

            int functionNumber = -1;
            int parameter = -1;
            int choice = -1;
            str = br.readLine();
            token = str.split(" ");
            for (int i = 0; i < Integer.parseInt(initialLength); i++) {
                int x = Integer.parseInt(token[i]);
                m.pushBack(x);
            }

            bw.write(m.display());
            bw.write(System.lineSeparator());

            str = br.readLine();
            token = str.split(" ");
            String numberOfOperations = token[0];
            int operationNumber = Integer.parseInt(numberOfOperations);
            while (operationNumber != 0) {
                str = br.readLine();
                token = str.split(" ");
                functionNumber = Integer.parseInt(token[0]);
                choice = functionNumber;
                parameter = Integer.parseInt(token[1]);
                switch (choice) {
                    case 1:
                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        String sizenumber = String.valueOf(m.size());
                        bw.write(sizenumber);
                        break;
                    case 2:
                        m.push(parameter);
                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        bw.write("-1");
                        break;
                    case 3:
                        m.pushBack(parameter);
                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        bw.write("-1");
                        break;
                    case 4:
                        String value = String.valueOf(m.erase());

                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        bw.write(value);
                        break;
                    case 5:
                        m.setToBegin();
                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        bw.write("-1");
                        break;
                    case 6:
                        m.setToEnd();
                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        bw.write("-1");
                        break;
                    case 7:
                        m.prev();
                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        bw.write("-1");
                        break;
                    case 8:
                        m.next();
                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        bw.write("-1");
                        break;
                    case 9:
                        String currpos = String.valueOf(m.currPos());
                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        bw.write(currpos);
                        break;
                    case 10:
                        m.setToPos(parameter);
                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        bw.write("-1");
                        break;
                    case 11:
                        String getval = String.valueOf(m.getValue());
                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        bw.write(getval);
                        break;
                    case 12:
                        String fnd = String.valueOf(m.find(parameter));
                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        bw.write(fnd);
                        break;
                    case 13:
                        m.clear();
                        bw.write(m.display());
                        bw.write(System.lineSeparator());
                        bw.write("-1");
                        break;
                }
                bw.write(System.lineSeparator());
                operationNumber--;
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
