Feature: Testing Comments request

  @V2Comments @Gorest
  Scenario: Validate comments requests from V2 controller
    Given url gorest
    And path 'public/v2/comments'
    When method GET
    Then status 200
    And print response

