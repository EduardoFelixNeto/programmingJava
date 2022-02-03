
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch){
        String vowels = "AEIOUaeiou";
        int idx = vowels.indexOf(ch);
        if (idx != -1){ 
            return true;
        }
        else{
            return false;
        }      
    }
    public void testIsVowel(){
        char ch = 'a';
        boolean test = isVowel(ch);
        System.out.println(test);
    }
    public String replaceVowels(String phrase, char ch){
        StringBuilder sb = new StringBuilder(phrase);
        for (int i = 0; i < sb.length(); i++){
            char currChar = sb.charAt(i);
            boolean vowel = isVowel(currChar);
            if (vowel){
                sb.setCharAt(i, ch);
            }
        }
        return sb.toString();
    }
    public void testReplaceVowels(){
        String phrase = "Hello World";
        char ch = '*';
        String answer = replaceVowels(phrase,ch);
        System.out.println(answer);
    }
    public String emphasize(String phrase, char ch){
        int idx = 0;
         StringBuilder sb = new StringBuilder(phrase);
         for (int i = 0; i < sb.length(); i++){
            idx = phrase.indexOf(ch, idx);
            if (idx != -1l){
                if (idx % 2 == 0){
                    sb.setCharAt(idx, '*');
                }
                else{
                    sb.setCharAt(idx, '+');
                }
            }
        }
        return sb.toString();
    }
    public void testEmphasize(){
        String phrase = "dna ctgaaactga";
        char ch = 'a';
        String answer = emphasize(phrase,ch);
        System.out.println(phrase);
        System.out.println(answer);
    }
}