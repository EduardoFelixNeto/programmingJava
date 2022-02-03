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
    public void testfindStopCodon(){
        //String dna = "ATCTTTGAGTCTAA";
        //String dna = "TGTATGGGTAGT";
        //String dna = "TTGGTACGATAC";
        //String dna = "ATGGGGTTTCCCAAATAAGTCTCA";
        String dna = "ATGGTAGTTCCTAA";
        int startIndex = 0;
        String stopCodon = "TAA";
        int test = findStopCodon(dna, startIndex, stopCodon);
    }
}