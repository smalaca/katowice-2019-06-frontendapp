package com.smalaca.bik.client.http;

import com.smalaca.bik.BikService;
import com.smalaca.rest.api.dto.BankClientDto;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Profile("prod")
@Service
public class HttpBikService implements BikService {
    @Override
    public String check(BankClientDto bankClientDto) {
        HttpGet httpGet = new HttpGet("http://localhost:8002/history/" + bankClientDto.getPesel());

        HttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpEntity entity = httpClient.execute(httpGet).getEntity();
            return EntityUtils.toString(entity);
        } catch (IOException exception) {
            throw new BikServiceConnectivyException(bankClientDto, exception);
        }
    }
}
