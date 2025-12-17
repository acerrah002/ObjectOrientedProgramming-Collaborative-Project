package Visitor;

import Models.invoiceHTMLContent;

public class InvoicePrintVisitor implements InvoiceVisitor {

    @Override
    public void visit(invoiceHTMLContent invoice) {
        System.out.println("Invoice HTML:");
        System.out.println(invoice.getHtmlContent());
    }
}
