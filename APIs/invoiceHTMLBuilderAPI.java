package APIs;

import Models.invoiceHTMLContent;

public interface invoiceHTMLBuilderAPI {
    void build_userName(String userName);
    void build_addressV(String addressV);
    void build_phoneV(String phoneV);
    void build_emailV(String emailV);
    void build_dateV(String dateV);
    void build_hourVariable(int hourVariable);
    void build_rateVariable(double rateVariable);
    void build_totalVariable(double totalVariable);
    void build_htmlContent();

    invoiceHTMLContent getResult();
}
