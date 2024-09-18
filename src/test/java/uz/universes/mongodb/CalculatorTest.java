package uz.universes.mongodb;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import java.awt.*;
import java.time.Duration;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calkulyator test qilinmoqda")
public class CalculatorTest {
    Calculator calculator;
    private final static Logger LOGGER=Logger.getLogger(CalculatorTest.class.getName());
    @BeforeEach
    void setUp(){
        LOGGER.info("Before Each SetUp()");
        calculator=new Calculator();
    }

    @AfterEach
    void tearDown(){
        calculator=null;
        LOGGER.info("After Each Tear Down");
    }
    @Test
    @DisplayName("summ xisoblanmoqda")
    void testForSum(){
        LOGGER.info("TEST SUM");
        int expected=5;
        int actual=calculator.sum(2,3); //2 jarayon
        assertEquals(expected,actual); //3 jarayon
    }
    @Test
    @DisplayName("Bo'lish amali bajarilmoqda")
    void testForDiv(){
        LOGGER.info("TEST DIV");
        int expected=6;
        int actual=calculator.div(6,1);
        assertEquals(expected,actual);
    }
    @Test
    @DisplayName("Time Throws ")
    void testForDiv_time(){
        ArithmeticException e=assertThrows(ArithmeticException.class, () ->calculator.div(10,0));
        e.printStackTrace();
    }
    @Test
    @DisplayName("Time Out ")
    void testForDiv_time_out(){
        assertTimeout(Duration.ofMillis(1100),()-> calculator.div(10,-2));
    }
    @BeforeAll
    static void setUpAll(){
        LOGGER.info("Before ALL SetUp()");
    }
    @AfterAll
    static void tearDownAll(){
        LOGGER.info("After ALL Tear Down");
    }
    @Test
    @Disabled("atmen")
    void testDesable(){
    }

    @Test
    @DisabledOnOs({OS.MAC,OS.WINDOWS})
    void showWindows(){}
    @Test
    @EnabledOnOs({OS.WINDOWS})
    void showWindowsLinux(){}
}
