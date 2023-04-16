package com.project.database.service;

import org.springframework.stereotype.Service;

import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;

@Service
public class Bucket4JService {
    public ConsumptionProbe consumeToken(Bucket bucket,long consume) {
        return bucket.tryConsumeAndReturnRemaining(consume);
    }
}
