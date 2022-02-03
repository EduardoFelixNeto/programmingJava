import edu.duke.*;
import org.apache.commons.csv.*; // Open source libary for CSVParser

public class FirstCSVExample {

    public void readFood(){
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        for(CSVRecord record : parser){
            System.out.print(record.get("Name") + " ");
            System.out.print(record.get("Farovite Color") + " ");
            System.out.println(record.get("Favorite Food"));
        }
    }
}