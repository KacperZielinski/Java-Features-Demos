package com.java.demos.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

class FunctionalDemo {

    @Test
    void biConsumerTest() {
        AtomicInteger counter = new AtomicInteger();

        int p = 12;
        double q = 2.3;

        BiConsumer<Integer, Double> consumer = (integer, aDouble) -> {
            System.out.println(aDouble.intValue() + integer);
            counter.getAndIncrement();
        };

        consumer.accept(p, q);
        assertEquals(1, counter.get());

        consumer.andThen(consumer);
        consumer.accept(p, q);
        assertEquals(2, counter.get());

        BiConsumer<Integer, Double> doubleConsumer = (integer, aDouble) -> {
            System.out.println(aDouble.intValue() + integer);
            counter.getAndIncrement();
            counter.getAndIncrement();
        };

        // compose both functions: execute consumer andThen execute doubleConsumer function
        consumer.andThen(doubleConsumer).accept(p, q);
        assertEquals(5, counter.get());
    }

    @Test
    void predicateTest() {
        Predicate<String> p = (s) -> s.length() > 5;
        assertFalse(p.test("hej"));
        assertTrue(p.test("hejhej"));
    }

    @Test
    void functionTest() {
        Function<Integer, Integer> square = (num1) -> num1*num1;
        assertEquals(25, square.apply(5));
    }

    @Test
    void shouldPassFunctionAsAParameter() {
        Function<Integer, Integer> square = (num1) -> num1*num1;

        Integer value = 8;

        value = compute(square, value);
        value = compute((num1) -> 2*num1, value);

        assertEquals(128, value);
    }

    private Integer compute(Function<Integer, Integer> f, Integer value) {
        return f.apply(value);
    }

    @Test
    void supplierDemo() {
        Supplier<String> i  = () -> "hello";
        assertEquals("hello", i.get());

        String value = supply("hi"::toUpperCase);

        assertEquals("HI", value);
    }

    @Test
    void slashTest() {
        String test = "\\";
        test.replace("\\", " ");
    }

    private String supply(Supplier<String> s) {
        return s.get();
    }

    // supplier

    // consumer


    // method reference wtf ??
    interface Messageable{
        Message getMessage(String wtf);
    }
    class Message{
        Message(String msg){
            System.out.print(msg);
        }
    }
    @Test
    void ConstructorReference() {
        Messageable hello = Message::new;
        hello.getMessage("Hello");
    }
}
