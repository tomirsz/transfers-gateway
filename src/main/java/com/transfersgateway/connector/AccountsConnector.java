package com.transfersgateway.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@FeignClient(name = "Accounts")
public interface AccountsConnector {

    @GetMapping("/account/fetch-founds")
    BigDecimal getFounds(@RequestParam(name="nrb") String nrb);
}
