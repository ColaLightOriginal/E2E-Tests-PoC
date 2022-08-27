@Sales
Feature: Sale Process

  Scenario Outline:
    Given I am at login page
    When I login as "<user>"
    Then I am at "<page>"

    When I add product "<product_name>" to cart
    Then Product was added

    When I go to my cart
    Then I check products in my cart

    When I go to checkout page
    And I fill my information data with "<first_name>", "<last_name>" and "<postal_code>"
    Then I check data in information form "<first_name>", "<last_name>" and "<postal_code>"

    When I go to overview page
    Then I check product in overview page

    When I go to confirmation page
    Then I see information about order dispatchment

    Examples:
      | user     | page          | product_name        | first_name | last_name | postal_code |
      | STANDARD | PRODUCTS_PAGE | Sauce Labs Backpack | test       | testowy   | 04-400      |
      | PROBLEM | PRODUCTS_PAGE | Sauce Labs Backpack | test        | testowy   | 04-400      |

