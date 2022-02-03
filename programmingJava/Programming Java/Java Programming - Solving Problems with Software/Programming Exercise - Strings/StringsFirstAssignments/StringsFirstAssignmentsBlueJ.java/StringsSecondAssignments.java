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
        printAllGenes(dna);
    }
    public void test(){
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATCCGAAGATAATAGAGGGCCATGTAA");
    }
}
public class Part2(){
    public int howMany(String stringa, String stringb){
        int startIndex = stringb.indexOf(stringa);
        int count = 0;
        while(true){
            count = count + 1;
            String currentString = stringb.substring(startIndex, stringa.length() + 1);
            if (currentString.isEmpty()){
                break;
            }
            startIndex = stringb.indexOf(currentString, startIndex) + currentString.length();
        }
        return count;
    }
    public void testHowMany(){
        String stringa = "AA";
        String stringb = "ATAAAA";
        int countAA = howMany(stringa,stringb);
        System.out.println(countAA);
    }
}
public class Part3(){
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
    public int countGenes(String dna){
        int startIndex = 0;
        int count = 0;
        while(true){
            String currentGene = findGene(dna,startIndex);
            if (currentGene,isEmpty()){
                break;
            }
            count = count + 1;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return count;
    }
    public void testCountGenes(){
        String dna = "ATGTAAGATGCCCTAGT"
        int test = countGenes(dna);
        System.out.println(test);
    }
}