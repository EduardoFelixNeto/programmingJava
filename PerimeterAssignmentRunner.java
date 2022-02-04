import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
        int count=0;
        for (Point p : s.getPoints()){
            count = count + 1;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        // Put code here
        double sidesLengths = getPerimeter(s);
        int numberSides = getNumPoints(s);
        //(Sum of all sides lengths) / (number of sides)
        double avg = sidesLengths/numberSides;
        //Number of sides is equal to the number of points ia a two dimensional shape.
        return avg;
    }

    public double getLargestSide(Shape s) {
        // Put code here
        //The length of a side of a shape is the distance between two points of the shape
        double largestSide = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()){
            double currDist = prevPt.distance(currPt);
            if (currDist > largestSide){
                largestSide = currDist;
                prevPt = currPt;
            }
        }
        return largestSide;
    }

    public double getLargestX(Shape s) {
        // Put code here
        Point prevPt = s.getLastPoint();
        double lgx = prevPt.getX();
        for (Point currPt : s.getPoints() ){
            double currx = currPt.getX();
            if (currx > lgx){
                lgx = currx;
            }
        }
        return lgx;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
        double lgstPerimeter = 0.0;
        // Creates a DirectoryResource and then iterates over these files.
        DirectoryResource dr = new DirectoryResource();
        // For each file f, it converts the file into a FileResource with the line FileResource fr = new FileResource(f);
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
        // Then it should create a shape from the FileResource
            Shape s = new Shape(fr);
        // Calculate that shape's perimeter
            double currlgstPerimeter = getPerimeter(s);
            if (currlgstPerimeter > lgstPerimeter){
                lgstPerimeter = currlgstPerimeter;
            }
        }
        // Return the largest perimeter over all the shapes in the files you've selected.
        return lgstPerimeter;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File temp = null;    // replace this code
         // Put code here
        double lgstPerimeter = 0.0;
        // Creates a DirectoryResource and then iterates over these files.
        DirectoryResource dr = new DirectoryResource();
        // For each file f, it converts the file into a FileResource with the line FileResource fr = new FileResource(f);
        for (File f : dr.selectedFiles()){
            FileResource fr = new FileResource(f);
        // Then it should create a shape from the FileResource
            Shape s = new Shape(fr);
        // Calculate that shape's perimeter
            double currlgstPerimeter = getPerimeter(s);
            if (currlgstPerimeter > lgstPerimeter){
                lgstPerimeter = currlgstPerimeter;
                temp = f;
            }
        }
        String filename = temp.getName();
        // Return the string type value that represents the filename which contains the shape with the largest Perimeter.
        return filename;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int numPoints = getNumPoints(s);
        System.out.println("Number of Points = " + numPoints);
        double avglen = getAverageLength(s);
        System.out.println("Average length of sides = " + avglen);
        double largestLenghtSide = getLargestSide(s);
        System.out.println("Largest Side = " + largestLenghtSide);
        double larx = getLargestX(s);
        System.out.println("Largest X = " + larx);

    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
        // Call getLargestPerimeterMultipleFiles and to print out the largest such perimeter
        double outputLgstPerimeter = getLargestPerimeterMultipleFiles();
        System.out.println("The largest Perimeter in these files is = " + outputLgstPerimeter);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
        // Creates its own DirectoryResource
        String outputFileLgstPerimeter = getFileWithLargestPerimeter();
        System.out.println("The File with the Largest Perimeter is = " + outputFileLgstPerimeter);
        // This new method should return the name of the file that has the largest such perimeter, so it returns type string.
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testFileWithLargestPerimeter();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}
