package Builder;

import APIs.invoiceHTMLBuilderAPI;
import Models.invoiceHTMLContent;

public class invoiceHTMLBuilder implements invoiceHTMLBuilderAPI {
    private invoiceHTMLContent invoiceHTML = new invoiceHTMLContent();

    @Override
    public void build_userName(String userName) {
        invoiceHTML.setUserName(userName);
    }

    @Override
    public void build_addressV(String addressV) {
        invoiceHTML.setAddressV(addressV);
    }

    @Override
    public void build_phoneV(String phoneV) {
        invoiceHTML.setPhoneV(phoneV);
    }

    @Override
    public void build_emailV(String emailV) {
        invoiceHTML.setEmailV(emailV);
    }

    @Override
    public void build_dateV(String dateV) {
        invoiceHTML.setDateV(dateV);
    }

    @Override
    public void build_hourVariable(int hourVariable) {
        invoiceHTML.setHourVariable(hourVariable);
    }

    @Override
    public void build_rateVariable(double rateVariable) {
        invoiceHTML.setRateVariable(rateVariable);
    }

    @Override
    public void build_totalVariable(double totalVariable) {
        invoiceHTML.setTotalVariable(totalVariable);
    }

    @Override
    public void build_htmlContent() {
        invoiceHTML.setHtmlResult();
    }

    @Override
    public invoiceHTMLContent getResult() {
        return invoiceHTML;
    }
}
