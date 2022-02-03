import edu.duke.*;
import org.apache.commons.csv.*;

public class BabyNames {
    public void readOneFile(int year){
    // Create a FileResource for yobXYZW.txt
    String fname = "data/yob" + year + ".txt";
    FileResource fr = new FileResource(fname);
    // Call getCSVParser(false) - no header row
    CSVParser parser = fr.getCSVParser(false);
        for (CSVRecord rec : parser){
        // Acess CSVRecord data by index: 0-based
            String name = rec.get(0);
            String gender = rec.get(1);
         }
    }
}
public class BabyBirths {
    public void printNames(){
        FileResource fr = new FileResource();
        for (CSVRescord rec : fr.getCSVParser(false)){
            int numBorn = Interger.parseInt(rec.get(2));
            if (numBorn <= 100){
                System.out.println("Name " + rec.get(0) + " Gender " + rec.get(1) + " Num Born " + rec.get(2));
            }
        } 
    }
    public void totalBirths (FileResource fr){
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int numOfGirls = 0;
        int numOfBoys = 0;
        int numOfBabys = 0;
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Interger.parseInt(rec.get(2));
            totalBirths += numBorn;
            numOfBabys += 1;
            if(rec.get(1).equals("M")){
                totalBoys += numBorn;
                numOfBoys += 1;
            }
            else{
                totalGirls += numBorn;
                numOfGirls += 1;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("total boys = " + totalBoys);
        System.out.println("total girls = " + totalGirls);
        System.out.println("number of girls = " + numOfGirls);
        System.out.println("number of boys = " + numOfBoys);
        System.out.println("number of babys = " + numOfBabys);
    }
    public void testTotalBirths(){
        FileResource fr = new FileResource();
        totalBirths(fr);
    }
    public void getRank(int year, String name, String gender){
        int rank = 0;
        FileResource fr = new FileResource("testing/yob" + year + "short.csv");
        for (CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(0).equals(name) && rec.get(1).equals(gender)){
                rank += 1;
            }
        }
        System.out.println("Given the " + year + ", the name " + name + " and the gender " + 
        gender + ", the number returned is " + rank);
    }
    public void testGetRank(){
        int year = 2012;
        String name = "Mason";
        String gender = "M";
        getRank(year,name,gender); 
    }

}
