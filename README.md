# QA Coding Exercise for Airloo website
This repository contains automated tests for 
Airloo Website. 
The tests are built using Selenium WebDriver and JUnit for browser automation and testing. 
Page Object Model (POM) design pattern is used to structure the code in a maintainable and scalable way.
The tests are configured to run with Maven.
**POM** helps to decouple the logic of interacting with pages from the tests.
This separation provides easier maintenance as the website and framework grows.

## Project Structure

1. **src/main** <br />
This directory contains the **Page Object Model** classes which are used to represent the pages on the Airloo website 
and provide methods for interacting with their elements.
* **HomePage.java** Contains elements and methods for interacting with the Home Page.
* **JapanPage.java** Contains elements and methods for interacting with the page **https://www.airalo.com/japan-esim**
<br /><br />
2. **src/test**
This directory contains all the tests together with the WebDriver setup that is required to run the tests.
* **base** the base folder contains **BaseTest.java** class responsible for setting up and managing the WebDriver instance.
* **tests** the tests folder contains the actual JUnit test classes that interact with Page Objects and define the test scenarios.

## Test flow
1. **WebDriver setup** 
* The webdriver is initialized and managed by **BaseTest.java**. Also here is the configuration for which browser 
to use to run the test cases.
2. **Page Integrations** 
* The test classes interact with **HomePage.java** and **JapanPage.java** to simulate user actions and validate expected results.
3. **Test clean-up**
* After each test, the WebDriver is properly shut down to ensure there is no leftover browser instances.

## Prerequisities
Before running the tests, ensure you have the following installed:
* **Java** (version 8 or higher)
* **Maven** (to run the tests)

## Getting started
1. Clone the repository 
```
git clone https://github.com/Teod0ra/QA_CodingExercise.git
```
2. Install dependencies
```
mvn clean install
```
3. Run the tests
```
mvn clean test
```


