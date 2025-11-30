
import java.io.FileWriter;
import java.io.IOException;


// Main class to create or append to a file based on its existence
public class CreateFile {
  public static void main(String[] args) {
    writeToFile o1 = new writeToFile();
    AppendToFile o2 = new AppendToFile();
    checkiffileexcists o3 = new checkiffileexcists();
    if (o3.CheckIfFileExists() == false) {
      o1.writeToFile();
    } else {
      o2.AppendToFile();
    }
  }
}


// Write to file
class writeToFile {
  public static void writeToFile() {
    try {
      FileWriter myWriter = new FileWriter("Data.txt");
      
      myWriter.write(String.format("Firstname: %s, Lastname: %s, Address: %s, Phonenumber:%s, Email: %s",
       "Luis", "Doe", "123 Main St", "555-1234", "john.doe@example.com"));
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}


// Append to file
class AppendToFile {
  public static void AppendToFile() {

    try (FileWriter myWriter = new FileWriter("Data.txt", true)) {
      myWriter.write(String.format("Firstname: %s, Lastname: %s, Address: %s, Phonenumber:%s, Email: %s",
       "John", "Mathew", "647 ErmSigma", "892-2222", "DispatchBestgame@gmail.com"));
      System.out.println("Successfully appended to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}

// Check if file exists
class checkiffileexcists {
  public static Boolean CheckIfFileExists() {
    java.io.File file = new java.io.File("Data.txt");
    if (file.exists()) {
      System.out.println("The file exists.");
      return true;
    } else {
      System.out.println("The file does not exist.");
      return false;
    }
  }
}