package com.smalaca.bik.client.http;

import com.smalaca.rest.api.dto.BankClientDto;

import java.io.IOException;

class BikServiceConnectivyException extends RuntimeException {
    private final BankClientDto bankClientDto;
    private final IOException exception;

    BikServiceConnectivyException(BankClientDto bankClientDto, IOException exception) {
        this.bankClientDto = bankClientDto;
        this.exception = exception;
    }
}
