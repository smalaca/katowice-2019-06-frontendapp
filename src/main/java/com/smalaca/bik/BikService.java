package com.smalaca.bik;

import com.smalaca.rest.api.dto.BankClientDto;

public interface BikService {
    boolean check(BankClientDto bankClientDto);
}
