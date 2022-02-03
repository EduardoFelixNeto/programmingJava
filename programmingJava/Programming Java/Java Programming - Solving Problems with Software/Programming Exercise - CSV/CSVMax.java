import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class CSVMax {
    public CSVRecord hottestHourInFile(CSVParser parser){
        // start with largestSoFar as nothing
        CSVRecord largestSoFar = null;
        // For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            //If largestSoFar is nothing
           largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
            }
        }
        //The largestSoFar is the answer
        return largestSoFar;
    }
    public void testHottestInDay(){
        FileResource fr = new FileResource();
        CSVRecord largest = hottestHourInFile(fr.getCSVParser());
        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + largest.get("TimeEST"));
    }
    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        //iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            //use method to get largest in File.
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        //The largestSoFar is the Answer
        return largestSoFar;
    }
    public void testHottestInManyDays() {
        CSVRecord largest = hottestInManyDays();
        System.out.println("hottest temperature was " + largest.get("TemperatureF") + " at " + 
        largest.get("DateUTC"));
    }

    public CSVRecord getLargestOfTwo (CSVRecord currentRow, CSVRecord largestSoFar){
        if (largestSoFar == null) {
            largestSoFar = currentRow;
        }
        else{
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            //Check if currentRow's temperature > largestSoFar
            if (currentTemp > largestTemp){
                //If so update largestSoFar to currentRow
                largestSoFar = currentRow;
            }
        }
    }
}
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;


public class CSVMin {
    public CSVRecord coldestHourInFile(CSVParser parser){
        // start with largestSoFar as nothing
        CSVRecord lowestSoFar = null;
        // For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
            //If largestSoFar is nothing
            if (lowestSoFar == null) {
                lowestSoFar = currentRow;
            }
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                //Check if currentRow's temperature > largestSoFar
                if (currentTemp < lowestTemp){
                    //If so update largestSoFar to currentRow
                    lowestSoFar = currentRow;
                }
             }
        //The largestSoFar is the answer
        }
        return lowestSoFar;

    
    }
    public void testColdestInDay(){
        FileResource fr = new FileResource();
        CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature was " + lowest.get("TemperatureF") + " at " + 
        lowest.get("TimeEST"));
    }
    public String fileWithColdestTemperature(){
        CSVRecord lowestSoFar = null;
        String filename = null;
        DirectoryResource dr = new DirectoryResource();
        //iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            //use method to get lowest in File.
            CSVRecord currentRow = coldestHourInFile(fr.getCSVParser());
            if (lowestSoFar == null) {
                lowestSoFar = currentRow;
                filename = f.getName();
            }
            else{
                double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
                double lowestTemp = Double.parseDouble(lowestSoFar.get("TemperatureF"));
                //Check if currentRow's temperature > largestSoFar
                if (currentTemp < lowestTemp){
                    //If so update largestSoFar to currentRow
                    lowestSoFar = currentRow;
                    filename = f.getName();
                }
            }
        }
        //The largestSoFar is the Answer
        return filename;
    }
    public void testFileWithColdestTemperature(){
        String name = fileWithColdestTemperature();
        System.out.println("Coldest day was in file " + name);
        String lowestTemp = null;
        String lowestTime = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
            CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
            lowestTemp = lowest.get("TemperatureF");
            lowestTime = lowest.get("TimeEST");
        }
        System.out.println("Coldest temperature on that day was " + lowestTemp + " at " + 
            lowestTime);
    }
}