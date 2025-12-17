package Chain;

public class ValidationHandler extends InvoiceHandler {

    @Override
    public void handle(InvoiceRequest request) {
        if (request.name == null || request.name.isEmpty()) {
            throw new IllegalStateException("Invalid name");
        }
        if (next != null) next.handle(request);
    }
}
