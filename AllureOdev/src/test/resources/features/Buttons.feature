Feature: Click Me Button Functionally
  As a user i would like check dynamic message of Click Me button in Buttons page

  Background: The Elements page opens and the Buttons button is clicked

    @Test
    Scenario: Checking dynamic click of Click Me button in Buttons page
      Given Buttons page opens
      When Click the Click me button
      Then The dynamic message is displayed