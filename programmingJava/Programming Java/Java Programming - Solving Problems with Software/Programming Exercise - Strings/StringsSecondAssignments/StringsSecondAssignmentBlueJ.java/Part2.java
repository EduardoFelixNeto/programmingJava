
/**
 * Write a description of Part2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part2 {
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
