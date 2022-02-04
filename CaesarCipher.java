
import edu.duke.*;

public class CaesarCipher {
   public String encrypt(String input, int key){
       // Make a StringBuilder with message (encrypted)
       StringBuilder encrypted = new StringBuilder(input);
       // Write down the alphabet
       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       // Compute the shifted alphabet
       String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0,key);
       // Count from 0 to < length of encrypted, (call it i)
       for (int i = 0; i < encrypted.length(); i++){
           // Look at the i'th character of encrypted (call it currChar)
           char currChar = encrypted.charAt(i);
           currChar = Character.toUpperCase(currChar);
           // Find the index of currChar in the alphabet (call it index)
           int index = alphabet.indexOf(currChar);
           // If currChar is in the alphabet
           if (index != -1){
               // Get the index'th character of shiftedAlphabet (call it newChar);
               char newChar = shiftedAlphabet.charAt(index);
               // Replace the i'th character of encrypted with newChar
               encrypted.setCharAt(i,newChar);
           } 
       }
       return encrypted.toString();
   }
   public void testEncrypt(){
       int key = 15;
       String message = "Can you imagine life WITHOUT the internet AND computers in your pocket?";
       String encrypted = encrypt(message,key);
       System.out.println("key is " + key + "\n" + encrypted);
       String decrypted = encrypt(encrypted,26-key);
       System.out.println(decrypted);
   }
   public String encryptTwoKeys(String input, int key1, int key2){
       StringBuilder encrypted = new StringBuilder(input);
       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       String shiftedAlphabetKey1 = alphabet.substring(key1) + alphabet.substring(0,key1);
       String shiftedAlphabetKey2 = alphabet.substring(key2) + alphabet.substring(0,key2);
       for (int i = 0; i < encrypted.length(); i++){
            char currChar = encrypted.charAt(i);
            currChar = Character.toUpperCase(currChar);
            int index = alphabet.indexOf(currChar);
            if ((index != -1) && (i % 2 == 0)){
                char newChar = shiftedAlphabetKey1.charAt(index);
                encrypted.setCharAt(i,newChar);
            }
            if ((index != -1) && (i % 2 != 0)){
                char newChar = shiftedAlphabetKey2.charAt(index);
                encrypted.setCharAt(i,newChar);
            }
        }
        return encrypted.toString();
   }
   public void testEncryptTwoKeys(){
            int key1 = 12;  
            int key2 = 2;
            String message = "Hfs cpwewloj loks cd Hoto kyg Cyy.!";
            String encrypted = encryptTwoKeys(message,key1,key2);
            System.out.println("key is " + key1 + " and " + key2 + " : " + encrypted);
            String decrypted = encryptTwoKeys(encrypted,26-key1,26-key2);
            System.out.println(decrypted);  
   }
   public void testEncryptTwoKeys2(){
    for(int i = 22; i <= 26; i++){
        int key1 = i;
        for (int k = 1; k <= 26; k++){
        int key2 = k;
        String message = "Uybi Gfqgykii Jgziegv Uigeixdiex Smiizzin";
        String encrypted = encryptTwoKeys(message,key1,key2);
        System.out.println("key is " + key1 + " and " + key2 + " : " + encrypted);
        //String decrypted = encryptTwoKeys(encrypted,26-key1,26-key2);
        //System.out.println(decrypted);
        }
    } 
}
   public int[] countLetters(String message){
        String alph = "abcdefghigklmnopqrstuvwxyz";
        int [] counts = new int[26];
        for(int k = 0; k < message.length(); k++){
        char ch = Character.toLowerCase(message.charAt(k));
        int dex = alph.indexOf(ch);
            if (dex != -1){
                counts[dex] += 1;
            }
        }
        return counts;
   }
   public String decrypt(String encrypted){
       CaesarCipher cc = new CaesarCipher();
       int[] freqs = countLetters(encrypted);
       int maxDex = maxIndex(freqs);
       int dkey = maxDex - 4;
       if (maxDex < 4){
           dkey = 26 - (4-maxDex);
       }
       return cc.encrypt(encrypted,26-dkey);
   }
   public int maxIndex(int[] vals){
        int maxDex = 0;
        for (int k = 0; k < vals.length; k++){
           if (vals[k] > vals[maxDex]){
               maxDex = k;
            }
        }
        return maxDex;
   }
   public void testDecrypt(){
        String encrypted = "XQ KLLK YB FK QEB ZLKCBOBKZB OLLJ TFQE VLRO EXQ LK CLO X PROMOFPB MXOQV. VBII ILRA!";
        String decrypted = decrypt(encrypted);
        System.out.println(decrypted);
   }
}
