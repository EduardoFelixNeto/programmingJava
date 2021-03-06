import edu.duke.*;
import java.io.File;

public class usingStorageResource{
    public void processGenes(StorageResource sr){
        FileResource fr = new FileResource("brca1line.fa");
        String dna = fr.asString();
        int answer = countGenes(dna);
        System.out.println(answer);
    }
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
    public int countGenes(String dna){
        int startIndex = 0;
        int count = 0;
        while(true){
            String currentGene = findGene(dna,startIndex);
            if (currentGene.isEmpty()){
                break;
            }
            count = count + 1;
            startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
        }
        return count;
    }
    public void testCountGenes(){
        FileResource fr = new FileResource();
        String dna = fr.asString();
        int test = countGenes(dna);
        System.out.println(test);
}
}