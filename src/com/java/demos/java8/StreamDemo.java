package com.java.demos.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class StreamDemo {

    @Test
    void shouldGetStringsWhichStartsWithC()
    {
        List<String> myList = Arrays.asList("a1", "a2", "b1", "cb2", "ca1");

        final long counter = myList.stream()
                .filter(s -> s.startsWith("c"))
                .count();

        assertEquals(counter, 2L);
    }
}
