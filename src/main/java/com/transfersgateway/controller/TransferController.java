package com.transfersgateway.controller;

import com.transfersgateway.exception.InsufficientFoundsException;
import com.transfersgateway.model.request.TransferRequest;
import com.transfersgateway.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController("/v1")
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping("/transfers")
    public ResponseEntity saveTransfer(@RequestBody TransferRequest request) {
        log.info("Recived transfer request: {}", request);
        try {
            transferService.createTransfer(request);
            return ResponseEntity.ok().build();
        } catch(InsufficientFoundsException e) {
            return ResponseEntity.badRequest().body(e);
        }
    }
}
