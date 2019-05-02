import java.io.*;

public class printWriter {
    public static void main(String[] args) {
        try {
            File f = new File("printWriter.txt");
            FileWriter fw = new FileWriter(f, true);
            PrintWriter pw = new PrintWriter(fw);

            pw.println("This is so easy");
            pw.println("Data successfully appended.");
            pw.close();


            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                line = br.readLine();
            }
            br.close();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
