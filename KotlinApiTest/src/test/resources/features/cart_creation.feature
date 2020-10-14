Feature: Cart Creation

  Scenario: Create a new cart with a voucher inside
    Given An empty cart
    When I add a new voucher to the newly created empty cart
    Then Cart item is successfully created
    And The voucher inside the cart is the expected one

