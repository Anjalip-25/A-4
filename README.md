# API Testing with TestNG and RestAssured

This project is an implementation of **API Testing** using **TestNG** and **RestAssured**. It demonstrates the process of creating temporary solutions, reducing technical debt, and isolating problematic code without refactoring. The project tests various APIs, starting with JSONPlaceholder, a fake online REST API.

## Objective

The purpose of this project is to:

1. Create API tests using **TestNG** and **RestAssured**.
2. Implement temporary solutions that can be improved later.
3. Identify and address technical debts.
4. Isolate problematic code and document known issues.

## Project Structure

- **`src/test/java/com/example/api/`**: Contains the test classes for API testing.
  - **`ApiTest.java`**: The main test class for verifying API endpoints using GET and POST methods.
- **`testng.xml`**: The TestNG configuration file that defines the suite and test cases to run.
- **`pom.xml`**: The Maven project configuration that includes dependencies for TestNG, RestAssured, and other required libraries.

## Prerequisites

- **Java 8+** (Verify using `java -version`).
- **Maven** (Verify using `mvn -version`).
- **Git** (Optional for version control).

## Project Setup

### 1. Clone the Repository

Clone the project from GitHub:

```bash
git clone https://github.com/yourusername/api-testing-project.git
cd api-testing-project
mvn clean install
mvn test
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="API Testing Suite">
    <test name="API Tests">
        <classes>
            <class name="com.example.api.ApiTest"/>
        </classes>
    </test>
</suite>
@Test
public void testGetRequest() {
    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
    Assert.assertEquals(response.getStatusCode(), 200);
    // Temporary solution: Verifying only the status code for now
}
@Test
public void testGetRequest() {
    Response response = RestAssured.get("https://jsonplaceholder.typicode.com/posts/1");
    Assert.assertEquals(response.getStatusCode(), 200);
    Assert.assertNotNull(response.getBody());
    Assert.assertTrue(response.getBody().asString().contains("userId"));
}
@Test
public void testPostRequest() {
    Response response = RestAssured.given()
        .contentType("application/json")
        .body("{ \"title\": \"foo\", \"body\": \"bar\", \"userId\": 1 }")
        .post("https://jsonplaceholder.typicode.com/posts");
    Assert.assertEquals(response.getStatusCode(), 201);
}

