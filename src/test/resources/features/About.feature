Feature: About Us page

  @navigation
  Scenario: Navigate to the About page
    Given user is on the home page
    When user clicks on the About link
    Then user is navigated to the About page
    When user clicks on what are we link
    Then what is pharmeasy wrapper should be displayed
    When user clicks on core values link
    Then core values of pharmeasy should be displayed
    When user clicks on Order medicines & healthcare products online dropdown
    Then Order Medicines Now button should be displayed
    When user clicks on Order Medicines Now button
    Then browser should navigate to the Order Medicine page
    When user navigates back to the About page
    Then user should be back on the About page
    When user clicks on Book diagonostics test online dropdown
    Then Book a Lab Test Now button should be displayed
    When user clicks on Book a Lab Test Now button
    Then Lab test booking window should be displayed
    When user navigates back to the About page
    Then user should be back on the About page
    When user clicks on  Authoritative & Trustworthy Content dropdown
    Then Know more about our Editorial Policy button should be displayed
    When user clicks on Know more about our Editorial Policy button
    Then privacy policy window should be displayed
    When user navigates back to the About page
    Then user should be back on the About page
    When user scrolls down to the press coverage section
    Then images of news paper should be displayed
