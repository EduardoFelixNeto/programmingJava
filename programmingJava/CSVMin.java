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
        }
        return lowestSoFar;
    }
    public void testColdestInDay(){
        FileResource fr = new FileResource();
        CSVRecord lowest = coldestHourInFile(fr.getCSVParser());
        System.out.println("Coldest temperature was " + lowest.get("TemperatureF") + " at " + 
        lowest.get("DateUTC"));
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
            lowestTime = lowest.get("DateUTC");
        }
        System.out.println("Coldest temperature on that day was " + lowestTemp + " at " + 
            lowestTime);
    }
    public CSVRecord lowestHumidityInFile(CSVParser parser){
        CSVRecord lowestHumiditySoFar = null;
        for (CSVRecord currentRow : parser) {
            if (lowestHumiditySoFar == null) {
                lowestHumiditySoFar = currentRow;
            }
            else{
                if (currentRow.get("Humidity").equals("N/A")){
                    break;
                }
                double currentHumidityTemp = Double.parseDouble(currentRow.get("Humidity"));
                double lowestHumidityTemp = Double.parseDouble(lowestHumiditySoFar.get("Humidity"));
                if (currentHumidityTemp < lowestHumidityTemp){

                    lowestHumiditySoFar = currentRow;
                }
             }

        }
        return lowestHumiditySoFar;
    }
    public void testLowestHumidityInFile(){
        FileResource fr = new FileResource();
        CSVRecord lowest = lowestHumidityInFile(fr.getCSVParser());
        System.out.println("Lowest humidity was " + lowest.get("Humidity") + " at " + 
        lowest.get("DateUTC"));
    }
    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord lowestHumiditySoFar = null;
        DirectoryResource dr = new DirectoryResource();
        //iterate over files
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            //use method to get largest in File.
            CSVRecord currentRow = lowestHumidityInFile(fr.getCSVParser());
            if (lowestHumiditySoFar == null) {
                lowestHumiditySoFar = currentRow;
            }
            else{
                if (currentRow.get("Humidity").equals("N/A")){
                    break;
                }
                double currentHumidityTemp = Double.parseDouble(currentRow.get("Humidity"));
                double lowestHumidityTemp = Double.parseDouble(lowestHumiditySoFar.get("Humidity"));
                if (currentHumidityTemp < lowestHumidityTemp){

                    lowestHumiditySoFar = currentRow;
                }
            }
        }
        //The largestSoFar is the Answer
        return lowestHumiditySoFar;
    }
    public void testLowestHumidityInManyFiles() {
        CSVRecord lowest = lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity was " + lowest.get("Humidity") + " at " + 
        lowest.get("DateUTC")); 
    }
    public double averageTemperatureInFile(CSVParser parser){
        int count = 0;
        double sumTemperature = 0.0;
        // For each row (currentRow) in the CSV File
        for (CSVRecord currentRow : parser) {
                sumTemperature = sumTemperature + Double.parseDouble(currentRow.get("TemperatureF"));
                count = count + 1;
        }
        double avgTemperature = sumTemperature/count;
        return avgTemperature;
    }
    public void testAverageTemperatureInFile(){
        FileResource fr = new FileResource();
        double average = averageTemperatureInFile(fr.getCSVParser());
        System.out.println("Average temperature in file is " + average);
    }
    public double averageTemperatureWithHighHumidityinFile(CSVParser parser, int value){
        int count = 0;
        double sumTemperature = 0.0;
        for (CSVRecord currentRow : parser) {
            if (currentRow.get("Humidity").equals("N/A")){
                break;
            }
            double humidityTemp = Double.parseDouble(currentRow.get("Humidity"));
            if (humidityTemp >= value){
                sumTemperature = sumTemperature + Double.parseDouble(currentRow.get("TemperatureF"));
                count = count + 1;
            }
        }
        double avgTemperature = sumTemperature/count;
        return avgTemperature;
    }
    public void testAverageTemperatureWithHighHumidityinFile(){
        FileResource fr = new FileResource();
        double average = averageTemperatureWithHighHumidityinFile(fr.getCSVParser(), 80);
        if (average != 0){
        System.out.println("Average temperature in file is " + average);
        }
        else{
            System.out.println("No temperatures with that humidity");
        }
    }
}