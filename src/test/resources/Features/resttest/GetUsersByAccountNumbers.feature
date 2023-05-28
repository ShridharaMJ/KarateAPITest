Feature: Testing user by account numbers request


  @V2UsersByAccountNumbsrs @Gorest
  Scenario Outline: Validate comments requests from V2 controller
    Given url gorest
    And path 'public/v2/<ACCT>/comments'
    When method GET
    Then status 200
    And print response

    @FirstGroup
    Examples:
      | ACCT |
      | 2223205     |
      | 2223204     |
      | 2223202     |
      | 2223201     |
      | 2223200     |

    @SecondGroup
    Examples:
      | ACCT |
      | 2223199     |
      | 2223198     |
      | 2223196     |
      | 2223195     |
      | 2223194     |
