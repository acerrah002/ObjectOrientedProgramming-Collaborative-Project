import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;           

public class ReadFile {
  public static void main(String[] args) {
  }
}

class ReadingFileArrayList{
  public static ArrayList<ArrayList<String>> getArrayList() {
    File myObj = new File("Data.txt");
     ArrayList<ArrayList<String>> allusers = new ArrayList<ArrayList<String>>();

    try (Scanner myReader = new Scanner(myObj)) {
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        ArrayList<String> currentusers = new ArrayList<String>();
        String[] parts = data.split(",");
        for (String i : parts) {
          String[] keyValue = i.split(":");
          currentusers.add(keyValue[1].trim());
        }
        allusers.add(currentusers);
      }
      
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred."); 
      e.printStackTrace();
    }
    return allusers;
  }
}





