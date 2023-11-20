Feature: Hear shout

  "Shouty" allows to hear other users' "shouts" as long as they are close enough to each other

  Rule: Shouts can be heard by other users
    Scenario: Listener is within range
      Given the range is 100
      And a person named Sean
      And a person named Lucy
      When Sean shouts "free bagels at Sean's"
      Then Lucy should hear a shout

  Rule: Shouts should only be heard if listener is within the range
    Scenario: Listener is within range
      Given the range is 100
      And people are located at
        | name     | Sean | Lucy |
        | location | 0    | 50   |
      When Sean shouts
      Then Lucy should hear a shout
    Scenario: Listener is out of range
      Given the range is 100
      And people are located at
        | name     | Sean | Larry |
        | location | 0    | 150   |
      When Sean shouts
      Then Larry should not hear a shout

  Rule: Listeners should be able to hear multiple shouts
    Scenario: Two shouts
      Given the range is 100
      And people are located at
        | name     | Sean | Lucy |
        | location | 0    | 50   |
      When Sean shouts "free bagels at Sean's"
      And Sean shouts "free toast"
      Then Lucy should hear following shouts
        | free bagels at Sean's |
        | free toast            |

  Rule: Message over 180 characters cannot be sent
    Scenario: Too long message
      Given the range is 100
      And people are located at
        | name     | Sean | Lucy |
        | location | 0    | 50   |
      When Sean shouts the following message
      """
      This is veery long message,
      so long that I will not be allowed to send it,
      unless it does not exceed 180 characters size
      """
      Then Lucy should not hear a shout

