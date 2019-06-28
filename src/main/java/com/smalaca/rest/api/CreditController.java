package com.smalaca.rest.api;

import com.smalaca.rest.api.dto.BankClientDto;
import com.smalaca.rest.api.dto.CreditResponse;
import com.smalaca.rest.api.dto.CreditStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/credit")
public class CreditController {
    private String lastId;

    @PostMapping
    public CreditResponse requestCredit(@RequestBody BankClientDto bankClientDto) {
//        if ("10000".equals(bankClientDto.getAmount())
//                && "12345678901".equals(bankClientDto.getPesel())) {
            return new CreditResponse(aLastId());
//        }
//        }
//
//        return new CreditResponse("it will gonna fail");
    }

    private String aLastId() {
        if (lastId == null) {
            lastId = UUID.randomUUID().toString();
        }
        return lastId;
    }

    @GetMapping(value = "/{id}")
    public CreditStatus requestCredit(@PathVariable("id") String id) {
//        if (lastId.equals(id)) {
            return CreditStatus.success();
//        }
//
//        return CreditStatus.fail();
    }
}
