package uz.universes.mongodb;

import org.junit.jupiter.api.*;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Class Check Method !!")
class CalculatorRepeatedTest {
    Calculator calculator;
    Random random;

    @BeforeEach
    void setUp() {
        calculator=new Calculator();
        random=new Random();
    }

    @AfterEach
    void tearDown() {
    }

    @RepeatedTest(10)
    @DisplayName("Service DataBase Connaction")
    void serviceDB() {
        int a=random.nextInt(20)+10;
        int b=random.nextInt(4)+12;
        int expected=a+b;
        assertEquals(expected,calculator.sum(a,b));
    }

    @Test
    void div() {
    }

}