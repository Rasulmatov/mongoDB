package uz.universes.mongodb;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathTest {
    Math math ;

    @BeforeEach
    void setUp() {
        math=new Math();
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    void sum_validArguments() {
        assertEquals(10, math.sum(2, 3, 5));
        assertEquals(0, math.sum());
    }

    @Test
    void sum_nullArguments() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> math.sum(null));
        assertEquals("Arguments can not be null", exception.getMessage());
    }

    @Test
    void sub_validArguments() {
        assertEquals(1, math.sub(3, 2));
    }

    @Test
    void add_validArguments() {
        assertEquals(5, math.add(2, 3));
    }

    @Test
    void div_validArguments() {
        assertEquals(2, math.div(6, 3));
    }

    @Test
    void div_zeroDivision() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> math.div(1, 0));
        assertEquals("Divider can not be zero", exception.getMessage());
    }

    @Test
    void mul_validArguments() {
        assertEquals(6, math.mul(2, 3));
    }

    @Test
    void pow_validArguments() {
        assertEquals(8, math.pow(2, 3));
        assertEquals(1, math.pow(5, 0));
    }
}