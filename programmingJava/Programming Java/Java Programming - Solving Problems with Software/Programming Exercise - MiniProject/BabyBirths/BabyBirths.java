import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.File;

public class BabyBirths {
    public void printNames(){
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)){
            int numBorn = Integer.parseInt(rec.get(2));
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
            int numBorn = Integer.parseInt(rec.get(2));
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
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob" + year + ".csv");
        for (CSVRecord rec : fr.getCSVParser(false)){
            if(rec.get(0).equals(name) && rec.get(1).equals(gender)){
                rank += 1;
            }
        }
        System.out.println("Given the year" + year + ", the name " + name + " and the gender " + 
        gender + ", the number returned is " + rank);
    }
    public void testGetRank(){
        int year = 1960;
        String name = "Emily";
        String gender = "F";
        getRank(year,name,gender); 
    }
    public void getName(int year, int rank, String gender){
        int count = rank;
        String name = null;
        FileResource fr = new FileResource("testing/yob" + year + "short.csv");
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(1).equals(gender)){
            count += 1;
            name = rec.get(0);
            }
            if (count > rank){
                break;
            }
        }
        System.out.println("The baby name in the file at rank " + rank + 
        ", for the gender " + gender + " is " + name);
    }
    public void testGetName(){
        int year = 2012;
        int rank = 1;
        String gender = "M";
        getName(year,rank,gender); 
    }
    public void whatIsNameInYear(String name, int year, int newYear, String gender){
        int count = 0;
        int rank = 0;
        String newName = null;
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob" + year + ".csv");
        for (CSVRecord rec : fr.getCSVParser(false)){
            if (rec.get(0).equals(name) && rec.get(1).equals(gender)){
                break;
            }
            else{
            count += 1;
            }
        }
        FileResource f = new FileResource("us_babynames/us_babynames_by_year/yob" + newYear + ".csv");
        for (CSVRecord record : f.getCSVParser(false)){
            if (record.get(1).equals(gender)){
                rank += 1;
                newName = record.get(0);
                }
                if (count < rank){
                    break;
                }
        }
        System.out.println(name + " born in " + year + " would be " + 
        newName + " is he was born in " + newYear);
    }
    public void testWhatIsNameInYear(){
        String name = "Owen";
        int year = 1974;
        int newYear = 2014;
        String gender = "M";
        whatIsNameInYear(name,year,newYear,gender);

    }
    public String yearOfHighestRank(String name, String gender){
        int count = 0;
        int rank = 0;
        String filename = null;
        DirectoryResource dr = new DirectoryResource();
        //iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            //use method to get highest in File.
            for (CSVRecord record : fr.getCSVParser(false)){
                if (record.get(0).equals(name) && record.get(1).equals(gender)){
                    break;
                }else{
                count += 1;
                }
            }
            if (rank == 0){
                filename = f.getName();
                rank = count;
                count = 0;
            }
            else{
                if (count < rank){
                filename = f.getName();
                rank = count;
                }
                count = 0;
            }
        }
        //The largestSoFar is the Answer
        return filename;
    }
    public void testYearOfHighestRank(){
        String name = "Mich";
        String gender = "M";
        String file = yearOfHighestRank(name,gender);
        System.out.println(file);
    }
    //Write the method getAverageRank that has two parameters: a string name, and a string named gender (F for female and M for male). 
    //This method selects a range of files to process and returns a double representing the average rank of the name and gender over the selected files. 
    //It should return -1.0 if the name is not ranked in any of the selected files. 
    //For example calling getAverageRank with name Mason and gender ‘M’ and selecting the three test files above results in returning 3.0, as he is rank 2 in the year 2012, 
    //rank 4 in 2013 and rank 3 in 2014.  As another example, calling   getAverageRank with name Jacob and gender ‘M’ and selecting the three test files above results in returning 2.66.

    public double getAverageRank (String name, String gender) {
        double count = 0.0;
        double rank = 0.0;
        double count1 = 0.0;
        String filename = null;
        DirectoryResource dr = new DirectoryResource();
        //iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            //use method to get highest in File.
            for (CSVRecord record : fr.getCSVParser(false)){
               if (record.get(1).equals(gender)){
                    count += 1.0;
               }
               if(record.get(0).equals(name) && record.get(1).equals(gender)){
                    break;
               }
            }
            rank += count;
            count1 += 1.0;
            count = 0.0;
        }
        double avg = rank/count1;
        //The largestSoFar is the Answer
        return avg;
    }
    public void testGetAverageRank (){
        String name = "Robert";
        String gender = "M";
        double average = getAverageRank(name,gender);
        System.out.println(average);
    }
}

