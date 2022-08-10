package edu.school21.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberWorkerTest {
    NumberWorker nw;

    @BeforeEach
    void createNW (){nw = new NumberWorker();}

    @ParameterizedTest
    @ValueSource (ints = {8423, 1321, 9413, 2, 3})
    void isPrimeReal(int number) {
        Assertions.assertTrue(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource (ints = {9999, 5605, 8428, 16})
    void isPrimeNotReal(int number) {
        Assertions.assertFalse(nw.isPrime(number));
    }

    @ParameterizedTest
    @ValueSource (ints = {-10, 0, 1, -8423})
    void isPrimeNotValid(int number) {
        Assertions.assertThrows(IllegalNumberException.class, ()-> nw.isPrime(number));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", delimiter = ',')
    void checkDigitSum(int x, int y) {
        Assertions.assertEquals(nw.sumDigit(x), y);
    }
}
