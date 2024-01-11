# Documentation and Explanation

## Highlights
1. The provided solution is universal and works with any JSON format, not limited to specific structures.
2. Developed using Test Driven Development (TDD) methodology.

## Notes
1. Unit tests were carefully crafted with mock data to guarantee code quality.
2. Pure Java was employed for the solution, with additional use of libraries like JUnit and JSONAssert solely for unit testing.

## Assumptions
1. Based on the challenge document and examples:
    1. JSON is formatted across multiple lines.
    2. Each field is on a new line to avoid issues with missing commas or double quotes.
    3. Incomplete JSON is assumed to be correct up to the cutting line.

## Design Summary

The solution first checks if the provided string is a valid JSON. If valid, it returns the original JSON. If invalid or incomplete, it extracts as much data as possible, correcting missing brackets, double quotes, and extra commas to produce a well-formed JSON string.

## Design Explanation

* Validate the given JSON; if valid, return the original.
* If invalid:
    1. Iterate through each character, using a stack to track brackets.
    2. Append characters to a StringBuilder.
    3. Handle opening and closing brackets, ensuring correct matching.
    4. After iteration, append any remaining closing brackets with new lines.
    5. Return the fixed JSON.

## Input and Output

* Input: An incomplete JSON string. 
* Output: A completed and valid JSON string.


## Instructions to Run Code
1. Ensure Java 21 or a compatible runtime is installed.
2. Ensure that Apache Maven 3.9.5 or a later version is installed and import the project using Maven.
3. Refer to the `com/workflow86/Main.java` file for an example featuring an incomplete JSON.
4. Execute the Main method with any incomplete JSON to obtain a completed version.
5. Alternatively, execute the unit test `src/test/java/com/workflow86/service/JsonServiceTest.java` using Maven (`mvn test`).

## Unit Test Highlights
1. Rigorous unit tests with diverse mock data.
2. JUnit and JSONAssert libraries were utilized solely to check if the solution's outcome matches the expected result.