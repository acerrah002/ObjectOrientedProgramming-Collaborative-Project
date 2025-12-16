package Models;

public class invoiceHTMLContent extends htmlContent {

    private String userName;
    private String addressV;
    private String phoneV;
    private String emailV;
    private String dateV;
    private int hourVariable;
    private double rateVariable;
    private double totalVariable;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAddressV(String addressV) {
        this.addressV = addressV;
    }

    public void setPhoneV(String phoneV) {
        this.phoneV = phoneV;
    }

    public void setEmailV(String emailV) {
        this.emailV = emailV;
    }

    public void setDateV(String dateV) {
        this.dateV = dateV;
    }

    public void setHourVariable(int hourVariable) {
        this.hourVariable = hourVariable;
    }

    public void setRateVariable(double rateVariable) {
        this.rateVariable = rateVariable;
    }

    public void setTotalVariable(double totalVariable) {
        this.totalVariable = totalVariable;
    }

    @Override
    public void setHtmlContent()
    {
        /*
        While using the default way, it allows for more possible information to be added to the HTML if needed such as any big computations can be made above it.
         */
        this.setHtmlContentDefaultWay("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Invoice Document</title>
                </head>
                <body>
                    <h1>Invoice for %s</h1>
                    <p><strong>Address:</strong> %s</p>
                    <p><strong>Phone:</strong> %s</p>
                    <p><strong>Email:</strong> %s</p>
                    <p><strong>Date:</strong> %s</p>
                    <p><strong>Hours Worked:</strong> %d</p>
                    <p><strong>Rate Per Hour:</strong> $%.2f</p>
                    <h2>Total: $%.2f</h2>
                </body>
                </html>
                """.formatted(this.userName, addressV, phoneV, emailV, dateV, hourVariable, rateVariable, totalVariable));
    }
}
