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
