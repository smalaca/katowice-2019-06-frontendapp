package com.smalaca.rest.api.dto;

public class CreditStatus {
    private String status;

    public static CreditStatus success() {
        return new CreditStatus("SUCCESS");
    }

    CreditStatus() {}

    private CreditStatus(String status) {
        this.status = status;
    }

    public static CreditStatus fail() {
        return new CreditStatus("FAIL");
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
