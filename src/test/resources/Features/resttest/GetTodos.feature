Feature: Testing TODOs request

  @V2Todos @Gorest
  Scenario: Validate TODOs requests from V2 controller
    Given url gorest
    And path 'public/v2/todos'
    When method GET
    Then status 200
    And print response
