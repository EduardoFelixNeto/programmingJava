
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part1 {
 public String findSimpleGene(String dna){
        //Finds the index position of the startCodon "ATG"
        int startIndex = dna.indexOf("ATG");
        //If there's no "ATG", return and empty string
        if (startIndex == -1){
            return "";
        }
        //Finds the index position of the first stopCodon "TAA" appering after the "ATG" that was found.
        int stopIndex = dna.indexOf("TAA", startIndex + 3);
        //If there is no such "TAA", return the empty string
        if (stopIndex == -1){
            return "";
        }
        String gene = dna.substring(startIndex,stopIndex + 3);
        int length = gene.length();
        if (length % 3 == 0){
            return gene;
        }
        else{
            return "";
        }
    }
    public void testSimpleGene(){
        //String dna = "ATCTTTGAGTCTAA";
        //String dna = "TGTATGGGTAGT";
        //String dna = "TTGGTACGATAC";
        //String dna = "ATGGGGTTTCCCAAATAAGTCTCA";
        String dna = "ATGGTAGTTCCTAA";
        String test = findSimpleGene(dna);
        System.out.println(test);
    }
}
