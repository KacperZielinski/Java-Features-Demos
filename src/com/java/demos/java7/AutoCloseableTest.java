package com.java.demos.java7;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.jupiter.api.Test;


/**
 * Allows us to replace try-catch-finally  ->  try-catch.
 */
class AutoCloseableTest {

    private boolean isScannerClosed = false;

    @Test
    void shouldCloseCustomResourceAutomatically() {

        class AutoCloseableImpl implements AutoCloseable {

            @Override
            public void close() {
                System.out.println("Scanner closed!");
                isScannerClosed = true;
            }

            void mockRead() {
                System.out.println("Reading...");
            }
        }

        try(AutoCloseableImpl autoCloseable = new AutoCloseableImpl()) {
            autoCloseable.mockRead();
        }

        assertTrue(isScannerClosed);
    }

    /** Notice semicolon!
     * They already implements AutoCloseable interface
     * Resources that were defined/acquired first will be closed last.
     **/
    @Test
    void shouldCloseMultipleEmbeddedResources() {
        try (Scanner scanner = new Scanner(new File("test.txt"));
             PrintWriter writer = new PrintWriter(new File("test.txt"))) {

            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }

        } catch (FileNotFoundException e) {
            assertTrue(true);
        }
    }
}
