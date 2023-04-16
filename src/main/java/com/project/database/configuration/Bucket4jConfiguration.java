package com.project.database.configuration;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.BucketConfiguration;
import io.github.bucket4j.ConfigurationBuilder;
import io.github.bucket4j.Refill;
import io.github.bucket4j.TokensInheritanceStrategy;

@Configuration
public class Bucket4jConfiguration {
    // Lần refill đầu tiên (Nếu dùng Interval refill sẽ được tính đầu tiên vào lúc 0h00)
    
    @Bean
    public Instant getInstantTime () {
        return ZonedDateTime.now().truncatedTo(ChronoUnit.DAYS).plus(0, ChronoUnit.DAYS).toInstant();
    }

    public static BucketConfiguration addBucketConfiguration(Bandwidth[] bandwidths) {
        ConfigurationBuilder configurationBuilder = BucketConfiguration.builder();
        for (Bandwidth bandwidth : bandwidths) {
            configurationBuilder.addLimit(bandwidth);
        }
        return configurationBuilder.build();
    }

    @Bean (name="limit5PerMinute")
    public Bucket limit5PerMinute() {
        Bandwidth [] bandwidths = {
            Bandwidth.simple(5, Duration.ofMinutes(1)),
            Bandwidth.classic(10, Refill.greedy(5, Duration.ofHours(1)))
        };
        BucketConfiguration bucketConfig =  Bucket4jConfiguration.addBucketConfiguration(bandwidths);
        Bucket bucket = Bucket.builder().addLimit(Bandwidth.simple(5, Duration.ofMinutes(1))).build();
        bucket.replaceConfiguration(bucketConfig,TokensInheritanceStrategy.AS_IS);

        return bucket;
    }

    @Bean
    public Bucket limit1PerHour() {
        return Bucket
            .builder()
            .addLimit(Bandwidth.classic(1, Refill.intervallyAligned(1, Duration.ofHours(1), getInstantTime(), false)))
            .addLimit(Bandwidth.classic(12, Refill.intervally(12, Duration.ofDays(1))))
            .build();
    }

}
