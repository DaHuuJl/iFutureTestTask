package ru.spb.ifuture.bank.server.util;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class Analytics extends Thread {
    public static int countMethodCallsGetBalance = 0;
    public static int countMethodCallsChangeBalance = 0;
    private final int time;

    @Override
    @SneakyThrows
    public void run() {
        while(true) {
            log.info(String.format("Вызовов GetBalance за %d секунд: %d",
                    time / 1000, Analytics.countMethodCallsGetBalance));

            log.info(String.format("Вызовов ChangeBalance за %d секунд: %d",
                    time / 1000, Analytics.countMethodCallsChangeBalance));

            log.info(String.format("Общее количество за %d секунд: %d",
                    time / 1000, Analytics.countMethodCallsGetBalance + Analytics.countMethodCallsChangeBalance));

            Analytics.countMethodCallsGetBalance = 0;
            Analytics.countMethodCallsChangeBalance = 0;

            sleep(time);
        }
    }
}
