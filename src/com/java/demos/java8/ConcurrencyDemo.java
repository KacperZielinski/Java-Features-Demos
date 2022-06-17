package com.java.demos.java8;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcurrencyDemo {

    @Test
    public void futureTask() {

    }

    @Test
    public void shouldCombineTwoCompletableFutures() throws ExecutionException, InterruptedException {
        // given
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello is ready");
            return "Hello";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("World is ready");
            return "World";
        });

        // when
        CompletableFuture<String> combined = cf1.thenCombine(cf2, (val1, val2) -> val1 + " " + val2);

        // then
        assertEquals("Hello World", combined.get());
    }

    @Test
    public void shouldExecuteTwoCompletableFutures() {
        // given
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello is ready");
            return "Hello";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("World is ready");
            return "World";
        });

        // when
        CompletableFuture.allOf(cf1, cf2);

        // "Hello" is not printed!
    }

    @Test
    public void shouldExecuteFirstGotCompletableFuture() {
        // given
        CompletableFuture<String> cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Hello is ready");
            return "Hello";
        });

        CompletableFuture<String> cf2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("World is ready");
            return "World";
        });

        // when
        CompletableFuture.anyOf(cf1, cf2);

        // "Hello" is not printed!
    }
}
