package se.lexicon;

import java.util.Scanner;

public class ConverterApp {

    // Constants
    static final double CELSIUS_TO_FAHRENHEIT_MULTIPLIER = 9.0 / 5.0;
    static final double FAHRENHEIT_TO_CELSIUS_MULTIPLIER = 5.0 / 9.0;
    static final double FAHRENHEIT_OFFSET = 32.0;
    static final double ABSOLUTE_ZERO_CELSIUS = -273.15;
    static final double ABSOLUTE_ZERO_FAHRENHEIT = -459.67;

    static final double SPEED_CONVERSION_FACTOR = 3.6;

    static final double FUEL_CONVERSION_BASE = 100.0;

    static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMainMenu();

            int choice = readIntInRange("Choose an option: ", 1, 4);

            switch (choice) {
                case 1 -> temperatureConverter();
                case 2 -> speedConverter();
                case 3 -> fuelConsumptionConverter();
                case 4 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }
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

        int choice = readIntInRange("Your choice: ", 1, 2);

        switch (choice) {
            case 1 -> {
                double celsius = readDoubleWithMinimum(
                        "Enter temperature in Celsius: ",
                        ABSOLUTE_ZERO_CELSIUS,
                        "Invalid value. Temperature cannot be below absolute zero (-273.15 C)."
                );
                double fahrenheit = celsiusToFahrenheit(celsius);
                System.out.printf("Result: %.2f C = %.2f F%n%n", celsius, fahrenheit);
            }
            case 2 -> {
                double fahrenheit = readDoubleWithMinimum(
                        "Enter temperature in Fahrenheit: ",
                        ABSOLUTE_ZERO_FAHRENHEIT,
                        "Invalid value. Temperature cannot be below absolute zero (-459.67 F)."
                );
                double celsius = fahrenheitToCelsius(fahrenheit);
                System.out.printf("Result: %.2f F = %.2f C%n%n", fahrenheit, celsius);
            }
        }
    }

    static void speedConverter() {
        System.out.println("\n--- Speed Converter ---");
        System.out.println("Convert:");
        System.out.println("  1. km/h to m/s");
        System.out.println("  2. m/s to km/h");

        int choice = readIntInRange("Your choice: ", 1, 2);

        switch (choice) {
            case 1 -> {
                double kmPerHour = readNonNegativeDouble("Enter speed in km/h: ");
                double metersPerSecond = kmhToMs(kmPerHour);
                System.out.printf("Result: %.2f km/h = %.2f m/s%n%n", kmPerHour, metersPerSecond);
            }
            case 2 -> {
                double metersPerSecond = readNonNegativeDouble("Enter speed in m/s: ");
                double kmPerHour = msToKmh(metersPerSecond);
                System.out.printf("Result: %.2f m/s = %.2f km/h%n%n", metersPerSecond, kmPerHour);
            }
        }
    }

    static void fuelConsumptionConverter() {
        System.out.println("\n--- Fuel Consumption Converter ---");
        System.out.println("Convert:");
        System.out.println("  1. Litres per 100 km to km per litre");
        System.out.println("  2. km per litre to litres per 100 km");

        int choice = readIntInRange("Your choice: ", 1, 2);

        switch (choice) {
            case 1 -> {
                double litresPer100Km = readPositiveDouble("Enter litres per 100 km: ");
                double kmPerLitre = litresPer100KmToKmPerLitre(litresPer100Km);
                System.out.printf("Result: %.2f L/100km = %.2f km/L%n%n", litresPer100Km, kmPerLitre);
            }
            case 2 -> {
                double kmPerLitre = readPositiveDouble("Enter km per litre: ");
                double litresPer100Km = kmPerLitreToLitresPer100Km(kmPerLitre);
                System.out.printf("Result: %.2f km/L = %.2f L/100km%n%n", kmPerLitre, litresPer100Km);
            }
        }
    }

    // Conversion methods
    static double celsiusToFahrenheit(double celsius) {
        return celsius * CELSIUS_TO_FAHRENHEIT_MULTIPLIER + FAHRENHEIT_OFFSET;
    }

    static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - FAHRENHEIT_OFFSET) * FAHRENHEIT_TO_CELSIUS_MULTIPLIER;
    }

    static double kmhToMs(double kmPerHour) {
        return kmPerHour / SPEED_CONVERSION_FACTOR;
    }

    static double msToKmh(double metersPerSecond) {
        return metersPerSecond * SPEED_CONVERSION_FACTOR;
    }

    static double litresPer100KmToKmPerLitre(double litresPer100Km) {
        return FUEL_CONVERSION_BASE / litresPer100Km;
    }

    static double kmPerLitreToLitresPer100Km(double kmPerLitre) {
        return FUEL_CONVERSION_BASE / kmPerLitre;
    }

    // Input helper methods
    static int readIntInRange(String message, int min, int max) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                int value = Integer.parseInt(input);

                if (value < min || value > max) {
                    System.out.printf("Invalid choice. Please enter a number between %d and %d.%n", min, max);
                    continue;
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    static double readDoubleWithMinimum(String message, double minimum, String errorMessage) {
        while (true) {
            double value = readDouble(message);

            if (value < minimum) {
                System.out.println(errorMessage);
                continue;
            }

            return value;
        }
    }

    static double readNonNegativeDouble(String message) {
        while (true) {
            double value = readDouble(message);

            if (value < 0) {
                System.out.println("Invalid value. Please enter a value that is zero or greater.");
                continue;
            }

            return value;
        }
    }

    static double readPositiveDouble(String message) {
        while (true) {
            double value = readDouble(message);

            if (value <= 0) {
                System.out.println("Invalid value. Please enter a value greater than zero.");
                continue;
            }

            return value;
        }
    }

    static boolean askToContinue() {
        while (true) {
            System.out.print("Continue? (yes/no): ");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("yes")) {
                return true;
            }

            if (answer.equalsIgnoreCase("no")) {
                System.out.println("Goodbye!");
                return false;
            }

            System.out.println("Invalid input. Please enter yes or no.");
        }
    }
}