package com.thoughtworks.tdd;

import java.util.UUID;

public class Receipt {
    public UUID getReceipt() {
        return receipt;
    }

    public void setReceipt(UUID receipt) {
        this.receipt = receipt;
    }

    public Receipt(UUID receipt) {
        this.receipt = receipt;
    }
    public Receipt() {
    }

//    UUID receipt = UUID.randomUUID();
    private UUID receipt ;
//    String randomUUIDString = receipt.toString();
}
