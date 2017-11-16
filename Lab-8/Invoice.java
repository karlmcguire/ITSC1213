public class Invoice {
    private String invoiceID;
    private String description;
    private double amount;
    private boolean isPaid;

    public Invoice() {
        invoiceID = description = "";
        amount = 0.0;
        isPaid = false;
    }

    public Invoice(String id, String desc, double amo, boolean paid) {
        invoiceID = id;
        description = desc;
        amount = amo;
        isPaid = paid;
    }

    public String getInvoiceID() {
        return invoiceID;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean val) {
        isPaid = val;
    }

    public void setAmount(double amo) {
        amount = amo;
    }

    public boolean equals(Invoice invoice) {
        return (invoiceID.equals(invoice.getInvoiceID()));
    }

    public int compareTo(Invoice invoice) {
        if(amount < invoice.getAmount())
            return -1;
        else if(amount == invoice.getAmount())
            return 0;
        else // amount > invoice.getAmount()
            return 1;
    }

    public String toString() {
        return "\tID: " + invoiceID + ", " +
               "Description: " + description + ", " +
               "Amount: " + amount + ", " +
               "Paid: " + isPaid;
    }
}
