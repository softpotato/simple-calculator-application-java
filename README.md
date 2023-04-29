# Basic Calculator Application

This application parses a string math formula and outputs 2 outputs in 
integer and float format. The math formula uses spaces to tokenize each
part, so every part of the formula needs to be split apart to function
properly. E.g. "1 + 2 + ( 3 * 4 / 5 - ( 62 + 73 ) ) - ( 1 - 2 )".

The following is a list of supported operations.
* binary operations (2 inputs)
  * addition (e.g. 1 + 2)
  * subtraction (e.g. 1 - 2)
  * division (e.g. 4 / 2)
  * multiplication (e.g. 2 * 2)
  * exponents (e.g. 2 ^ 6)

* Unary operations (1 input)
  * sine (e.g. sin 1) 
  * cosine (e.g. cos 1)
  * tangent (e.g. tan 1)
  * negation (e.g. -1)

## Required Tools
- Maven
- Java 17 (can configure which Java in Pom.xml)

## Compiling and Running Code

Open the ```interview-app``` directory on terminal, then run.

```
mvn clean test
```

To compile the code into a jar, run the following.

```
mvn install
cd target
java -jar interview-app-1.0.jar
```

There might be alternate ways to run the code, but I usually use the button on my IDE to compile and run it.