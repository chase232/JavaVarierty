

package JFXhangman;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class Helper {
    
    public static void loadWordsIntoMemory(List<String> wordList) {

        /**
         * Load words into memory from execution path
         */
        /*        try (Stream<String> stream = Files.lines(Paths.get("words.txt"))) {
            stream.forEach(word -> wordList.add(word.trim()));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        /**
         * Load words into memory using package path
         */
        try {            
            URL url = HangMan.class.getClassLoader().getResource("hangman/data.txt");
            BufferedInputStream inputStream = new BufferedInputStream(new URL(url.toString()).openStream());
            
            // Load words into memory using package path       
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.trim().length() > 0) {
                        wordList.add(line.trim());
                    }
                }
            }           
                    
        } catch (Exception e) {
            System.out.println("File/Stream Error!");
            e.printStackTrace();
        }
    }

}


