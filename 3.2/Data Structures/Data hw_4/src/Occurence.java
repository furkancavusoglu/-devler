import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Occurence {
    private Map<String, Integer> searchMap = new HashMap<>();
    Occurence() {
    }

    public void showOccurance(File file) throws FileNotFoundException {
        searchMap.clear();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String inputLine = null;
        try {
            while ((inputLine = bufferedReader.readLine()) != null) {
                String[] words = inputLine.split("[.,!?:;'\"-]|\\s");
                for (String counter : words) {
                    String key = counter.toLowerCase(); // remove .toLowerCase for Case Sensitive result.
                    if (key.length() > 0) {
                        if (searchMap.get(key) == null) {
                            searchMap.put(key, 1);
                        } else {
                            searchMap.replace(key, searchMap.get(key) + 1);
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("file error");
        }
        System.out.println(searchMap.entrySet());
    }
}
