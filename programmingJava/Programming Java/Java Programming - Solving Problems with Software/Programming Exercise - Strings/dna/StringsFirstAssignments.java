public class Part1 {
    public String findSimpleGene(String dna){
        // Finds the index position of the start codon "ATG". If there is no "ATG", return the empty string.
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1){
            return "";
        }
        // Finds the index position of the first stop codon "TAA" appering after the "ATG" that was found. If there is no such "TAA", return the empty string.
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if (stopIndex == -1){
            return "";
        }
        //If the length of the substring between the "ATG" and "TAA" is a multiple of 3, then return the substring that starts with that "ATG" and 
        if ((stopIndex - startIndex) % 3 == 0){
            String gene = dna.substring(startIndex,stopIndex+3);
        }else{
            String gene = "";
        }
        return gene;
    }
    public void testSimpleGene(){
        // DNA with no “ATG”
        String dna = "CGTAGTCATAA";
        // DNA with no “TAA”
        // DNA with no “ATG” or “TAA”
        // DNA with ATG, TAA and the substring between them is a multiple of 3 (a gene)
        // DNA with ATG, TAA and the substring between them is not a multiple of 3
        System.out.println("DNA is " + dna);
        String ans = findSimpleGene(dna);
        System.ou.println("Gene is " + ans);
    }
}
