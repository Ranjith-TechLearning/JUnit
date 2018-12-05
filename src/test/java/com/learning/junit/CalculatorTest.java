package com.learning.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@DisplayName("Calculator Test... ")
public class CalculatorTest {
    Calculator calc;

    @BeforeEach
    public void init (){
         calc = new Calculator();

    }
    @DisplayName("Test case ")
    @Test
    public void whenTwoNumbersAreAddedPositiveCase(){
        Assertions.assertEquals("A", "A");

    }


    @DisplayName("Value Souring...")
    @ParameterizedTest
    @ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
    public void whenPositivecase(String candidate){
       Assertions.assertEquals(candidate,calc.display(candidate));
    }


    @Tag("DisplayTest..")
    @DisplayName("Method source Testing...")
    @ParameterizedTest
    @MethodSource("inputProvider")
    public void displayTest(String input){
        Assertions.assertEquals(input, calc.display(input));

    }

    @DisplayName("RepeatTest 100000")
    @RepeatedTest(10000)
    public void displayTest1(){
        Assertions.assertEquals("ABC", "ABC");
    }

    @Test
    @DisplayName("Exception Testing..")
    public void testException(){
        Throwable exception = Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, ()->{
            calc.throwException();
        });
        Assertions.assertEquals("I am Exception",exception.getMessage());

    }
    public static Stream<String> inputProvider(){
        return Stream.of("name1","name2", "name3");
    }
    @AfterEach
    public void tearDown(){
        calc=null;
    }
}
