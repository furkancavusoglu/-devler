import java.io.*;
public class bufferedwriter {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            String mycontent = "This String would be written" +
                    " to the specified File";
            //Specify the file name and path here
            File file = new File("bufferedWriter.txt");
            FileWriter fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(mycontent);
            System.out.println("File written Successfully");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception ex) {
                System.out.println("Error in closing the bufferedwriter" + ex);
            }
        }
    }
}