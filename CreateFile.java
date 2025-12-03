import java.io.FileWriter;
import java.io.IOException;


// Main class to create or append to a file based on its existence
public class CreateFile {
  public static void main(String[] args) {
    //writeToFile o1 = new writeToFile();
    //AppendToFile o2 = new AppendToFile();
    //checkiffileexcists o3 = new checkiffileexcists();
    //if (o3.CheckIfFileExists() == false) {
    //  o1.writeToFile();
    //} else {
    //  o2.AppendToFile();
    //}
  }
  
  // Write to file
  public static void writeToFile(String Firstname, String LastName, String Address, String PhoneNumber, String Email, String Hoursworked, String RateperHour) {
    try {
      FileWriter myWriter = new FileWriter("Data.txt");
      myWriter.write(String.format("Firstname: %s, Lastname: %s, Address: %s, Phonenumber:%s, Email: %s, Hoursworked: %s, Rateperhour: %s\n",
       Firstname, LastName, Address, PhoneNumber, Email, Hoursworked, RateperHour));
      myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
  
  // Append to file
  public static void AppendToFile(String Firstname, String LastName, String Address, String PhoneNumber, String Email, String Hoursworked, String RateperHour) {
    try (FileWriter myWriter = new FileWriter("Data.txt", true)) {
      myWriter.write(String.format("\nFirstname: %s, Lastname: %s, Address: %s, Phonenumber:%s, Email: %s, Hoursworked: %s, Rateperhour: %s",
      Firstname, LastName, Address, PhoneNumber, Email, Hoursworked, RateperHour));
      System.out.println("Successfully appended to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
  }
  }
  
  // Check if file exists
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