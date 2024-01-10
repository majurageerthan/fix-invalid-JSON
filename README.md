Documentation and Explanation

Notes
1. Below solution will work for ANY JSON. I.e. not restricted only to the JSON above.
2. Appropriate unit tests were added with the mock data to ensure the code quality
3. Solution was created only using pure Java. Some libraries were used only for the unit test purposes. eg: jsonassert

Assumptions
1. Assumed JSON is in multi lines. every field is in new line. because if many fields in same line comma or double quote missing.
it can not be able to distinguish

Fix code
check line by line for "

First code the given string will be checked whether is is valid json or not.
if a valid json is given, it will simply return the valid json

if the json is not valid, the method will Extract the data from the JSON as much and as detail as possible
then return the extracted json string

Instructions to run code
1. Java 21 is used to create this solution
2. Run Main method with the given json string supplied
3. Or run the unit test `src/test/java/com/workflow86/service/JsonServiceTest.java` to run with the existing provided test cases

