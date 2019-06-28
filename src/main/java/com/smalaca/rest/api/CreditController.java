package com.smalaca.rest.api;

import com.smalaca.bik.BikService;
import com.smalaca.rest.api.dto.BankClientDto;
import com.smalaca.rest.api.dto.CreditResponse;
import com.smalaca.rest.api.dto.CreditStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/credit")
public class CreditController {
    private final Map<String, CreditStatus> creditIds = new HashMap<>();
    private final BikService bikService;

    @Autowired
    public CreditController(BikService bikService) {
        this.bikService = bikService;
    }

    @PostMapping
    public CreditResponse requestCredit(@RequestBody BankClientDto bankClientDto) {
        String id = anId();
        CreditStatus creditStatus = processClientRequest(bankClientDto);
        creditIds.put(id, creditStatus);
        return new CreditResponse(id);
    }

    private CreditStatus processClientRequest(BankClientDto bankClientDto) {
        if (bikService.check(bankClientDto)) {
            return CreditStatus.success();
        }

        return CreditStatus.fail();
    }

    private String anId() {
        return UUID.randomUUID().toString();
    }

    @GetMapping(value = "/{id}")
    public CreditStatus requestCredit(@PathVariable("id") String id) {
        return creditIds.get(id);
    }
}
