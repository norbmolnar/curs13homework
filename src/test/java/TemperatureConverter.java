package com.example;

public class TemperatureConverter {

    public static double fahrenheitToCelsius(double temperature) {
        return (temperature - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double temperature) {
        return (temperature * 9 / 5) + 32;
    }

    public static void main(String[] args) {
        double tempF1 = 100;
        double tempC1 = fahrenheitToCelsius(tempF1);
        System.out.println(tempF1 + "°F -> " + tempC1 + "°C");

        double tempC2 = 0;
        double tempF2 = celsiusToFahrenheit(tempC2);
        System.out.println(tempC2 + "°C -> " + tempF2 + "°F");

        double tempF3 = 50;
        double tempC3 = fahrenheitToCelsius(tempF3);
        System.out.println(tempF3 + "°F -> " + tempC3 + "°C");
    }
}
