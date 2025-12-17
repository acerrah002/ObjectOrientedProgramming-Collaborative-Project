package Visitor;

import Models.invoiceHTMLContent;
// Goal: Add operations on invoiceHTMLContent without modifying its core logic.
public interface InvoiceVisitor {
    void visit(invoiceHTMLContent invoice);
}
