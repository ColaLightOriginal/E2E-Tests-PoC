# E2E Test Automation Proof of Concept

This is a Proof of Concept project for End2End Test Automation of demo site https://www.saucedemo.com/.
Project is based on Serenity BDD Framework, Selenium WebDriver, Allure Reports and Maven. It's purpose is to prepare the design and stack for future projects.

## Requirements

 - Maven
 - Java 17
 - Installed browsers for example: Google Chrome
 
 ## Usage
 
 ## Execution
 
 In root folder of project open terminal, type and execute command to run all tests:
 ```java
 mvn clean verify
 ```
 
Tests are defined as *.feature files in src/test/resources/features directory. Tests have their tags so it's possible to run tests with specific tags:
 ```java
 mvn clean verify -Dtags=TagName
 ```
 ### Test Cases
 
 Test Cases Can Be defined in */feature files with Gherkin Given, When, Then syntax. Example feature file below:
  ```java
@Login
Feature: Login feature

Scenario Outline: Login
  Given I am at login page
  When I login as "<user>"
  Then I am at "<page>"

  Examples:
  | user     | page          |
  | STANDARD | PRODUCTS_PAGE |
  | PROBLEM  | PRODUCTS_PAGE |
  | LOCKED   | PRODUCTS_PAGE |
 ```
 
 - @Login: Tags for the Feature
 - Feature: Name of feature
 - Scenario Outline: Name of scenario in feature. Outline version means that It can use examples tables as test data.
 - Examples: Test data
 
 ### Allure Reports
 
 After execution the data about runned tests are stored in directory /allure-results after the execution. It's possible to generate test report with command from project root directory:
  ```java
allure serve /allure-results
```
 
