@hepsiburadaGrocery
Feature: Grocery DB

  @getAllGrocery
  Scenario: Test All Grocery GET Request
    Given user sends the GET request for grocery
    Then validates get request for grocery

  @getSpesificAppleGrocery
  Scenario: Test Spesific Apple Grocery GET Request
    Given user sends the GET request for "apple" grocery
    Then validates get request for "apple" grocery

  @getSpesificGrapesGrocery
  Scenario: Test Spesific Grapes Grocery GET Request
    Given user sends the GET request for "grapes" grocery
    Then validates get request for "grapes" grocery

  @getSpesificBananaGrocery
  Scenario: Negative Test Spesific Banana Grocery GET Request
    Given user sends the GET request for "banana" grocery
    Then validates negative get request for banana grocery

  @postRequestGrocery
  Scenario Outline: Test Grocery POST Request
    Given user sends the POST request for "<id>", "<name>", "<price>", "<stock>"
    Then validates post request for grocery
    Examples:
      | id | name   | price | stock |
      | 4  | string | 12.3  | 3     |

  @negativePostRequestGrocery
  Scenario Outline: Negative Test Grocery POST Request
    Given user sends the negative POST request for "<id>", "<name>", "<price>", "<stock>"
    Then validates post request for negative grocery
    Examples:
      | id | name  | price | stock |
      | 5  | mango | 18    | 9     |
