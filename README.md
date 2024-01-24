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

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/majurageerthan/fix-invalid-JSON.git
   ```

2. **Navigate to the Project Directory:**
   ```bash
   cd fix-invalid-JSON
   ```

3. **Switch to main branch:**
   ```bash
   git switch main
   ```
   
4. **Ensure Java 21 is Installed:**
    - Confirm that Java 21 or a compatible version is installed on your system.

5. **Ensure Maven 3.9.5 or Higher is Installed:**
    - Verify that Apache Maven 3.9.5 or a later version is installed on your machine.

6. **Build the Project:**
   ```bash
   mvn clean install
   ```

7. **Run the Main Method with Incomplete JSON:**
    - Open the `com/workflow86/Main.java` file.
    - Modify or use the existing incomplete JSON in the `main` method.
    - Run the `Main` class to see the completed and valid JSON.

8. **Run Unit Tests:**
   ```bash
   mvn test
   ```
    - This will execute the unit tests and display the results.
      - `src/test/java/com/workflow86/service/FixIncompleteJsonTest.java`
      - `src/test/java/com/workflow86/service/SimpleArrayJsonTest.java`
      - `src/test/java/com/workflow86/service/SimpleOneObjectJsonTest.java`

These instructions are provided with the assumption that Git, Java, and Maven are already installed on the system.
If adjustments are necessary based on the specific environment, kindly make the required modifications.

## Unit Test Highlights
1. Rigorous unit tests with diverse mock data.
2. JUnit and JSONAssert libraries were utilized solely to check if the solution's outcome matches the expected result.
