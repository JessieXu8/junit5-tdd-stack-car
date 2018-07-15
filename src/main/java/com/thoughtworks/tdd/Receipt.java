package com.thoughtworks.tdd;

import java.util.UUID;

public class Receipt {

    public Receipt() {
        UUID uuid = UUID.randomUUID();
        this.receipt = uuid.toString();
    }

    public Receipt(String receipt) {
        this.receipt = receipt;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    private String receipt ;
}
