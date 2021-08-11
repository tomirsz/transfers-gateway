package com.transfersgateway.provider;

import com.transfersgateway.connector.AccountsConnector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class AccountsProvider {

    private final AccountsConnector accountsConnector;

    public BigDecimal getFounds(String nrb) {
        return accountsConnector.getFounds(nrb);
    }
}
