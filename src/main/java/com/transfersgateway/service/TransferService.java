package com.transfersgateway.service;

import com.kodilla.commons.Transfer;
import com.transfersgateway.exception.InsufficientFoundsException;
import com.transfersgateway.model.request.TransferRequest;
import com.transfersgateway.provider.AccountsProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransferService {

    private final TransferProducer transferProducer;
    private final AccountsProvider accountsProvider;

    public void createTransfer(TransferRequest request) throws InsufficientFoundsException {
        BigDecimal founds = accountsProvider.getFounds(request.getSenderAccount());
        if(founds.compareTo(request.getAmount()) < 0) {
            throw new InsufficientFoundsException();
        }
        Transfer transfer = new Transfer();
        transfer.setAmount(request.getAmount());
        transfer.setRecipientAccount(request.getRecipientAccount());
        transfer.setSenderAccount(request.getSenderAccount());
        transfer.setTitle(request.getTitle());

        transferProducer.sendTransfer(transfer);
    }
}
