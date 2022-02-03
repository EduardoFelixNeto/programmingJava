import edu.duke.*;
public class Part1{
    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int stopIndex = dna.indexOf(stopCodon,startIndex + 3);
        if (stopIndex == -1){
            return dna.length();
        }
        else{
        return stopIndex;
        }
    }
    public String findGene(String dna, int where){
        int minIndex = -1;
        int closestIndex = -1;
        int startIndex = dna.indexOf("ATG", where);
        if (startIndex == -1){
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }
        if (tgaIndex == -1 || (taaIndex != -1 && taaIndex < tgaIndex)){
            minIndex = taaIndex;
        }
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)){
            closestIndex = tagIndex;
        }
        else{
            closestIndex = minIndex;
        }
        if ((closestIndex - startIndex) % 3 == 0){
            return dna.substring(startIndex, closestIndex + 3);
        }
        else{
            return "";
        }
    }
    public void testFindStopCodon(){
        //String dna = "ATCTTTGAGTCTAA";
        //String dna = "TGTATGGGTAGT";
        //String dna = "TTGGTACGATAC";
        //String dna = "ATGGGGTTTCCCAAATAAGTCTCA";
        String dna = "ATGGTAGTTCCTAA";
        int startIndex = 0;
        String stopCodon = "TAA";
        int test = findStopCodon(dna, startIndex, stopCodon);
        System.out.println(test);
    }
    //public void testFindGene(){
        //String dna = "ATGGGGTTTCCTAA";
        //String dna = "ATGTTTCCCAAATGA";
        //String dna = "ATGCCCAAATTTTAG";
        //String dna = "ATGGGGTTTAAA";
        //String dna = "GGGTTTAAA";
        //String test = findGene(dna);
        //System.out.println(test);
    //}
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
    public void testOn(String dna){
        System.out.println("Testing printAllGenes on " + dna);
        StorageResource gene = getAllGenes(dna);
        for(String g: gene.data()){
            System.out.println(g);
        }
    }
    public void test(){
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATCCGAAGATAATAGAGGGCCATGTAA");
    }
    public StorageResource getAllGenes(String dna){
        StorageResource sr = new StorageResource();
        int startIndex = 0;
        while(true){
            String currentGene = findGene(dna,startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            sr.add(currentGene);
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return sr;
    }
    public float cgRatio(String dna){
        int startIndexC = dna.indexOf("C");
        int startIndexG = dna.indexOf("G");
        int countc = 0;
        int countg = 0;
        while(true){
            countc = countc + 1;
            String currentStringC = dna.substring(startIndexC);
            if (currentStringC.isEmpty()){
                break;
            }
            startIndexC = dna.indexOf(currentStringC, startIndexC) + 1;
        }
        while(true){
            countg = countg + 1;
            String currentStringG = dna.substring(startIndexG);
            if (currentStringG.isEmpty()){
                break;
            }
            startIndexG = dna.indexOf(currentStringG, startIndexG) + 1;
        }
        float ans = (((float)(countc + countg))/dna.length())-1;
        return ans;
    }
    public void testCgRatio(){
        String dna = "ATGCCCGGGT";
        float test = cgRatio(dna);
        System.out.println(test);
    }
    public int countCTG(String dna){
        int startIndex = dna.indexOf("CTG");
        int count = 0;
        while(true){
            String currentctg = dna.substring(startIndex);
            if (currentctg.isEmpty()){
                break;
            }
            count = count + 1;
            startIndex = dna.indexOf("CTG", startIndex) + 3;
        }
        return count;
    }
    public void testCountCTG(){
        String dna = "CTGATGCCCTGCGGCTCCTG";
        int test = countCTG(dna);
        System.out.println(test);
    }
}