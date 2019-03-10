package com.java.demos.java8;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;

class OptionalDemo {

    @Test
    void innerAnonymousClassVersusLambdaExpression() {
        Runnable r1 = new Runnable() {

            @Override public void run() {
                assertTrue(true);
            }
        };
        r1.run();

        Runnable r2 = () -> assertTrue(true);
        r2.run();
    }

    @Test
    void shouldThrowNullPointerExceptionWhenOfUsed() {
        assertThrows(NullPointerException.class, () -> Optional.of(null));
    }

    @Test
    void shouldNotThrowExceptionWhenOfNullableUsed() {
        assertDoesNotThrow(() -> Optional.ofNullable(null));
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenNullValueInOfNullableOptionalUsed() {
        assertThrows(NoSuchElementException.class, () -> {
            final Optional<String> nullableString = Optional.ofNullable(null);
            nullableString.get();
        });
    }

    @Test
    void shouldThrowNoSuchElementExceptionWhenGetWithEmptyOptionalInvoked() {
        assertThrows(NoSuchElementException.class, () -> {
            final Optional<String> emptyOptional = Optional.empty();
            emptyOptional.get();
        });
    }

    @Test
    void shouldNotThrowExceptionWhenIfPresentUsed() {
        final Optional<String> nullableString = Optional.ofNullable(null);
        nullableString.ifPresent(s -> fail());
    }

    @Test
    void shouldReturnProperValueFromOptional() {
        final String name = "Kacper";
        Optional<String> optionalName = Optional.ofNullable(name);
        assertEquals(name, optionalName.get());
    }

    @Test
    void shouldReturnDefaultWhenValueIsEmpty() {
        final String nullableString = null;
        final String notEmptyString = "Kacper";

        String value = Optional.ofNullable(nullableString).orElse(notEmptyString);
        assertEquals(value, notEmptyString);
    }

    @Test
    void shouldIgnoreDefaultWhenValueIsNotEmpty() {
        final String nonEmptyString1 = "Java";
        final String nonEmptyString2 = "Kacper";

        String value = Optional.ofNullable(nonEmptyString1).orElse(nonEmptyString2);
        assertEquals(value, nonEmptyString1);
    }

}