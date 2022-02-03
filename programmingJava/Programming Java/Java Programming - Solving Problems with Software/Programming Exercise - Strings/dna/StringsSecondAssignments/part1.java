/**
 * Write a description of part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part1 {
        //Write the method findStopCodon that has three parameters, a String parameter named dna, an integer parameter named startIndex that represents where the first occurrence of ATG occurs in dna, and a String parameter named stopCodon. 
        //This method returns the index of the first occurrence of stopCodon that appears past startIndex and is a multiple of 3 away from startIndex. If there is no such stopCodon, this method returns the length of the dna strand.
        public int findStopCodon(String dna, int startIndex, String stopCodon){
            int stopIndex = dna.indexOf(stopCodon, startIndex + 3);
            int diff = stopIndex - startIndex;
            if (diff % 3 == 0) {
                return stopIndex;
            }
            else{
                return dna.length();
            }
        }
        //Write the method findGene that has one String parameter dna, representing a string of DNA. In this method you should do the following:
        public String findGene(String dna){
            //Find the index of the first occurrence of the start codon “ATG”. If there is no “ATG”, return the empty string.
            int startIndex = dna.indexOf("ATG");
            if (startIndex == -1){
                return "";
            }
            //Find the index of the first occurrence of the stop codon “TAA” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”. Hint: call findStopCodon.
            int taaIndex = findStopCodon(dna, startIndex, "TAA");
            //Find the index of the first occurrence of the stop codon “TAG” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”.
            int tagIndex = findStopCodon(dna, startIndex, "TAG");
            //Find the index of the first occurrence of the stop codon “TGA” after the first occurrence of “ATG” that is a multiple of three away from the “ATG”.
            int tgaIndex = findStopCodon(dna, startIndex, "TGA");
            //Return the gene formed from the “ATG” and the closest stop codon that is a multiple of three away.
            int minIndex = 0;
            if (taaIndex == -1 || (tagIndex != -1 && tagIndex > taaIndex)){
                minIndex = tagIndex;
            }
            else{
                minIndex = taaIndex;
            }
            if (minIndex == -1 || (tgaIndex != -1 && tgaIndex > minIndex)){
                minIndex = tgaIndex;
            }
            //If there is no valid stop codon and therefore no gene, return the empty string.
            if (minIndex == -1){
                return "";
            }
            else{
                String gene =  dna.substring(startIndex, minIndex + 3);
                return gene;
            }
        }
        //Write the void method testFindStopCodon that calls the method findStopCodon with several examples and prints out the results to check if findStopCodon is working correctly. 
        //Think about what types of examples you should check. For example, you may want to check some strings of DNA that have genes and some that do not.
         public void testFindStopCodon(){
            String dna = "ATGCCC";
            int startIndex = dna.indexOf("ATG");
            String stopCodon = "TAA";
            int test = findStopCodon(dna, startIndex, stopCodon);
            System.out.println(test);
        }
        //Write the void method testFindGene that has no parameters. You should create five DNA strings. 
        //The strings should have specific test cases such as DNA with no “ATG”, DNA with “ATG” and one valid stop codon, DNA with “ATG” and multiple valid stop codons, DNA with “ATG” and no valid stop codons. 
        //Think carefully about what would be good examples to test. For each DNA string you should: 
        public void testFindGene(){
            String dna = "ATGCCCTAA";
            String test = findGene(dna);
            System.out.println(test);
        }
}