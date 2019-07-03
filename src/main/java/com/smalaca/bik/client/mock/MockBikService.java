package com.smalaca.bik.client.mock;

import com.google.common.collect.ImmutableMap;
import com.smalaca.bik.BikService;
import com.smalaca.credit.CreditGrantedScenario;
import com.smalaca.credit.CreditNotGrantedBikInvalidScenario;
import com.smalaca.rest.api.dto.BankClientDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Map;

@Profile("dev")
@Service
public class MockBikService implements BikService {
    private final Map<String, String> responses = ImmutableMap.of(
            CreditGrantedScenario.PESEL, CreditGrantedScenario.BIK_STATUS,
            CreditNotGrantedBikInvalidScenario.PESEL, CreditNotGrantedBikInvalidScenario.BIK_STATUS
    );

    @Override
    public String check(BankClientDto bankClientDto) {
        return responses.get(bankClientDto.getPesel());
    }
}
