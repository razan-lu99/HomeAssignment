Scenario: Buying a book
When Asserting Thinking in HTML book exist along with its price
Then Clicking on Add to Basket for Thinking in HTML book
And Clicking on Shopping Cart
And Asserting Item added to cart with its details
And Clicking on Proceed to Checkout
And Assert Billing Details form displayed

