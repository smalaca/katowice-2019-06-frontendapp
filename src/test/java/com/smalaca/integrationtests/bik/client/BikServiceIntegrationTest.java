package com.smalaca.integrationtests.bik.client;

import com.smalaca.bik.BikService;
import com.smalaca.bik.client.http.HttpBikService;
import com.smalaca.credit.CreditGrantedScenario;
import com.smalaca.credit.CreditNotGrantedBikInvalidScenario;
import com.smalaca.rest.api.dto.BankClientDto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BikServiceIntegrationTest {
    private final BikService serviceClient = new HttpBikService();

    @Test
    public void shouldRecognizeClientWithValidBikHistory() {
        BankClientDto bankClientDto = aBankClientDto(CreditGrantedScenario.PESEL);

        String result = serviceClient.check(bankClientDto);

        assertThat(result).isEqualTo(CreditGrantedScenario.BIK_STATUS);
    }

    @Test
    public void shouldRecognizeClientWithInValidBikHistory() {
        BankClientDto bankClientDto = aBankClientDto(CreditNotGrantedBikInvalidScenario.PESEL);

        String result = serviceClient.check(bankClientDto);

        assertThat(result).isEqualTo(CreditNotGrantedBikInvalidScenario.BIK_STATUS);
    }

    private BankClientDto aBankClientDto(String pesel) {
        BankClientDto bankClientDto = new BankClientDto();
        bankClientDto.setPesel(pesel);
        return bankClientDto;
    }
}