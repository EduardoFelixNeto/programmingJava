
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
 public String findSimpleGene(String dna, String startCodon, String stopCodon){
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1){
            return "";
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
        if (stopIndex == -1){
            return "";
        }
        String gene = dna.substring(startIndex, stopIndex + 3);
        int length = gene.length();
        if (length % 3 == 0){
            return gene;
        }
        else{
            return "";
        }
    }
    public void testSimpleGene(){
        String dna = "ATGGGTTAAGTC";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        String test = findSimpleGene(dna,startCodon,stopCodon);
        System.out.println(test);
    }
}
