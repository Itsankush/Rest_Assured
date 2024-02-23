Feature: Data Tables with Scenario Outline combination

Scenario Outline: User places an order
  Given the user is on the order page
  When the user adds the following items to the cart:
    | Item      | Quantity |
    | Laptop    | 2        |
    | Smartphone| 1        |
  And clicks on the checkout button
  Then the order should be processed successfully for "<payment_method>"

  Examples:
    | payment_method |
    | Credit Card     |
    | PayPal          |