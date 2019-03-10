package com.java.demos.java8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    @Test
    void shouldConcatenateListsOneByOne()
    {
        List<String> myList1 =
                Arrays.asList("a11", "a21", "b11", "cb21", "ca11");

        List<String> myList2 =
                Arrays.asList("2a12", "a22", "b12", "cb22", "ca12");

        List<String> concatenatedList = Stream.concat(myList1.stream(), myList2.stream())
                .collect(Collectors.toList());

        assertEquals(concatenatedList.get(0), myList1.get(0));
        assertEquals(concatenatedList.get(5), myList2.get(0));
        assertEquals(concatenatedList.get(9), myList2.get(4));
    }
}
