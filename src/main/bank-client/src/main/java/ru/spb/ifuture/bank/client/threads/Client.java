package ru.spb.ifuture.bank.client.threads;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@RequiredArgsConstructor
public class Client extends Thread {
    private final WebClient client = WebClient.create();
    private final int port;
    private final int[] read;
    private final int[] write;
    private final double readQuota;
    private final double writeQuota;

    @Override
    public void run() {
        log.info("Thread started");
        while(true) {
            double readProbability = readQuota / (readQuota + writeQuota);
            if (ThreadLocalRandom.current().nextDouble() < readProbability) {
                getBalance(read[new Random().nextInt(read.length)]);
            } else {
                changeBalance(write[new Random().nextInt(write.length)], 10L);
            }
        }
    }

    private void getBalance(int id) {
        try {
            client.get()
                    .uri(String.format("http://localhost:%d/api/accounts/%d/getBalance/", port, id))
                    .retrieve()
                    .toBodilessEntity()
                    .block();
        } catch (Exception e) {
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private void changeBalance(int id, long amount) {
        try {
        client.get()
                .uri(String.format("http://localhost:%d/api/accounts/%d/changeBalance/%d", port, id, amount))
                .retrieve()
                .toBodilessEntity()
                .block();
        } catch (Exception e) {
            try {
                sleep(3000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
