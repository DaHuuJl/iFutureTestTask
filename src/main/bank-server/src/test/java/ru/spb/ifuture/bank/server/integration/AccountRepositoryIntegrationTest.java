/*
package ru.spb.ifuture.bank.server.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import ru.spb.ifuture.bank.server.repository.AccountRepository;

import static org.assertj.core.api.Assertions.assertThat;

@Sql(scripts = "classpath:sql/account/account.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        config = @SqlConfig(encoding = "UTF-8"))
@Sql(scripts = "classpath:sql/clear-all.sql",
        executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD,
        config = @SqlConfig(encoding = "UTF-8"))
public class AccountRepositoryIntegrationTest extends BaseIntegrationTest {
    @Autowired
    private AccountRepository repository;

    @Test
    public void getBalance() {
        var result = repository.getBalance(1L);

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get()).isEqualTo(100L);
    }

    @Test
    public void changeBalance() {
        var toUpdate = repository.findById(2L);

        assertThat(toUpdate.isPresent()).isTrue();
        assertThat(toUpdate.get().getBalance()).isEqualTo(200L);

        var toUpdateEntity = toUpdate.get();
        toUpdateEntity.setBalance(toUpdateEntity.getBalance() + 100L);
        repository.save(toUpdateEntity);

        var result = repository.findById(2L);

        assertThat(result.isPresent()).isTrue();
        assertThat(result.get().getBalance()).isEqualTo(300L);
    }

}
*/
