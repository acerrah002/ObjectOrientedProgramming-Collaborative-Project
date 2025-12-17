package Visitor;

import Models.invoiceHTMLContent;

public interface InvoiceVisitor {
    void visit(invoiceHTMLContent invoice);
}
