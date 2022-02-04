import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest){
        //for each row in the CSV File
        for (CSVRecord record : parser) {
            //Look at the "Exports" column
            String export = record.get("Exports");
            // Check if it countains exportOfInterest
            if (export.contains(exportOfInterest)){
                    //If so, write down the "Country" from that row
                    String country = record.get("Country");
                    System.out.println(country);
            }
        }

    }
    public void whoExportsCoffee(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }
    public void countryInfo(CSVParser parser, String country){
         //for each row in the CSV File
         for (CSVRecord record : parser) {
            //Look at the "Country" column
            String place = record.get("Country");
            // Check if it countains exportOfInterest
            if (place.contains(country)){
                    //If so, write down the Info from that intire row
                    String exports = record.get("Exports");
                    String value = record.get("Value (dollars)");
                    System.out.println(place + ": " + exports + ": " + value);
            }
        }
    }
    public void testCountryInfo(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        countryInfo(parser, "Nauru");
    }
    public void listExportersTwoProducts(CSVParser parser, String exportItem,String exportItem2){
        for (CSVRecord record : parser) {
            String item = record.get("Exports");
            if (item.contains(exportItem)){
                if (item.contains(exportItem2)){
                    String country = record.get("Country");
                    System.out.println(country);
                }

            }
        }
    }
    public void testListExportersTwoProducts(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "cotton", "flowers");
    }
    public void numberOfExporters(CSVParser parser, String exportItem){
        int count = 0;
        for (CSVRecord record : parser) {
            String item = record.get("Exports");
            if (item.contains(exportItem)){
                count = count + 1;
            }
        }
        System.out.println(count);
    }
    public void testNumberOfExporters(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        numberOfExporters(parser, "cocoa");
    }
    public void bigExporters(CSVParser parser, String amount){
        for (CSVRecord record : parser){
            String dollars = record.get("Value (dollars)");
            if (dollars.length() > amount.length()){
                String country = record.get("Country");
                System.out.println(country + " " + dollars);
            }
        }
    }
    public void testBigExporters(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");
    }
}
