<a id="readme-top"></a>
<h3 align="center">
README</a> 👋
</h3>

<h2 align="center">
Test Script Design & Execution Guide
</h2> 
This README provides instructions for setting up, running, and understanding the test suite. It also includes describe how I design test scripts.

### 1. Test Script Design

- 1.1 Understanding Requirements
  * Gather functional and non-functional requirements.
  * Identify test scenarios based on business logic, edge cases, and user workflows.
  * Define expected outcomes for each scenario.
- 1.2 Choosing the Test Framework  
  * Framework: Use a testing framework like TestNG or JUnit for Java.
  * Libraries: Use RestAssured libraries for API testing.
  * Build Tool: Use Maven  for dependency management and running tests.
- 1.3 Structuring the Test Script:  
  * Base Test Class: Create a BaseTest class to handle common setup (e.g., initializing RestAssured, loading configurations).
  * Test Classes: Create separate test classes for different functionalities (e.g., UserTests, ProductTests).
  * Utilities: Create utility classes for reusable methods (e.g., generating random data, reading configuration files).
- 1.4 Writing Reusable Components
  * Create utility methods for common API calls or UI actions.
  * Implement Page Object Model (POM) for UI automation.
  * Use environment variables or config files for API base URLs and credentials.
- 1.5 Location Design
    The directory structure should look like this: src/test/resources.
```
src
├── main
│   └── java
│       └── org
│           └── example
│               └── BaseTest
└── test
    ├── java
    │   └── org
    │       └── example
    │           └── GoRestAPITest
    └── resources
        └── config.properties
```


### 2. Test Setup Instructions

#### Prerequisites
  Software & Tools:
  - Java JDK 11+
  - Maven (for dependency management)
  - IntelliJ IDEA / VS Code
  - Postman (for API testing validation)
  - Dependencies (Maven pom.xml)
  - Add the following dependencies:
    dependencies
    ```sh
    <dependency>
        <groupId>io.rest-assured</groupId>
        <artifactId>rest-assured</artifactId>
        <version>5.5.1</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.11.0</version>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.14.1</version>
    </dependency>
    ```
  - Configure the Environment:
    Create a config.properties file in the src/test/resources directory with the following content:
    properties
    ```
    base_url=https://gorest.co.in/public/v2
    token=your_access_token_here
     ```
    Replace your_access_token_here with your actual GoRest API token.

### 3. Running the Tests

- 3.1 Command Line Execution
    Navigate to the project root directory
    ```sh
     cd /path/to/project
    ```
    Run the test cases using Maven
     ```mvn clean test```
 
- 3.2 Running Tests in IntelliJ IDEA 
    Open the test file.
    Click on the Run button beside the test method or class.
- 3.3 Run All Tests
    To run all the tests, use the following command:
    ```
    mvn test
    ```

### 4. Debugging & Logs
- Enable debug mode:
    ``` mvn test -Dlog4j.debug=true```
- Use breakpoints in IntelliJ for step-by-step debugging.

### 5. Reporting & Analysis
- Use Allure Reports:
 ```mvn allure:serve```
Or Extent Reports for graphical results.

### 6. Best Practices
✅ Maintain clear and modular test scripts. ✅ Use assertions for validation. ✅ Parameterize inputs for flexibility. ✅ Keep test data separate from scripts. ✅ Ensure scripts are CI/CD compatible.

### Built With
[![My Skills](https://skillicons.dev/icons?i=java,idea,nodejs,maven&theme=dark)](https://skillicons.dev)

<p align="right">(<a href="#readme-top">back to top</a>)</p>
