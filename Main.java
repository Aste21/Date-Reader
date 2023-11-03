import java.io.IOException;

public class Main { //z main jest poroblem 
    public static void main(String[] args){
        try{
            int rewrittenDates = FileDataConverter.fileDataConvert("InputData.txt", "MyData.txt");
            System.out.println("Number of rewritten dates: " + rewrittenDates);
        }catch(IOException e){
            System.out.println("IOException ensasd");
        }
    }
}
 
