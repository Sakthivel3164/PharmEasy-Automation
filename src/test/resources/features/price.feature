Feature: Verify Price Section on Phareasy Website

  Scenario: Checking Price Section on Phareasy Website
    Given  user is on the Phareasy website
    Then  the user verifies the URL of the Phareasy website page
    When the user navigates to the Value Store section
    Then the user validate the value store title
    When the user scrolls to the price section
    Then the user should check the price text displayed
    And the user should see the following price range options:
      | Below 99    |
      | 100 - 199   |
      | 200 - 299   |
      | 300 - 399   |
      | 400 - 499   |
