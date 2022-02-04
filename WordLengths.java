import edu.duke.*;

public class WordLengths{
    public int[] countWordLengths(){
        FileResource resource = new FileResource("data/manywords.txt");
        int[] counts = new int[31];
        for(String word : resource.words()){
            int length = word.length();
            for (int k = 0; k < word.length(); k++){
                if(!Character.isLetter(word.charAt(k))){
                    length = word.length() - 1;
                }
            }
            counts[length] += 1;
        }
        for(int k = 1; k < counts.length; k++){
            System.out.println("There is " + counts[k] + " with " + k + " letters.");
        }
        return counts;
    }
    public int indexOfMax(int[] values){
        int maxDex = 0;
        for (int k = 0; k < values.length; k++){
            if (values[k] > values[maxDex]){
               maxDex = k;
            }
       }
        // This method returns the index position of the largest element in the values
        return maxDex;
    }
    public void testIndexOfMax(){
        int maxIndex = indexOfMax(countWordLengths());
        System.out.println(maxIndex);
    }
}