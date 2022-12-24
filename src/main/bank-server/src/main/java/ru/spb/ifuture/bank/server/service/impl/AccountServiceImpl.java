package ru.spb.ifuture.bank.server.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.spb.ifuture.bank.server.model.Account;
import ru.spb.ifuture.bank.server.repository.AccountRepository;
import ru.spb.ifuture.bank.server.service.BalanceService;

import java.util.Optional;

@Service
@CacheConfig(cacheNames = "balance")
@RequiredArgsConstructor
public class AccountServiceImpl implements BalanceService {
    private final AccountRepository repository;

    @Override
    @Cacheable
    public Optional<Long> getBalance(Long id) {
        return repository.getBalance(id);
    }

    @Override
    @CacheEvict(key = "#id")
    public void changeBalance(Long id, Long amount) {
        Account toUpdate = repository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Счёт с id: %d не найден!", id)));
        toUpdate.setBalance(toUpdate.getBalance() + amount);
        repository.save(toUpdate);
    }
}
