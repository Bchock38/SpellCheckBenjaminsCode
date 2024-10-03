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
     * @param text       The list of all words in the text.
     * @param dictionary The list of all accepted words.
     * @return String[] of all mispelled words in the order they appear in text. No duplicates.
     */
    public String[] checkWords(String[] text, String[] dictionary) {
        Trie dictionaryTrie = makeDictionaryTrie(dictionary);
        ArrayList<String> mispelled = new ArrayList<String>();
        for (String words : text){
            if (!dictionaryTrie.lookUp(words)){
                mispelled.add(words);
            }
        }

        return mispelled.toArray(new String[0]);
    }

    public Trie makeDictionaryTrie(String[] dictionary){
        Trie dictionaryTrie = new Trie();
        for (String words : dictionary) {
            dictionaryTrie.insert(words);
        }
        return dictionaryTrie;
    }
}

