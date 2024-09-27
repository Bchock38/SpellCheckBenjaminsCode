import java.util.ArrayList;
import java.util.Collections;

/**
 * Spell Check
 * A puzzle written by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Benjamin Chock
 * */

public class SpellCheck {


    /**
     * checkWords finds all words in text that are not present in dictionary
     *
     * @param text The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        ArrayList<String> misspelled = new ArrayList<String>();
        ArrayList<String> misspelledSorted = new ArrayList<String>();
        for (int i = 0; i < text.length; i++){
            if (!checkDictionary(dictionary, text[i]) && !checkMispelled(misspelledSorted,text[i])){
                misspelled.add(text[i]);
                sort(misspelledSorted,text[i]);
            }
        }

        for (int i = 0; i < misspelledSorted.size(); i++){
//            System.out.println(misspelled.get(i));
            System.out.println(misspelledSorted.get(i));
        }

        return misspelled.toArray(new String[0]);
    }

    public static boolean checkDictionary(String[] dictionary, String toFind){
        int current;
        int start = 0;
        int end = dictionary.length-1;
        while (end-start >= 0){
            current = (end-start)/2 + start;
            if (dictionary[current].equals(toFind)){
                return true;
            }
            else if (toFind.compareTo(dictionary[current]) < 0){
                end = current-1;
            }
            else {
                start = current+1;
            }
        }
        return false;
    }

    public static ArrayList<String> sort(ArrayList<String> toBeSorted, String addedWord){
        int current;
        int start = 0;
        int end = toBeSorted.size()-1;
        if (toBeSorted.isEmpty()){
            toBeSorted.add(addedWord);
            return toBeSorted;
        }
        while (end-start >=0){
            current = (end-start)/2 + start;
            if (end == start){
                toBeSorted.add(end, addedWord);
                System.out.print(end);
                System.out.println(addedWord);
                return toBeSorted;
            }
            else if (addedWord.compareTo(toBeSorted.get(current)) < 0){
                end = current-1;
            }
            else {
                start = current+1;
            }
        }
        return toBeSorted;
    }
    public static boolean checkMispelled(ArrayList<String> misspelled, String toFind){
        int current;
        int start = 0;
        int end = misspelled.size()-1;
        while (end-start >= 0){
            current = (end-start)/2 + start;
            if (misspelled.get(current).equals(toFind)){
                return true;
            }
            else if (toFind.compareTo(misspelled.get(current)) < 0){
                end = current-1;
            }
            else {
                start = current+1;
            }
        }
        return false;
    }

}
