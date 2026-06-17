package se.lexicon;

import java.util.Scanner;

public class ConverterApp {

    // Constants
    static final double CELSIUS_TO_FAHRENHEIT_MULTIPLIER = 9.0 / 5.0;
    static final double FAHRENHEIT_TO_CELSIUS_MULTIPLIER = 5.0 / 9.0;
    static final double FAHRENHEIT_OFFSET = 32.0;

    static final double SPEED_CONVERSION_FACTOR = 3.6;

    static final double FUEL_CONVERSION_BASE = 100.0;

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMainMenu();

            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> temperatureConverter();
               // case 2 -> speedConverter();
               // case 3 -> fuelConsumptionConverter();
                case 4 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice. Please choose 1-4.");
            }

            if (running && choice >= 1 && choice <= 3) {
                running = askToContinue();
            }
        }

        scanner.close();
    }

    static void printMainMenu() {
        System.out.println("==================================");
        System.out.println("      LEXICON CONVERTER APP");
        System.out.println("==================================");
        System.out.println("1. Temperature Converter");
        System.out.println("2. Speed Converter");
        System.out.println("3. Fuel Consumption Converter");
        System.out.println("4. Exit");
        System.out.println("==================================");
    }

    static void temperatureConverter() {
        System.out.println("\n--- Temperature Converter ---");
        System.out.println("Convert:");
        System.out.println("  1. Celsius to Fahrenheit");
        System.out.println("  2. Fahrenheit to Celsius");

        int choice = readInt("Your choice: ");

        switch (choice) {
            case 1 -> {
                double celsius = readDouble("Enter temperature in Celsius: ");
                double fahrenheit = celsiusToFahrenheit(celsius);
                System.out.printf("Result: %.2f C = %.2f F%n%n", celsius, fahrenheit);
            }
            case 2 -> {
                double fahrenheit = readDouble("Enter temperature in Fahrenheit: ");
                double celsius = fahrenheitToCelsius(fahrenheit);
                System.out.printf("Result: %.2f F = %.2f C%n%n", fahrenheit, celsius);
            }
            default -> System.out.println("Invalid choice.\n");
        }
    }


    // Conversion methods
    static double celsiusToFahrenheit(double celsius) {
        return celsius * CELSIUS_TO_FAHRENHEIT_MULTIPLIER + FAHRENHEIT_OFFSET;
    }

    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - FAHRENHEIT_OFFSET) * FAHRENHEIT_TO_CELSIUS_MULTIPLIER;
    }

    // Input helper methods
    static int readInt(String message) {
        System.out.print(message);
        int value = scanner.nextInt();
        scanner.nextLine();
        return value;
    }

    static double readDouble(String message) {
        System.out.print(message);
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }

    static boolean askToContinue() {
        System.out.print("Continue? (yes/no): ");
        String answer = scanner.nextLine();

        if (answer.equalsIgnoreCase("yes")) {
            return true;
        } else {
            System.out.println("Goodbye!");
            return false;
        }
    }
}