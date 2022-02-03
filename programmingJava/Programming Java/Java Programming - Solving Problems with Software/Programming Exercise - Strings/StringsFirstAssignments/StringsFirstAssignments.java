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
public class Part2{
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
