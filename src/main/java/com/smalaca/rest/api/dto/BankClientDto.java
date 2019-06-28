package com.smalaca.rest.api.dto;

public class BankClientDto {
    private String pesel;
    private String amount;

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPesel() {
        return pesel;
    }

    public String getAmount() {
        return amount;
    }

}
