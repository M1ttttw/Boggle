package boggle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.TreeSet;

/**
 * The Dictionary class for the first Assignment in CSC207, Fall 2022
 * The Dictionary will contain lists of words that are acceptable for Boggle 
 */
public class Dictionary {

    /**
     * set of legal words for Boggle
     */
    private TreeSet<String> legalWords;

    /**
     * Class constructor 
     * 
     * @param filename the file containing a list of legal words.
     */
    public Dictionary(String filename) {
        String line = "";
        this.legalWords = new TreeSet<String>();
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null)
            {
                if (line.strip().length() > 0) {
                    legalWords.add(line.strip());
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /* 
     * Checks to see if a provided word is in the dictionary.
     *
     * @param word  The word to check
     * @return  A boolean indicating if the word has been found
     */
    public boolean containsWord(String word) {
        return this.legalWords.contains(word.toLowerCase());
    }

    /* 
     * Checks to see if a provided string is a prefix of any word in the dictionary.
     *
     * @param str  The string to check
     * @return  A boolean indicating if the string has been found as a prefix
     */
    public boolean isPrefix(String str) {
        str = str.toLowerCase();
        String s = this.legalWords.ceiling(str);
        if (s == null || s.length() < str.length()) return false;
        return Objects.equals(str, s.substring(0, str.length()));
    }

}
