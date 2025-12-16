package Builder;

public class invoiceDirector {
    private String userName;
    private String addressV;
    private String phoneV;
    private String emailV;
    private String dateV;
    private int hourVariable;
    private double rateVariable;
    private double totalVariable;

    public void getInformation(String userName, String addressV, String phoneV, String emailV, String dateV, int hourVariable, double rateVariable, double totalVariable)
    {
        this.userName = userName;
        this.addressV = addressV;
        this.phoneV = phoneV;
        this.emailV = emailV;
        this.dateV = dateV;
        this.hourVariable = hourVariable;
        this.rateVariable = rateVariable;
        this.totalVariable = totalVariable;
    }

    public void construct(invoiceHTMLBuilder builder)
    {
        builder.build_userName(userName);
        builder.build_addressV(addressV);
        builder.build_phoneV(phoneV);
        builder.build_emailV(emailV);
        builder.build_dateV(dateV);
        builder.build_hourVariable(hourVariable);
        builder.build_rateVariable(rateVariable);
        builder.build_totalVariable(totalVariable);
        builder.build_htmlContent();
    }
}
