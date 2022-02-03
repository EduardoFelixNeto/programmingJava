
import edu.duke.*;

public class WordPlay {
    public boolean isVowel(char ch){
        String vowels = "AEIOU";
        ch = Character.toUpperCase(ch);
        // Return true if ch is a vowel
        if (vowels.indexOf(ch) != -1){
            return true;
        }
        else{
            // Otherwise return false
            return false;
        }
    }
    public void testIsVowel(){
        char ch = 'A';
        boolean vowel = isVowel(ch);
        System.out.println(vowel);
    }
    public String replaceVowels(String phrase,char ch){
        StringBuilder sb = new StringBuilder(phrase);
        for (int i = 0; i < sb.length(); i++){
            char currChar = sb.charAt(i);
            if(isVowel(currChar)){
                sb.setCharAt(i,ch);
            }
        }

       // This method should return a String that is the string phrase with all the vowels (uppercase or lowercase) replaced by ch

        return sb.toString();

    }
    public void testReplaceVowels(){
        String phrase = "Hello World";
        char ch = '*';
        String answer = replaceVowels(phrase, ch);
        System.out.println(answer);
    }
    public String emphasize(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        ch = Character.toUpperCase(ch);
        for (int i = 0; i < sb.length(); i++){
            char currChar = sb.charAt(i);
            currChar = Character.toUpperCase(currChar);
            if ((currChar == ch) && (i % 2 == 0)){
                sb.setCharAt(i,'*');
            }
            if((currChar == ch) && (i % 2 != 0)){
                sb.setCharAt(i,'+');
            }
        }
        return sb.toString();
    }
    public void testEmphasize(){
        String phrase = "DNA CTGAAACTGA";
        char ch = 'a';
        String answer = emphasize(phrase, ch);
        System.out.println(answer);
    }
}
