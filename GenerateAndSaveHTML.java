import Builder.invoiceDirector;
import Builder.invoiceHTMLBuilder;
import Models.htmlContent;

import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter; 

public class GenerateAndSaveHTML {

    public static void generateAndSaveHtml(String name, String address, String phone, String email,String hoursWorked, String ratePerHour) {

        // Processing some information given.
        String dateV = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
        int hourVariable = Integer.parseInt(hoursWorked);
        double rateVariable = Double.parseDouble(ratePerHour);
        double totalVariable = hourVariable * rateVariable;

        // Client request being served.
        invoiceHTMLBuilder invoiceBuilder = new invoiceHTMLBuilder();
        invoiceDirector director = new invoiceDirector();
        director.getInformation(name, address, phone, email, dateV, hourVariable, rateVariable, totalVariable);
        director.construct(invoiceBuilder);
        htmlContent invoiceHTML = invoiceBuilder.getResult();

//        String userName = name;
//        String addressV = address;
//        String phoneV = phone;
//        String emailV = email;
//
//        String dateV = java.time.LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
//
//        int hourVariable = Integer.parseInt(hoursWorked);
//        double rateVariable = Double.parseDouble(ratePerHour);
//        double totalVariable = hourVariable * rateVariable;
//
//        String htmlContent = """
//<!DOCTYPE html>
//<html lang="en">
//<head>
//    <meta charset="UTF-8">
//    <meta name="viewport" content="width=device-width, initial-scale=1.0">
//    <title>Invoice Document</title>
//</head>
//<body>
//    <h1>Invoice for %s</h1>
//    <p><strong>Address:</strong> %s</p>
//    <p><strong>Phone:</strong> %s</p>
//    <p><strong>Email:</strong> %s</p>
//    <p><strong>Date:</strong> %s</p>
//    <p><strong>Hours Worked:</strong> %d</p>
//    <p><strong>Rate Per Hour:</strong> $%.2f</p>
//    <h2>Total: $%.2f</h2>
//</body>
//</html>
//                """.formatted(userName, addressV, phoneV, emailV, dateV, hourVariable, rateVariable, totalVariable);

        String outputFilename = "output.html";
        
        try (FileWriter writer = new FileWriter(outputFilename)) {
            writer.write(invoiceHTML.getHtmlContent());
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