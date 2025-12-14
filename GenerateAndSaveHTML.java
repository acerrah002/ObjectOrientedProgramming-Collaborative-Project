import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter; 

public class GenerateAndSaveHTML {

    public static void generateAndSaveHtml(String name, String address, String phone, String email,String hoursWorked, String ratePerHour) {

        String userName = name;
        String addressV = address;
        String phoneV = phone;
        String emailV = email;

        String dateV = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));

        int hourVariable = Integer.parseInt(hoursWorked);
        double rateVariable = Double.parseDouble(ratePerHour);
        double totalVariable = hourVariable * rateVariable;

         String htmlContent = String.format(
                             "<!DOCTYPE html>\n" +
                             "<html>\n" +
                             "<head>\n" +
                             "    <title>My Generated HTML</title>\n" +
                             "</head>\n" +
                             "<body>\n" +
                             "    <h1>Hello %s from Java!</h1>\n" +
                             "    <p>Address: %s</p>\n" +
                             "    <p>Phone: %s</p>\n" +
                             "    <p>Email: %s</p>\n" +
                             "    <p>Date: %s</p>\n" +
                             "    <p>Hours Worked: %d</p>\n" +
                             "    <p>Rate Per Hour: $%.2f</p>\n" +
                             "<p>Total: $%.2f</p>\n" +
                             "</body>\n" +
                             "</html>",
            userName,
            addressV,
            phoneV,
            emailV,
            dateV,
            hourVariable,
            rateVariable,
            totalVariable
        );

        String outputFilename = "output.html";
        
        try (FileWriter writer = new FileWriter(outputFilename)) {
            writer.write(htmlContent);
            System.out.println("Success! HTML file created: " + outputFilename);
            System.out.println("You can open this file in any web browser to view the result.");
        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        generateAndSaveHtml("Jane Doe", "456 Commerce Drive, Suite 100", "555-9876", "jane.doe@consulting.com", "6969", "75.50");
    }
}