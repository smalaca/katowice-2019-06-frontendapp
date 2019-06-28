package com.smalaca.bik;

import com.smalaca.rest.api.dto.BankClientDto;
import org.springframework.stereotype.Service;

@Service
public class FakeBikService implements BikService {
    @Override
    public boolean check(BankClientDto bankClientDto) {
        return "12345678901".equals(bankClientDto.getPesel());
    }
}
