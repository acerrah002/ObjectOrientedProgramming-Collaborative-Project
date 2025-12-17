package Chain;

import Builder.invoiceDirector;
import Builder.invoiceHTMLBuilder;

public class BuildInvoiceHandler extends InvoiceHandler {

    @Override
    public void handle(InvoiceRequest request) {
        invoiceHTMLBuilder builder = new invoiceHTMLBuilder();
        invoiceDirector director = invoiceDirector.getInstance();

        director.getInformation(
                request.name,
                request.address,
                request.phone,
                request.email,
                java.time.LocalDate.now().toString(),
                request.hours,
                request.rate,
                request.hours * request.rate
        );

        director.construct(builder);

        if (next != null) next.handle(request);
    }
}
