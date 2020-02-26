package com.devexperts.rest;

import org.springframework.http.ResponseEntity;

import java.util.concurrent.ExecutionException;

public abstract class AbstractAccountController {
    abstract ResponseEntity<Void> transfer(long sourceId, long targetId, double amount) throws InterruptedException, ExecutionException;
}
