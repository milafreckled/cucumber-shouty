Feature: Premium account

  Rules:
  * Mentioning the word "buy" and you lose 5 credits
  * Too long message costs 2 credits

  Background:
    Given the range is 100
    And people are located at
      | name     | Sean | Lucy |
      | location | 0    | 100  |

  Scenario: Test premium account features
    Given Sean has bought 30 credits
    When Sean shouts 3 long messages
    And Sean shouts 2 over-long messages
    And Sean shouts 2 messages containing word "buy"
    Then Lucy should hear 7 messages
    And Sean should have 11 credits

  @todo
  Scenario: Shouting a message with wod "buy" takes 5 credits
#   arbitrary value, e.g. bug id
    BUG #2789
    Given Sean has bought 100 credits
    When Sean shouts "Buy, buy, buy me delicious coffee!"
    Then Sean should have 95 credits