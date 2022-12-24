package ru.spb.ifuture.bank.client.config;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import ru.spb.ifuture.bank.client.threads.Client;
import ru.spb.ifuture.bank.client.util.QuotaCountException;

@Component
public class AccountsConfig {
    @Value("${account.read.list}")
    public int[] read;

    @Value("${account.write.list}")
    public int[] write;

    @Value("${account.read.quota}")
    public double[] readQuota;

    @Value("${account.write.quota}")
    public double[] writeQuota;

    @Value("${client.thread.count}")
    public int count;

    @Value("${client.thread.same.quota}")
    public boolean same;
    @Value("${bank.server.port}")
    public int port;

    @Bean
    @SneakyThrows
    public void createThreads() {
        if(!same)
            if(writeQuota.length != readQuota.length || count != writeQuota.length)
                throw new QuotaCountException("Количество вероятностей не соответствует количеству нитей");

        if(same)
            for(int i = 0; i < count; i++) {
                new Client(port, read, write, readQuota[0], writeQuota[0]).start();
            }
        else
            for(int i = 0; i < count; i++) {
                new Client(port, read, write, readQuota[i], writeQuota[i]).start();
            }
    }
}
