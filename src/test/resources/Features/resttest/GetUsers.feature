Feature: Testing users request

  @V2Users @Gorest
  Scenario: Validate user requests from V2 controller
    Given url gorest
    And path 'public/v2/users'
    When method GET
    Then status 200
    And print response
