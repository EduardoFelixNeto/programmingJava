public class Part2 {

    // Write the method findGeneSimple that has one String parameter dna, representing a string of DNA.

    public String findGeneSimple(String dna, String startCodon, String stopCodon){

        String result = "";

        // Find the index position of the start codon "ATG".

        int startIndex = dna.indexOf(startCodon);

        // If there's no "ATG", return the emplty string.

        if (startIndex == -1){

            // No ATG

            return "";
        }

        // Find the index position of the start codon "TAA".

        int stopIndex = dna.indexOf(stopCodon, startIndex + 3);

        // If there's no "TAA", return the emplty string.

        if (stopIndex == -1){

            //No TAA

            return "";
        }

        // Find the gene between ATG, included, and TAA, included.

        result = dna.substring(startIndex,stopIndex + 3);

        // If the length of the substring between the ATG and TAA is a multiple of 3,

        if ((stopIndex - startIndex) % 3 == 0){

            // Return the substring that starts with ATG and ends with that TAA.
            
            return result;
        }
        else{
            return "";
        }
    }
    public void testfindGeneSimple(){
        String dna = "AATGCGTAATATGGT";
        String stopCodon = "TAA";
        String startCodon = "ATG";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        int length = gene.length();
        System.out.println("Gene's length is " + length);

        dna = "AATGCTAGGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        length = gene.length();
        System.out.println("Gene's length is " + length);

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        length = gene.length();
        System.out.println("Gene's length is " + length);

        dna = "ATCCTCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        length = gene.length();
        System.out.println("Gene's length is " + length);

        dna = "ATCCTATGCTTCGGCTGCTCTATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna,startCodon,stopCodon);
        System.out.println("Gene is " + gene);
        length = gene.length();
        System.out.println("Gene's length is " + length);
    }
    
}
