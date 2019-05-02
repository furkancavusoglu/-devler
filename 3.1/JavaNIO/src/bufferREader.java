
import java.io.*;
public class bufferREader {
    public static void main(String[] args) {

        BufferedReader br = null;
        BufferedReader br2 = null;
        try {
            FileReader fr = new FileReader("br1.txt");
            br = new BufferedReader(fr);

            //One way of reading the file
            System.out.println("Reading the file using readLine() method:");
            String contentLine = br.readLine();
            while (contentLine != null) {
                System.out.println(contentLine);
                contentLine = br.readLine();
            }

            br2 = new BufferedReader(new FileReader("br2.txt"));

            //Second way of reading the file
            System.out.println("Reading the file using read() method:");
            int num = 0;
            char ch;
            while ((num = br2.read()) != -1) {
                ch = (char) num;
                System.out.print(ch);
            }

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (br2 != null)
                    br2.close();
            } catch (IOException ioe) {
                System.out.println("Error in closing the BufferedReader");
            }
        }
    }
}
