package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TemperatureConverterTest {

    @Test
    public void testFahrenheitToCelsius() {
        assertEquals(37.777777778, TemperatureConverter.fahrenheitToCelsius(100), 0.000000001);
        assertEquals(-17.777777778, TemperatureConverter.fahrenheitToCelsius(0), 0.000000001);
        assertEquals(10.0, TemperatureConverter.fahrenheitToCelsius(50), 0.000000001);
    }

    @Test
    public void testCelsiusToFahrenheit() {
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100), 0.000000001);
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0), 0.000000001);
        assertEquals(50.0, TemperatureConverter.celsiusToFahrenheit(10), 0.000000001);
    }
}
