package com.learning.junit;

import org.junit.jupiter.api.*;

@DisplayName("String Calculator Test")
public class StringCalculatorTest {
    StringCalculator calc=null;

    @BeforeEach
    public void init()
    {
        calc= new StringCalculator();
    }
    @Test
    @DisplayName("1.An empty string returns zero")
    public void whenTheStringisEmpty(){
        Assertions.assertEquals(0, calc.calculate(""));
    }
    @Test
    @DisplayName("2.A single number returns the value")
    public void whenStringReturnstheValue(){
        Assertions.assertEquals(5, calc.calculate("5"));
    }
    @Test
    @DisplayName("3.Two numbers, comma delimited, returns the sum")
    public void whenTwoNumbersCommaDelimited(){
        Assertions.assertEquals(10, calc.calculate("4,6"));
    }
    @Test
    @DisplayName("4. Two numbers, newLine delimited, returns the sum")
    public void whenTwoNumberNewLineDelimited(){
        Assertions.assertEquals(10, calc.calculate("5\n5"));
    }

    @Test
    @DisplayName("5. Three numbers, delimited either way, returns the sum")
    public void whenThreeNumberDelimitedEitherWay(){
        Assertions.assertEquals(7+2+4, calc.calculate("7\n2,4"));
    }

    @Test
    @DisplayName("6. Negative numbers throw an exception")
    public void whenNegativeNumbersThrowException(){
        Assertions.assertThrows(Exception.class, ()->calc.calculate("-5,2"));
    }
    @Test
    @DisplayName("6.1 Negative number throw an exception")
    public void whenNegativeNumberThrowException(){
        Assertions.assertThrows(Exception.class, ()->calc.calculate("-5"));
    }
    @Test
    @DisplayName("7. Numbers greater than 1000 are ignored")
    public void whenNumberGreaterThanThousands(){
    Assertions.assertEquals(10+20, calc.calculate("10,20,1001"));
    }

    @Test
    @DisplayName("8. A single char delimiter can be defined on the first line (e.g. //# for a ‘#’ as the delimiter)")
    public void whenAsingleCharDelimiterCanbeDefined(){
        Assertions.assertEquals(10+20, calc.calculate("//#10#20#1001"));
    }

    @Test
    @DisplayName("9. A single char delimiter can be defined on the first line (e.g. //[###]for a ‘###’ as the delimiter)")
    public void whenMultiCharDelimiterCanbeDefined(){
       Assertions.assertEquals(10+20, calc.calculate("//[###]10###20###1001"));
    }
    @AfterEach
    public void tearDown()
    {
        calc= null;
    }

}
