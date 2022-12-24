package ru.spb.ifuture.bank.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.spb.ifuture.bank.server.model.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT account.balance FROM CNT_ACCOUNT account WHERE account.id = ?1")
    Optional<Long> getBalance(Long id);
}
