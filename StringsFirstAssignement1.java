// Create a new Java project named StringsFirstAssignments.

// Create a new Java class named Part1.

public class Part1 {

    // Write the method findGeneSimple that has one String parameter dna, representing a string of DNA.

    public String findGeneSimple(String dna){

        String result = "";

        // Find the index position of the start codon "ATG".

        int startIndex = dna.indexOf("ATG");

        // If there's no "ATG", return the emplty string.

        if (startIndex == -1){

            // No ATG

            return "";
        }

        // Find the index position of the start codon "TAA".

        int stopIndex = dna.indexOf("TAA", startIndex + 3);

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
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        int length = gene.length();
        System.out.println("Gene's length is " + length);

        dna = "AATGCTAGGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        length = gene.length();
        System.out.println("Gene's length is " + length);

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        length = gene.length();
        System.out.println("Gene's length is " + length);

        dna = "ATCCTCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        length = gene.length();
        System.out.println("Gene's length is " + length);

        dna = "ATCCTATGCTTCGGCTGCTCTATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        length = gene.length();
        System.out.println("Gene's length is " + length);
    }
    
}

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
        String gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        int length = gene.length();
        System.out.println("Gene's length is " + length);

        dna = "AATGCTAGGGGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        length = gene.length();
        System.out.println("Gene's length is " + length);

        dna = "ATCCTATGCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        length = gene.length();
        System.out.println("Gene's length is " + length);

        dna = "ATCCTCTTCGGCTGCTCTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        length = gene.length();
        System.out.println("Gene's length is " + length);

        dna = "ATCCTATGCTTCGGCTGCTCTATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is " + gene);
        length = gene.length();
        System.out.println("Gene's length is " + length);
    }
}

public class FindGeneWhile {

    public String findGeneSimple(String dna) {
        int startIndex = dna.indexOf("ATG");
        int currIndex = dna.indexOf("TAA", startIndex + 3);
        while(currIndex != -1){
            if((currIndex - startIndex) % 3 == 0){
                return dna.substring(startIndex, currIndex + 3);
            }
            else{
                currIndex = dna.indexOf("TAA", currIndex + 1);
            }
        }
        return "";
    }
    public void testfindGeneSimple(){

        String dna = "AATGCGTAATTAATCG";
        System.out.println("DNA strand is " + dna);
        String gene = findGeneSimple(dna);
        System.out.println("Gene is" + gene);

        dna = "CGATGGTTGATAAGCCTAAGCTATAA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is" + gene);

        dna = "CGATGGTTGATAAGCCTAAGCTA";
        System.out.println("DNA strand is " + dna);
        gene = findGeneSimple(dna);
        System.out.println("Gene is" + gene);
    }

}

public class AllCodons{

    public int findStopCodon(String dna, int startIndex, String stopCodon){

        int currIndex = dna.indexOf(stopCodon, startIndex + 3);

        while(currIndex != -1){
            int diff = currIndex - startIndex;
            if(diff % 3 == 0){
                return currIndex;
            }
            else{
                currIndex = dna.indexOf(stopCodon, currIndex + 1);
            }
        }
        return -1;
    }

    public String findGene(String dna, int where){
        int startIndex = dna.indexOf("ATG", where);
        if(startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");

        int minIndex = 0;

        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }
        else{
            minIndex = taaIndex;
        }

        if(minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
            minIndex = tagIndex;
        }

        if(minIndex == -1){
            return "";
        }

        return dna.substring(startIndex,minIndex + 3);
    }

    public void testFindStopCodon(){

        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna,0,"TAA");
        if (dex != 1) System.out.println("error on 9");
        dex = findStopCodon(dna,9,"TAA");
        if (dex != 21) System.out.println("error on 21");
        dex = findStopCodon(dna,1,"TAA");
        if (dex != 26) System.out.println("error on 26");
        dex = findStopCodon(dna,0,"TAG");
        if (dex != 26) System.out.println("error on 26 TAG");
        System.out.println("Tests Finished");
    }

    public void testFindGene(){
        String dna = "ATGCCCGGGAAATAACCC";
        String gene = findGene(dna);
        if(! gene.equals("ATGCCCGGGCCCTAA")){
            System.out.println("error")
        }
        System.out.println("tests finished")
    }

    public void printAllGenes(String dna){
        int startIndex = 0;

        while(true){
            
            String currentGene = findGene(dna,startIndex);

            if (currentGene.isEmpty()){
                break;
            }

            System.out.println(currentGene);

            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
    }

    public void textPrintAllGenes(){
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }

    public void testOn(String dna){
        System.out.println("Testing printAllGenes on " + dna);
        printAllGenes(dna); 
    }

    public StorageResource getAllGenes(String dna){
        
        StorageResource geneList = new StorageResource();

        int startIndex = 0;

        while(true){
            
            String currentGene = findGene(dna,startIndex);

            if (currentGene.isEmpty()){
                break;
            }

            geneList.add(currentGene);

            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return geneList;
    }

    public void textPrintAllGenes(){
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }

    public void testOn(String dna){
        System.out.println("Testing printAllGenes on " + dna);
        StorageResource genes = getAllGenes(dna);
        for (String g: genes.data){
            System.ou.println(g);
        }
    }

}


