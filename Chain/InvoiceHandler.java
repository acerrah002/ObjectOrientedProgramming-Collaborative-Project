package Chain;

public abstract class InvoiceHandler {

    protected InvoiceHandler next;

    public void setNext(InvoiceHandler next) {
        this.next = next;
    }

    public abstract void handle(InvoiceRequest request);
}
