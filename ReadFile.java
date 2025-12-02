import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFile {
  //Testing
  /* 
  public static void main(String[] args) {
    ArrayList<ArrayList<String>> allusers = getArrayList();
    int positionToRemove = 2;
    removeFromFile(positionToRemove);
    allusers = getArrayList();
    for (int i = 0; i < allusers.size(); i++) {
      System.out.println("User " + (i+1) + ": " + allusers.get(i));
    }
  }*/


  public static ArrayList<ArrayList<String>> getArrayList() {
    File myObj = new File("Data.txt");
    ArrayList<ArrayList<String>> allusers = new ArrayList<>();
    try (Scanner myReader = new Scanner(myObj)) {

      //This section reads line by line and on the line it seperates the commas
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        ArrayList<String> currentusers = new ArrayList<>();
        String[] parts = data.split(",");
        //This section seperates the colons so now you only get the values from the key value pairs
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

  //No work yet
  /* 
  public static void removeFromFile(int positionToRemove) {
    File myObj = new File("Data.txt");
    ArrayList<String> lines = new ArrayList<>();
    try (Scanner myReader = new Scanner(myObj)) {
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        lines.add(data);}
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    if (positionToRemove >= 0 && positionToRemove < lines.size()) {
      lines.remove(positionToRemove);
    }
    try {
      File myObjNew = new File("Data.txt");
      FileWriter writer = new FileWriter(myObjNew);
      for (String line : lines) {
        writer.write(line + "\n");
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }*/
}





