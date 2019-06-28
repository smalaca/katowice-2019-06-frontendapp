package com.smalaca.rest.api.dto;

public class CreditResponse {
    private String id;

    public CreditResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
