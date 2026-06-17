# Java2 Workshop - Converter App

A simple console-based unit converter built in Java.

The application allows users to perform conversions between:

* Temperature

    * Celsius → Fahrenheit
    * Fahrenheit → Celsius
* Speed

    * km/h → m/s
    * m/s → km/h
* Fuel Consumption

    * Litres per 100 km → km per litre
    * km per litre → Litres per 100 km

The program uses a menu-driven interface and continues running until the user chooses to exit.

---

## Features

* Interactive console menu
* Multiple conversion categories
* Sub-menus for conversion direction selection
* Reusable conversion methods
* Constants for conversion factors
* Formatted output using `printf`
* Built with standard Java and Maven

---

## Project Structure

```text
Java2_Workshop_Converter/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── se/
                └── lexicon/
                    └── ConverterApp.java
```

---

## Requirements

* Java 17+ (or newer)
* Maven 3.8+

Verify your installation:

```bash
java -version
mvn -version
```

---

## Compile the Project

From the project root directory:

```bash
mvn compile
```

---

## Run the Application

### Option 1 - From IntelliJ IDEA

Open the project and run:

```java
ConverterApp.main()
```

### Option 2 - From the Command Line

After compiling:

```bash
mvn exec:java -Dexec.mainClass="se.lexicon.ConverterApp"
```

If the Maven Exec plugin is not configured, you can also run the compiled class directly.

---

## Example Usage

```text
==================================
      LEXICON CONVERTER APP
==================================
1. Temperature Converter
2. Speed Converter
3. Fuel Consumption Converter
4. Exit
==================================
Choose an option: 1

--- Temperature Converter ---
Convert:
  1. Celsius to Fahrenheit
  2. Fahrenheit to Celsius
Your choice: 1

Enter temperature in Celsius: 100

Result: 100.00 C = 212.00 F
```

---

## Concepts Practiced

This project demonstrates:

* Variables and data types
* Constants (`final`)
* Methods
* User input with `Scanner`
* Loops (`while`)
* Selection statements (`switch`)
* Basic arithmetic operations
* String formatting
* Maven project structure

---

## Author

Created by Felix S.N as part of the Lexicon Java Fundamentals workshop series.
