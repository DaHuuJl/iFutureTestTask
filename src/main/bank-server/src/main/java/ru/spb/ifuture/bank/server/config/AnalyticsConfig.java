package ru.spb.ifuture.bank.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.spb.ifuture.bank.server.util.Analytics;

@Configuration
public class AnalyticsConfig {
    @Value("${analytics.time}")
    private int time;

    @Bean
    public void startAnalytics() {
        final Analytics analytics = new Analytics(time);
        analytics.start();
    }
}
