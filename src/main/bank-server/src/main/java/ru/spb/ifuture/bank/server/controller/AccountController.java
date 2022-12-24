package ru.spb.ifuture.bank.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spb.ifuture.bank.server.util.Analytics;
import ru.spb.ifuture.bank.server.service.BalanceService;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/accounts", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountController {
    private final BalanceService balanceService;

    @GetMapping("{id}/getBalance/")
    public ResponseEntity<Long> getBalance(@PathVariable Long id) {
        Analytics.countMethodCallsGetBalance++;
        return ResponseEntity.ok(balanceService.getBalance(id).orElseThrow(
                () -> new RuntimeException(String.format("Счёт с id: %d не найден!", id))));
    }

    @GetMapping("{id}/changeBalance/{amount}")
    public ResponseEntity<?> changeBalance(@PathVariable Long id, @PathVariable Long amount) {
        Analytics.countMethodCallsChangeBalance++;
        balanceService.changeBalance(id, amount);
        return ResponseEntity.ok().build();
    }
}