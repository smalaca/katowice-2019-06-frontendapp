package com.smalaca.rest.api;

import com.smalaca.rest.api.dto.BankClientDto;
import com.smalaca.rest.api.dto.CreditResponse;
import com.smalaca.rest.api.dto.CreditStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/credit")
public class CreditController {
    private final Map<String, String> creditIds = new HashMap<>();

    @PostMapping
    public CreditResponse requestCredit(@RequestBody BankClientDto bankClientDto) {
        String id = anId();
        creditIds.put(id, bankClientDto.getPesel());
        return new CreditResponse(id);
    }

    private String anId() {
        return UUID.randomUUID().toString();
    }

    @GetMapping(value = "/{id}")
    public CreditStatus requestCredit(@PathVariable("id") String id) {
        if (creditIds.containsKey(id) && creditIds.get(id).equals("12345678901")) {
            return CreditStatus.success();
        }

        return CreditStatus.fail();
    }
}
