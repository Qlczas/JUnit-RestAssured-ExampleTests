# Test Automation of API - Example Project by Qlczas
Framework using Java: JUnit5 + RestAssured + Lombok.
Maven - Dependency Management.
Awaitility + Allure.

## Running the tests
Lombok Plugin needed to be installed in intelliJ/Eclipse
Provide required data in `credentials.properties` file

Example:
```
fullName=QA
devAccessToken=QaTokenDev
proxyHost=proxy.host.example.com
proxyPort=00
```

To Execute tests, run command `mvn test`.
