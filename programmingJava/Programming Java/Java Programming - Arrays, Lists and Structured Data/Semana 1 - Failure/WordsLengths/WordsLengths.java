
/**
 * Write a description of WordsLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordsLengths {
    public void countWordsLengths(FileResource resource,int[] counts){
        for(String word : resource.words()){
            word = word.toLowerCase();
            for(int k=0; k < word.length; k++){
                if (list[k].equals(word)){
                    return k;
                }
            }
            return -1;
}
