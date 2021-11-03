package model;

public class HistoryRentBike {
    private int barcode;
    private int transactionRentBikeId;
    private int transactionReturnBikeId;

    public HistoryRentBike() {
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public int getTransactionRentBikeId() {
        return transactionRentBikeId;
    }

    public void setTransactionRentBikeId(int transactionRentBikeId) {
        this.transactionRentBikeId = transactionRentBikeId;
    }

    public int getTransactionReturnBikeId() {
        return transactionReturnBikeId;
    }

    public void setTransactionReturnBikeId(int transactionReturnBikeId) {
        this.transactionReturnBikeId = transactionReturnBikeId;
    }
}
