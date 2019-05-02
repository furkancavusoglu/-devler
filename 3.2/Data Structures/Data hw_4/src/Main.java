import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the file directory: ");
        File file = new File(scan.nextLine());
        Occurence occurence = new Occurence();
        occurence.showOccurance(file);
        System.out.println("Do you want to search a specific word?(y/n)");
        String answer = scan.next();
        if (answer.equalsIgnoreCase("y")) {
            System.out.println("Please enter the word that you are looking for");
            String word=scan.next();
            OccurenceLine occuranceLine= new OccurenceLine();
            occuranceLine.showOccuranceLine(file,word);
        }
    }
}

