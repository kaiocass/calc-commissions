package org.technical.test.model;

public class Transfer {

    private String accountID;
    private String transferID;
    private double totalTransferAmount;

    public Transfer(String accountID, String transferID, double totalTransferAmount) {
        this.accountID = accountID;
        this.transferID = transferID;
        this.totalTransferAmount = totalTransferAmount;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getTransferID() {
        return transferID;
    }

    public void setTransferID(String transferID) {
        this.transferID = transferID;
    }

    public double getTotalTransferAmount() {
        return totalTransferAmount;
    }

    public void setTotalTransferAmount(double totalTransferAmount) {
        this.totalTransferAmount = totalTransferAmount;
    }
}
