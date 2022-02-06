Feature: Verify Rozerka filters.
  As user
  I want to test Rozetka main functionality,
  So that I can select product to Cart with applying my filter.

  Scenario Outline: Check that selected item price is more then limit.
    Given User makes search by keyword '<keyword>' at Rozetka
    And User select filter brand '<brandName>'
    When User add first product to Cart.
    Then User checks that item price is more then '<limit>'


    Examples:
      | keyword | brandName | limit |
      | phone   | ASUS      | 100   |
      | лижі    | Volkl     | 1500  |



