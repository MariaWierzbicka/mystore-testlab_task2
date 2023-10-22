Feature: Log in and place an order

  Scenario Outline:
    Given user has an account on mystore-testlab.coderslab.pl and is not logged in
    When sign in button is clicked
    And valid <email> and <password> are given and sign in button is clicked
    And user navigates to the clothes section
    And user navigates to product page by clicking on its name
#    And user navigates to "<product>" page by clicking on its name
    And chooses size <size>
    And chooses quantity <quantity>
    And adds product to cart
    And clicks proceed to checkout in the success popup
    And clicks proceed to checkout in the cart view
    And address is confirmed by clicking continue
    And user chooses shipping option self-pick-up and clicks continue
#    And user chooses shipping option <shipping> and clicks continue
    And chooses payment method pay-by-check
#    And chooses payment method <payment>
#    And accepts terms of service
#    And confirms by clicking place order
#    Then order confirmation is displayed
#    And screenshot is taken

    Examples:
      | email                        | password  | product                     | size | quantity | shipping    | payment      |
      | euhusxlmggfextjier@cwmxc.com | password1 | Hummingbird printed sweater | M    | 5        | Self pickup | Pay by check |