import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OccurenceLine {
    private Map<String, String> occuranceMap = new HashMap<>();

    OccurenceLine() {
    }
    String[] readLines(String filename) throws IOException {
        FileReader fileReader = new FileReader(filename);

        BufferedReader bufferedReader = new BufferedReader(fileReader);
        List<String> lines = new ArrayList<>();
        String line = null;
        String[] split=null;

        while ((line = bufferedReader.readLine()) != null) {
            split=line.split("[.,!?:;'\"-]|\\s");
            for(String word:split)
                lines.add(word);
        }
        bufferedReader.close();
        return lines.toArray(new String[lines.size()]);
    }
    void showOccuranceLine(File file,String word) throws  IOException {
        String[] words = readLines(file.getAbsolutePath());
        word = word.toLowerCase();
        for (int ar_i = 0; ar_i < words.length; ar_i++) {
            if (words[ar_i].equalsIgnoreCase(word)) {
                if (occuranceMap.get(word) == null)
                    occuranceMap.put(word, String.valueOf(ar_i) + ",");
                else
                    occuranceMap.replace(word, occuranceMap.get(word) + " " + String.valueOf(ar_i)+" ,");
            }
        }
        if (occuranceMap.entrySet().isEmpty())
            System.out.println("This word does not exist.");
        else
            System.out.println(occuranceMap.entrySet());
    }

    /*void showOccuranceLine(File file, String word) throws IOException {
        occuranceMap.clear();
        word = word.toLowerCase();
        try (LineNumberReader r = new LineNumberReader(new FileReader(file))) {
            String line;
            while ((line = r.readLine()) != null) {
                for (String element : line.split("[.,!?:;'\"-]|\\s")) {
                    element = element.toLowerCase();
                    if (element.equals(word)) {
                        if (occuranceMap.get(word) == null)
                            occuranceMap.put(word, String.valueOf(r.getLineNumber()) + ",");
                        else
                            occuranceMap.replace(word,occuranceMap.get(word)+" "+String.valueOf(r.getLineNumber() + ","));
                    }
                }
            }
        }
        if (occuranceMap.entrySet().isEmpty())
            System.out.println("This word does not exist.");
        else
            System.out.println(occuranceMap.entrySet());*/
    }
