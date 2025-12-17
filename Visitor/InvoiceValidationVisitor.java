package Visitor;

import Models.invoiceHTMLContent;

public class InvoiceValidationVisitor implements InvoiceVisitor {

    @Override
    public void visit(invoiceHTMLContent invoice) {
        if (invoice.getHtmlContent().isEmpty()) {
            throw new IllegalStateException("Invoice HTML is empty");
        }
    }
}

